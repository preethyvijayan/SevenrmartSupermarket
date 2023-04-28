package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManagePagesPage;

import Utilities.ExcelUtility;
import Utilities.TestDataUtility;
import io.reactivex.rxjava3.functions.Action;

public class ManagePagesTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManagePagesPage managepagespage;

	@Test(retryAnalyzer = Retry.class)

	public void toDeletePages() throws IOException 
	{
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(9, 0, TestDataUtility.getProperty(), "Categories"));
		managepagespage = new ManagePagesPage(driver);
		managepagespage.toClickManagePagesCategory().toClickSearchButton();
		managepagespage.toEnterTitle();
		managepagespage.toClickSecondSearchButton();
		String expecteddata = managepagespage.togetTitle1();
		String actualData = managepagespage.todeleteData();
		assertTrue(actualData.equals(expecteddata), "Data in title and  data  in table is not same");
		managepagespage.todeleteData();
		managepagespage.toClickDeleteButton();
		assertTrue(managepagespage.toDisplayAlertElement() == true,
				"Alert box is not displaying after succesfull deleting the page");

	}

}
