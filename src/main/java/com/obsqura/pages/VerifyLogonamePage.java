package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class VerifyLogonamePage {
	public WebDriver driver;

	public VerifyLogonamePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement logonameElement;

	public String getTextLogoname() {
		PageUtility.isElementDisplayed(logonameElement);
		String s = logonameElement.getText();
		return s;
	}
}
