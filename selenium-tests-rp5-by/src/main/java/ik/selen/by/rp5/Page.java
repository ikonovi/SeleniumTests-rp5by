package ik.selen.by.rp5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.service.DriverService;

public abstract class Page {

	protected WebDriver driver;
	private DriverService service;

	Page(WebDriver driver) throws Exception {
		this.driver = driver;
	}

	Page(WebDriver driver, DriverService service) {
		this.driver = driver;
		this.service = service;
	}

	public void open(String url) {
		driver.navigate().to(url);
	}

	/**
	 * Close the window. Driver process stays alive.
	 */
	public void close() {
		driver.close();
	}

	/**
	 * Close all browser windows and terminate driver process.
	 */
	public void quit() {
		driver.quit();
		if (service != null && service.isRunning()) {
			service.stop();
		}
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
