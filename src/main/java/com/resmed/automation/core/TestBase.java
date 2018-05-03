package com.resmed.automation.core;

import java.net.MalformedURLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.resmed.automation.util.PropertyFileUtil;
import com.resmed.automation.util.TestUtil;

public class TestBase extends TestUtil {

	private final static Logger log = LogManager.getLogger(TestBase.class);

	public static void initializeDriver() throws MalformedURLException {
		Driver driverObj = new Driver();
		String browser = testProp.getProperty("browser");
		driverObj.initiateDriver(browser);
		driver = driverObj.getDriver();
		driver.manage().window().maximize();
	}

	public static void setupTestProperties(String propertyFilePath) {
		testProp = new PropertyFileUtil().readProperty(propertyFilePath);
	}

	public static void shutdownDriver() {
		driver.quit();
	}

}
