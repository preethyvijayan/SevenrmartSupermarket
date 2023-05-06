package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.MobileSliderPage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class MobileSliderTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	MobileSliderPage mobilesliderpage;

	@Test(retryAnalyzer = Retry.class)
	public void validateTheUserCanAbleToViewTheAlertMessageAfterCreatingTheNewMobileSliderWhileClickOnSaveButton() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(13, 0, "Categories"));
		mobilesliderpage = new MobileSliderPage(driver);
		mobilesliderpage.toClickNewButtonAddingNewSlider();
		mobilesliderpage.toSelectCategory(ExcelUtility.getString(1, 0, "ManageCategorySubcategory"));
		mobilesliderpage.toUploadFile().toClickSaveButtonforAddingNewSlider();
		assertTrue(mobilesliderpage.toDisplayAlertElement(), "Mobile slider created succesfully alert is not showing");

	}

}
