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

public class ExpenseCategoryPage {
	public WebDriver driver;
	RandomDataUtility fakeutility = new RandomDataUtility();
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public ExpenseCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//div[@class='card-header']//following::tr") })
	public List<WebElement> table;

	@FindBy(xpath = "//div[@class='card-header']//following::td")
	WebElement expenseCategorySearchElement;
	@FindBy(xpath = "//a[text()=' New']")
	WebElement newButtonElement;
	@FindBy(xpath = "//a[@onclick=\'click_button(2)\']")
	WebElement searchButtonElement;
	@FindBy(xpath = "//a[text()=' Reset']")
	WebElement resetButtoncolorElement;

	@FindBy(css = "input#name")
	WebElement titleElement;
	@FindBy(css = "input#un")
	WebElement searchTitleElement;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButtonElement;
	@FindBy(xpath = "//section[@class='content']//following::div[4]")
	WebElement alertElement;

	@FindBy(xpath = "//button[@name='Create']//following::a[text()='Reset']")
	WebElement resetButtonElement;
	@FindBy(xpath = "//div[@class='card']//td")
	WebElement expenseCategorylistElement;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement toSearchtitleButtonelement;
	@FindBy(xpath = "//div[@class='card-header']//following::tr")
	WebElement tableelement;

	public void clickNewButton() {
		waitutility.waitForElementClickable(driver, newButtonElement);
		pageutility.isElementDisplayed(newButtonElement);
		newButtonElement.click();
	}

	public String enterTitle() {
		pageutility.isElementDisplayed(titleElement);
		String input = fakeutility.togetProductName();
		titleElement.sendKeys(input);
		return input;

	}

	public ExpenseCategoryPage enterTitleforSearch() {
		pageutility.isElementDisplayed(searchTitleElement);
		String value = pageutility.getElementText(expenseCategorySearchElement);
		searchTitleElement.sendKeys(value);
		return this;
	}

	public String getTitleforSearchVerify() {
		return pageutility.getElementText(expenseCategorySearchElement);
	}

	public void clickSavebutton() {
		waitutility.waitForElementClickable(driver, saveButtonElement);
		pageutility.isElementDisplayed(saveButtonElement);
		saveButtonElement.click();
	}

	public void clickResetbutton() {
		waitutility.waitForElementClickable(driver, resetButtonElement);
		pageutility.isElementDisplayed(resetButtonElement);
		resetButtonElement.click();
	}

	public ExpenseCategoryPage clickSearchbutton() {
		waitutility.waitForElementClickable(driver, searchButtonElement);
		pageutility.isElementDisplayed(searchButtonElement);
		searchButtonElement.click();
		return this;
	}

	public ExpenseCategoryPage clicksearchButtoninSearchPage() {
		waitutility.waitForElementClickable(driver, toSearchtitleButtonelement);
		pageutility.isElementDisplayed(toSearchtitleButtonelement);
		toSearchtitleButtonelement.click();
		return this;
	}

	public String gettextFromExpenseCategoryListElement() {
		pageutility.isElementDisplayed(expenseCategorylistElement);
		String output = pageutility.getElementText(expenseCategorylistElement);
		return output;
	}

	public String colorofButtonsNew() {
		return pageutility.getbackgroundcolorofButton(newButtonElement);
	}

	public String colorofButtonsSearch() {
		return pageutility.getbackgroundcolorofButton(searchButtonElement);
	}

	public String colorofButtonsReset() {
		return pageutility.getbackgroundcolorofButton(resetButtoncolorElement);

	}

	public boolean isCheckAlertEnabled() {
		return pageutility.elementIsEnabled(alertElement);

	}

	public String getTableData() {
		ArrayList<String> al = new ArrayList<String>();

		for (WebElement data : table) {
			String actual = data.getText();

			al.add(actual);
		}
		return al.toString();
	}

	public String getTextFromTitle() {
		pageutility.isElementDisplayed(titleElement);
		return pageutility.getToolTip(titleElement);
	}

	public boolean istitleElementDisplayed() {
		return pageutility.isElementDisplayed(titleElement);
	}

	public boolean isResetElementDisplayed() {
		return pageutility.isElementDisplayed(tableelement);
	}

}
