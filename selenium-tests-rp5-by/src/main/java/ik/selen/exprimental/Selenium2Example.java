package ik.selen.exprimental;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class Selenium2Example {

	public static void main(String[] args) throws Exception {

		// Chrome
		
		// System.setProperty("webdriver.chrome.driver",
		// "D:\\Install\\Selenium\\Chrome Driver\\chromedriver-v2.30.exe");
		// WebDriver driver = new ChromeDriver();

		// Firefox
		
		// Set system environment variable with the same name as user's defined
		// 	environment variable if such exists.
		final String WEBDRIVER_ENV = "webdriver.gecko.driver";		
		
		String geskoDriver = System.getenv(WEBDRIVER_ENV);		
		if (geskoDriver == null){
			throw new WebDriverException("User's environment variable \"" + WEBDRIVER_ENV
					+ "\" is not defined in your system, or you didn't restart Eclipse after you defined it.");
		}
		
		// Check Gecko Driver path in file system.
		File geskoDriverFile = new File(geskoDriver);
		if (geskoDriverFile.exists()) {
			System.setProperty(WEBDRIVER_ENV, geskoDriver);
		} else {
			throw new WebDriverException("User's environment variable \"" + WEBDRIVER_ENV
					+ "\" has incorrect value, " + geskoDriverFile.getPath());
		}
		// Create driver
		//File profileDir = new File(System.getenv("LOCALAPPDATA") + "\\Mozilla\\FirefoxProfile.4autoTests");
		//FirefoxProfile ffProfile = new FirefoxProfile(profileDir);
		
		
		FirefoxProfile ffProfile = new FirefoxProfile();
		FirefoxOptions ffOptions = new FirefoxOptions();
		ffOptions.addPreference("browser.tabs.remote.autostart.2", false);
		ffOptions.setProfile(ffProfile);		
		WebDriver driver = new FirefoxDriver(ffOptions);		

		driver.get("http://google.com");
		//driver.findElement(By.xpath("//body")).sendKeys(Keys.F11);
		
		WebElement element = driver.findElement(By.name("q"));
		System.out.println("Page title is: " + driver.getTitle());
		element.sendKeys("Cheese!");
			Actions act = new Actions(driver); // !!
			act.moveToElement(element); // !! Scrolling
		element.submit();
/*
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver dr) {
				return dr.getTitle().toLowerCase().startsWith("cheese!");
			}
		});
*/
		Thread.sleep(2000); // Let the user actually see something!
		System.out.println("Page title is: " + driver.getTitle());

		assertThat("Page title is wrong.", driver.getTitle(), containsString("Cheese!"));

		System.out.println("before: driver.toString() = " + driver.toString());
		// output: "FirefoxDriver: firefox on ANY (60d31607-4ced-4373-a1c1-9955c3f10651)"
		driver.quit();		
		System.out.println("after: driver.toString() = " + driver.toString());
		// output: FirefoxDriver: firefox on ANY (null)  
		System.out.println(driver.toString().contains("null"));
		
	}

}
