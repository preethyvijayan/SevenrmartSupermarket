package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtility;

public class CategorySelectionPage {
	public WebDriver driver;

	public CategorySelectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By selectcategory = By.xpath("//div[@class='os-content']//child::a");

	public void toClickSelectCategory(String category) {
		List<WebElement> selectCategories = driver.findElements(selectcategory);

		for (WebElement categorieslist : selectCategories) {
			if (categorieslist.getText().contains(category)) {
				categorieslist.click();
				break;
			}
			WaitUtility.waitForElementClickable(driver, selectcategory);

		}
	}
}
