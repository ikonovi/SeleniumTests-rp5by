package ik.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.MethodSorters;
import org.junit.runners.model.Statement;
import org.openqa.selenium.By;

import by.rp5.Rp5PageElements;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyTest {

	@BeforeClass
	public static void setUp() {
		System.out.println("-Before class");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("-After class");
	}

	@Before 
	public void beforeMethod() {
		System.out.println("--Before method");
    }	
	
	@After 
	public void afterMethod() {
		System.out.println("--After method");
    }
	
	@Rule
	public final TemporaryFolder tempFolder = new TemporaryFolder();
	
	//@Rule
	public TestRule rule01() {
		System.out.println("---Rule 1");
		return new TestRule(){

			@Override
			public Statement apply(Statement base, Description description) {
				// TODO Auto-generated method stub
				return null;
			}} ;
    }

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

	@Test
	public void test03() {
		assumeFalse("assumption severy violated", false);
		assumeThat("vv", is("vv"));

	}

	@Test(expected = AssumptionViolatedException.class)
	public void test04() {
		throw new AssumptionViolatedException("Test of exception on rising.");
	}
}
