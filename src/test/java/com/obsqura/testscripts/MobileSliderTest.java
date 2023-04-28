package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;
import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.MobileSliderPage;

import Utilities.ExcelUtility;
import Utilities.TestDataUtility;

public class MobileSliderTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	MobileSliderPage mobilesliderpage;

	@Test(retryAnalyzer = Retry.class)
	public void tocreatea_newMobileSlider() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(13, 0, TestDataUtility.getProperty(), "Categories"));
		mobilesliderpage = new MobileSliderPage(driver);
		mobilesliderpage.toClickNewButtonAddingNewSlider();
		mobilesliderpage.toSelectCategory(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "MobileSlider"));
		mobilesliderpage.toUploadFile().toClickSaveButtonforAddingNewSlider();
		assertTrue(mobilesliderpage.toDisplayAlertElement() == true,
				"Mobile slider created succesfully alert is not showing");
	}

}
