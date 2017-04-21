package by.rp5;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Rp5PageTest {

	public final String city = "Минск";
	
	private WebBrowser browser;
	private Rp5Page myPage;  

	@BeforeClass()
	public void setUp() throws Exception {
		browser = new WebBrowser();
		myPage = browser.openPageRp5();				
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		browser.close();
	}

	@Test(priority = 10, description = "Сайт http://rp5.by открывается.")
	public void testOpenHomepage() throws Exception {
		myPage.open();		
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
		assertEquals(tempText.charAt(tempText.length() - 2), '°');
	}

	
	@Test(priority = 40, description = "Температура отображается в форенгейтах - если переключить.")
	public void testTemperatureShowupFahrenheit() throws Exception {		
		myPage.doSetMeasurementUnitsTemperatureFahrenheit();				
		WebElement temperature = myPage.getWeatherReportCaptionTemperature();
		String text = temperature.getText();		
		assertEquals(text.charAt(text.length() - 1), 'F');
	}

}
