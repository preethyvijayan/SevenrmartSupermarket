package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageExpensePage;

import Utilities.ExcelUtility;
import Utilities.TestDataUtility;

public class ManageExpenseTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageExpensePage manageexpensepage;

	@Test(priority = 1, retryAnalyzer = Retry.class)
	public void verifyExpenseDetailsTable_Headings() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Categories"));
		manageexpensepage = new ManageExpensePage(driver);
		manageexpensepage.toselectSubcategoryManageExpense();
		manageexpensepage.togetheadingsofExpenseTable();
		assertTrue(
				manageexpensepage.togetheadingsofExpenseTable().contains(
						"Title Date Credit Bank Debit Bank Credit Cash Debit Cash Cash With DB View More Action"),
				"Table not contains these headings");

	}

	@Test(priority = 2, retryAnalyzer = Retry.class)
	public void toAddNewExpense() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Categories"));
		manageexpensepage = new ManageExpensePage(driver);
		manageexpensepage.toselectSubcategoryManageExpense();
		manageexpensepage.toClickNewButtonforAddingexpense().toSelectUser().toEnterDate().toSelectCategory()
				.toSelectOrderId().toSelectPrchaseId().toSelectExpensetype().toEnterAmount().toEnterRemarks()
				.toUploadFile().toClickSaveButtonforAddingexpense();
		assertTrue(manageexpensepage.toDisplayAlertElement() == true,
				"Alert box is not displaying after succesfull adding of new Expense Record");
	}

}
