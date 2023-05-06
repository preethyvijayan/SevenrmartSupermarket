package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManagePagesPage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class ManagePagesTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManagePagesPage managepagespage;

	@Test(retryAnalyzer = Retry.class)

	public void checkWhethertheUserCanAbleToViewtheAlertMessageandAlsoCheckingtheDeletedItemIsShowingInTableAfterDeletingThePage() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(9, 0, "Categories"));
		managepagespage = new ManagePagesPage(driver);
		managepagespage.clickManagePagesCategory().clickSearchButton();
		managepagespage.enterTitle();
		managepagespage.clickSecondSearchButton();
		String expecteddata = managepagespage.getdeletedTitle();
		String actualData = managepagespage.getdeleteData();
		assertTrue(actualData.equals(expecteddata), "Data in title and  data  in table is not same");
		managepagespage.getdeleteData();
		managepagespage.clickDeleteButton();
		assertTrue(managepagespage.isDisplayAlertElementdisplayed(),	"Alert box is not displaying after succesfull deleting the page");
	}

}
