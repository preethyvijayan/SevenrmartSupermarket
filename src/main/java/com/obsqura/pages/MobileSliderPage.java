package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FakeUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class MobileSliderPage {
	public WebDriver driver;
	FakeUtility fakeutility = new FakeUtility();

	public MobileSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButtonElement;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categoryElement;
	@FindBy(css = "input#main_img")
	WebElement UploadFileElement;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButtonElement;
	@FindBy(xpath = "//button[@data-dismiss='alert']//ancestor::div[contains(@class,'alert-dismissible')]")
	WebElement alertElement;
	@FindBy(xpath = "//a[contains(@href,'edit?edit=504&page_ad=1')]")
	WebElement clickStatusElement;
	@FindBy(xpath = "//span[contains(@class,'fa-trash-alt')]")
	WebElement deleteButtonElement;

	public void toClickNewButtonAddingNewSlider() {
		WaitUtility.waitForElementClickable(driver, newButtonElement);
		PageUtility.isElementDisplayed(newButtonElement);
		PageUtility.clickOnElement(newButtonElement);

	}

	public void toSelectCategory(String value) {
		WaitUtility.waitForElementClickable(driver, categoryElement);
		PageUtility.clickOnElement(categoryElement);
		PageUtility.selectDropdownbyText(categoryElement, value);
	}

	public MobileSliderPage toUploadFile() {
		UploadFileElement.sendKeys("E://uploadfile//managetestFile.png");
		return this;

	}

	public MobileSliderPage toClickSaveButtonforAddingNewSlider() {
		WaitUtility.waitForElementClickable(driver, saveButtonElement);
		PageUtility.isElementDisplayed(saveButtonElement);
		PageUtility.clickOnElement(saveButtonElement);
		return this;

	}

	public boolean toDisplayAlertElement() {
		WaitUtility.waitForElementClickable(driver, alertElement);
		return PageUtility.isElementDisplayed(alertElement);
	}

}
