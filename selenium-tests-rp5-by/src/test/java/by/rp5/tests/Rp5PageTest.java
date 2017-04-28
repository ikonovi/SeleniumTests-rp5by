package by.rp5.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Assume;
import org.junit.Test;
import org.openqa.selenium.By;

import by.rp5.Rp5PageElements;

public class Rp5PageTest {

	@Test
	public void test01PageLocatorExample() {
		By oBy = Rp5PageElements.measureUnitsButton;
		System.out.println("Locator measureUnitsButton = " + oBy);
		assertNotNull(oBy);
	}

	@Test
	public void test02LocatorsFileSysEnvPassedOn() {
		String sysEnv = System.getProperty("locators_rp5.properties");
		Assume.assumeTrue("Not defined system environment variable \"locators_rp5.properties\"", sysEnv != null);
		System.out.println("Sys env variable locators.properties=" + sysEnv);
	}

}
