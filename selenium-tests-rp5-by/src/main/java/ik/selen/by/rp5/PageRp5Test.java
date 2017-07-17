package ik.selen.by.rp5;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ik.selen.browser.BrowserType;
import ik.selen.browser.WebDriverSelector;

public class PageRp5Test {

	public final String city = "Минск";

	private PageRp5 myPage;

	@BeforeClass()
	public void setUp() throws Exception {
		WebDriver driver = WebDriverSelector.getInstance().getWebDriver(BrowserType.FIREFOX);		
		myPage = new PageRp5(driver);
		myPage.open();
	}

	@AfterClass(alwaysRun = true, enabled = false)
	public void tearDown() throws Exception {
		myPage.close();
	}

	@Test(priority = 10, description = "Сайт http://rp5.by открывается.")
	public void testOpenHomepage() throws Exception {
		String title = myPage.getTitle();
		assertEquals(title.substring(0, 6), "Погода");
	}

	@Test(priority = 20, description = "Данные на странице отображаются для Минска")
	public void testWeatherReportStandsForLocation() throws Exception {
		myPage.doSearchForLocation(city);
		myPage.doSelectOptionInSearchResult(city);
		WebElement caption = myPage.getWeatherReportCaption();
		assertEquals(caption.isDisplayed(), true);
		assertEquals(caption.getText(), "Погода в Минске");
	}

	@Test(priority = 30, description = "Температура отображается в градусах.")
	public void testTemperatureDisplayedInDegrees() throws Exception {
		WebElement temperature = myPage.getSearchResulTemperature();
		String tempText = temperature.getText();
		//assertEquals(tempText.charAt(tempText.length() - 2), );
		assertThat("", tempText.charAt(tempText.length() - 2), is(Character.valueOf('°')));
	}

	@Test(priority = 40, description = "Температура отображается в форенгейтах - если переключить.")
	public void testTemperatureShowupFahrenheit() throws Exception {
		myPage.doSetMeasurementUnitsTemperatureFahrenheit();
		WebElement temperature = myPage.getWeatherReportCaptionTemperature();		
		String text = temperature.getText();
		assertEquals(text.charAt(text.length() - 1), 'F');
		
	}	    
	
}
