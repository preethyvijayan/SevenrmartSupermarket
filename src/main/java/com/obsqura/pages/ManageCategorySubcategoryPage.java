package com.obsqura.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.FakeUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageCategorySubcategoryPage {
	public WebDriver driver;
	FakeUtility fakeutility = new FakeUtility();

	public ManageCategorySubcategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By categoryValuesFromSubcategory = By.xpath("//select[@id='cat_id']");
	By tableData = By.xpath("//div[@class='card-header']//following::td");
	By categoryValuesFromSubcategorySearch = By.xpath("//select[@id='un']");
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

	public ManageCategorySubcategoryPage toSelectSubCategoryMenu() {

		WaitUtility.waitForElementClickable(driver, subCategoryMenuElement);
		PageUtility.isElementDisplayed(subCategoryMenuElement);
		PageUtility.clickOnElement(subCategoryMenuElement);
		return this;
	}

	public ManageCategorySubcategoryPage toClicknewButton() {

		WaitUtility.waitForElementClickable(driver, newButtonElement);
		PageUtility.isElementDisplayed(newButtonElement);
		PageUtility.clickOnElement(newButtonElement);
		return this;
	}

	public ManageCategorySubcategoryPage toSelectCategory() {
		WaitUtility.waitForElementClickable(driver, categoryElement);
		Select objSelect = new Select(categoryElement);
		objSelect.selectByValue("176");
		return this;
	}

	public ManageCategorySubcategoryPage toEnterSubCategory() {
		WaitUtility.waitForElementClickable(driver, subCategoryElement);
		PageUtility.isElementDisplayed(subCategoryElement);
		PageUtility.enterText(subCategoryElement, fakeutility.togetfruit());
		return this;

	}

	public ManageCategorySubcategoryPage toUploadFile() {
		WaitUtility.waitForElementClickable(driver, fileUploadElement);
		fileUploadElement.sendKeys("E://uploadfile//ManageCategoryPage.png");
		return this;
	}

	public ManageCategorySubcategoryPage toClickSaveButton() {
		WaitUtility.waitForElementClickable(driver, saveButtonElement);
		PageUtility.isElementDisplayed(saveButtonElement);
		PageUtility.clickOnElement(saveButtonElement);
		return this;
	}

	public boolean toCheckAlert() {
		WaitUtility.waitForElementClickable(driver, alertElement);
		return PageUtility.isElementDisplayed(alertElement);
	}

	public void toClickSearchButton() {
		WaitUtility.waitForElementClickable(driver, searchButtonElement);
		PageUtility.isElementDisplayed(searchButtonElement);
		PageUtility.clickOnElement(searchButtonElement);
	}

	public String toGetCategory() {

		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> table = driver.findElements(categoryValuesFromSubcategory);

		for (WebElement data : table) {
			String actual = data.getText();

			al.add(actual);

		}
		System.out.println(al.toString());
		return al.toString();

	}

	public String toGetCategoryFromSearch() {

		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> table = driver.findElements(categoryValuesFromSubcategorySearch);

		for (WebElement data : table) {
			String actual = data.getText();

			al.add(actual);

		}
		System.out.println(al.toString());
		return al.toString();

	}

	public void toSelectCategoryforSearch(String value) {

		WaitUtility.waitForElementClickable(driver, categoryValuesByindexFromSubcategorySearch);
		Select objSelect = new Select(categoryValuesByindexFromSubcategorySearch);
		objSelect.selectByValue(value);

	}

	public void toEnterSubCategoryForSearch(String value) {
		WaitUtility.waitForElementClickable(driver, subCategoryinSearchElement);
		PageUtility.enterText(subCategoryinSearchElement, value);

	}

	public void toClickSearchButtonForSearch() {

		WaitUtility.waitForElementClickable(driver, searchButtonforSearchElement);
		PageUtility.isElementDisplayed(searchButtonforSearchElement);
		PageUtility.clickOnElement(searchButtonforSearchElement);
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

	public String gettextCategory() {
		return subCategoryinSearchElement.getAttribute("value");
	}

}
