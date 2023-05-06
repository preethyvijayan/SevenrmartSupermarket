package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.ExpenseCategoryPage;
import com.obsqura.pages.LoginPage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class ExpenseCategoryTest extends Base {

	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ExpenseCategoryPage expensecategorypage;

	@Test(groups = { "smoke", "regression" }, retryAnalyzer = Retry.class)
	public void verifyTheUserCanAbletoSeetheNewlyaddedExpenseinTableWhileClickonSaveButton() {

		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(1, 0, "Categories"));
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(2, 0, "Categories"));
		expensecategorypage = new ExpenseCategoryPage(driver);
		expensecategorypage.clickNewButton();
		expensecategorypage.enterTitle();
		expensecategorypage.clickSavebutton();
		assertTrue(expensecategorypage.isCheckAlertEnabled(),	"Alert for succesfully added the category is not displayed");
		String expectedCategory = expensecategorypage.getTextFromTitle();
		String actualCategory = expensecategorypage.getTableData();
		assertTrue(actualCategory.contains(expectedCategory), "Newly added expense category is not in the table");

	}

	@Test(groups = { "smoke" }, retryAnalyzer = Retry.class)
	public void verifytheUserCanAbletoseeTheTitleFieldIsBlankWhileClickOnResetButton() {

		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(1, 0, "Categories"));
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(2, 0, "Categories"));
		expensecategorypage = new ExpenseCategoryPage(driver);
		expensecategorypage.clickNewButton();
		expensecategorypage.enterTitle();
		expensecategorypage.clickResetbutton();
		assertTrue(expensecategorypage.isCheckAlertEnabled(), "The reset is not working in the expense category page");

	}

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "bgcolorNew", "bgcolorSearch", "bgcolorReset" })
	public void ValidatetheColorOfNewSearchResetbuttonwithExpectedColor(String bgcolorNew, String bgcolorSearch,
			String bgcolorReset) {

		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(1, 0, "Categories"));
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(2, 0, "Categories"));
		expensecategorypage = new ExpenseCategoryPage(driver);
		assertEquals(expensecategorypage.colorofButtonsNew(), bgcolorNew,	"Actual and expected color of New button is same");
		assertEquals(expensecategorypage.colorofButtonsSearch(), bgcolorSearch,	"Actual and expected color of Search button is same");
		assertEquals(expensecategorypage.colorofButtonsReset(), bgcolorReset,	"Actual and expected color of Reset button is same");

	}

	@Test(groups = { "regression" }, retryAnalyzer = Retry.class)
	public void verifyUserCanAbleToVisibleTheSearchedCategoryinCategoryListTablewhileClickOnSearchButton() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(1, 0, "Categories"));
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(2, 0, "Categories"));
		expensecategorypage = new ExpenseCategoryPage(driver);
		expensecategorypage.clickSearchbutton().enterTitleforSearch().clicksearchButtoninSearchPage();
		String expected = expensecategorypage.getTitleforSearchVerify();
		String actual = expensecategorypage.gettextFromExpenseCategoryListElement();
		assertEquals(actual, expected, "Given title is not included in the table");

	}

}
