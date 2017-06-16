package ik;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium2Example {

	public static void main(String[] args) throws Exception {

		// Chrome
		// System.setProperty("webdriver.chrome.driver",
		// "D:\\Install\\Selenium\\Chrome Driver\\chromedriver-v2.30.exe");
		// WebDriver driver = new ChromeDriver();

		// Firefox

		// Set system environment variable with the same name as user's defined
		// 	environment variable if such exists.
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
		WebDriver driver = new FirefoxDriver(ffOptions);
		

		driver.get("http://google.com");
		WebElement element = driver.findElement(By.name("q"));
		System.out.println("Page title is: " + driver.getTitle());
		element.sendKeys("Cheese!");
		element.submit();

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver dr) {
				return dr.getTitle().toLowerCase().startsWith("cheese!");
			}
		});

		Thread.sleep(2000); // Let the user actually see something!
		System.out.println("Page title is: " + driver.getTitle());

		assertThat("Page title is wrong.", driver.getTitle(), containsString("Cheese!"));

		driver.quit();
	}

}
