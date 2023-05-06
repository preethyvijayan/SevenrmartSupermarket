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

public class ManagePagesPage {
	public WebDriver driver;

	RandomDataUtility fakeutility = new RandomDataUtility();
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManagePagesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//div[@class='card-header']//following::td") })
	public List<WebElement> searchtableElements;
	@FindAll({ @FindBy(xpath = "//a[starts-with(@href,'https://groceryapp.uniqassosiates.com/admin/pages/delete')]") })
	public List<WebElement> deleteElements;

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

	public ManagePagesPage clickManagePagesCategory() {
		waitutility.waitForElementClickable(driver, managePageSubcatElement);
		pageutility.isElementDisplayed(managePageSubcatElement);
		managePageSubcatElement.click();
		return this;
	}

	public String gettableDatatoSearch() {
		pageutility.isElementDisplayed(toSearchElement);
		return gettableData();
	}

	public ManagePagesPage clickSearchButton() {
		waitutility.waitForElementClickable(driver, searchButtonElement);
		pageutility.isElementDisplayed(searchButtonElement);
		searchButtonElement.click();
		return this;
	}

	public String enterTitle() {
		pageutility.isElementDisplayed(titleElement);
		String input = gettableDatatoSearch();
		titleElement.sendKeys(input);
		return input;

	}

	public void clickSecondSearchButton() {
		waitutility.waitForElementClickable(driver, secondSearchButtonElement);
		pageutility.isElementDisplayed(secondSearchButtonElement);
		secondSearchButtonElement.click();
	}

	public String getTitle() {
		pageutility.isElementDisplayed(titleElement);
		return pageutility.getToolTip(titleElement);

	}

	public String getdeletedTitle() {
		return getdeleteData();
	}

	public String gettableData() {
		ArrayList<String> al = new ArrayList<String>();
		for (WebElement data : searchtableElements) {
			String actual = data.getText();

			al.add(actual);
		}
		return al.get(0).toString();
	}

	public String getdeleteData() {
		ArrayList<String> al = new ArrayList<String>();
		for (WebElement data : deleteElements) {
			String actual = data.getAttribute("href");
			al.add(actual);
		}
		return al.get(0);

	}

	public void clickDeleteButton() {
		waitutility.waitForElementClickable(driver, deleteElement);
		pageutility.isElementDisplayed(deleteElement);
		deleteElement.click();
		driver.switchTo().alert().accept();
	}

	public boolean isDisplayAlertElementdisplayed() {
		return pageutility.isElementDisplayed(alertElement);

	}

}
