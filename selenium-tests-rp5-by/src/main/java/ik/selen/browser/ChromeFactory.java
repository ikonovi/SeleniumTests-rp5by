package ik.selen.browser;

import java.io.File;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Starts Chrome web-browser and pass on WebDriver object.
 * <P>
 * Prerequisite: Set user's environment variable with name
 * <code>webdriver.chrome.driver</code> and value that is a path to ChromeDriver
 * exe-file.
 * <P>
 * ChromeDriver page:
 * <a href='https://sites.google.com/a/chromium.org/chromedriver/downloads'>
 * https://sites.google.com/a/chromium.org/chromedriver/downloads</a>
 *  
 * @author KanavalauI
 * @see also {@link FirefoxFactory}
 *
 */
public class ChromeFactory implements BrowserFactory {

	private static final String WEBDRIVER_ENV = "webdriver.chrome.driver";
	private String driverPath;
	private File driverFile;
	private static ChromeFactory instance;

	private ChromeFactory() {
	}

	static ChromeFactory getInstace() {
		if (instance == null) {
			instance = new ChromeFactory();
		}
		return instance;
	}

	@Override
	public ChromeDriver createBrowser() throws WebDriverException {
		initSysEnv();
		ChromeDriver driver = new ChromeDriver();
		return driver;
	}

	private void initSysEnv() {
		driverPath = System.getenv(WEBDRIVER_ENV);
		driverFile = new File(driverPath);
		if (driverFile.exists()) { // Validate path.
			System.setProperty(WEBDRIVER_ENV, driverPath);
		} else {
			throw new WebDriverException("User's environment variable \"" + WEBDRIVER_ENV
					+ "\" is not set or has incorrect value, " + driverFile.getPath());
		}
	}

}
