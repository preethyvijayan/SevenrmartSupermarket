package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtility;
import Utilities.PageUtility;
import Utilities.RandomDataUtility;
import Utilities.WaitUtility;

public class MobileSliderPage {
	public WebDriver driver;
	RandomDataUtility fakeutility = new RandomDataUtility();
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

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

	public void toClickNewButtonAddingNewSlider() {
		waitutility.waitForElementClickable(driver, newButtonElement);
		pageutility.isElementDisplayed(newButtonElement);
		newButtonElement.click();

	}

	public void toSelectCategory(String value) {
		waitutility.waitForElementClickable(driver, categoryElement);
		categoryElement.click();
		pageutility.selectDropdownbyText(categoryElement, value);
	}

	public MobileSliderPage toUploadFile() {
		try {
			pageutility.sendKey(UploadFileElement, GeneralUtility.IMAGEFILEFORMANAGEEXPENSEPAGE);

		} catch (Exception e) {
			System.out.println("FileNotFoundException");
		}
		return this;

	}

	public MobileSliderPage toClickSaveButtonforAddingNewSlider() {
		waitutility.waitForElementClickable(driver, saveButtonElement);
		pageutility.isElementDisplayed(saveButtonElement);
		saveButtonElement.click();
		return this;

	}

	public boolean toDisplayAlertElement() {
		waitutility.waitForElementClickable(driver, alertElement);
		return pageutility.isElementDisplayed(alertElement);
	}

}
