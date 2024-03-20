package com.ama.page.objects;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class LoginPage {

	private static LoginPage LoginInstance;

	private LoginPage() {

	}

	public static LoginPage getInstance() {
		if (LoginInstance == null) {
			LoginInstance = new LoginPage();
		}
		return LoginInstance;

	}

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
	private WebElement LOGIN_USERNAME;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	private WebElement LOGIN_PASSWORD;
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	private WebElement LOGIN_BUTTON;
	

	public WebElement getLOGIN_USERNAME() {
		return LOGIN_USERNAME;
	}

	public WebElement getLOGIN_PASSWORD() {
		return LOGIN_PASSWORD;
	}

	public WebElement getLOGIN_BUTTON() {
		return LOGIN_BUTTON;
	}
	/*
	 * @FindBy(xpath = "//input[@id='continue']") public static WebElement
	 * CONTINUE_BUTTON;
	 */

	public void enterUserNameclick() {
		LOGIN_USERNAME.click();
	}

	public void enterUserName(String userrName) {
		LOGIN_USERNAME.sendKeys(userrName);
	}

	public void enterPasswordclick() {
		LOGIN_PASSWORD.click();
	}

	public void enterPassword(String passsword) {
		LOGIN_PASSWORD.sendKeys(passsword);
	}

	public void enterLogin() {
		LOGIN_BUTTON.click();
	}
}
