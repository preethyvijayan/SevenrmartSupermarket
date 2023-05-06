package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.VerifyLogonamePage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class VerifyLogonameTest extends Base {
	LoginPage loginpage;
	VerifyLogonamePage verifylogonamepage;

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "logoname" })
	public void verifyUserCanAbletoViewLogoNameisAsPerExpectedLogoName(String logoname) {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		verifylogonamepage = new VerifyLogonamePage(driver);
		verifylogonamepage.getTextLogoname();
		String expectedLogo = ExcelUtility.getString(1, 0, "Logo");
		assertEquals(verifylogonamepage.getTextLogoname(), expectedLogo, "Logo Nme is not displayed same");

	}
}
