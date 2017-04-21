package by.rp5.tests;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

import by.rp5.Rp5PageElements;

public class Rp5PageTest {

	@BeforeClass
	public static void setUp() throws Exception {
		
	}

	@Test
	public void testPageLocatorsAvaialable() {
		By byObj = Rp5PageElements.measureUnitsButton;		
		System.out.println("Locator example: " + byObj);
		assert true;
	}
	
	@Ignore("Env var locators.properties is not set.")
	@Test	
	public void testLocatorsFileSysEnvPassedOn(){
		String locatorsFile = System.getProperty("locators_Rp5.properties");
		System.out.println("Enviroment variable locators.properties = " + locatorsFile);		
		assert true;
	}	

}
