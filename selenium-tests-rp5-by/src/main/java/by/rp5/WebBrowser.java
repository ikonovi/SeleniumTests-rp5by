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
		//driver.manage().window().maximize();		
	}

	public void close() {
		driver.quit();
		// What can it be used for? 
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}
	
	public PageRp5 openPageRp5(){
		return new PageRp5(driver);
	}

}
