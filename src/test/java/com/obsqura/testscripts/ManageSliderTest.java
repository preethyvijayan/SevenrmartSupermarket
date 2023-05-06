package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageSliderPage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class ManageSliderTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageSliderPage managepagesPage;

	@Test(retryAnalyzer = Retry.class)
	public void verifyUserCanAbletoViewTheAlertMessageafterAddingThenewListSlidersWhileClickOnSaveButon() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(8, 0, "Categories"));
		managepagesPage = new ManageSliderPage(driver);
		managepagesPage.clickNewButton().clickUploadButton();
		managepagesPage.enterLinkelement(ExcelUtility.getString(3, 0, "ManageSlider"));
		managepagesPage.clickSaveButtonelement();
		assertTrue(managepagesPage.isCheckAlertIsDisplayed(), "New slider is not created succesfully");

	}

}
