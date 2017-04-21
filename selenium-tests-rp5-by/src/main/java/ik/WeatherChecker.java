package ik;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WeatherChecker {

	public static final String APP_I18N = "ru";
	public static final String APP_HOMEPAGE = "http://rp5.by/?lang=" + APP_I18N;
	public static final String WEBDRIVER_FIREFOX_BIN = "C:\\Program Files\\Mozilla Firefox 45.8\\firefox.exe";
	public static final String DATA_SEARCH_LOC = "Минск";

	public static void main(String[] args) {

		System.setProperty("webdriver.firefox.bin", WEBDRIVER_FIREFOX_BIN);
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get(APP_HOMEPAGE);
		System.out.println("Page title is: " + driver.getTitle());

		// Switch over to Russian
		/*
		 * WebElement langButton = driver.findElement(By.xpath(
		 * "//div[@id='langButton']/table/tbody/tr/td")); langButton.click();
		 * WebElement langMenu =
		 * driver.findElement(By.xpath("//div[@id='langMenu']")); WebElement
		 * langMenuItemRus = driver.findElement(By.
		 * xpath("//div[@id='langMenu']/ul/li//div[@class='ru imgflag']"));
		 * langMenuItemRus.click();
		 */

		// Type in name of a city into search box & click submit
		WebElement searchBox = driver.findElement(By.xpath("//form[@name='fsearch']//input[@id='searchStr']"));
		searchBox.clear();
		searchBox.sendKeys(DATA_SEARCH_LOC);
		searchBox.submit();
		WebElement searchButton = driver.findElement(By.xpath("//form[@name='fsearch']//input[@id='searchButton']"));
		searchButton.submit();

		// Select Minsk from search results.
		WebElement searchResultItemMinsk = driver.findElement(By.linkText(DATA_SEARCH_LOC));
		searchResultItemMinsk.click();

		// Verify Celsius in weather report
		WebElement searchResulTemperatureCelsius = driver
				.findElement(By.xpath("//div[@id='ArchTemp']//span[contains(text(),'C')]"));
		WebElement searchResulTemperatureFahrenheit = driver
				.findElement(By.xpath("//div[@id='ArchTemp']//span[contains(text(),'F')]"));
		System.out.println("Verify: displayed: \n" + "\tCelsius: " + searchResulTemperatureCelsius.isDisplayed() + "\n"
				+ "\tFahrenheit: " + searchResulTemperatureFahrenheit.isDisplayed());

		// Units of measurement: Temperature: switch over from C to F.

		WebElement measurementUnitsButton = driver.findElement(By.id("unitsButton"));
		measurementUnitsButton.click();
		WebElement measureUnitsMenu = driver.findElement(By.xpath("//div[@id='unitsMenu']"));

		WebElement measureUnitsTempCelsiusRadio = driver.findElement(By.id("r_t1"));
		WebElement measureUnitsTempFahrenheitRadio = driver.findElement(By.id("r_t2"));

		if (!measureUnitsTempFahrenheitRadio.isSelected()) {
			System.out.println("Select (F)");
			measureUnitsTempFahrenheitRadio.click();			
		} else { 
			System.err.println("Error: (F) appeared being selected.");
		}

		// Verify Fahrenheit in weather report
		System.out.println("Verify: displayed: \n" + "\tCelsius: " + searchResulTemperatureCelsius.isDisplayed() + "\n"
				+ "\tFahrenheit: " + searchResulTemperatureFahrenheit.isDisplayed());
		
		
		
		// driver.quit();
	}

}
