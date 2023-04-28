package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FakeUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageNewsPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	FakeUtility fakeutility = new FakeUtility();

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By tableElement = By.xpath("//div[@class='card-header']//following::td");
	@FindBy(xpath = "//p[text()='Manage News']")
	WebElement manageNewsSubcatElement;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButtonElement;
	@FindBy(css = "textarea#news")
	WebElement textAreaElement;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButonElement;
	@FindBy(xpath = "//button[@data-dismiss='alert']//ancestor::div[contains(@class,'alert-dismissible')]")
	WebElement alertElement;
	@FindBy(xpath = "//div[@class='card-header']//following::td[1]")
	WebElement tableElementdata;

	public ManageNewsPage toClickManageNewsPageCategory() {
		WaitUtility.waitForElementClickable(driver, manageNewsSubcatElement);
		PageUtility.isElementDisplayed(manageNewsSubcatElement);
		PageUtility.clickOnElement(manageNewsSubcatElement);
		return this;
	}

	public ManageNewsPage toClickNewButtonElement() {
		WaitUtility.waitForElementClickable(driver, newButtonElement);
		PageUtility.isElementDisplayed(newButtonElement);
		PageUtility.clickOnElement(newButtonElement);
		return this;
	}

	public ManageNewsPage toEnterTextarea() {
		PageUtility.isElementDisplayed(textAreaElement);
		PageUtility.enterText(textAreaElement, fakeutility.togetanimalname());
		return this;

	}

	public ManageNewsPage toClickSaveButtonElement() {
		WaitUtility.waitForElementClickable(driver, saveButonElement);
		PageUtility.isElementDisplayed(saveButonElement);
		PageUtility.clickOnElement(saveButonElement);
		return this;

	}

	public boolean toCheckAlertinManageNewspage() {
		WaitUtility.waitForElementClickable(driver, alertElement);
		return PageUtility.isElementDisplayed(alertElement);
	}

	public String getTabledata() {
		List<WebElement> table = driver.findElements(By.xpath("//table[@id='dtBasicExample']"));
		for (WebElement data : table) {
			String actualData = data.getText();

			System.out.println(actualData);
			// assertTrue(actualData.contains(expectedData), "Expected data is not in
			// table");
		}
		return getTabledata();

	}

}
