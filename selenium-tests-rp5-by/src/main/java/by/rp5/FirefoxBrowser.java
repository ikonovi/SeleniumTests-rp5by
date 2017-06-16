package by.rp5;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxBrowser implements Browser {
	
	protected WebDriver driver;

	public FirefoxBrowser() throws Exception {

		// Set system environment variable with the same name as user's defined
		// environment variable if such exists.
		final String ENV_WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
		String geskoDriver = System.getenv(ENV_WEBDRIVER_GECKO_DRIVER);

		// Check Gecko Driver path in file system.
		File geskoDriverFile = new File(geskoDriver);
		if (geskoDriverFile.exists()) {
			System.setProperty(ENV_WEBDRIVER_GECKO_DRIVER, geskoDriver);
		} else {
			throw new Exception("User's environment variable \"" + ENV_WEBDRIVER_GECKO_DRIVER
					+ "\" is not set or has incorrect value, " + geskoDriverFile.getPath());
		}
		
		// Create driver
		FirefoxProfile ffProfile = new FirefoxProfile();
		FirefoxOptions ffOptions = new FirefoxOptions();
		ffOptions.addPreference("browser.tabs.remote.autostart.2", false);
		ffOptions.setProfile(ffProfile);
		driver = new FirefoxDriver(ffOptions);				 

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().window().maximize();

	}
	
	@Override
	public WebDriver getWebDriver() {
		return driver;
	}

	@Override
	public void close() {
		driver.close();
	}

	@Override
	public void quit() {
		driver.quit();
	}


}
