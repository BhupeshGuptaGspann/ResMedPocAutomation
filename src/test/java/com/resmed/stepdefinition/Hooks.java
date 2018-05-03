package com.resmed.stepdefinition;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cucumber.listener.Reporter;
import com.resmed.automation.core.TestBase;
import com.resmed.automation.util.TestUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends TestBase {

	private final static Logger log = LogManager.getLogger(TestUtil.class);

/*	@BeforeSuite
	public void initializeTestProperties() {
		setupTestProperties(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.properties");
	}*/

	@Before
	public void preTestInitialzer() throws MalformedURLException {
		setupTestProperties(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.properties");
		initializeDriver();
	}

	@After(order = 1)
	public void embedScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			log.info("Scenario is faile..:" + scenario.getName());
			try {
				String screenShotName = takeScreenshotAtEndOfTest();
				log.info("Path of Screenshot is.." + screenShotName);
				log.info("Capturing Screenshot of the failed Scenario is..");
				Reporter.addScreenCaptureFromPath(screenShotName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@After(order = 0)
	public void postTestDeinitializer() {
		driver.quit();
	}

}
