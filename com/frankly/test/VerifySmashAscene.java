package com.frankly.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.frankly.base.Keywords;
import com.frankly.page.SmashAscene;

public class VerifySmashAscene extends Keywords{
	SmashAscene smashascene = new SmashAscene();
	@BeforeClass
	public void initilizeAppSetup(){
		try {
			smashascene.setupForInitialize();
		} catch (Exception e) {
			APP_LOGS.info(e.getMessage());
		}
	}
	@Test(enabled = true, priority = 1)
	public void verifyloginfun(){
		try{
			smashascene.loginwithValid(
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
	@Test(enabled = true, priority = 2)
	public void createsmash(){
		try{
			smashascene.createsmashascene("MainScree_Xpath",
					"SmashAscene_Name",
					"SelectCategories_Xpath");
		}catch(Exception e){
			APP_LOGS.info(e.getMessage());
		}
	}
	@AfterClass
	public void closeDriver(){
		try {
			smashascene.terminateDriver();
		} catch (Exception e) {
			APP_LOGS.info(e.getMessage());
		}
	}

}
