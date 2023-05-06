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

public class ManageFooterTextPage {
	public WebDriver driver;
	RandomDataUtility fakeutility = new RandomDataUtility();
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//div[@class='card-header']//following::td") })
	public List<WebElement> tableElements;
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

	public ManageFooterTextPage selectSubcategoryManageFooterText() {
		waitutility.waitForElementClickable(driver, manageFooterTextCategoryElement);
		pageutility.isElementDisplayed(manageFooterTextCategoryElement);
		manageFooterTextCategoryElement.click();
		return this;

	}

	public ManageFooterTextPage clickEditButton() {
		waitutility.waitForElementClickable(driver, editButtonElement);
		pageutility.isElementDisplayed(editButtonElement);
		editButtonElement.click();
		return this;

	}

	public ManageFooterTextPage enterAddress() {
		pageutility.clearElement(addressElement);
		pageutility.isElementDisplayed(addressElement);
		addressElement.sendKeys(fakeutility.togetstreetAddress());
		return this;
	}

	public ManageFooterTextPage enterEmail() {
		pageutility.clearElement(emailElement);
		pageutility.isElementDisplayed(emailElement);
		emailElement.sendKeys(fakeutility.togetemail());
		return this;
	}

	public String getEmail() {
		return pageutility.getToolTip(emailElement);
	}

	public ManageFooterTextPage enterPhoneNo() {
		phoneNoElement.clear();
		pageutility.isElementDisplayed(phoneNoElement);
		phoneNoElement.sendKeys(fakeutility.togetPhoneNo());
		return this;
	}

	public ManageFooterTextPage clickUpdateButton() {
		waitutility.waitForElementClickable(driver, updateButtonElement);
		pageutility.isElementDisplayed(updateButtonElement);
		updateButtonElement.click();
		return this;

	}

	public boolean displayAlertElement() {
		waitutility.waitForElementClickable(driver, alertElement);
		return pageutility.isElementDisplayed(alertElement);
	}

	public String getTabledata() {
		ArrayList<String> al = new ArrayList<String>();
		for (WebElement data : tableElements) {
			String actual = data.getText();

			al.add(actual);
		}
		return al.toString();

	}

}
