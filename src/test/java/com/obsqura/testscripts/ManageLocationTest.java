package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageLocationPage;

import Utilities.ExcelUtility;
import Utilities.TestDataUtility;

public class ManageLocationTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageLocationPage managelocationpage;

	@Test(retryAnalyzer = Retry.class)
	public void toAddNewLocationtothe_ManageLocationPaged() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(17, 0, TestDataUtility.getProperty(), "Categories"));
		managelocationpage = new ManageLocationPage(driver);
		managelocationpage.toClickNewButtonin_ManageLocationPage().toSelectCountryDropdown().toSelectStateDropdown()
				.toEnterLocation().toEnterDeliveryCharges().toClickSaveButtonin_ManageLocationPage();
		assertTrue(managelocationpage.toDisplayAlertElement() == true,
				"Alert message Location created succesfully is not displayed");

	}

	@Test(retryAnalyzer = Retry.class)
	public void togetthelistofloactionbySearchingwithCountryandStateinthe_ManageLocationPaged() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(17, 0, TestDataUtility.getProperty(), "Categories"));
		managelocationpage = new ManageLocationPage(driver);
		managelocationpage.toClickSearchButtonin_ManageLocationPage().toSelectCountryDropdown().toSelectStateDropdown()
				.toClickSearchForSearchButtonin_ManageLocationPage();
		assertTrue(managelocationpage.togetResultTabledata().contains(managelocationpage.gettextState()) == true,
				"The location list is not displayed as perthe given data");

	}

}
