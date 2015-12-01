package com.frankly.page;

import java.io.IOException;

import org.json.JSONException;

import com.frankly.base.Keywords;

public class DubAdialogue extends Keywords{
	public void setupForInitialize() throws JSONException{
		try {
			InstallApp();
			propertyFileinitialize();
		} catch (IOException e) {
			APP_LOGS.info(e.getMessage());
	}
	}
	public void loginwithValid(
			String GetStartedBtnName,
			String LoginBtnName,
			String UserNameTextFieldXpath,
			String UserName,
			String NextBtn_Name,
			String LoginPasswordTextFieldXpath,
			String Password) throws InterruptedException{
		clickByName(GetStartedBtnName);
		clickByName(LoginBtnName);
		clickByXpath(UserNameTextFieldXpath);
		writeTextByXpath(UserNameTextFieldXpath,UserName);
		clickByName(NextBtn_Name);
		writeTextByXpath(LoginPasswordTextFieldXpath,Password);
		clickByName(NextBtn_Name);
	}
	public void terminateDriver(){
		try{
			terminatedriver();
		}catch(Exception e){
			APP_LOGS.info(e.getMessage());
		}
	}
}