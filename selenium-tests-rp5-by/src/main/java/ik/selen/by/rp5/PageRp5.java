package ik.selen.by.rp5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.service.DriverService;

public class PageRp5 extends Page {

	
	public PageRp5(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public PageRp5(WebDriver driver, DriverService service) {
		super(driver,service);
	}
	
	public WebElement getWeatherReportCaption() {
		WebElement e = driver.findElement(Rp5PageElements.weatherReportCaption);
		return e;
	}

	public WebElement getSearchResulTemperature() {
		WebElement e = driver.findElement(Rp5PageElements.searchResultTemperature);
		return e;
	}

	public WebElement getWeatherReportCaptionTemperature() throws InterruptedException {
		WebElement e1 = driver.findElement(Rp5PageElements.weatherReportCaptionTemper);

		// Experimental highlight of element. why arguments ?? not args
		// JavascriptExecutor js = ((JavascriptExecutor) driver);
		// String script = "var el = arguments[arguments.length - 1];" +
		// "el.style.border = 'medium solid yellow';";
		// WebElement e2 = (WebElement) js.executeAsyncScript(script);
		// Object responce =
		// js.executeAsyncScript("document.getElementById('ArchTemp').style.border =
		// 'medium solid yellow'");

		return e1;
	}

	public void doSelectOptionInSearchResult(String location) {
		WebElement e = driver.findElement(By.linkText(location));
		e.click();
	}

	public void doSetMeasurementUnitsTemperatureFahrenheit() throws InterruptedException {

		// Open settings area
		WebElement measureUnitsButton = driver.findElement(Rp5PageElements.measureUnitsButton);
		measureUnitsButton.click();

		// wait element
		isElementPresent(Rp5PageElements.measureUnitsMenu);

		WebElement tempFRadio = driver.findElement(Rp5PageElements.measureUnitsMenuTemperF);

		// UI logic
		if (tempFRadio.isEnabled()) {
			if (!tempFRadio.isSelected()) {
				tempFRadio.click();
			} else {
				System.out.println("Can't be clicked by cause it's already selected.");
			}
		} else {
			System.out.println("Can't be clicked by cause it's disabled.");
		}

		// Close settings area
		measureUnitsButton.click();
	}

	public void doSelectLanguage(String language) throws InterruptedException {
		By langMenuElem = Rp5PageElements.languageMenu;
		WebElement langMenu = driver.findElement(langMenuElem);
		langMenu.click();

		String langMenuItemXPath = "//div[@id='langMenu']/ul/li/div[contains(text(),'langPlaceholder')]"
				.replace("langPlaceholder", language);
		WebElement langMenuItemElement = driver.findElement(By.xpath(langMenuItemXPath));

		while (!langMenuItemElement.isDisplayed()) {
			Thread.sleep(300);
		}
		langMenuItemElement.click();
	}

	public void doCloseGeoVidget() {
		String geoVidgetCloseXPath = "//div[@id='geo-vidget-close']";
		By geoVidgetCloseBy = By.xpath(geoVidgetCloseXPath);
		WebElement geoVidgetCloseElem = driver.findElement(geoVidgetCloseBy);
		geoVidgetCloseElem.click();
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

	private boolean acceptNextAlert = true;
	
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
