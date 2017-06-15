package ik;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium2Example {

	public static void main(String[] args) throws InterruptedException {

		// Chrome
		// System.setProperty("webdriver.chrome.driver",
		// "D:\\Install\\Selenium\\Chrome Driver\\chromedriver-v2.30.exe");
		// WebDriver driver = new ChromeDriver();

		// Firefox
		// System.setProperty("webdriver.firefox.bin", "C:\\Program
		// Files\\Mozilla Firefox 45.8\\firefox.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\Install\\Selenium\\Gecko Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

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
		driver.quit();
	}

}
