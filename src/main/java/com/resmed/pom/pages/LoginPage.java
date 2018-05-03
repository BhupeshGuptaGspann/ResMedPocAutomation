package com.resmed.pom.pages;

import org.openqa.selenium.By;

import com.resmed.automation.core.TestBase;

public class LoginPage extends TestBase {
	private By usernameTextField = By.xpath("//div[@class='login-center']//*[@title='Username']");
	private By passwordTextField = By.xpath("//div[@class='login-center']//*[@title='Password']");
	private By loginButton = By.xpath("//div[@class='login-center']//*[@title='LOGIN']");

	public HomePage signIn(String username, String password) {
		type(usernameTextField, username);
		type(passwordTextField, password);
		click(loginButton);
		return new HomePage();
	}

	public HomePage signIn_withoutClick(String username, String password) {
		type(usernameTextField, username);
		type(passwordTextField, password);
		return new HomePage();
	}
}
