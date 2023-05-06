package com.obsqura.pages;

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

public class ManageNewsPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	RandomDataUtility fakeutility = new RandomDataUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//table[@id='dtBasicExample']") })
	public List<WebElement> tableElement;

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

	public ManageNewsPage clickManageNewsPageCategory() {
		waitutility.waitForElementClickable(driver, manageNewsSubcatElement);
		pageutility.isElementDisplayed(manageNewsSubcatElement);
		manageNewsSubcatElement.click();
		return this;
	}

	public ManageNewsPage clickNewButtonElement() {
		waitutility.waitForElementClickable(driver, newButtonElement);
		pageutility.isElementDisplayed(newButtonElement);
		newButtonElement.click();
		return this;
	}

	public ManageNewsPage enterTextarea() {
		pageutility.isElementDisplayed(textAreaElement);
		textAreaElement.sendKeys(fakeutility.togetanimalname());
		return this;

	}

	public ManageNewsPage clickSaveButtonElement() {
		waitutility.waitForElementClickable(driver, saveButonElement);
		pageutility.isElementDisplayed(saveButonElement);
		saveButonElement.click();
		return this;

	}

	public boolean isCheckAlertisDisplayedinManageNewspage() {
		waitutility.waitForElementClickable(driver, alertElement);
		return pageutility.isElementDisplayed(alertElement);
	}

	public String getTabledata() {
		for (WebElement data : tableElement) {
			data.getText();
		}
		return getTabledata();

	}

}
