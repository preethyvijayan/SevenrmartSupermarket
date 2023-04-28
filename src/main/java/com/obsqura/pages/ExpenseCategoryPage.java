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

public class ExpenseCategoryPage {
	public WebDriver driver;
	FakeUtility fakeutility = new FakeUtility();

	public ExpenseCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By tableElements = By.xpath("//div[@class='card-header']//following::tr");
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

	public void toClickNewButton() {
		WaitUtility.waitForElementClickable(driver, newButtonElement);
		PageUtility.isElementDisplayed(newButtonElement);
		PageUtility.clickOnElement(newButtonElement);
	}

	public String toEnterTitle() {
		PageUtility.isElementDisplayed(titleElement);
		String input = fakeutility.togetfoodName();
		PageUtility.enterText(titleElement, input);
		return input;

	}

	public ExpenseCategoryPage toEnterTitleforSearch() {
		PageUtility.isElementDisplayed(searchTitleElement);
		String value = expenseCategorySearchElement.getText();
		PageUtility.enterText(searchTitleElement, value);
		return this;

	}

	public String toEnterTitleforSearchVerify() {
		String s = expenseCategorySearchElement.getText();
		return s;

	}

	public void toClickSavebutton() {
		WaitUtility.waitForElementClickable(driver, saveButtonElement);
		PageUtility.isElementDisplayed(saveButtonElement);
		PageUtility.clickOnElement(saveButtonElement);
	}

	public void toClickResetbutton() {
		WaitUtility.waitForElementClickable(driver, resetButtonElement);
		PageUtility.isElementDisplayed(resetButtonElement);
		PageUtility.clickOnElement(resetButtonElement);
	}

	public ExpenseCategoryPage toClickSearchbutton() {
		WaitUtility.waitForElementClickable(driver, searchButtonElement);
		PageUtility.isElementDisplayed(searchButtonElement);
		PageUtility.clickOnElement(searchButtonElement);
		return this;
	}

	public ExpenseCategoryPage toclicksearchofsearchbutton() {
		WaitUtility.waitForElementClickable(driver, toSearchtitleButtonelement);
		PageUtility.isElementDisplayed(toSearchtitleButtonelement);
		PageUtility.clickOnElement(toSearchtitleButtonelement);
		return this;
	}

	public String toverifytheCategoryListafteraddingnewCategory() {
		PageUtility.isElementDisplayed(expenseCategorylistElement);
		String output = PageUtility.getElementText(expenseCategorylistElement);
		return output;
	}

	public String colorofButtonsNew() {
		return PageUtility.getbackgroundcolorofButton(newButtonElement);

	}

	public String colorofButtonsSearch() {
		return PageUtility.getbackgroundcolorofButton(searchButtonElement);
	}

	public String colorofButtonsReset() {
		return PageUtility.getbackgroundcolorofButton(resetButtoncolorElement);

	}

	public boolean toCheckAlert() {
		return PageUtility.isElementDisplayed(alertElement);

	}

	public String totableData() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> table = driver.findElements(tableElements);

		for (WebElement data : table) {
			String actual = data.getText();

			al.add(actual);
		}
		return al.toString();
	}

	public String togetTitle() {
		PageUtility.isElementDisplayed(titleElement);
		return titleElement.getAttribute("value");

	}

	public boolean titleElementDisplay() {
		return PageUtility.isElementDisplayed(titleElement);
	}

	public boolean toReset() {
		return PageUtility.isElementDisplayed(tableelement);
	}

}
