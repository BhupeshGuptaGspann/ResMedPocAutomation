package com.resmed.stepdefinition;

import com.cucumber.listener.Reporter;
import com.resmed.automation.core.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class GlobalTestSteps extends TestBase {

	@Given("^User launched ResMed Application$")
	public void user_launched_ResMed_Application() {
		Reporter.addStepLog("We are in Background");
		driver.get(testProp.getProperty("BaseURL"));
		Reporter.addStepLog("User Landed on the ResMed Application Login Page");
		String page_Title = driver.getTitle();
	}

	@Then("^verify ResApp login page is opened$")
	public void verify_title_of_login_page() throws Throwable {
		String loginPageTitle = getTitle();
		String appTitle = "RESMED Online Store";
		Assert.assertEquals(appTitle, loginPageTitle);

	}

	@Given("^user is on Login Page")
	public void user_is_on_login_page() throws Throwable {
		driver.get(testProp.getProperty("baseURL"));
	}

	@Then("^verify user is on Login Page$")
	public void verify_user_is_on_login_page() throws Throwable {
		String loginPageTitle = getTitle();
		String appTitle = "RESMED Online Store";
		Assert.assertEquals(appTitle, loginPageTitle);
	}

}
