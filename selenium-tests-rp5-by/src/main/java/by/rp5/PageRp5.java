package by.rp5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageRp5 extends Page {

	private WebDriver driver;
	private static final String url = "http://rp5.by/?lang=ru";
	private boolean acceptNextAlert = true;

	public PageRp5(Browser browser) {
		this.driver = browser.getWebDriver();
	}

	public void open() {
		driver.get(url);
	}
	
	public void close() {
		driver.close();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public WebElement getWeatherReportCaption() {
		WebElement e = driver.findElement(Rp5PageElements.weatherReportCaption);
		return e;
	}

	public WebElement getSearchResulTemperature() {
		WebElement e = driver.findElement(Rp5PageElements.searchResultTemperature);
		return e;
	}
	
	public WebElement getWeatherReportCaptionTemperature() throws InterruptedException{
		WebElement e = driver.findElement(Rp5PageElements.weatherReportCaptionTemper);
		// >> Experimental highlight of element. why arguments ?? not args
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String script = "var el = arguments[0]; " + 
						"el.style.border = 'medium solid yellow';";
		e = (WebElement) js.executeAsyncScript(script, e);
		// <<
		return e;
	}

	public void doSelectOptionInSearchResult(String location) {
		WebElement e = driver.findElement(By.linkText(location));
		e.click();
	}
	
	public void doSetMeasurementUnitsTemperatureFahrenheit() {
		WebElement measureUnitsButton = driver.findElement(Rp5PageElements.measureUnitsButton);
		measureUnitsButton.click();
		isElementPresent(Rp5PageElements.measureUnitsMenu);
		WebElement tempFRadio = driver.findElement(Rp5PageElements.measureUnitsMenuTemperF);
		tempFRadio.click();
		measureUnitsButton.click();
	}

	/**
	 * @param location
	 *            - city or town to get weather info
	 */
	public void doSearchForLocation(String location) {
		WebElement searchBox = driver.findElement(Rp5PageElements.searchBox);
		WebElement searchButton = driver.findElement(Rp5PageElements.searchButton);
		searchBox.clear();
		searchBox.sendKeys(location);
		searchButton.submit();
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	@SuppressWarnings("unused")
	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@SuppressWarnings("unused")
	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
