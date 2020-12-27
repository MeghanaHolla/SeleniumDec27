package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferConfirmation {
	
	@FindBy(css = "#transfer_funds_content > div > div > div.alert.alert-success")
	private WebElement successmsgBox;
	
	@FindBy(css="#settingsBox > ul > li:nth-child(3) > a")
	private WebElement username;
	
	@FindBy(id="logout_link")
	private WebElement logout; 
	
	
	public FundTransferConfirmation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getSuccessMsg() {
		String confMsg = successmsgBox.getText();
		return confMsg;
	}

	public void logout() {
		username.click();
		logout.click();
	}
}
