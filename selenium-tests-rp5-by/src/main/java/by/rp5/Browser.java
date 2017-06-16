package by.rp5;

import org.openqa.selenium.WebDriver;

public interface Browser {
	
	abstract public void close();
	
	abstract public void quit();

	public abstract WebDriver getWebDriver();

}
