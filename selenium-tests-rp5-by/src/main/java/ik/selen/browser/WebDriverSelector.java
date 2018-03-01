package ik.selen.browser;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.service.DriverService;

public class WebDriverSelector {

	private static WebDriverSelector instance;

	private WebDriverSelector() {
	}

	public static WebDriverSelector getInstance() {
		if (instance == null) {
			instance = new WebDriverSelector();
		}
		return instance;
	}

	public WebDriver getWebDriver(BrowserType browserType) {
		WebDriver driver = null;
		switch (browserType) {
		case FIREFOX:
			driver = FirefoxFactory.getFactoryInstace().createBrowserAsService();
			break;
		case CHROME:
			driver = ChromeFactory.getFactoryInstace().createBrowserAsService();
			break;
		}
		// Options
		driver = WebDriverOptions.applyTimeouts(driver);
		driver = WebDriverOptions.applyWindowSettings(driver);
		return driver;
	}
	
	public DriverService getDriverService(BrowserType browserType) {
		Optional<DriverService> service = null;
		switch (browserType) {
		case FIREFOX:
			service = Optional.ofNullable(FirefoxFactory.getFactoryInstace().getBrowserService());
			break;
		case CHROME:
			service = Optional.ofNullable(ChromeFactory.getFactoryInstace().getBrowserService());
			break;
		}
		if (!service.isPresent()) {
			throw new RuntimeException("No WebDriver service defined.");
		}		
		return service.get();
	}
}
