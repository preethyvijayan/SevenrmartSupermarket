package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FakeUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class PushNotificationPage {
	public WebDriver driver;
	FakeUtility fakeutility = new FakeUtility();

	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input#title")
	WebElement titleElement;
	@FindBy(css = "input#description")
	WebElement descriptionElement;
	@FindBy(xpath = "//button[contains(@class,'btn-info')]")
	WebElement sendButtonElement;
	@FindBy(xpath = "//button[@data-dismiss='alert']//ancestor::div[contains(@class,'alert-dismissible')]")
	WebElement alertElement;
	@FindBy(xpath = "//a[text()='Reset']")
	WebElement resetButtonElement;

	public PushNotificationPage toEnterTitle() {
		PageUtility.isElementDisplayed(titleElement);
		PageUtility.enterText(titleElement, fakeutility.togetstate());
		return this;
	}

	public PushNotificationPage toEnterDecsription() {
		PageUtility.isElementDisplayed(descriptionElement);
		PageUtility.enterText(descriptionElement, fakeutility.togetstreetAddress());
		return this;

	}

	public PushNotificationPage toClickSendbutton() {
		WaitUtility.waitForElementClickable(driver, sendButtonElement);
		PageUtility.isElementDisplayed(sendButtonElement);
		PageUtility.clickOnElement(sendButtonElement);
		return this;
	}

	public boolean toCheckAlert() {
		WaitUtility.waitForElementClickable(driver, alertElement);
		return PageUtility.isElementDisplayed(alertElement);
	}

	public void toClickResetbutton() {
		WaitUtility.waitForElementClickable(driver, resetButtonElement);
		PageUtility.isElementDisplayed(resetButtonElement);
		PageUtility.clickOnElement(resetButtonElement);
	}

	public String toCheckResetof_Title() {
		return titleElement.getText();

	}

	public String toCheckResetof_Decsription() {
		return descriptionElement.getText();

	}

}
