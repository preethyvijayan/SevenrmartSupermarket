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

public class ManageLocationPage {
	public WebDriver driver;
	RandomDataUtility fakeutility = new RandomDataUtility();
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//div[@class='card-header']//following::td") })
	public List<WebElement> tableData;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbuttonElement;
	@FindBy(xpath = "//select[@id='country_id']")
	WebElement countrydropDownforNewElement;
	@FindBy(xpath = "//select[@id='st_id']")
	WebElement stateDropdownForNewElement;

	@FindBy(xpath = "//select[@name='country_id']")
	WebElement countrydropDownforSearchElement;
	@FindBy(xpath = "//select[@name='state_id']")
	WebElement stateDropdownForsearchElement;
	@FindBy(xpath = "//input[@id='location']")
	WebElement locationElement;
	@FindBy(xpath = "//input[@id='location']")
	WebElement LocationSearchElementElement;

	@FindBy(xpath = "//input[@id='delivery']")
	WebElement deliveryChargeElement;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButtonElement;
	@FindBy(xpath = "//button[@data-dismiss='alert']//ancestor::div[contains(@class,'alert-dismissible')]")
	WebElement alertElement;
	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	WebElement searchButtonElement;
	@FindBy(xpath = "//button[@value='sr']")
	WebElement searchButtonForSearchElement;

	public ManageLocationPage clickNewButtonin_ManageLocationPage() {
		waitutility.waitForElementClickable(driver, newbuttonElement);
		pageutility.isElementDisplayed(newbuttonElement);
		newbuttonElement.click();
		return this;
	}

	public ManageLocationPage selectCountryDropdown() {
		waitutility.waitForElementClickable(driver, countrydropDownforNewElement);
		pageutility.selectDropdownbyText(countrydropDownforNewElement, "United Kingdom");
		return this;
	}

	public ManageLocationPage selectStateDropdown() {
		waitutility.waitForElementClickable(driver, stateDropdownForNewElement);
		pageutility.selectDropdownbyText(stateDropdownForNewElement, "England");
		return this;
	}

	public void selectCountryDropdownforSearch(String value) {
		waitutility.waitForElementClickable(driver, countrydropDownforSearchElement);
		pageutility.selectDropdownbyText(countrydropDownforSearchElement, value);

	}

	public void selectStateDropdownforSearch(String value) {
		waitutility.waitForElementClickable(driver, stateDropdownForsearchElement);
		pageutility.selectDropdownbyText(stateDropdownForsearchElement, value);

	}

	public void enterLocationforSearch(String value) {
		pageutility.isElementDisplayed(LocationSearchElementElement);
		waitutility.waitForElementClickable(driver, LocationSearchElementElement);
		LocationSearchElementElement.sendKeys(value);

	}

	public ManageLocationPage enterLocation() {
		pageutility.isElementDisplayed(locationElement);
		waitutility.waitForElementClickable(driver, locationElement);
		locationElement.sendKeys(fakeutility.togetstreetAddress());
		return this;
	}

	public ManageLocationPage enterDeliveryCharges() {
		pageutility.isElementDisplayed(deliveryChargeElement);
		waitutility.waitForElementClickable(driver, deliveryChargeElement);
		deliveryChargeElement.sendKeys(fakeutility.togetStringnumber(2));
		return this;
	}

	public ManageLocationPage clickSaveButtonin_ManageLocationPage() {
		waitutility.waitForElementClickable(driver, saveButtonElement);
		pageutility.isElementDisplayed(saveButtonElement);
		saveButtonElement.click();
		return this;
	}

	public boolean isAlertElementisDisplayed() {
		waitutility.waitForElementClickable(driver, alertElement);
		return pageutility.isElementDisplayed(alertElement);
	}

	public ManageLocationPage clickSearchButtonin_ManageLocationPage() {
		waitutility.waitForElementClickable(driver, searchButtonElement);
		pageutility.isElementDisplayed(searchButtonElement);
		searchButtonElement.click();
		return this;
	}

	public void clickSearchForSearchButtonin_ManageLocationPage() {
		waitutility.waitForElementClickable(driver, searchButtonForSearchElement);
		pageutility.isElementDisplayed(searchButtonForSearchElement);
		searchButtonForSearchElement.click();
	}

	public String getResultTabledata() {

		ArrayList<String> al = new ArrayList<String>();
		for (WebElement data : tableData) {
			String actual = data.getText();

			al.add(actual);

		}
		return al.toString();

	}

	public String gettextLocationFromSearch() {
		return pageutility.getToolTip(LocationSearchElementElement);
	}

}
