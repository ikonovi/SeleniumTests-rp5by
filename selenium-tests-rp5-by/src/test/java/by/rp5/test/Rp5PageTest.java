package by.rp5.test;

import org.junit.Assume;
import org.junit.Test;
import org.openqa.selenium.By;

import ik.selen.by.rp5.Rp5PageElements;

public class Rp5PageTest {

	@Test
	public void test01PageLocatorExample() {
		By oBy = Rp5PageElements.measureUnitsButton;
		Assume.assumeNotNull(oBy);
		System.out.println("Locator measureUnitsButton = " + oBy);		
	}

	@Test
	public void test02LocatorsFileSysEnvPassedOn() {
		String sysEnv = System.getProperty("locators_rp5.properties");
		Assume.assumeTrue("Not defined system environment variable \"locators_rp5.properties\"", sysEnv != null);
		System.out.println("Sys env variable locators.properties=" + sysEnv);
	}

}
