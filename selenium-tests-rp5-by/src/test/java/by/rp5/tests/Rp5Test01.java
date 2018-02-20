package by.rp5.tests;

import org.junit.Assume;
import org.junit.Test;
import org.openqa.selenium.By;

import ik.selen.by.rp5.Rp5PageElements;

public class Rp5Test01 {

	@Test
	public void testPageLocatorExample() {
		By oBy = Rp5PageElements.measureUnitsButton;
		Assume.assumeNotNull(oBy);
		System.out.println("Locator measureUnitsButton = " + oBy);		
	}

	@Test
	public void testLocatorsFileSysEnvPassedOn() {
		String sysEnv = System.getProperty("locators_rp5.properties");
		Assume.assumeTrue("Not defined system environment variable \"locators_rp5.properties\"", sysEnv != null);
		System.out.println("Sys env variable locators.properties=" + sysEnv);
	}

}
