package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;

import com.obsqura.pages.ManagePaymentMethodsPage;

import Utilities.ExcelUtility;
import Utilities.TestDataUtility;

public class ManagePaymentMethodsTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManagePaymentMethodsPage managepaymentmethodspage;

	@Test(retryAnalyzer = Retry.class)
	public void updatePayLimitin_ManagePaymentMethod() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(16, 0, TestDataUtility.getProperty(), "Categories"));
		managepaymentmethodspage = new ManagePaymentMethodsPage(driver);
		managepaymentmethodspage.toClickEditButtonin_ManagePaymentMethodsPage().toEnterPayLimit()
				.toClickUpdateButtonin_ManagePaymentMethodsPage();
		String actual = managepaymentmethodspage.togetResultTabledata();
		String expected = managepaymentmethodspage.gettextPayLimit();
		assertTrue(actual.contains(expected) == true, "The entered PayLimit is not updated in table");

	}

	@Test(retryAnalyzer = Retry.class)
	public void updateTitlein_ManagePaymentMethod() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(16, 0, TestDataUtility.getProperty(), "Categories"));
		managepaymentmethodspage = new ManagePaymentMethodsPage(driver);
		managepaymentmethodspage.toClickEditButtonin_ManagePaymentMethodsPage();
		managepaymentmethodspage
				.toEnterTitle(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "ManagePaymentMethods"));
		managepaymentmethodspage.toClickUpdateButtonin_ManagePaymentMethodsPage();
		String actual = managepaymentmethodspage.togetResultTabledata();
		String expected = managepaymentmethodspage.gettextTitle();
		assertTrue(actual.contains(expected) == true, "The entered title is not updated in table");

	}

	@Test(retryAnalyzer = Retry.class)
	public void updateBothTitleandPayLimitin_ManagePaymentMethod() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(16, 0, TestDataUtility.getProperty(), "Categories"));
		managepaymentmethodspage = new ManagePaymentMethodsPage(driver);
		managepaymentmethodspage.toClickEditButtonin_ManagePaymentMethodsPage();
		managepaymentmethodspage
				.toEnterTitle(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "ManagePaymentMethods"));
		managepaymentmethodspage.toEnterPayLimit().toClickUpdateButtonin_ManagePaymentMethodsPage();
		String actual = managepaymentmethodspage.togetResultTabledata();
		String expected = managepaymentmethodspage.gettextTitle();
		String expected1 = managepaymentmethodspage.gettextPayLimit();
		assertTrue((actual.contains(expected)) && (actual.contains(expected1)) == true,
				"The entered title and paylimit is not updated in table");

	}

	@Test(retryAnalyzer = Retry.class)
	public void tocheckAlertMessageisShowingWhileupdateBothTitleandPayLimitin_ManagePaymentMethod() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(16, 0, TestDataUtility.getProperty(), "Categories"));
		managepaymentmethodspage = new ManagePaymentMethodsPage(driver);
		managepaymentmethodspage.toClickEditButtonin_ManagePaymentMethodsPage();
		managepaymentmethodspage
				.toEnterTitle(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "ManagePaymentMethods"));
		managepaymentmethodspage.toEnterPayLimit().toClickUpdateButtonin_ManagePaymentMethodsPage();
		assertTrue(managepaymentmethodspage.toDisplayAlertElement() == true,
				"Alert message Payment method updated succesfully is not displayed");

	}

}
