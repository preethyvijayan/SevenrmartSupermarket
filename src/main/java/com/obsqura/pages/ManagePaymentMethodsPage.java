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

public class ManagePaymentMethodsPage {
	public WebDriver driver;
	FakeUtility fakeutility = new FakeUtility();

	public ManagePaymentMethodsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By tableData = By.xpath("//div[@class='card-header']//following::td");
	@FindBy(xpath = "//a[contains(@href,'edit=1&page_ad=1')]")
	WebElement editButtonElement;
	@FindBy(xpath = "//input[@id='name']")
	WebElement titleElement;
	@FindBy(xpath = "//input[@id='limit']")
	WebElement payLimitElement;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButtonElement;
	@FindBy(xpath = "//button[@data-dismiss='alert']//ancestor::div[contains(@class,'alert-dismissible')]")
	WebElement alertElement;

	public ManagePaymentMethodsPage toClickEditButtonin_ManagePaymentMethodsPage() {
		WaitUtility.waitForElementClickable(driver, editButtonElement);
		PageUtility.isElementDisplayed(editButtonElement);
		PageUtility.clickOnElement(editButtonElement);
		return this;
	}

	public ManagePaymentMethodsPage toEnterPayLimit() {
		PageUtility.isElementDisplayed(payLimitElement);
		payLimitElement.clear();
		PageUtility.enterText(payLimitElement, fakeutility.togetStringnumber(5));
		return this;
	}

	public void toEnterTitle(String value) {
		PageUtility.isElementDisplayed(titleElement);
		titleElement.clear();
		PageUtility.enterText(titleElement, value);
	}

	public ManagePaymentMethodsPage toClickUpdateButtonin_ManagePaymentMethodsPage() {
		WaitUtility.waitForElementClickable(driver, updateButtonElement);
		PageUtility.isElementDisplayed(updateButtonElement);
		PageUtility.clickOnElement(updateButtonElement);
		return this;
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

	public String gettextPayLimit() {
		return payLimitElement.getAttribute("value");
	}

	public String gettextTitle() {
		return titleElement.getAttribute("value");
	}

	public boolean toDisplayAlertElement() {
		WaitUtility.waitForElementClickable(driver, alertElement);
		return PageUtility.isElementDisplayed(alertElement);
	}

}
