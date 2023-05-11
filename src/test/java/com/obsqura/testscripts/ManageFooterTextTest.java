package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageFooterTextPage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class ManageFooterTextTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageFooterTextPage managefootertextpage;

	@Test(retryAnalyzer = Retry.class)
	public void verifyUserCanableToViewtheUpdatedFooterTextinformationinFooterTextTableafterClickingOnupdateButton() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(9, 0, "Categories"));
		managefootertextpage = new ManageFooterTextPage(driver);
		managefootertextpage.selectSubcategoryManageFooterText().clickEditButton().enterAddress().enterEmail().enterPhoneNo().clickUpdateButton();
		assertTrue(managefootertextpage.displayAlertElement(),	"Footer Text Updated succesfully alert is not displayed");
		String expectedData = managefootertextpage.getEmail();
		String actualData = managefootertextpage.getTabledata();
		assertTrue(actualData.contains(expectedData), "Updated data is not in the table");

	}
}
