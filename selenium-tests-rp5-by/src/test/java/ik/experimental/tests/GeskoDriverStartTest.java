package ik.experimental.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GeskoDriverStartTest {

	private static final String GECKO_DRIVER_ENV = "webdriver.gecko.driver";
	private String driverPath;
	private File executable;
	private GeckoDriverService service;
	private FirefoxDriver driver;
	String url = "http://google.by";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		service.stop();
	}

	
	@Test 
	public void test01_() {
		driverPath = System.getenv(GECKO_DRIVER_ENV);
		assertTrue(GECKO_DRIVER_ENV + " is not defined as system env var", driverPath != null);
		
		executable = new File(driverPath);
		assertTrue("Wrong path: " + executable.getAbsolutePath(), executable.exists());
		
		service = new GeckoDriverService.Builder().usingDriverExecutable(executable).usingAnyFreePort().build();
		
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.tabs.remote.autostart.2", false);
		options.addPreference("security.sandbox.content.level", 5);
		
		driver = new FirefoxDriver(service, options);
		driver.navigate().to(url);
	}

	@Test 
	public void test02_() {
		new FirefoxDriver().navigate().to(url);
		
	}
	
	@Test 
	public void test03_() {
		
	}
	
	@Test 
	public void test04_() {
		
	}
}
