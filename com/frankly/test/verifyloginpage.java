package com.frankly.test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.frankly.base.Keywords;
import com.frankly.page.loginpage;


public class verifyloginpage extends Keywords {
	loginpage LoginPage = new loginpage();
	@BeforeClass
	public void initilizeAppSetup(){
		try {
			LoginPage.setupForInitialize();
		} catch (Exception e) {
			APP_LOGS.info(e.getMessage());
		}
	}
	@Test
	public void verifyloginfun(){
		try{
			LoginPage.loginwithInvalid("GetStartedBtnName");
		}catch(Exception e){
			APP_LOGS.info(e.getMessage());
		}
	}
	@AfterClass
	public void closeDriver(){
		try {
			LoginPage.terminateDriver();
		} catch (Exception e) {
			APP_LOGS.info(e.getMessage());
		}
	}

}
