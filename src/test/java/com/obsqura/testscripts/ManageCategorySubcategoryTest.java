package com.obsqura.testscripts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageCategorySubcategoryPage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class ManageCategorySubcategoryTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageCategorySubcategoryPage managecategorysubcategorypage;

	@Test(retryAnalyzer = Retry.class)
	public void verifyUserCanAbletoSeeTheAlertMessageafterAddingThenewSubCategoryinSubCategorypageWhileClickOnSaveButton() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(15, 0, "Categories"));
		managecategorysubcategorypage = new ManageCategorySubcategoryPage(driver);
		managecategorysubcategorypage.selectSubCategoryMenu().clickNewButton();
		managecategorysubcategorypage.selectCategory(ExcelUtility.getString(1, 0, "ManageCategorySubcategory"));
		managecategorysubcategorypage.enterSubCategory().uploadFile().clickSaveButton();
		assertTrue(managecategorysubcategorypage.isCheckAlertDisplayed(),"Alert message Sub category created succesfully is not displayed");

	}

	@Test(retryAnalyzer = Retry.class)
	public void validatetheNewlyAddedcategoryisShowinginCateegoryTableWhileClickOnSearchButton() {

		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(15, 0, "Categories"));
		managecategorysubcategorypage = new ManageCategorySubcategoryPage(driver);
		managecategorysubcategorypage.selectSubCategoryMenu().clickNewButton().selectSubCategoryMenu().clickSearchButton();
		assertFalse(	managecategorysubcategorypage.getCategory().equals(managecategorysubcategorypage.getCategoryFromSearch()),	"Category in new page and search page is not same");

	}

	@Test(retryAnalyzer = Retry.class)
	public void VerifyUserCanAbleToviewTheSearchedSubCategoryinListOfSubCategoryTablewhileclickonSearchButton() {

		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(15, 0, "Categories"));
		managecategorysubcategorypage = new ManageCategorySubcategoryPage(driver);
		managecategorysubcategorypage.selectSubCategoryMenu().clickSearchButton();
		managecategorysubcategorypage
				.selectCategoryforSearch(ExcelUtility.getString(1, 0, "ManageCategorySubcategory"));
		managecategorysubcategorypage
				.enterSubCategoryForSearch(ExcelUtility.getString(1, 1, "ManageCategorySubcategory"));
		managecategorysubcategorypage.clickSearchButtonForSearch();
		String actual = managecategorysubcategorypage.getResultTabledata();
		String expected = managecategorysubcategorypage.gettextCategory();
		assertTrue(actual.contains(expected), "The entered category is not in table");

	}
}
