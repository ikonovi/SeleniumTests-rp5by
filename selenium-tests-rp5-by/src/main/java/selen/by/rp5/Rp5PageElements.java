package selen.by.rp5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class Rp5PageElements {

	public static By searchBox = By.xpath(XPathExpression.searchBox.toString());
	public static By searchButton = By.xpath(XPathExpression.searchButton.toString());
	public static By weatherReportCaption = By.xpath(XPathExpression.weatherReportCaption.toString());
	public static By searchResultTemperature = By.xpath(XPathExpression.searchResultTemperature.toString());
	public static By measureUnitsButton = By.xpath(XPathExpression.measureUnitsButton.toString());
	public static By measureUnitsMenu = By.xpath(XPathExpression.measureUnitsMenu.toString());
	public static By measureUnitsMenuTemperF = By.xpath(XPathExpression.measureUnitsMenuTemperF.toString());
	public static By measureUnitsMenuTemperC = By.xpath(XPathExpression.measureUnitsMenuTemperC.toString());
	public static By weatherReportCaptionTemper = By.xpath(XPathExpression.weatherReportCaptionTemper.toString());

	private enum XPathExpression {
		
		weatherReportCaptionTemper("weatherReportCaptionTemper"),
		measureUnitsMenuTemperF("measureUnitsMenuTemperF"),
		measureUnitsMenuTemperC("measureUnitsMenuTemperC"),
		measureUnitsMenu("measureUnitsMenu"),
		measureUnitsButton("measureUnitsButton"),
		searchResultTemperature("searchResultTemperature"),
		weatherReportCaption("weatherReportCaption"),
		searchButton("searchButton"),
		searchBox("searchBox"); 		

		private String xpathExpression;
		private Properties props = null;
		private InputStream input = null;

		XPathExpression(String xpathExpression) {

			if (props == null) {
				try {
					props = new Properties();
					// It can be set as a VM argument in the way:  -Dlocators_rp5.properties=filePathValue
					String locatorsPropsFile = System.getProperty("locators_rp5.properties", 
							"src/main/resources/locators_rp5.properties");
					input = new FileInputStream(locatorsPropsFile);
					props.load(input);
				} catch (IOException ex) {
					ex.printStackTrace();
				} finally {
					if (input != null) {
						try {
							input.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			this.xpathExpression = props.getProperty(xpathExpression);
		}

		@Override
		public String toString() {
			return xpathExpression;
		}

	}

}
