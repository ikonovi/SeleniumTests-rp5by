package by.rp5.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ik.selen.browser.BrowserType;
import ik.selen.browser.WebDriverSelector;
import ik.selen.by.rp5.PageRp5;

public class PageRp5Test {

	private String url = "http://rp5.by";
	private String city = "Minsk";
	private String pageLanguage = "English";
	private BrowserType browserType = BrowserType.CHROME;
	private PageRp5 page;

	@BeforeClass()
	public void setUp() throws Exception {
		WebDriver driver = WebDriverSelector.getInstance().getWebDriver(browserType);
		DriverService service = WebDriverSelector.getInstance().getDriverService(browserType);

		page = new PageRp5(driver, service);
		page.open(url);
		page.doCloseGeoVidget();
		page.doSelectLanguage(pageLanguage);
	}

	@AfterClass(alwaysRun = true, enabled = true)
	public void tearDown() throws Exception {
		page.quit();
	}

	@Test(priority = 10, description = "Open Homepage of website")
	public void testOpenHomepage() throws Exception {
		String title = page.getTitle();
		assertEquals(title.substring(0, 7), "Weather");
	}

	@Test(priority = 20, description = "Minsk city weather is displayed.")
	public void testWeatherReportStandsForLocation() throws Exception {
		page.doSearchForLocation(city);
		page.doSelectOptionInSearchResult(city);
		WebElement caption = page.getWeatherReportCaption();
		assertEquals(caption.isDisplayed(), true);
		assertEquals(caption.getText(), "Weather in Minsk");
	}

	@Test(priority = 30, description = "Temperature is displayed in Degrees, sign '°'")
	public void testTemperatureDisplayedInDegrees() throws Exception {
		WebElement temperature = page.getSearchResulTemperature();
		String tempText = temperature.getText();
		// assertEquals(tempText.charAt(tempText.length() - 2), );
		assertThat("", tempText.charAt(tempText.length() - 2), is(Character.valueOf('°')));
	}

	@Test(priority = 40, description = "Temperature is displayed in Fahrenheit.")
	public void testTemperatureShowupFahrenheit() throws Exception {
		page.doSetMeasurementUnitsTemperatureFahrenheit();
		WebElement temperature = page.getWeatherReportCaptionTemperature();
		String text = temperature.getText();
		assertEquals(text.charAt(text.length() - 1), 'F');
	}
}
