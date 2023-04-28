package com.obsqura.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FakeUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageLocationPage {
	public WebDriver driver;
	FakeUtility fakeutility = new FakeUtility();

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By tableData = By.xpath("//div[@class='card-header']//following::td");
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbuttonElement;
	@FindBy(xpath = "//select[@id='country_id']")
	WebElement countrydropDownElement;
	@FindBy(xpath = "//select[@id='st_id']")
	WebElement stateDropdownElement;
	@FindBy(xpath = "//input[@id='location']")
	WebElement locationElement;
	@FindBy(xpath = "//input[@id='delivery']")
	WebElement deliveryChargeElement;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButtonElement;
	@FindBy(xpath = "//button[@data-dismiss='alert']//ancestor::div[contains(@class,'alert-dismissible')]")
	WebElement alertElement;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButtonElement;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButtonForSearchElement;

	public ManageLocationPage toClickNewButtonin_ManageLocationPage() {
		WaitUtility.waitForElementClickable(driver, newbuttonElement);
		PageUtility.isElementDisplayed(newbuttonElement);
		PageUtility.clickOnElement(newbuttonElement);
		return this;
	}

	public ManageLocationPage toSelectCountryDropdown() {
		WaitUtility.waitForElementClickable(driver, countrydropDownElement);
		PageUtility.selectDropdownbyText(countrydropDownElement, "United Kingdom");
		return this;
	}

	public ManageLocationPage toSelectStateDropdown() {
		WaitUtility.waitForElementClickable(driver, stateDropdownElement);
		PageUtility.selectDropdownbyText(stateDropdownElement, "England");
		return this;
	}

	public ManageLocationPage toEnterLocation() {
		PageUtility.isElementDisplayed(locationElement);
		WaitUtility.waitForElementClickable(driver, locationElement);
		PageUtility.enterText(locationElement, fakeutility.togetstreetAddress());
		return this;
	}

	public ManageLocationPage toEnterDeliveryCharges() {
		PageUtility.isElementDisplayed(deliveryChargeElement);
		WaitUtility.waitForElementClickable(driver, deliveryChargeElement);
		PageUtility.enterText(deliveryChargeElement, fakeutility.togetStringnumber(2));
		return this;
	}

	public ManageLocationPage toClickSaveButtonin_ManageLocationPage() {
		WaitUtility.waitForElementClickable(driver, saveButtonElement);
		PageUtility.isElementDisplayed(saveButtonElement);
		PageUtility.clickOnElement(saveButtonElement);
		return this;
	}

	public boolean toDisplayAlertElement() {
		WaitUtility.waitForElementClickable(driver, alertElement);
		return PageUtility.isElementDisplayed(alertElement);
	}

	public ManageLocationPage toClickSearchButtonin_ManageLocationPage() {
		WaitUtility.waitForElementClickable(driver, searchButtonElement);
		PageUtility.isElementDisplayed(searchButtonElement);
		PageUtility.clickOnElement(searchButtonElement);
		return this;
	}

	public void toClickSearchForSearchButtonin_ManageLocationPage() {
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
		return al.toString();

	}

	public String gettextCountry() {
		return countrydropDownElement.getAttribute("value");
	}

	public String gettextState() {
		return stateDropdownElement.getAttribute("value");
	}

}
