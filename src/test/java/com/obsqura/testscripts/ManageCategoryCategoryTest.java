package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageCategoryCategoryPage;

import Utilities.ExcelUtility;
import Utilities.TestDataUtility;

public class ManageCategoryCategoryTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageCategoryCategoryPage managecategorycategorypage;

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "category" })
	public void AddingnewCategoryin_Categorypage(String category) throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(15, 0, TestDataUtility.getProperty(), "Categories"));
		managecategorycategorypage = new ManageCategoryCategoryPage(driver);
		managecategorycategorypage.toClickcategoryOptionin_ManageCategory()
				.toClickNewButonforaddingNewCategoryin_ManageCategory()
				.toEnterCategoryforaddingNewCategoryin_ManageCategory(category)
				.toEnterGroupforaddingNewCategoryin_ManageCategory().toUploadFile()
				.toClicktopMenuRadiobuttonElementisSelected().toClicksideMenuRadiobuttonElementisSelected()
				.toClickSaveButtonin_ManageCategory();
		assertTrue(managecategorycategorypage.toCheckAlert() == true,
				"Alert information Message Category created succesfully is not displayed");

	}

	@Test(retryAnalyzer = Retry.class)
	public void verifythenewCategorywillCreate_withoutManadotoryfield_Categoryin_Categorypage() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(15, 0, TestDataUtility.getProperty(), "Categories"));
		managecategorycategorypage = new ManageCategoryCategoryPage(driver);
		managecategorycategorypage.toClickcategoryOptionin_ManageCategory()
				.toClickNewButonforaddingNewCategoryin_ManageCategory()
				.toEnterGroupforaddingNewCategoryin_ManageCategory().toUploadFile()
				.toClicktopMenuRadiobuttonElementisSelected().toClicksideMenuRadiobuttonElementisSelected()
				.toClickSaveButtonin_ManageCategory();
		String actual = managecategorycategorypage.gettextCategory();
		assertTrue(actual == null, "category field is not blank");
	}

}
