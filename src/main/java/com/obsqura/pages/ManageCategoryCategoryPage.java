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

public class ManageCategoryCategoryPage {
	public WebDriver driver;
	RandomDataUtility fakeutility = new RandomDataUtility();
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

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

	public ManageCategoryCategoryPage clickcategoryOptionin_ManageCategory() {
		waitutility.waitForElementClickable(driver, categoryElement);
		pageutility.isElementDisplayed(categoryElement);
		categoryElement.click();
		return this;

	}

	public ManageCategoryCategoryPage clickNewButonforaddingNewCategoryin_ManageCategory() {
		waitutility.waitForElementClickable(driver, newButtonElement);
		pageutility.isElementDisplayed(newButtonElement);
		newButtonElement.click();
		return this;

	}

	public ManageCategoryCategoryPage enterCategoryforaddingNewCategoryin_ManageCategory() {

		pageutility.isElementDisplayed(categoryfieldElement);
		categoryfieldElement.sendKeys(fakeutility.togetProductName());
		return this;

	}

	public ManageCategoryCategoryPage enterGroupforaddingNewCategoryin_ManageCategory() {
		waitutility.waitForElementClickable(driver, selectGroupsElement);
		pageutility.isElementDisplayed(selectGroupsElement);
		pageutility.actionClick(selectGroupsElement, driver);
		return this;

	}

	public ManageCategoryCategoryPage uploadFile() {
		try {
			pageutility.sendKey(choosefileElement, GeneralUtility.IMAGEFILEFORMANAGECATEGORYCATEGORYPAGE);
		} catch (Exception e) {
			System.out.println("FileNotFoundException");
		}
		return this;
	}

	public ManageCategoryCategoryPage clicktopMenuRadiobuttonElement() {
		waitutility.waitForElementClickable(driver, radioButtonNoTopmenuElement);
		pageutility.toClickButton(driver, radioButtonNoTopmenuElement);
		return this;
	}

	public ManageCategoryCategoryPage clicksideMenuRadiobuttonElement() {

		pageutility.toClickButton(driver, radioButtonNoLeftmenuElement);
		return this;

	}

	public ManageCategoryCategoryPage clickSaveButtonin_ManageCategory() {
		pageutility.toClickButton(driver, saveButtonElement);
		return this;
	}

	public boolean isAlertDisplayed() {
		waitutility.waitForElementClickable(driver, alertElement);
		return pageutility.isElementDisplayed(alertElement);
	}

	public String gettextCategory() {
		return pageutility.getToolTip(categoryElement);
	}

}
