package com.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObject.loginPage;


public class TC_01_Login extends baseClass{
	
	@Test
	public void login() throws IOException {
		driver.get(baseURL);
		logger.info("page is opened");
		loginPage lp= new loginPage(driver);
		//captureScreen(driver, "logintest");
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickbtn();
		
		if(driver.getTitle().equals("My account - My Store")) 
		{
			Assert.assertTrue(true);	
		}
		else
		{
			captureScreen(driver, "login");
			Assert.assertTrue(false);
		}
	}

}
