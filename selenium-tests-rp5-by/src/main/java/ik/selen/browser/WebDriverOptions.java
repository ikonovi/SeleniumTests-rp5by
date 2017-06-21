package ik.selen.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

class WebDriverOptions {
	
	private final static int WAIT_SECONDS = 15;

	static WebDriver apply(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(WAIT_SECONDS, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
		return driver;
	}
	
}
