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

public class ManageOfferCodePage {
	public WebDriver driver;
	RandomDataUtility fakeutility = new RandomDataUtility();
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManageOfferCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//div[@class='card-header']//following::td") })
	public List<WebElement> tableData;
	@FindBy(xpath = "//a[contains(@href,'list-offercode')]")
	WebElement moreInfoElement;
	@FindBy(xpath = "//h1[text()='List Offercodes']")
	WebElement uniqueElement;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButtonElement;
	@FindBy(xpath = "//input[@id='offer_code']")
	WebElement offerCodeElement;
	@FindBy(xpath = "//input[@value='yes']")
	WebElement yesRadioButtonElement;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButtonElement;
	@FindBy(xpath = "//input[@id='offer_per']")
	WebElement percentageElement;
	@FindBy(xpath = "//input[@id='offer_price']")
	WebElement amountElement;
	@FindBy(xpath = "//div[@role='textbox']//child::p")
	WebElement decsriptionElement;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement fileUploadElement;
	@FindBy(xpath = "//button[@data-dismiss='alert']//ancestor::div[contains(@class,'alert-dismissible')]")
	WebElement alertElement;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButtonElement;
	@FindBy(xpath = "//input[@name='un']")
	WebElement offerCodeForSearchElement;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButtonForSearchElement;

	public ManageOfferCodePage clickMoreinfoForManageofferCode() {
		waitutility.waitForElementClickable(driver, moreInfoElement);
		pageutility.isElementDisplayed(moreInfoElement);
		moreInfoElement.click();
		return this;
	}

	public String checkUniqueElementToVerifytheNavigatedpage() {
		return pageutility.getElementText(uniqueElement);
	}

	public ManageOfferCodePage clickNewButtoninManageOffercodePage() {
		waitutility.waitForElementClickable(driver, newButtonElement);
		pageutility.isElementDisplayed(newButtonElement);
		newButtonElement.click();
		return this;
	}

	public String enterOffercode() {
		pageutility.isElementDisplayed(offerCodeElement);
		offerCodeElement.sendKeys(fakeutility.togetStringnumber(4));
		return offerCodeElement.getAttribute("value");
	}

	public ManageOfferCodePage selectRadioButtoninManageOffercodePage() {
		waitutility.waitForElementClickable(driver, yesRadioButtonElement);
		pageutility.isElementDisplayed(yesRadioButtonElement);
		yesRadioButtonElement.click();
		return this;
	}

	public ManageOfferCodePage enterPercentage() {
		pageutility.isElementDisplayed(percentageElement);
		percentageElement.sendKeys(fakeutility.togetStringnumber(2));
		return this;
	}

	public ManageOfferCodePage enterAmount() {
		pageutility.isElementDisplayed(amountElement);
		amountElement.sendKeys(fakeutility.togetStringnumber(4));
		return this;
	}

	public ManageOfferCodePage enterDescription() {
		pageutility.isElementDisplayed(decsriptionElement);
		decsriptionElement.sendKeys(fakeutility.togetanimalname());
		return this;
	}

	public ManageOfferCodePage uploadFile() {
		try {
			pageutility.sendKey(fileUploadElement, GeneralUtility.IMAGEFILEFORMANAGEOFFERPAGE);

		} catch (Exception e) {
			System.out.println("FileNotFoundException");
		}
		return this;

	}

	public ManageOfferCodePage clickSaveButtoninManageOffercodePage() {
		pageutility.toClickButton(driver, saveButtonElement);
		return this;

	}

	public boolean isAlertElementisDisplayed() {
		waitutility.waitForElementClickable(driver, alertElement);
		return pageutility.isElementDisplayed(alertElement);
	}

	public void clickSearchButtoninManageOffercodePage() {
		waitutility.waitForElementClickable(driver, searchButtonElement);
		pageutility.isElementDisplayed(searchButtonElement);
		searchButtonElement.click();
	}

	public void enterOffercodeForSearch(String value) {
		pageutility.isElementDisplayed(offerCodeForSearchElement);
		offerCodeForSearchElement.sendKeys(value);

	}

	public void clicSearchButtonForSearchinManageOffercodePage() {
		waitutility.waitForElementClickable(driver, searchButtonForSearchElement);
		pageutility.isElementDisplayed(searchButtonForSearchElement);
		searchButtonForSearchElement.click();
	}

	public String getResultTabledata() {

		ArrayList<String> al = new ArrayList<String>();
		for (WebElement data : tableData) {
			String actual = data.getText();

			al.add(actual);

		}
		return al.toString();

	}

	public String gettextOffercode() {
		return pageutility.getToolTip(offerCodeForSearchElement);
	}

}
