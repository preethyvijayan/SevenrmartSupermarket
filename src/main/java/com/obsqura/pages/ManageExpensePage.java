package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.FakeUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageExpensePage {
	public WebDriver driver;
	FakeUtility fakeutility = new FakeUtility();
	PageUtility pageutility;

	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By tableElements = By.xpath("//div[@class='card-header']//following::tr");

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

	public void toselectSubcategoryManageExpense() {
		WaitUtility.waitForElementClickable(driver, manageExpensesecondElement);
		PageUtility.isElementDisplayed(manageExpensesecondElement);
		PageUtility.clickOnElement(manageExpensesecondElement);

	}

	public String togetheadingsofExpenseTable() {
		PageUtility.isElementDisplayed(tableHeadingElement);
		String s = tableHeadingElement.getText();
		return s;
	}

	public ManageExpensePage toClickNewButtonforAddingexpense() {
		WaitUtility.waitForElementClickable(driver, newButtonElement);
		PageUtility.isElementDisplayed(newButtonElement);
		PageUtility.clickOnElement(newButtonElement);
		return this;

	}

	public ManageExpensePage toSelectUser() {
		WaitUtility.waitForElementClickable(driver, userElement);
		PageUtility.selectDropdownbyIndex(userElement, fakeutility.togetnumber(1, 20));
		return this;

	}

	public ManageExpensePage toEnterDate() {
		WaitUtility.waitForElementClickable(driver, dateElement);
		dateElement.clear();
		PageUtility.isElementDisplayed(dateElement);
		PageUtility.enterText(dateElement, fakeutility.togetdate());
		PageUtility.isElementDisplayed(datePickerElement);
		PageUtility.clickOnElement(datePickerElement);
		return this;
	}

	public ManageExpensePage toSelectCategory() {
		WaitUtility.waitForElementClickable(driver, categoryElement);
		PageUtility.selectDropdownbyIndex(categoryElement, fakeutility.togetnumber(1, 50));
		return this;
	}

	public void toSelectCategoryforUpdate() {
		WaitUtility.waitForElementClickable(driver, categoryElement);
		PageUtility.selectDropdownbyIndex(categoryElement, 12);
	}

	public ManageExpensePage toSelectOrderId() {
		WaitUtility.waitForElementClickable(driver, orderidElement);
		Select objSelect = new Select(orderidElement);
		int number = fakeutility.togetnumber(1, 100);
		objSelect.selectByIndex(number);
		return this;
	}

	public ManageExpensePage toSelectPrchaseId() {
		WaitUtility.waitForElementClickable(driver, purchaseidElement);
		PageUtility.selectDropdownbyIndex(purchaseidElement, fakeutility.togetnumber(1, 100));
		return this;
	}

	public ManageExpensePage toSelectExpensetype() {
		WaitUtility.waitForElementClickable(driver, expensetypeElement);
		PageUtility.selectDropdownbyIndex(expensetypeElement, fakeutility.togetnumber(1, 4));
		return this;
	}

	public ManageExpensePage toEnterAmount() {
		WaitUtility.waitForElementClickable(driver, amountElement);
		int amount = fakeutility.togetnumber(100, 3000);
		String number = String.valueOf(amount);
		amountElement.clear();
		PageUtility.enterText(amountElement, number);
		return this;
	}

	public ManageExpensePage toEnterRemarks() {
		WaitUtility.waitForElementClickable(driver, remarksElement);
		remarksElement.clear();
		PageUtility.enterText(remarksElement, fakeutility.togetfruit());
		return this;
	}

	public ManageExpensePage toUploadFile() {
		fileElement.sendKeys("E://uploadfile//managetestFile.png");
		return this;

	}

	public ManageExpensePage toClickSaveButtonforAddingexpense() {
		WaitUtility.waitForElementClickable(driver, saveButtonElement);
		PageUtility.isElementDisplayed(saveButtonElement);
		Actions actions = new Actions(driver);
		actions.click(saveButtonElement).perform();
		return this;
	}

	public boolean toDisplayAlertElement() {
		WaitUtility.waitForElementClickable(driver, alertElement);
		return PageUtility.isElementDisplayed(alertElement);
	}

	public void toDisplaytableElement() {
		WaitUtility.waitForElementClickable(driver, tableElement);
		PageUtility.isElementDisplayed(tableElement);
	}

	/*
	 * public void togetTabledata() { List<WebElement>
	 * tabledatas=driver.findElements(tableElements);
	 * 
	 * for(WebElement data:tabledatas) { if(data.getText().contains(toSelectUser()))
	 * { data.getText(); break; } WaitUtility.waitForElement(driver, tableElements);
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

}
