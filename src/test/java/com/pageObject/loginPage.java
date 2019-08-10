package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	WebDriver ldriver;
	
	public loginPage(WebDriver rDriver){
		ldriver=rDriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(name="email")
	@CacheLookup
	WebElement textUserName;
	
	@FindBy(name="passwd")
	@CacheLookup
	WebElement textPassword;
	
	@FindBy(name="SubmitLogin")
	@CacheLookup
	WebElement btnLogin;
	
	public void setUserName(String usr) {
		textUserName.sendKeys(usr);
	}
	
	public void setPassword(String pwd) {
		textPassword.sendKeys(pwd);
	}
	
	public void clickbtn() {
		btnLogin.click();
	}
	
}
