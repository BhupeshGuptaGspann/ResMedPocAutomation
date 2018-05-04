package com.resmed.automation.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.exec.OS;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {

	private ThreadLocal<WebDriver> driverPool = new ThreadLocal<WebDriver>();
	private DesiredCapabilities caps;
	private String grid;
	private final static Logger log = LogManager.getLogger(TestBase.class);

	public void initiateDriver(String browser) throws MalformedURLException {
		log.info("Initializing " + browser);
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					OS.isFamilyWindows() ? System.getProperty("user.dir") + "/drivers/geckodriver.exe"
							: System.getProperty("user.dir") + "/drivers/geckodriver");
			caps = DesiredCapabilities.firefox();
			driverPool.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					OS.isFamilyWindows() ? System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe"
							: System.getProperty("user.dir") + "/drivers/chromedriver");
			System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "default-src 'self'; script-src 'self' 'unsafe-inline' 'unsafe-eval'; img-src 'self'; style-src 'self' 'unsafe-inline'; font-src *");
			caps = DesiredCapabilities.chrome();
			driverPool.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
			caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driverPool.set(
					grid.equalsIgnoreCase("yes") ? new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps)
							: new InternetExplorerDriver());
		} else {
			caps = DesiredCapabilities.firefox();
			driverPool.set(new FirefoxDriver());
		}
	}

	public WebDriver getDriver() {
		return driverPool.get();
	}

}
