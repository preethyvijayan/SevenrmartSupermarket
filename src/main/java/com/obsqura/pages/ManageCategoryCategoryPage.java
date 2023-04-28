package com.obsqura.pages;

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

public class ManageCategoryCategoryPage {
	public WebDriver driver;
	FakeUtility fakeutility = new FakeUtility();

	public ManageCategoryCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By categoryValuesFromCatergory = By.xpath("//div[@class='card ']//child::td");

	@FindBy(xpath = "//p[text()='Category']")
	WebElement categoryElement;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButtonElement;
	@FindBy(css = "input.form-control[id='category']")
	WebElement categoryfieldElement;
	@FindBy(xpath = "//div[@class='ms-container']//child::li[1]")
	WebElement selectGroupsElement;
	@FindBy(xpath = "//div[@class='ms-selection']")
	WebElement dropselectGroupsElement;
	@FindBy(css = "input#main_img")
	WebElement choosefileElement;

	@FindBy(xpath = "//input[@value='no' and @name='top_menu']")
	WebElement radioButtonNoTopmenuElement;

	@FindBy(xpath = "//input[@value='no' and @name='show_home']")
	WebElement radioButtonNoLeftmenuElement;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButtonElement;

	@FindBy(xpath = "//button[@data-dismiss='alert']//ancestor::div[contains(@class,'alert-dismissible')]")
	WebElement alertElement;

	public ManageCategoryCategoryPage toClickcategoryOptionin_ManageCategory() {
		WaitUtility.waitForElementClickable(driver, categoryElement);
		PageUtility.isElementDisplayed(categoryElement);
		PageUtility.clickOnElement(categoryElement);
		return this;

	}

	public ManageCategoryCategoryPage toClickNewButonforaddingNewCategoryin_ManageCategory() {
		WaitUtility.waitForElementClickable(driver, newButtonElement);
		PageUtility.isElementDisplayed(newButtonElement);
		PageUtility.clickOnElement(newButtonElement);
		return this;

	}

	public ManageCategoryCategoryPage toEnterCategoryforaddingNewCategoryin_ManageCategory(String value) {

		PageUtility.isElementDisplayed(categoryfieldElement);
		PageUtility.enterText(categoryfieldElement, value);
		return this;

	}

	public ManageCategoryCategoryPage toEnterGroupforaddingNewCategoryin_ManageCategory() {
		WaitUtility.waitForElementClickable(driver, selectGroupsElement);
		PageUtility.isElementDisplayed(selectGroupsElement);
		Actions action = new Actions(driver);
		action.click(selectGroupsElement).perform();
		return this;

	}

	public ManageCategoryCategoryPage toUploadFile() {
		choosefileElement.sendKeys("E://uploadfile//ManageCategoryPage.png");
		return this;

	}

	public ManageCategoryCategoryPage toClicktopMenuRadiobuttonElementisSelected() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", radioButtonNoTopmenuElement);
		return this;
	}

	public ManageCategoryCategoryPage toClicksideMenuRadiobuttonElementisSelected() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", radioButtonNoLeftmenuElement);
		return this;

	}

	public ManageCategoryCategoryPage toClickSaveButtonin_ManageCategory() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", saveButtonElement);
		return this;
	}

	public boolean toCheckAlert() {
		WaitUtility.waitForElementClickable(driver, alertElement);
		return PageUtility.isElementDisplayed(alertElement);
	}

	public String gettextCategory() {
		return categoryElement.getAttribute("value");
	}

}
