package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;

import com.obsqura.pages.ManageCategorySubcategoryPage;

import Utilities.ExcelUtility;
import Utilities.TestDataUtility;

public class ManageCategorySubcategoryTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageCategorySubcategoryPage managecategorysubcategorypage;

	@Test(retryAnalyzer = Retry.class)
	public void AddingnewSubCategoryin_SubCategorypage() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(15, 0, TestDataUtility.getProperty(), "Categories"));
		managecategorysubcategorypage = new ManageCategorySubcategoryPage(driver);
		managecategorysubcategorypage.toSelectSubCategoryMenu().toClicknewButton().toSelectCategory()
				.toEnterSubCategory().toUploadFile().toClickSaveButton();
		assertTrue(managecategorysubcategorypage.toCheckAlert() == true,
				"Alert message Sub category created succesfully is not displayed");
	}

	@Test(retryAnalyzer = Retry.class)
	public void verifythecategoryinNew_SubcategoryPageAndSearchCategoryPageis_Same() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(15, 0, TestDataUtility.getProperty(), "Categories"));
		managecategorysubcategorypage = new ManageCategorySubcategoryPage(driver);
		managecategorysubcategorypage.toSelectSubCategoryMenu().toClicknewButton().toSelectSubCategoryMenu()
				.toClickSearchButton();
		assertFalse(
				managecategorysubcategorypage.toGetCategory()
						.equals(managecategorysubcategorypage.toGetCategoryFromSearch()) == true,
				"Category in new page and search page is not same");

	}

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "categoryforSearch", "category" })
	public void toSearchSubCategory_whileclickonSearchButton(String categoryforSearch, String category)
			throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(15, 0, TestDataUtility.getProperty(), "Categories"));
		managecategorysubcategorypage = new ManageCategorySubcategoryPage(driver);
		managecategorysubcategorypage.toSelectSubCategoryMenu().toClickSearchButton();
		managecategorysubcategorypage.toSelectCategoryforSearch(category);
		managecategorysubcategorypage.toEnterSubCategoryForSearch(categoryforSearch);
		managecategorysubcategorypage.toClickSearchButtonForSearch();
		String actual = managecategorysubcategorypage.togetResultTabledata();
		String expected = managecategorysubcategorypage.gettextCategory();
		assertTrue(actual.contains(expected), "The entered category is not in table");

	}
}
