package ik.selen.browser;

import java.io.File;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

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
 * @see ik.selen.browser.FirefoxFactory
 *
 */
public class ChromeFactory implements BrowserFactory {

	private static final String WEBDRIVER_SYSTEM_ENV = "webdriver.chrome.driver";
	private static ChromeFactory instance;

	private String driverPath;
	private File executable;
	private ChromeDriverService service;

	private ChromeFactory() {
	}

	static ChromeFactory getFactoryInstace() {
		if (instance == null) {
			instance = new ChromeFactory();
		}
		return instance;
	}

	@Override
	public ChromeDriverService getBrowserService() {
		return service;
	}

	@Override
	public ChromeDriver createBrowserDefault() throws WebDriverException {
		checkSysEnv();
		ChromeDriver driver = new ChromeDriver();
		return driver;
	}
	
	@Override
	public ChromeDriver createBrowserAsService() throws WebDriverException {
		checkSysEnv();
		service = new ChromeDriverService.Builder().
				usingDriverExecutable(executable).
				usingAnyFreePort().
				build();
		return new ChromeDriver(service, createChromeOptions());
	}
	
	private ChromeOptions createChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		return options;
	}

	private void checkSysEnv() {
		driverPath = System.getenv(WEBDRIVER_SYSTEM_ENV);
		if (driverPath == null) {
			throw new WebDriverException("User's environment variable \"" + WEBDRIVER_SYSTEM_ENV
					+ "\" is not defined in your system, or you didn't restart Eclipse after you defined it.");
		}
		executable = new File(driverPath);
		
		if (executable.exists()) {
			// Initialize system environment variable, using user's environment variable.
			//System.setProperty(WEBDRIVER_SYSTEM_ENV, driverPath);
		} else {
			throw new WebDriverException("User's environment variable \"" + WEBDRIVER_SYSTEM_ENV
					+ "\" is not set or has incorrect value, " + executable.getPath());
		}
	}

}
