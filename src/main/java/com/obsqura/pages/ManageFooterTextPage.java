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

public class ManageFooterTextPage {
	public WebDriver driver;
	FakeUtility fakeutility = new FakeUtility();
	PageUtility pageutility;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By tableElements = By.xpath("//div[@class='card-header']//following::td");
	@FindBy(xpath = "//p[starts-with(text(),'Manage Footer')]")
	WebElement manageFooterTextCategoryElement;
	@FindBy(xpath = "//a[contains(@href,'edit=2')]")
	WebElement editButtonElement;
	@FindBy(css = "textarea#content")
	WebElement addressElement;
	@FindBy(css = "input#email")
	WebElement emailElement;
	@FindBy(css = "input#phone")
	WebElement phoneNoElement;
	@FindBy(css = "button[name='Update']")
	WebElement updateButtonElement;
	@FindBy(xpath = "//button[@data-dismiss='alert']//ancestor::div[contains(@class,'alert-dismissible')]")
	WebElement alertElement;

	public ManageFooterTextPage toselectSubcategoryManageFooterText() {
		WaitUtility.waitForElementClickable(driver, manageFooterTextCategoryElement);
		PageUtility.isElementDisplayed(manageFooterTextCategoryElement);
		PageUtility.clickOnElement(manageFooterTextCategoryElement);
		return this;

	}

	public ManageFooterTextPage toClickEditButton() {
		WaitUtility.waitForElementClickable(driver, editButtonElement);
		PageUtility.isElementDisplayed(editButtonElement);
		PageUtility.clickOnElement(editButtonElement);
		return this;

	}

	public ManageFooterTextPage toEnterAddress() {
		addressElement.clear();
		PageUtility.isElementDisplayed(addressElement);
		PageUtility.enterText(addressElement, fakeutility.togetstreetAddress());
		return this;
	}

	public ManageFooterTextPage toEnterEmail() {
		emailElement.clear();
		PageUtility.isElementDisplayed(emailElement);
		PageUtility.enterText(emailElement, fakeutility.togetemail());
		return this;
	}

	public String toGetEmail() {
		return emailElement.getAttribute("value");
	}

	public ManageFooterTextPage toEnterPhoneNo() {
		phoneNoElement.clear();
		PageUtility.isElementDisplayed(phoneNoElement);
		PageUtility.enterText(phoneNoElement, fakeutility.togetPhoneNo());
		return this;
	}

	public ManageFooterTextPage toClickUpdateButton() {
		WaitUtility.waitForElementClickable(driver, updateButtonElement);
		PageUtility.isElementDisplayed(updateButtonElement);
		PageUtility.clickOnElement(updateButtonElement);
		return this;

	}

	public boolean toDisplayAlertElement() {
		WaitUtility.waitForElementClickable(driver, alertElement);
		return PageUtility.isElementDisplayed(alertElement);
	}

	public String getTabledata() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> table = driver.findElements(tableElements);

		for (WebElement data : table) {
			String actual = data.getText();

			al.add(actual);
		}
		return al.toString();

	}

}
