package ik.selen.browser;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;

/**
 * Starts FireFox web-browser and pass on WebDriver object.
 * <P>
 * Prerequisite: Set user's environment variable with name
 * <code>webdriver.gecko.driver</code> and value that is a path to GeckoDriver
 * exe-file.
 * <P>
 * GeckoDriver page: <a href='https://github.com/mozilla/geckodriver/releases'>
 * https://github.com/mozilla/geckodriver/releases</a>
 * 
 * @author KanavalauI
 * @see ik.selen.browser.ChromeFactory
 */
public class FirefoxFactory implements BrowserFactory {

	private static FirefoxFactory factoryInstance;

	private static final String GECKO_DRIVER_ENV = "webdriver.gecko.driver";
	private String driverPath;
	private File executable;
	private GeckoDriverService service;


	static FirefoxFactory getFactoryInstace() {
		if (factoryInstance == null) {
			factoryInstance = new FirefoxFactory();
		}
		return factoryInstance;
	}

	@Override
	public GeckoDriverService getBrowserService() {
		return service;
	}

	@Override
	public WebDriver createBrowserDefault() throws WebDriverException {
		// return createBrowserWithOptionLegacyOn();  // ! Legacy style
		return createBrowserWithGeckoDriverDefault();
	}

	@Override
	public WebDriver createBrowserAsService() throws WebDriverException {
		checkSysEnv();
		service = new GeckoDriverService.Builder().
				usingDriverExecutable(executable).
				usingAnyFreePort().
				build();
		return new FirefoxDriver(service, setFirefoxOptions());
	}
	
	private FirefoxDriver createBrowserWithGeckoDriverDefault() throws WebDriverException {
		checkSysEnv();
		return new FirefoxDriver(setFirefoxOptions());
	}

	@SuppressWarnings("unused")
	private FirefoxDriver createBrowserWithOptionLegacyOn() throws WebDriverException {
		return new FirefoxDriver(setFirefoxOptions().setLegacy(true));
	}

	private void checkSysEnv() throws WebDriverException {

		// Get user's environment variable.
		driverPath = System.getenv(GECKO_DRIVER_ENV);
		if (driverPath == null) {
			throw new WebDriverException("User's environment variable \"" + GECKO_DRIVER_ENV
					+ "\" is not defined in your system, or you didn't restart Eclipse after you defined it.");
		}
		executable = new File(driverPath);
		
		// Initialize system environment variable, using user's environment variable.
		if (executable.exists()) {
			System.setProperty(GECKO_DRIVER_ENV, driverPath);
		} else {
			throw new WebDriverException("User's environment variable \"" + GECKO_DRIVER_ENV
					+ "\" is not set or has incorrect value, " + executable.getPath());
		}
	}

	private FirefoxOptions setFirefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();

		// Add option that prevent running FF in multiple thread mode.
		options.addPreference("browser.tabs.remote.autostart.2", false);

		FirefoxProfile profile = new FirefoxProfile();
		options.setProfile(profile);
		return options;
	}
}
