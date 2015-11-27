package com.frankly.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.frankly.base.Keywords;
import com.frankly.page.DubAdialogue;

public class VerifyDubAdialogue extends Keywords {
	DubAdialogue dubadialogue = new DubAdialogue();
	@BeforeClass
	public void initilizeAppSetup(){
		try {
			dubadialogue.setupForInitialize();
		} catch (Exception e) {
			APP_LOGS.info(e.getMessage());
		}
	}
	@Test(enabled = true, priority = 1)
	public void verifyloginfun(){
		try{
			dubadialogue.loginwithValid(
					"GetStartedBtnName",
					"LoginBtnName",
					"UserNameTextFieldXpath",
					"UserName",
					"NextBtn_Name",
					"LoginPasswordTextFieldXpath",
					"Password");
		}catch(Exception e){
			APP_LOGS.info(e.getMessage());
		}
	}
	@AfterClass
	public void closeDriver(){
		try {
			dubadialogue.terminateDriver();
		} catch (Exception e) {
			APP_LOGS.info(e.getMessage());
		}
	}

}
