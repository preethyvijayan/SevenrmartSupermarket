package com.obsqura.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtility;
import Utilities.PageUtility;
import Utilities.RandomDataUtility;
import Utilities.WaitUtility;

public class ManageCategorySubcategoryPage {
	public WebDriver driver;
	RandomDataUtility fakeutility = new RandomDataUtility();
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManageCategorySubcategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//select[@id='cat_id']") })
	public List<WebElement> categoryValuesFromSubcategory;
	@FindAll({ @FindBy(xpath = "//select[@id='un']") })
	public List<WebElement> categoryValuesFromSubcategorySearch;
	@FindAll({ @FindBy(xpath = "//div[@class='card-header']//following::td") })
	public List<WebElement> tableData;

	@FindBy(xpath = "//p[text()='Sub Category']")
	WebElement subCategoryMenuElement;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButtonElement;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categoryElement;
	@FindBy(css = "input#subcategory")
	WebElement subCategoryElement;
	@FindBy(css = "input#main_img")
	WebElement fileUploadElement;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButtonElement;
	@FindBy(xpath = "//button[@data-dismiss='alert']//ancestor::div[contains(@class,'alert-dismissible')]")
	WebElement alertElement;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButtonElement;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement subCategoryinSearchElement;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButtonforSearchElement;
	@FindBy(xpath = "//select[@id='un']")
	WebElement categoryValuesByindexFromSubcategorySearch;

	public ManageCategorySubcategoryPage selectSubCategoryMenu() {

		waitutility.waitForElementClickable(driver, subCategoryMenuElement);
		pageutility.isElementDisplayed(subCategoryMenuElement);
		subCategoryMenuElement.click();
		return this;
	}

	public ManageCategorySubcategoryPage clickNewButton() {

		waitutility.waitForElementClickable(driver, newButtonElement);
		pageutility.isElementDisplayed(newButtonElement);
		newButtonElement.click();
		return this;
	}

	public void selectCategory(String text) {
		waitutility.waitForElementClickable(driver, categoryElement);
		pageutility.selectDropdownbyText(categoryElement, text);

	}

	public ManageCategorySubcategoryPage enterSubCategory() {
		waitutility.waitForElementClickable(driver, subCategoryElement);
		pageutility.isElementDisplayed(subCategoryElement);
		subCategoryElement.sendKeys(fakeutility.togetVegetableName());
		return this;

	}

	public ManageCategorySubcategoryPage uploadFile() {
		waitutility.waitForElementClickable(driver, fileUploadElement);
		try {
			pageutility.sendKey(fileUploadElement, GeneralUtility.IMAGEFILEFORMANAGECATEGORYCATEGORYPAGE);
		} catch (Exception e) {
			System.out.println("FilenotFoundException");
		}
		return this;
	}

	public ManageCategorySubcategoryPage clickSaveButton() {
		waitutility.waitForElementClickable(driver, saveButtonElement);
		pageutility.isElementDisplayed(saveButtonElement);
		saveButtonElement.click();
		return this;
	}

	public boolean isCheckAlertDisplayed() {
		waitutility.waitForElementClickable(driver, alertElement);
		return pageutility.isElementDisplayed(alertElement);
	}

	public void clickSearchButton() {
		waitutility.waitForElementClickable(driver, searchButtonElement);
		pageutility.isElementDisplayed(searchButtonElement);
		searchButtonElement.click();
	}

	public String getCategory() {

		ArrayList<String> al = new ArrayList<String>();
		for (WebElement data : categoryValuesFromSubcategory) {
			String actual = data.getText();

			al.add(actual);

		}

		return al.toString();

	}

	public String getCategoryFromSearch() {

		ArrayList<String> al = new ArrayList<String>();
		for (WebElement data : categoryValuesFromSubcategorySearch) {
			String actual = data.getText();

			al.add(actual);

		}

		return al.toString();

	}

	public void selectCategoryforSearch(String value) {

		waitutility.waitForElementClickable(driver, categoryValuesByindexFromSubcategorySearch);
		pageutility.selectDropdownbyText(categoryValuesByindexFromSubcategorySearch, value);

	}

	public void enterSubCategoryForSearch(String value) {
		waitutility.waitForElementClickable(driver, subCategoryinSearchElement);
		subCategoryinSearchElement.sendKeys(value);

	}

	public void clickSearchButtonForSearch() {

		waitutility.waitForElementClickable(driver, searchButtonforSearchElement);
		pageutility.isElementDisplayed(searchButtonforSearchElement);
		searchButtonforSearchElement.click();
	}

	public String getResultTabledata() {

		ArrayList<String> al = new ArrayList<String>();

		for (WebElement data : tableData) {
			String actual = data.getText();

			al.add(actual);
		}
		return al.toString();
	}

	public String gettextCategory() {
		return pageutility.getToolTip(subCategoryinSearchElement);

	}

}
