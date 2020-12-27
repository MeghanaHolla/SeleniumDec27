package com.webappsecurity.zero.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webappsecurity.zero.Pages.AccountSummary;
import com.webappsecurity.zero.Pages.FundTransfer;
import com.webappsecurity.zero.Pages.FundTransferConfirmation;
import com.webappsecurity.zero.Pages.FundTransferVerify;
import com.webappsecurity.zero.Pages.Login;

import utils.GenericMethods;

public class VerifyFundTransferTest extends Base{

	@Test
	public void verifyFundTransfer() throws IOException {

		Login lp = new Login(driver);
		AccountSummary acc = new AccountSummary(driver);
		FundTransfer ft = new FundTransfer(driver);
		FundTransferVerify ftv = new FundTransferVerify(driver);
		FundTransferConfirmation ftc = new FundTransferConfirmation(driver);

		String[][] data = GenericMethods.getData("D:\\SelNov29\\TestData.xlsx", "Sheet1");

		for(int i = 1;i<data.length;i++) {
			lp.applicationLogin(data[i][0], data[i][1]);
			acc.clickFundTransfer();
			ft.doFundTransfer(Integer.parseInt(data[i][2]), Integer.parseInt(data[i][3]), data[i][4], data[i][5]);
			ftv.clickSubmit();
			String actualMsg = ftc.getSuccessMsg();
			String expectedMsg =data[i][6];
			Assert.assertEquals(actualMsg, expectedMsg);
			ftc.logout();
			driver.get("http://zero.webappsecurity.com/login.html");
		}
	}

}
