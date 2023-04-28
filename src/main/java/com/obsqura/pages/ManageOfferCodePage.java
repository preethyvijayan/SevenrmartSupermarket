package com.obsqura.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FakeUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageOfferCodePage {
	public WebDriver driver;
	FakeUtility fakeutility = new FakeUtility();

	public ManageOfferCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By tableData = By.xpath("//div[@class='card-header']//following::td");
	@FindBy(xpath = "//a[contains(@href,'list-offercode')]")
	WebElement moreInfoElement;
	@FindBy(xpath = "//h1[text()='List Offercodes']")
	WebElement uniqueElement;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButtonElement;
	@FindBy(xpath = "//input[@id='offer_code']")
	WebElement offerCodeElement;
	@FindBy(xpath = "//input[@value='yes']")
	WebElement yesRadioButtonElement;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButtonElement;
	@FindBy(xpath = "//input[@id='offer_per']")
	WebElement percentageElement;
	@FindBy(xpath = "//input[@id='offer_price']")
	WebElement amountElement;
	@FindBy(xpath = "//div[@role='textbox']//child::p")
	WebElement decsriptionElement;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement fileUploadElement;
	@FindBy(xpath = "//button[@data-dismiss='alert']//ancestor::div[contains(@class,'alert-dismissible')]")
	WebElement alertElement;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButtonElement;
	@FindBy(xpath = "//input[@name='un']")
	WebElement offerCodeForSearchElement;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButtonForSearchElement;

	public ManageOfferCodePage toClickMoreinfoForManageofferCode() {
		WaitUtility.waitForElementClickable(driver, moreInfoElement);
		PageUtility.isElementDisplayed(moreInfoElement);
		PageUtility.clickOnElement(moreInfoElement);
		return this;
	}

	public String toCheckUniqueElementToVerifytheNavigatedpage() {
		return uniqueElement.getText();
	}

	public ManageOfferCodePage toClickNewButtoninManageOffercodePage() {
		WaitUtility.waitForElementClickable(driver, newButtonElement);
		PageUtility.isElementDisplayed(newButtonElement);
		PageUtility.clickOnElement(newButtonElement);
		return this;
	}

	public String toEnterOffercode() {
		PageUtility.isElementDisplayed(offerCodeElement);
		PageUtility.enterText(offerCodeElement, fakeutility.togetStringnumber(4));
		return offerCodeElement.getAttribute("value");
	}

	public ManageOfferCodePage toSelectRadioButtoninManageOffercodePage() {
		WaitUtility.waitForElementClickable(driver, yesRadioButtonElement);
		PageUtility.isElementDisplayed(yesRadioButtonElement);
		PageUtility.clickOnElement(yesRadioButtonElement);
		return this;
	}

	public ManageOfferCodePage toEnterPercentage() {
		PageUtility.isElementDisplayed(percentageElement);
		PageUtility.enterText(percentageElement, fakeutility.togetStringnumber(2));
		return this;
	}

	public ManageOfferCodePage toEnterAmount() {
		PageUtility.isElementDisplayed(amountElement);
		PageUtility.enterText(amountElement, fakeutility.togetStringnumber(4));
		return this;
	}

	public ManageOfferCodePage toEnterDescription() {
		PageUtility.isElementDisplayed(decsriptionElement);
		PageUtility.enterText(decsriptionElement, fakeutility.togetanimalname());
		return this;
	}

	public ManageOfferCodePage toUploadFile() {
		fileUploadElement.sendKeys("E://uploadfile//managetestFile.png");
		return this;

	}

	public ManageOfferCodePage toClickSaveButtoninManageOffercodePage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", saveButtonElement);
		return this;

	}

	public boolean toDisplayAlertElement() {
		WaitUtility.waitForElementClickable(driver, alertElement);
		return PageUtility.isElementDisplayed(alertElement);
	}

	public void toClickSearchButtoninManageOffercodePage() {
		WaitUtility.waitForElementClickable(driver, searchButtonElement);
		PageUtility.isElementDisplayed(searchButtonElement);
		PageUtility.clickOnElement(searchButtonElement);
	}

	public void toEnterOffercodeForSearch(String value) {
		PageUtility.isElementDisplayed(offerCodeForSearchElement);
		PageUtility.enterText(offerCodeForSearchElement, value);

	}

	public void toClicSearchButtonForSearchinManageOffercodePage() {
		WaitUtility.waitForElementClickable(driver, searchButtonForSearchElement);
		PageUtility.isElementDisplayed(searchButtonForSearchElement);
		PageUtility.clickOnElement(searchButtonForSearchElement);
	}

	public String togetResultTabledata() {

		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> table = driver.findElements(tableData);

		for (WebElement data : table) {
			String actual = data.getText();

			al.add(actual);

		}
		System.out.println(al.toString());
		return al.toString();

	}

	public String gettextOffercode() {
		return offerCodeForSearchElement.getAttribute("value");
	}

}
