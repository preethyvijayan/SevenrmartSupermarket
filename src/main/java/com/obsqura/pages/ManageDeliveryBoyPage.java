package com.obsqura.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.RandomDataUtility;
import Utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	public WebDriver driver;
	RandomDataUtility fakeutility = new RandomDataUtility();
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//div[@class='card']//child::tr") })
	public List<WebElement> tableElement;
	@FindAll({ @FindBy(xpath = "//div[@class='card']//child::td") })
	public List<WebElement> resulttableElement;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButtonElement;
	@FindBy(css = "input#name")
	WebElement nameElement;
	@FindBy(css = "input#email")
	WebElement emailElement;
	@FindBy(css = "input#phone")
	WebElement phoneElement;
	@FindBy(css = "textarea#address")
	WebElement addressElement;
	@FindBy(css = "input#username ")
	WebElement usernameElement;
	@FindBy(css = "input#password ")
	WebElement passwordElement;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebuttonElement;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement seacrhButtonElement;
	@FindBy(css = "input#un")
	WebElement nameforSearchElement;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButtonforSearchElement;
	@FindBy(css = "input#ut")
	WebElement emailforSearchElement;
	@FindBy(css = "input#ph")
	WebElement phoneNoforSearchElement;

	public ManageDeliveryBoyPage clickSearchButtonin_ManageDeliveryboy() {
		waitutility.waitForElementClickable(driver, seacrhButtonElement);
		pageutility.isElementDisplayed(seacrhButtonElement);
		seacrhButtonElement.click();
		return this;

	}

	public ManageDeliveryBoyPage enterNameForSearch(String value) {

		pageutility.isElementDisplayed(nameforSearchElement);
		nameforSearchElement.sendKeys(value);
		return this;

	}

	public ManageDeliveryBoyPage clickSearchButtonforSearchin_ManageDeliveryboy() {
		waitutility.waitForElementClickable(driver, searchButtonforSearchElement);
		pageutility.isElementDisplayed(searchButtonforSearchElement);
		searchButtonforSearchElement.click();
		return this;

	}

	public ManageDeliveryBoyPage enterEmailForSearch(String value) {

		pageutility.isElementDisplayed(emailforSearchElement);
		emailforSearchElement.sendKeys(value);
		return this;

	}

	public ManageDeliveryBoyPage enterPhoneForSearch(String value) {

		pageutility.isElementDisplayed(phoneNoforSearchElement);
		phoneNoforSearchElement.sendKeys(value);
		return this;
	}

	public String tableData() {
		ArrayList<String> al = new ArrayList<String>();
		for (WebElement data : tableElement) {
			String actual = data.getText();

			al.add(actual);
		}
		return al.toString();
	}

	public String getresultTabledata() {
		ArrayList<String> al = new ArrayList<String>();
		for (WebElement data : resulttableElement) {
			String actual = data.getText();
			al.add(actual);
		}
		return al.toString();
	}

	public ManageDeliveryBoyPage clickNewButtonforAdding() {
		waitutility.waitForElementClickable(driver, newButtonElement);
		pageutility.isElementDisplayed(newButtonElement);
		newButtonElement.click();
		return this;

	}

	public ManageDeliveryBoyPage enterName() {

		pageutility.isElementDisplayed(nameElement);
		nameElement.sendKeys(fakeutility.togetFirstname());
		return this;

	}

	public void enterEmail(String value) {

		pageutility.isElementDisplayed(emailElement);
		emailElement.sendKeys(value);

	}

	public ManageDeliveryBoyPage enterPhone() {

		pageutility.isElementDisplayed(phoneElement);
		phoneElement.sendKeys(fakeutility.togetPhoneNo());
		return this;

	}

	public ManageDeliveryBoyPage enterAddress() {

		pageutility.isElementDisplayed(addressElement);
		addressElement.sendKeys(fakeutility.togetsecondaryAddress());
		return this;

	}

	public ManageDeliveryBoyPage enterUsername() {

		pageutility.isElementDisplayed(usernameElement);
		usernameElement.sendKeys(fakeutility.togetNamewithMiddle());
		return this;

	}

	public ManageDeliveryBoyPage enterPassword() {

		pageutility.isElementDisplayed(passwordElement);
		passwordElement.sendKeys(fakeutility.togetpass());
		return this;
	}

	public ManageDeliveryBoyPage clickSaveButtonforAddingNewDeliveryBoy() {
		pageutility.toClickButton(driver, savebuttonElement);
		return this;

	}

	public String getTextFromUsername() {

		return pageutility.getToolTip(usernameElement);
	}

	public String getTextFromUsernameforsearch() {

		return pageutility.getToolTip(nameforSearchElement);
	}

	public String getTextFromemailforsearch() {

		return pageutility.getToolTip(emailforSearchElement);
	}

	public String getTextFromphoneforsearch() {

		return pageutility.getToolTip(emailforSearchElement);
	}

}
