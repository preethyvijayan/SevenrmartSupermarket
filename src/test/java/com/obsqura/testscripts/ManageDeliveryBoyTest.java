package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageDeliveryBoyPage;

import Utilities.ExcelUtility;
import Utilities.TestDataUtility;

public class ManageDeliveryBoyTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageDeliveryBoyPage managedeliveryboypage;

	@Test(retryAnalyzer = Retry.class)
	public void addaNew_DeleiveryBoyDetails() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(14, 0, TestDataUtility.getProperty(), "Categories"));
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.toClickNewButtonforAdding_in().toEnterName().toEnterEmail().toEnterPhone()
				.toEnterAddress().toEnterUsername();
		String expectedata = managedeliveryboypage.getTextFromUsername();
		managedeliveryboypage.toEnterPassword().toClickSaveButtonforAddingNewDeliveryBoy();
		String actualData = managedeliveryboypage.tableData();
		assertTrue(actualData.contains(expectedata), "Newly Created delivery Boy is not included in table list");
	}

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "name" })
	public void search_DeleiveryBoyDetailsbyusing_Name(String name) throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(14, 0, TestDataUtility.getProperty(), "Categories"));
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.toClickSearchButtonin_ManageDeliveryboy().toEnterNameForSearch(name);
		String expectedData = managedeliveryboypage.getTextFromUsernameforsearch();
		managedeliveryboypage.toClickSearchButtonforSearchin_ManageDeliveryboy();
		String actualData = managedeliveryboypage.getresultTabledata();
		assertTrue(actualData.contains(expectedData), "Search name is not included in table list");

	}

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "email" })
	public void search_DeleiveryBoyDetailsbyusing_Email(String email) throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(14, 0, TestDataUtility.getProperty(), "Categories"));
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.toClickSearchButtonin_ManageDeliveryboy().toEnterEmailForSearch(email);
		String expectedData = managedeliveryboypage.getTextFromemailforsearch();
		managedeliveryboypage.toClickSearchButtonforSearchin_ManageDeliveryboy();
		String actualData = managedeliveryboypage.getresultTabledata();
		assertTrue(actualData.contains(expectedData), "Search email is not included in table list");
	}

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "phone" })
	public void search_DeleiveryBoyDetailsbyusing_PhoneNo(String phone) throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(14, 0, TestDataUtility.getProperty(), "Categories"));
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.toClickSearchButtonin_ManageDeliveryboy().toEnterPhoneForSearch(phone);
		managedeliveryboypage.toClickSearchButtonforSearchin_ManageDeliveryboy();
		String expectedData = managedeliveryboypage.getTextFromphoneforsearch();
		managedeliveryboypage.toClickSearchButtonforSearchin_ManageDeliveryboy();
		String actualData = managedeliveryboypage.getresultTabledata();
		assertTrue(actualData.contains(expectedData), "Search phone is not included in table list");
	}

}
