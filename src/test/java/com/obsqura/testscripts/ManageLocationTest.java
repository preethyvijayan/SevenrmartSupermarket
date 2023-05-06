package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageLocationPage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class ManageLocationTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageLocationPage managelocationpage;

	@Test(retryAnalyzer = Retry.class)
	public void ValidateTheSuccesfullAlertMessageIsDispalyedafteraddingTheNewLocationtotheManageLocationPage() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(17, 0, "Categories"));
		managelocationpage = new ManageLocationPage(driver);
		managelocationpage.clickNewButtonin_ManageLocationPage().selectCountryDropdown().selectStateDropdown()
				.enterLocation().enterDeliveryCharges().clickSaveButtonin_ManageLocationPage();
		assertTrue(managelocationpage.isAlertElementisDisplayed(),"Alert message Location created succesfully is not displayed");

	}

	@Test(retryAnalyzer = Retry.class)
	public void verifyUserCanAbletoViewThethelistofloactionbyCorrespondingSearchwithCountryandStatewhileClickonSearchButton() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(17, 0, "Categories"));
		managelocationpage = new ManageLocationPage(driver);
		managelocationpage.clickSearchButtonin_ManageLocationPage();
		managelocationpage.selectCountryDropdownforSearch(ExcelUtility.getString(1, 0, "ManageLocation"));
		managelocationpage.selectStateDropdownforSearch(ExcelUtility.getString(2, 0, "ManageLocation"));
		managelocationpage.enterLocationforSearch(ExcelUtility.getString(3, 0, "ManageLocation"));
		managelocationpage.clickSearchForSearchButtonin_ManageLocationPage();
		assertTrue(managelocationpage.getResultTabledata().contains(managelocationpage.gettextLocationFromSearch()),	"The location list is not displayed as per the given data");

	}

}
