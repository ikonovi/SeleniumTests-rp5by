package ik.selen.browser;

import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

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
 * @see also {@link ChromeFactory}
 */
public class FirefoxFactory implements BrowserFactory {

	private static FirefoxFactory factoryInstance;

	private FirefoxFactory() {
	}

	static FirefoxFactory getFactoryInstace() {
		if (factoryInstance == null) {
			factoryInstance = new FirefoxFactory();
		}
		return factoryInstance;
	}

	@Override
	public WebDriver createBrowser() throws WebDriverException {
		return createBrowserWithOptionLegacyOn();
	}

	FirefoxDriver createBrowserWithGeckoDriver() throws WebDriverException {
		initGeckoDriver();
		return new MyFirefoxDriver(setFirefoxOptions());
	}

	FirefoxDriver createBrowserWithMarionetteOff() throws WebDriverException {
		return new MyFirefoxDriver(setFirefoxOptions().addCapabilities(setCapabilityMarionetteOff()));
	}

	FirefoxDriver createBrowserWithOptionLegacyOn() throws WebDriverException {
		return new MyFirefoxDriver(setFirefoxOptions().setLegacy(true));
	}

	private void initGeckoDriver() throws WebDriverException {

		final String GECKO_DRIVER_ENV = "webdriver.gecko.driver";

		// Get user's environment variable.
		String envValue = System.getenv(GECKO_DRIVER_ENV);
		if (envValue == null) {
			throw new WebDriverException("User's environment variable \"" + GECKO_DRIVER_ENV
					+ "\" is not defined in your system, or you didn't restart Eclipse after you defined it.");
		}

		File fileExe = new File(envValue);

		// Initialize system environment variable, using user's environment variable.
		if (fileExe.exists()) {
			System.setProperty(GECKO_DRIVER_ENV, envValue);
		} else {
			throw new WebDriverException("User's environment variable \"" + GECKO_DRIVER_ENV
					+ "\" is not set or has incorrect value, " + fileExe.getPath());
		}
	}

	/**
	 * Use legacy FireFox extension as a driver.
	 */
	private Capabilities setCapabilityMarionetteOff() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("marionette", false);
		// The following is an alternative for the code above.
		// System.setProperty("webdriver.firefox.marionette", "false");
		return capabilities;
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
