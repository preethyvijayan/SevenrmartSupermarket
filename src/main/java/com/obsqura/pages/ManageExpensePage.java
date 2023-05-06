package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtility;
import Utilities.PageUtility;
import Utilities.RandomDataUtility;
import Utilities.WaitUtility;

public class ManageExpensePage {
	public WebDriver driver;
	RandomDataUtility fakeutility = new RandomDataUtility();
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='nav-link']//child::p[text()='Manage Expense']")
	WebElement manageExpensesecondElement;
	@FindBy(xpath = "//div[@class='card-header']//following::thead")
	WebElement tableHeadingElement;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButtonElement;
	@FindBy(xpath = "//select[@id='user_id']")
	WebElement userElement;
	@FindBy(xpath = "//input[@id='ex_date']")
	WebElement dateElement;
	@FindBy(xpath = "//select[@id='ex_cat']")
	WebElement categoryElement;
	@FindBy(xpath = "//select[@id='order_id']")
	WebElement orderidElement;
	@FindBy(xpath = "//select[@id='purchase_id']")
	WebElement purchaseidElement;
	@FindBy(xpath = "//select[@id='ex_type']")
	WebElement expensetypeElement;
	@FindBy(xpath = "//input[@id='amount']")
	WebElement amountElement;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement remarksElement;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div[1]/div[9]/input")
	WebElement fileElement;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButtonElement;
	@FindBy(xpath = "//div[@class='card-header']//following::tr")
	WebElement tableElement;
	@FindBy(xpath = "//div[@class='datepicker-days']//child::td[@class='active day']")
	WebElement datePickerElement;
	@FindBy(xpath = "//button[@data-dismiss='alert']//ancestor::div[contains(@class,'alert-dismissible')]")
	WebElement alertElement;

	public void selectSubcategoryManageExpense() {
		waitutility.waitForElementClickable(driver, manageExpensesecondElement);
		pageutility.isElementDisplayed(manageExpensesecondElement);
		manageExpensesecondElement.click();

	}

	public String getheadingsofExpenseTable() {
		pageutility.isElementDisplayed(tableHeadingElement);
		return pageutility.getElementText(tableHeadingElement);

	}

	public ManageExpensePage clickNewButtonforAddingexpense() {
		waitutility.waitForElementClickable(driver, newButtonElement);
		pageutility.isElementDisplayed(newButtonElement);
		newButtonElement.click();
		return this;

	}

	public ManageExpensePage selectUser() {
		waitutility.waitForElementClickable(driver, userElement);
		pageutility.selectDropdownbyIndex(userElement, fakeutility.togetnumber(1, 20));
		return this;

	}

	public ManageExpensePage enterDate() {
		waitutility.waitForElementClickable(driver, dateElement);
		dateElement.clear();
		pageutility.isElementDisplayed(dateElement);
		dateElement.sendKeys(fakeutility.togetdate());
		pageutility.isElementDisplayed(datePickerElement);
		datePickerElement.click();
		return this;
	}

	public ManageExpensePage selectCategory() {
		waitutility.waitForElementClickable(driver, categoryElement);
		pageutility.selectDropdownbyIndex(categoryElement, fakeutility.togetnumber(1, 50));
		return this;
	}

	public void selectCategoryforUpdate() {
		waitutility.waitForElementClickable(driver, categoryElement);
		pageutility.selectDropdownbyIndex(categoryElement, 12);
	}

	public ManageExpensePage selectOrderId() {
		waitutility.waitForElementClickable(driver, orderidElement);
		int number = fakeutility.togetnumber(1, 100);
		pageutility.selectDropdownbyIndex(orderidElement, number);
		return this;
	}

	public ManageExpensePage selectPrchaseId() {
		waitutility.waitForElementClickable(driver, purchaseidElement);
		pageutility.selectDropdownbyIndex(purchaseidElement, fakeutility.togetnumber(1, 100));
		return this;
	}

	public ManageExpensePage selectExpensetype() {
		waitutility.waitForElementClickable(driver, expensetypeElement);
		pageutility.selectDropdownbyIndex(expensetypeElement, fakeutility.togetnumber(1, 4));
		return this;
	}

	public ManageExpensePage enterAmount() {
		waitutility.waitForElementClickable(driver, amountElement);
		int amount = fakeutility.togetnumber(100, 3000);
		String number = String.valueOf(amount);
		pageutility.clearElement(amountElement);
		amountElement.sendKeys(number);
		return this;
	}

	public ManageExpensePage enterRemarks() {
		waitutility.waitForElementClickable(driver, remarksElement);
		pageutility.clearElement(remarksElement);
		remarksElement.sendKeys(fakeutility.togetfruit());
		return this;
	}

	public ManageExpensePage uploadFile() {
		try {
			pageutility.sendKey(fileElement, GeneralUtility.IMAGEFILEFORMANAGEEXPENSEPAGE);
		} catch (Exception e) {
			System.out.println("FilenotFoundException");
		}
		return this;

	}

	public ManageExpensePage clickSaveButtonforAddingexpense() {
		waitutility.waitForElementClickable(driver, saveButtonElement);
		pageutility.isElementDisplayed(saveButtonElement);
		pageutility.actionClick(saveButtonElement, driver);
		return this;
	}

	public boolean isDisplayedAlertElement() {
		waitutility.waitForElementClickable(driver, alertElement);
		return pageutility.isElementDisplayed(alertElement);
	}

	public void toDisplaytableElement() {
		waitutility.waitForElementClickable(driver, tableElement);
		pageutility.isElementDisplayed(tableElement);
	}

}
