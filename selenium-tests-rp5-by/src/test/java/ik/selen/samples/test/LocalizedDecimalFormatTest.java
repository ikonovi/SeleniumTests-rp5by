package ik.selen.samples.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.util.Locale;

import org.junit.Assume;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ik.selen.samples.LocalizedDecimalFormat;

public class LocalizedDecimalFormatTest {

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { 
			{ "20.02", "20,02" }, 
			{ "1100", "1.100,00" }, 
			{ "250", "250,00" } 
		};
	}

	@Test(dataProvider = "dp")
	public void formatTest(String doubleNumber, String localizedDecimal) {
		Assume.assumeThat(LocalizedDecimalFormat.getServerLocale(), is(equalTo(Locale.GERMANY)));
		Assert.assertEquals(LocalizedDecimalFormat.format(doubleNumber), localizedDecimal);
	}
}
