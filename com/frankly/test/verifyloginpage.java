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
		@Test(enabled = true, priority = 1)
		public void verifyErrorMessage(){
			try{
				LoginPage.verifyerrormessage("GetStartedBtnName",
						"UserNameTextFieldXpath",
						"InvalidUserName",
						"SignUp_ErrorMessageName",
						"SignUpErrorMessgae"
						);
			}catch(Exception e){
				APP_LOGS.info(e.getMessage());
			}
		}
		@Test(enabled = true, priority = 2)
		public void verifyErrorMessAfterInvalidCre(){
			try{
				LoginPage.errwithinvalidcredential("LoginBtnName",
				"UserNameTextFieldXpath",
				"InValidUserName",
				"NextBtn_Name",
				"LoginPasswordTextFieldXpath",
				"InvalidPassword",
				"ErrorMessageforInvalidCre",
				"invalidCreErrorMessage",
				"BackBtnXpath");
			}catch(Exception e){
				APP_LOGS.info(e.getMessage());
			}
		}
	@Test(enabled = true, priority = 3)
	public void verifyloginfun(){
		try{
			LoginPage.loginwithValid(
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
			LoginPage.terminateDriver();
		} catch (Exception e) {
			APP_LOGS.info(e.getMessage());
		}
	}

}
