package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtility;
import Utilities.PageUtility;
import Utilities.RandomDataUtility;
import Utilities.WaitUtility;

public class ManageSliderPage {
	public WebDriver driver;
	RandomDataUtility fakeutility = new RandomDataUtility();
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManageSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement NewButtonElement;
	@FindBy(css = "input#main_img")
	WebElement uploadButtonElement;
	@FindBy(xpath = "//input[@id='link']")
	WebElement linkElement;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButtonElement;
	@FindBy(xpath = "//div[@class='card-header']//following::td")
	WebElement tableContentElement;
	@FindBy(xpath = "//button[@data-dismiss='alert']//ancestor::div[contains(@class,'alert-dismissible')]")
	WebElement alertElement;

	public ManageSliderPage clickNewButton() {
		waitutility.waitForElementClickable(driver, NewButtonElement);
		pageutility.isElementDisplayed(NewButtonElement);
		NewButtonElement.click();
		return this;
	}

	public void enterLinkelement(String value) {
		pageutility.isElementDisplayed(linkElement);
		fakeutility.togetWebsite();
		linkElement.sendKeys(value);

	}

	public ManageSliderPage clickUploadButton() {
		try {
			pageutility.sendKey(uploadButtonElement, GeneralUtility.IMAGEFILEFORMANAGECATEGORYCATEGORYPAGE);
		} catch (Exception e) {
			System.out.println("FileNotFoundException");
		}
		return this;
	}

	public void clickSaveButtonelement() {
		waitutility.waitForElementClickable(driver, saveButtonElement);
		pageutility.isElementDisplayed(saveButtonElement);
		saveButtonElement.click();

	}

	public String getTabledetails() {
		pageutility.isElementDisplayed(tableContentElement);
		return pageutility.getElementText(tableContentElement);

	}

	public boolean isCheckAlertIsDisplayed() {
		waitutility.waitForElementClickable(driver, alertElement);
		return pageutility.isElementDisplayed(alertElement);

	}

}
