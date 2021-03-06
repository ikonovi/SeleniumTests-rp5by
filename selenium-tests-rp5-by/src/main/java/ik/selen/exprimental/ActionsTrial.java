package ik.selen.exprimental;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import ik.selen.browser.BrowserType;
import ik.selen.browser.WebDriverSelector;

public class ActionsTrial {

	private final String WEBDRIVER_ENV = "webdriver.gecko.driver";
	private static WebDriver driver;

	ActionsTrial() {
		String geskoDriver = System.getenv(WEBDRIVER_ENV);
		System.setProperty(WEBDRIVER_ENV, geskoDriver);

		FirefoxProfile ffProfile = new FirefoxProfile();
		FirefoxOptions ffOptions = new FirefoxOptions();
		ffOptions.addPreference("browser.tabs.remote.autostart.2", false);
		ffOptions.setProfile(ffProfile);
		driver = new FirefoxDriver(ffOptions);
	}

	public static void main(String[] args) {
/*
		WebDriver driver = new ActionsTrial().driver;

		driver.navigate().to("http://google.com");

		WebElement e = driver.findElement(By.id(""));
		Actions actions = new Actions(driver);
		actions.contextClick(driver.findElement(By.name("q"))).perform();
		actions.pause(Duration.ofSeconds(2));
		actions.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
		actions.build().perform();
*/
		
		WebDriver d = WebDriverSelector.getInstance().getWebDriver(BrowserType.FIREFOX);
		d.get("http://google.com");
		

		//Explicit Waits
/*		
		(new WebDriverWait(driver, 10)).until(
				new ExpectedCondition<Boolean>() {
					@Override
		            public Boolean apply(WebDriver d) {
		                return d.getTitle().toLowerCase().startsWith("selenium");
					}
				}
		);
*/		
		
	}

}
