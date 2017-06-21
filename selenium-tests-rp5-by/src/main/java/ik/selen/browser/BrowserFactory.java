package ik.selen.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public interface BrowserFactory {
	
	WebDriver createBrowser() throws WebDriverException;

}
