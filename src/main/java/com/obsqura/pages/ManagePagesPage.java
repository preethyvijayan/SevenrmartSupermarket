package com.obsqura.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FakeUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;
import io.reactivex.rxjava3.functions.Action;

public class ManagePagesPage {
	public WebDriver driver;

	FakeUtility fakeutility = new FakeUtility();

	public ManagePagesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By searchtableElements = By.xpath("//div[@class='card-header']//following::td");

	By deleteElements = By.xpath("//a[starts-with(@href,'https://groceryapp.uniqassosiates.com/admin/pages/delete')]");

	@FindBy(xpath = "//p[text()='Manage Pages']")
	WebElement managePageSubcatElement;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButtonElement;
	@FindBy(xpath = "//input[@name='un']")
	WebElement titleElement;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement secondSearchButtonElement;

	@FindBy(xpath = "//a[contains(@onclick,'return confirm')]")
	WebElement deleteElement;
	@FindBy(xpath = "//div[@class='card-header']//following::td[1]")
	WebElement toSearchElement;
	@FindBy(xpath = "//section[@class='content']//following::div[4]")
	WebElement alertElement;

	public ManagePagesPage toClickManagePagesCategory() {
		WaitUtility.waitForElementClickable(driver, managePageSubcatElement);
		PageUtility.isElementDisplayed(managePageSubcatElement);
		PageUtility.clickOnElement(managePageSubcatElement);
		return this;
	}

	public String togettableDatatoSearch() {
		PageUtility.isElementDisplayed(toSearchElement);
		return totableData();
	}

	public ManagePagesPage toClickSearchButton() {
		WaitUtility.waitForElementClickable(driver, searchButtonElement);
		PageUtility.isElementDisplayed(searchButtonElement);
		PageUtility.clickOnElement(searchButtonElement);
		return this;
	}

	public String toEnterTitle() {
		PageUtility.isElementDisplayed(titleElement);
		String input = togettableDatatoSearch();
		System.out.println(input);
		PageUtility.enterText(titleElement, input);
		return input;

	}

	public void toClickSecondSearchButton() {
		WaitUtility.waitForElementClickable(driver, secondSearchButtonElement);
		PageUtility.isElementDisplayed(secondSearchButtonElement);
		PageUtility.clickOnElement(secondSearchButtonElement);
	}

	public String togetTitle() {
		PageUtility.isElementDisplayed(titleElement);
		return titleElement.getAttribute("value");

	}

	public String togetTitle1() {
		return todeleteData();
	}

	public String totableData() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> table = driver.findElements(searchtableElements);

		for (WebElement data : table) {
			String actual = data.getText();

			al.add(actual);
		}
		return al.get(0).toString();
	}

	public String todeleteData() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> table = driver.findElements(deleteElements);

		for (WebElement data : table) {
			String actual = data.getAttribute("href");
			System.out.println(actual);
			al.add(actual);
		}
		return al.get(0);

	}

	public void toClickDeleteButton() {
		WaitUtility.waitForElementClickable(driver, deleteElement);
		PageUtility.isElementDisplayed(deleteElement);
		PageUtility.clickOnElement(deleteElement);
		driver.switchTo().alert().accept();
	}

	public boolean toDisplayAlertElement() {
		return PageUtility.isElementDisplayed(alertElement);

	}

}
