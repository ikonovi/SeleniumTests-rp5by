package ik.selen.exprimental;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class WebDriverLogsTrial {

	private final String WEBDRIVER_ENV = "webdriver.gecko.driver";
	private WebDriver driver;
	
	WebDriverLogsTrial() {
		String geskoDriver = System.getenv(WEBDRIVER_ENV);		
		System.setProperty(WEBDRIVER_ENV, geskoDriver);
		
		FirefoxProfile ffProfile = new FirefoxProfile();
		FirefoxOptions ffOptions = new FirefoxOptions();
		ffOptions.addPreference("browser.tabs.remote.autostart.2", false);
		ffOptions.setProfile(ffProfile);		
		driver = new FirefoxDriver(ffOptions);
	}

	public static void main(String[] args) {		
		WebDriver driver = new WebDriverLogsTrial().driver;
		driver.navigate().to("http://google.com");
		
		Set<String> logTypes = driver.manage().logs().getAvailableLogTypes();
		for (String string : logTypes) {
			System.out.println(string.toString());
		}
		
		
		
	}

}
