package ik.selen.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;

@SuppressWarnings("unused")
class WebDriverOptions {

	private static Timeouts elementSearchTimeout;
	private static Timeouts pageLoadTimeout;
	private static Timeouts scriptTimeout;

	static WebDriver applyTimeouts(WebDriver driver) {
		elementSearchTimeout = driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		pageLoadTimeout = driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		scriptTimeout = driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		return driver;
	}

	static WebDriver applyWindowSettings(WebDriver driver) {
		driver.manage().window().maximize();
		return driver;
	}

}
