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

public class ManagePaymentMethodsPage {
	public WebDriver driver;
	RandomDataUtility fakeutility = new RandomDataUtility();
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManagePaymentMethodsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//div[@class='card-header']//following::td") })
	public List<WebElement> tableData;

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

	public ManagePaymentMethodsPage clickEditButtonin_ManagePaymentMethodsPage() {
		waitutility.waitForElementClickable(driver, editButtonElement);
		pageutility.isElementDisplayed(editButtonElement);
		editButtonElement.click();
		return this;
	}

	public ManagePaymentMethodsPage enterPayLimit() {
		pageutility.isElementDisplayed(payLimitElement);
		pageutility.clearElement(payLimitElement);
		payLimitElement.sendKeys(fakeutility.togetStringnumber(5));
		return this;
	}

	public void enterTitle(String value) {
		pageutility.isElementDisplayed(titleElement);
		pageutility.clearElement(titleElement);
		titleElement.sendKeys(value);
	}

	public ManagePaymentMethodsPage clickUpdateButtonin_ManagePaymentMethodsPage() {
		waitutility.waitForElementClickable(driver, updateButtonElement);
		pageutility.isElementDisplayed(updateButtonElement);
		updateButtonElement.click();
		return this;
	}

	public String getResultfromTabledata() {

		ArrayList<String> al = new ArrayList<String>();
		for (WebElement data : tableData) {
			String actual = data.getText();

			al.add(actual);

		}
		System.out.println(al.toString());
		return al.toString();

	}

	public String gettextfromPayLimit() {
		return pageutility.getToolTip(payLimitElement);
	}

	public String gettextfromTitle() {
		return pageutility.getToolTip(titleElement);
	}

	public boolean isDisplayAlertElementIsDisplayed() {
		waitutility.waitForElementClickable(driver, alertElement);
		return pageutility.isElementDisplayed(alertElement);
	}

}
