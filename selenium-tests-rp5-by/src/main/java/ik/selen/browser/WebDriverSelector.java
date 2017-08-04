package ik.selen.browser;

import org.openqa.selenium.WebDriver;

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
			driver = FirefoxFactory.getFactoryInstace().createBrowser();
			break;
		case CHROME:
			driver = ChromeFactory.getFactoryInstace().createBrowser();
			break;
		}
		
		driver = WebDriverOptions.applyTimeouts(driver);
		driver = WebDriverOptions.applyWindowSettings(driver);
		return driver;
	}

}
