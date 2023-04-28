package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement usernameElement;
	@FindBy(name = "password")
	WebElement passwordElement;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signinButtonElement;
	@FindBy(xpath = "//label[@for='remember']")
	WebElement remembermeElement;
	@FindBy(xpath = "//div[@class='wrapper']")
	WebElement uniqueElement;

	public boolean loginUname() {
		return PageUtility.isElementDisplayed(usernameElement);
	}

	public void loginUnameEnterText(String uname) {

		PageUtility.enterText(usernameElement, uname);
	}

	public boolean loginPass() {
		return PageUtility.isElementDisplayed(passwordElement);
	}

	public void loginPassenterText(String pass) {
		PageUtility.enterText(passwordElement, pass);
	}

	public boolean Loginbtn() {
		return PageUtility.isElementDisplayed(signinButtonElement);
	}

	public void toClickLoginbtn() {
		PageUtility.clickOnElement(signinButtonElement);

	}

	public boolean uniqueElement() {
		return PageUtility.isElementDisplayed(uniqueElement);
	}

}
