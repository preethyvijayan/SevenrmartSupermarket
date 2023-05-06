package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class LoginPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

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
	@FindBy(xpath = "//div[@class='wrapper']")
	WebElement uniqueElement;

	public boolean isLoginUnameIsDisplayed() {
		return pageutility.isElementDisplayed(usernameElement);
	}

	public void enterLoginUname(String uname) {

		usernameElement.sendKeys(uname);
	}

	public boolean isLoginPassIsDisplayed() {
		return pageutility.isElementDisplayed(passwordElement);
	}

	public void enterLoginPassword(String pass) {
		passwordElement.sendKeys(pass);
	}

	public boolean isLoginbtnisDisplayed() {
		return pageutility.isElementDisplayed(signinButtonElement);
	}

	public void clickLoginbtn() {
		signinButtonElement.click();

	}

	public boolean uniqueElement() {
		return pageutility.isElementDisplayed(uniqueElement);
	}

}
