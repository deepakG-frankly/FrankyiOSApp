package com.frankly.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.frankly.base.Keywords;
import com.frankly.page.RecordAVlog;

public class VerifyRecordAVlog extends Keywords {
	RecordAVlog recordavlog = new RecordAVlog();
	@BeforeClass
	public void initilizeAppSetup(){
		try {
			recordavlog.setupForInitialize();
		} catch (Exception e) {
			APP_LOGS.info(e.getMessage());
		}
	}
	@Test(enabled = true, priority = 1)
	public void verifyloginfun(){
		try{
			recordavlog.loginwithValid(
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
	@Test(enabled = true,priority = 2)
	public void verifyvlog(){
		try{
			recordavlog.uploadavlog("RecordAvlog_Name",
					"RecordBtn_Xpath",
					"DeleteBtn_Xpath",
					"RecoderNxtBtn_Name",
					"VideoHeading_Xapth",
					"videoheadingText"
					);
		}catch(Exception e){
			APP_LOGS.info(e.getMessage());
		}
	}
	@Test(enabled = true,priority = 3)
	public void verifysegmentvlog(){
		try{
			recordavlog.uploadavloginsegments("MainScree_Xpath",
					"RecordAvlog_Name",
					"RecordBtn_Xpath",
					"DeleteBtn_Xpath",
					"RecoderNxtBtn_Name",
					"VideoHeading_Xapth",
					"videoheadingText"
					);
		}catch(Exception e){
			APP_LOGS.info(e.getMessage());
		}
	}
	@Test(enabled = true,priority = 4)
	public void verifysegmentwithdeletesegment(){
		try{
			recordavlog.uploaddeletesegment("MainScree_Xpath",
					"RecordAvlog_Name",
					"RecordBtn_Xpath",
					"DeleteBtn_Xpath",
					"RecoderNxtBtn_Name",
					"VideoHeading_Xapth",
					"videoheadingText"
					);
		}catch(Exception e){
			APP_LOGS.info(e.getMessage());
		}
	}
	@AfterClass
	public void closeDriver(){
		try {
			recordavlog.terminateDriver();
		} catch (Exception e) {
			APP_LOGS.info(e.getMessage());
		}
	}

}
