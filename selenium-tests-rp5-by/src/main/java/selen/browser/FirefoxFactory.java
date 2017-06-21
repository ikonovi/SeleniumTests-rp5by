package selen.browser;

import java.io.File;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Starts FireFox web-browser and pass on WebDriver object.
 * <P>
 * Prerequisite: Set user's environment variable with name
 * <code>webdriver.gecko.driver</code> and value that is a path to GeckoDriver exe-file.
 * <P>
 * GeckoDriver page:
 * <a href='https://github.com/mozilla/geckodriver/releases'>
 * https://github.com/mozilla/geckodriver/releases</a>
 * 
 * @author KanavalauI
 * @see also {@link ChromeFactory}
 */
public class FirefoxFactory implements BrowserFactory {

	private static final String WEBDRIVER_ENV = "webdriver.gecko.driver";

	private String driverPath;
	private File driverFile;
	private FirefoxProfile profile;
	private FirefoxOptions options;

	private static FirefoxFactory instance;

	private FirefoxFactory() {
	}

	static FirefoxFactory getInstace() {
		if (instance == null) {
			instance = new FirefoxFactory();
		}
		return instance;
	}

	public FirefoxDriver createBrowser() throws WebDriverException {
		initSysEnv();
		FirefoxDriver driver = newFirefoxDriver();
		return driver;
	}

	/**
	 * Define system environment variable that has the same name as user's
	 * defined environment variable, user created before as it's prerequisite.
	 * 
	 * @throws Exception
	 */
	private void initSysEnv() throws WebDriverException {
		driverPath = System.getenv(WEBDRIVER_ENV);
		driverFile = new File(driverPath);
		if (driverFile.exists()) { // Validate path.
			System.setProperty(WEBDRIVER_ENV, driverPath);
		} else {
			throw new WebDriverException("User's environment variable \"" + WEBDRIVER_ENV
					+ "\" is not set or has incorrect value, " + driverFile.getPath());
		}
	}

	private FirefoxDriver newFirefoxDriver() {
		options = new FirefoxOptions();
		options.addPreference("browser.tabs.remote.autostart.2", false);
		profile = new FirefoxProfile();
		options.setProfile(profile);
		return new MyFirefoxDriver(options);
	}

}
