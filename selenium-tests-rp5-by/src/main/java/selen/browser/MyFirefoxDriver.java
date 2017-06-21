/**
 * 
 */
package selen.browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * @author KanavalauI
 *
 */
class MyFirefoxDriver extends FirefoxDriver {

	/**
	 * 
	 */
	public MyFirefoxDriver() {
		super();
	}

	/**
	 * @param options
	 */
	public MyFirefoxDriver(FirefoxOptions options) {
		super(options);
	}

	/**
	 * @param profile
	 */
	public MyFirefoxDriver(FirefoxProfile profile) {
		super(profile);
	}
		
	/**
	 * @param desiredCapabilities
	 */
	public MyFirefoxDriver(Capabilities desiredCapabilities) {
		super(desiredCapabilities);
	}

	
	// TODO: Located element highlight by applying style like this 
	// document.getElementById('ArchTemp').style.border = 'medium solid yellow'; 
	
	@Override
	public WebElement findElement(By by) {
		return super.findElement(by);
	}

	@Override
	public List<WebElement> findElements(By by) {
		return super.findElements(by);
	}

}
