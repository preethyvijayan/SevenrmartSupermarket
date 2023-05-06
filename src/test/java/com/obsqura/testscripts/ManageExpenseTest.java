package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageExpensePage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class ManageExpenseTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageExpensePage manageexpensepage;

	@Test(priority = 1, retryAnalyzer = Retry.class)
	public void verifytheuserCanviewtheExpectedHeadingsinExpenseDetailsTableHeadings() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(1, 0, "Categories"));
		manageexpensepage = new ManageExpensePage(driver);
		manageexpensepage.selectSubcategoryManageExpense();
		manageexpensepage.getheadingsofExpenseTable();
		assertTrue(	manageexpensepage.getheadingsofExpenseTable().contains(ExcelUtility.getString(1, 0, "ManageExpense")),	"Table not contains these headings");
	}

	@Test(priority = 2, retryAnalyzer = Retry.class)
	public void verifyWhethertheUserCanAbletoviewAlertMessageafterSuccesfulladdingofNewExpenseCategory() {

		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(1, 0, "Categories"));
		manageexpensepage = new ManageExpensePage(driver);
		manageexpensepage.selectSubcategoryManageExpense();
		manageexpensepage.clickNewButtonforAddingexpense().selectUser().enterDate().selectCategory().selectOrderId()
				.selectPrchaseId().selectExpensetype().enterAmount().enterRemarks().uploadFile()
				.clickSaveButtonforAddingexpense();
		assertTrue(manageexpensepage.isDisplayedAlertElement(),	"Alert box is not displaying after succesfull adding of new Expense Record");

	}

}
