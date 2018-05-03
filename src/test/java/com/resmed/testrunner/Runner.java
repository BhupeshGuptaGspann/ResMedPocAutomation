package com.resmed.testrunner;

import java.io.File;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(strict = false, features = "src/test/resources/FeatureFiles", format = { "pretty",
		"json:target/cucumber.json" }, plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, glue = {
						"com.resmed.stepdefinition" }, tags = { "@demo" })

// mvn test
// -Dcucumber.options=”src/test/resources/functionalTests/End2End_Tests.feature”
// -Dcucumber.options=”–tags @Smoke”

public class Runner extends AbstractTestNGCucumberTests {

	@AfterClass(alwaysRun = true)
	public void writeExtentReport() throws IOException {

		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", System.getProperty("os.name"));
		Reporter.setSystemInfo("Selenium", "3.5.3");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Browser", System.getProperty("browser.useragent"));
		Reporter.setSystemInfo("Java Version", System.getProperty("java.version"));
	}
}
