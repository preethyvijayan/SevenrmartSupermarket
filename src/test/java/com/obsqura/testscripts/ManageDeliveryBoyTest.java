package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageDeliveryBoyPage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class ManageDeliveryBoyTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageDeliveryBoyPage managedeliveryboypage;

	@Test(retryAnalyzer = Retry.class)
	public void verifyUserCanAbeltoViewtheNewlyAddedDeleiveryBoyDetailsinListOfDeliveryBoyTbleWhileClickOnSaveButton() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(14, 0, "Categories"));
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickNewButtonforAdding().enterName();
		managedeliveryboypage.enterEmail(ExcelUtility.getString(1, 0, "ManageDeliveryBoy"));
		managedeliveryboypage.enterPhone().enterAddress().enterUsername();
		String expectedata = managedeliveryboypage.getTextFromUsername();
		managedeliveryboypage.enterPassword().clickSaveButtonforAddingNewDeliveryBoy();
		String actualData = managedeliveryboypage.tableData();
		assertTrue(actualData.contains(expectedata), "Newly Created delivery Boy is not included in table list");
	}

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "name" })
	public void ValidateSearchDeleiveryBoyDetailsisDisplayingInListDeliveryBoyTablebyEnteredOnlyNameWhileClickingonSearchbutton(String name) {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(14, 0, "Categories"));
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickSearchButtonin_ManageDeliveryboy().enterNameForSearch(name).clickSearchButtonforSearchin_ManageDeliveryboy();
		String expectedData = managedeliveryboypage.getTextFromUsernameforsearch();
		String actualData = managedeliveryboypage.getresultTabledata();
		assertTrue(actualData.contains(expectedData), "Search name is not included in table list");

	}

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "email" })
	public void ValidatesearchDeleiveryBoyDetailsisDisplayingInListDeliveryBoyTablebyEnteredEmailonlyWhileClickingonSearchbutton(
			String email) {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(14, 0, "Categories"));
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickSearchButtonin_ManageDeliveryboy().enterEmailForSearch(email).clickSearchButtonforSearchin_ManageDeliveryboy();
		String expectedData = managedeliveryboypage.getTextFromemailforsearch();
		String actualData = managedeliveryboypage.getresultTabledata();
		assertTrue(actualData.contains(expectedData), "Search email is not included in table list");
	}

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "phone" })
	public void ValidatesearchDeleiveryBoyDetailsisDisplayingInListDeliveryBoyTablebyEnteredPhoneonlyWhileClickingonSearchbutton(
			String phone) {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(14, 0, "Categories"));
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickSearchButtonin_ManageDeliveryboy().enterPhoneForSearch(phone).clickSearchButtonforSearchin_ManageDeliveryboy().clickSearchButtonforSearchin_ManageDeliveryboy();
		String expectedData = managedeliveryboypage.getTextFromphoneforsearch();
		String actualData = managedeliveryboypage.getresultTabledata();
		assertTrue(actualData.contains(expectedData), "Search phone is not included in table list");
	}

}
