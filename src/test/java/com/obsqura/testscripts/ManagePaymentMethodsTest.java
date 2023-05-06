package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManagePaymentMethodsPage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class ManagePaymentMethodsTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManagePaymentMethodsPage managepaymentmethodspage;

	@Test(retryAnalyzer = Retry.class)
	public void verifyUserCanAbletoViewTheUpdatedPayLimitinManagePaymentmethodsTableWhileClickOnUpdateButton() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(16, 0, "Categories"));
		managepaymentmethodspage = new ManagePaymentMethodsPage(driver);
		managepaymentmethodspage.clickEditButtonin_ManagePaymentMethodsPage().enterPayLimit()
				.clickUpdateButtonin_ManagePaymentMethodsPage();
		String actual = managepaymentmethodspage.getResultfromTabledata();
		String expected = managepaymentmethodspage.gettextfromPayLimit();
		assertTrue(actual.contains(expected), "The entered PayLimit is not updated in table");
	}

	@Test(retryAnalyzer = Retry.class)
	public void verifyUserCanAbletoViewTheUpdatedTitleinManagePaymentmethodsTablesWhileClickOnUpdateButton() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(16, 0, "Categories"));
		managepaymentmethodspage = new ManagePaymentMethodsPage(driver);
		managepaymentmethodspage.clickEditButtonin_ManagePaymentMethodsPage();
		managepaymentmethodspage.enterTitle(ExcelUtility.getString(1, 0, "ManagePaymentMethods"));
		managepaymentmethodspage.clickUpdateButtonin_ManagePaymentMethodsPage();
		String actual = managepaymentmethodspage.getResultfromTabledata();
		String expected = managepaymentmethodspage.gettextfromTitle();
		assertTrue(actual.contains(expected), "The entered title is not updated in table");
	}

	@Test(retryAnalyzer = Retry.class)
	public void verifyUserCanAbletoViewTheUpdatedPayLimitandTitleTogetherinManagePaymentmethodsTableWhileClickOnUpdateButton() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(16, 0, "Categories"));
		managepaymentmethodspage = new ManagePaymentMethodsPage(driver);
		managepaymentmethodspage.clickEditButtonin_ManagePaymentMethodsPage();
		managepaymentmethodspage.enterTitle(ExcelUtility.getString(1, 0, "ManagePaymentMethods"));
		managepaymentmethodspage.enterPayLimit().clickUpdateButtonin_ManagePaymentMethodsPage();
		String actual = managepaymentmethodspage.getResultfromTabledata();
		String expected = managepaymentmethodspage.gettextfromTitle();
		String expected1 = managepaymentmethodspage.gettextfromPayLimit();
		assertTrue((actual.contains(expected)) && (actual.contains(expected1)),	"The entered title and paylimit is not updated in table");

	}

	@Test(retryAnalyzer = Retry.class)
	public void tocheckAlertMessageisShowingafterSuccesfullupdateOfBothTitleandPayLimitinManagePaymentMethod() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(16, 0, "Categories"));
		managepaymentmethodspage = new ManagePaymentMethodsPage(driver);
		managepaymentmethodspage.clickEditButtonin_ManagePaymentMethodsPage();
		managepaymentmethodspage.enterTitle(ExcelUtility.getString(1, 0, "ManagePaymentMethods"));
		managepaymentmethodspage.enterPayLimit().clickUpdateButtonin_ManagePaymentMethodsPage();
		assertTrue(managepaymentmethodspage.isDisplayAlertElementIsDisplayed(),"Alert message Payment method updated succesfully is not displayed");

	}

}
