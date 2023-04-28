package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FakeUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageSliderPage {
	public WebDriver driver;
	FakeUtility fakeutility = new FakeUtility();

	public ManageSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement NewButtonElement;

	// @FindBy(css="input#main_img") WebElement uploadButtonElement;
	@FindBy(xpath = "//input[@id='link']")
	WebElement linkElement;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButtonElement;
	@FindBy(xpath = "//div[@class='card-header']//following::td")
	WebElement tableContentElement;
	@FindBy(xpath = "//button[@data-dismiss='alert']//ancestor::div[contains(@class,'alert-dismissible')]")
	WebElement alertElement;

	public void toClickNewButton() {
		WaitUtility.waitForElementClickable(driver, NewButtonElement);
		PageUtility.isElementDisplayed(NewButtonElement);
		PageUtility.clickOnElement(NewButtonElement);
	}

	public void toEnterLinkelement(String value) {
		PageUtility.isElementDisplayed(linkElement);
		fakeutility.togetWebsite();
		PageUtility.enterText(linkElement, value);

	}

	/*
	 * public void toClickUploadButton() {
	 * uploadButtonElement.sendKeys("E:\\uploadfile\\Screenshot_20221203_110531.png"
	 * ); }
	 */
	public void toClickSaveButtonelement() {
		WaitUtility.waitForElementClickable(driver, saveButtonElement);
		PageUtility.isElementDisplayed(saveButtonElement);
		PageUtility.clickOnElement(saveButtonElement);

	}

	public String toGetTabledetails() {
		PageUtility.isElementDisplayed(tableContentElement);
		String s = tableContentElement.getText();
		return s;
	}

	public boolean toCheckAlert() {
		WaitUtility.waitForElementClickable(driver, alertElement);
		return PageUtility.isElementDisplayed(alertElement);

	}

}
