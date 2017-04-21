package by.rp5;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebBrowser {

	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	public WebBrowser() {
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox 45.8\\firefox.exe");
		// System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver-v0.15.0-win64.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void close() {
		driver.quit();
		// What for can this be? 
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}
	
	public Rp5Page openPageRp5(){
		return new Rp5Page(driver);
	}

}
