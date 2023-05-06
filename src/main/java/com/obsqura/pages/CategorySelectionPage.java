package com.obsqura.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.WaitUtility;

public class CategorySelectionPage {
	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();

	public CategorySelectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//div[@class='os-content']//child::a") })
	public List<WebElement> selectCategories;

	public void clickSelectCategory(String category) {

		for (WebElement categorieslist : selectCategories) {
			if (categorieslist.getText().contains(category)) {
				categorieslist.click();
				break;
			}
		}
	}
}
