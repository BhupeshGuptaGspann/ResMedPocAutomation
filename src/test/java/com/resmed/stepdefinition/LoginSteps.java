package com.resmed.stepdefinition;

import org.openqa.selenium.By;

import com.resmed.pom.pages.BasePage;
import com.resmed.pom.pages.LoginPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginSteps extends BasePage {

	@When("^login to ResMed application$")
	public void login_to_ResMed_application() throws Throwable {
		loginPage = new LoginPage();
		homePage = loginPage.signIn(testProp.getProperty("username"), testProp.getProperty("password"));

	}

	@Then("^verify title of the landing page$")
	public void verify_title_of_the_landing_page() throws Throwable {

		boolean flag = homePage.verifyHomePage("ROS- Place Order");
		Assert.assertTrue(flag);

	}

	@Then("^logout from ResMed Application$")
	public void logout_from_resMed_application() throws Throwable {
		By logoutButton = By.xpath("//*[@id='myAccountForm']/a");
		click(logoutButton);
	}

	@Then("^login with username and Password$")
	public void login_with_username_and_password() throws Throwable {
		loginPage = new LoginPage();
		homePage = loginPage.signIn(testProp.getProperty("username"), testProp.getProperty("password"));

	}

	@Then("^verify user is on Home Page$")
	public void verify_user_is_on_home_page() throws Throwable {
		boolean flag = homePage.verifyHomePage("ROS- Place Order");
		Assert.assertTrue(flag);
	}

	@Then("^click on Logout button$")
	public void click_on_logout_button() throws Throwable {
		By logoutButton = By.xpath("//a[text()='Logout']");
		click(logoutButton);
	}

	@Then("^login with invalid username and Password$")
	public void login_with_invalid_username_and_Password() throws Throwable {
		loginPage = new LoginPage();
		homePage = loginPage.signIn_withoutClick(testProp.getProperty("invalidUsername"), testProp.getProperty("password"));

	}

	@Then("^verify and accept the alert with message Invalid username or password$")
	public void verify_and_accept_alert_with_message_Invalid_username_or_password() {
		boolean flag = verifyAlertText("Invalid username or password.");
		Assert.assertTrue(flag);
	}

}
