package com.frankly.page;

import java.io.IOException;
import org.json.JSONException;

import com.frankly.base.Keywords;
public class loginpage extends Keywords {
	public void setupForInitialize() throws JSONException{
		try {
			InstallApp();
			propertyFileinitialize();
		} catch (IOException e) {
			APP_LOGS.info(e.getMessage());
	}
	}
	public void loginwithInvalid(String GetStartedBtnName){
		clickByName(GetStartedBtnName);
	}
	public void terminateDriver(){
		try{
			terminatedriver();
		}catch(Exception e){
			APP_LOGS.info(e.getMessage());
		}
	}
	

}
