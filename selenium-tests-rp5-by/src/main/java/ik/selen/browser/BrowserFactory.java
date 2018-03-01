package ik.selen.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.service.DriverService;

public interface BrowserFactory {
	
	WebDriver createBrowserDefault() throws WebDriverException;
	
	WebDriver createBrowserAsService() throws WebDriverException; 

	DriverService getBrowserService();
}
