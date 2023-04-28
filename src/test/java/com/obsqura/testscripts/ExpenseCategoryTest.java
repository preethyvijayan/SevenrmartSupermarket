package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.ExpenseCategoryPage;
import com.obsqura.pages.LoginPage;
import Utilities.ExcelUtility;
import Utilities.FakeUtility;
import Utilities.TestDataUtility;

public class ExpenseCategoryTest extends Base {

	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ExpenseCategoryPage expensecategorypage;

	@Test(groups = { "smoke", "regression" }, retryAnalyzer = Retry.class)
	public void addNewExpenseCategory_and_VerifyAddingNewExpenceCategory_presentinTable() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Categories"));
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(2, 0, TestDataUtility.getProperty(), "Categories"));
		expensecategorypage = new ExpenseCategoryPage(driver);
		expensecategorypage.toClickNewButton();
		expensecategorypage.toEnterTitle();
		expensecategorypage.toClickSavebutton();
		assertTrue(expensecategorypage.toCheckAlert() == true,
				"Alert for succesfully added the category is not displayed");
		String expectedCategory = expensecategorypage.togetTitle();
		String actualCategory = expensecategorypage.totableData();
		assertTrue(actualCategory.contains(expectedCategory), "Newly added expense category is not in the table");

	}

	@Test(groups = { "smoke" }, retryAnalyzer = Retry.class)
	public void resettheTitle_usingReseButton() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Categories"));
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(2, 0, TestDataUtility.getProperty(), "Categories"));
		expensecategorypage = new ExpenseCategoryPage(driver);
		expensecategorypage.toClickNewButton();
		expensecategorypage.toEnterTitle();
		expensecategorypage.toClickResetbutton();
		assertTrue(expensecategorypage.toReset() == true, "The reset is not working in the expense category page");
	}

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "bgcolorNew", "bgcolorSearch", "bgcolorReset" })
	public void VerifycolorofNew_Search_Resetbutton(String bgcolorNew, String bgcolorSearch, String bgcolorReset)
			throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Categories"));
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(2, 0, TestDataUtility.getProperty(), "Categories"));
		expensecategorypage = new ExpenseCategoryPage(driver);
		assertEquals(expensecategorypage.colorofButtonsNew(), bgcolorNew,
				"Actual and expected color of New button is same");
		assertEquals(expensecategorypage.colorofButtonsSearch(), bgcolorSearch,
				"Actual and expected color of Search button is same");
		assertEquals(expensecategorypage.colorofButtonsReset(), bgcolorReset,
				"Actual and expected color of Reset button is same");

	}

	@Test(groups = { "regression" }, retryAnalyzer = Retry.class)
	public void verifySearchbutton_functionality_andSearchedItemisShowing() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Categories"));
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(2, 0, TestDataUtility.getProperty(), "Categories"));
		expensecategorypage = new ExpenseCategoryPage(driver);
		expensecategorypage.toClickSearchbutton().toEnterTitleforSearch().toclicksearchofsearchbutton();
		String expected = expensecategorypage.toEnterTitleforSearchVerify();
		String actual = expensecategorypage.toverifytheCategoryListafteraddingnewCategory();
		assertEquals(actual, expected, "Given title is not included in the table");
	}

}
