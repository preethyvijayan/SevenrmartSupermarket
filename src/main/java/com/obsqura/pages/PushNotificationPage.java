package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.RandomDataUtility;
import Utilities.WaitUtility;

public class PushNotificationPage {
	public WebDriver driver;
	RandomDataUtility fakeutility = new RandomDataUtility();
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

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
		pageutility.isElementDisplayed(titleElement);
		titleElement.sendKeys(fakeutility.togetstate());
		return this;
	}

	public PushNotificationPage toEnterDecsription() {
		pageutility.isElementDisplayed(descriptionElement);
		descriptionElement.sendKeys(fakeutility.togetstreetAddress());
		return this;

	}

	public PushNotificationPage toClickSendbutton() {
		waitutility.waitForElementClickable(driver, sendButtonElement);
		pageutility.isElementDisplayed(sendButtonElement);
		sendButtonElement.click();
		return this;
	}

	public boolean toCheckAlert() {
		waitutility.waitForElementClickable(driver, alertElement);
		return pageutility.isElementDisplayed(alertElement);
	}

	public void toClickResetbutton() {
		waitutility.waitForElementClickable(driver, resetButtonElement);
		pageutility.isElementDisplayed(resetButtonElement);
		resetButtonElement.click();
	}

	public String toCheckResetof_Title() {
		return pageutility.getElementText(titleElement);
	}

	public String toCheckResetof_Decsription() {
		return pageutility.getElementText(descriptionElement);

	}

}
