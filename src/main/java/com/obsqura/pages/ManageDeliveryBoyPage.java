package com.obsqura.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FakeUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	public WebDriver driver;
	FakeUtility fakeutility = new FakeUtility();

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By tableElement = By.xpath("//div[@class='card']//child::tr");
	By resulttableElement = By.xpath("//div[@class='card']//child::td");

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

	public ManageDeliveryBoyPage toClickSearchButtonin_ManageDeliveryboy() {
		WaitUtility.waitForElementClickable(driver, seacrhButtonElement);
		PageUtility.isElementDisplayed(seacrhButtonElement);
		PageUtility.clickOnElement(seacrhButtonElement);
		return this;

	}

	public void toEnterNameForSearch(String value) {

		PageUtility.isElementDisplayed(nameforSearchElement);
		PageUtility.enterText(nameforSearchElement, value);

	}

	public void toClickSearchButtonforSearchin_ManageDeliveryboy() {
		WaitUtility.waitForElementClickable(driver, searchButtonforSearchElement);
		PageUtility.isElementDisplayed(searchButtonforSearchElement);
		PageUtility.clickOnElement(searchButtonforSearchElement);

	}

	public void toEnterEmailForSearch(String value) {

		PageUtility.isElementDisplayed(emailforSearchElement);
		PageUtility.enterText(emailforSearchElement, value);

	}

	public void toEnterPhoneForSearch(String value) {

		PageUtility.isElementDisplayed(phoneNoforSearchElement);
		PageUtility.enterText(phoneNoforSearchElement, value);

	}

	public String tableData() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> table = driver.findElements(tableElement);

		for (WebElement data : table) {
			String actual = data.getText();

			al.add(actual);
		}
		System.out.println("TAble" + al.toString());
		return al.toString();
	}

	public String getresultTabledata() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> table = driver.findElements(resulttableElement);
		for (WebElement data : table) {
			String actual = data.getText();
			al.add(actual);
		}
		System.out.println("result" + al.toString());
		return al.toString();
	}

	public ManageDeliveryBoyPage toClickNewButtonforAdding_in() {
		WaitUtility.waitForElementClickable(driver, newButtonElement);
		PageUtility.isElementDisplayed(newButtonElement);
		PageUtility.clickOnElement(newButtonElement);
		return this;

	}

	public ManageDeliveryBoyPage toEnterName() {

		PageUtility.isElementDisplayed(nameElement);
		PageUtility.enterText(nameElement, fakeutility.togetFirstname());
		return this;

	}

	public ManageDeliveryBoyPage toEnterEmail() {

		PageUtility.isElementDisplayed(emailElement);
		PageUtility.enterText(emailElement, "test123@gmail.com");
		return this;

	}

	public ManageDeliveryBoyPage toEnterPhone() {

		PageUtility.isElementDisplayed(phoneElement);
		PageUtility.enterText(phoneElement, fakeutility.togetPhoneNo());
		return this;

	}

	public ManageDeliveryBoyPage toEnterAddress() {

		PageUtility.isElementDisplayed(addressElement);
		PageUtility.enterText(addressElement, fakeutility.togetsecondaryAddress());
		return this;

	}

	public ManageDeliveryBoyPage toEnterUsername() {

		PageUtility.isElementDisplayed(usernameElement);
		PageUtility.enterText(usernameElement, fakeutility.togetNamewithMiddle());
		return this;

	}

	public ManageDeliveryBoyPage toEnterPassword() {

		PageUtility.isElementDisplayed(passwordElement);
		PageUtility.enterText(passwordElement, fakeutility.togetpass());
		return this;
	}

	public ManageDeliveryBoyPage toClickSaveButtonforAddingNewDeliveryBoy() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", savebuttonElement);
		return this;

	}

	public String getTextFromUsername() {

		return usernameElement.getAttribute("value");
	}

	public String getTextFromUsernameforsearch() {

		return nameforSearchElement.getAttribute("value");
	}

	public String getTextFromemailforsearch() {

		return emailforSearchElement.getAttribute("value");
	}

	public String getTextFromphoneforsearch() {

		return emailforSearchElement.getAttribute("value");
	}

}
