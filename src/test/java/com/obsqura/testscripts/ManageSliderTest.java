package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageSliderPage;

import Utilities.ExcelUtility;
import Utilities.TestDataUtility;

public class ManageSliderTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageSliderPage managepagesPage;

	@Test(retryAnalyzer = Retry.class)
	public void new_ListSliders() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(8, 0, TestDataUtility.getProperty(), "Categories"));
		managepagesPage = new ManageSliderPage(driver);
		managepagesPage.toClickNewButton();
		managepagesPage.toEnterLinkelement(ExcelUtility.getString(3, 0, TestDataUtility.getProperty(), "ManageSlider"));
		managepagesPage.toClickSaveButtonelement();
		assertTrue(managepagesPage.toCheckAlert() == true, "New slider is not created succesfully");
	}

}
