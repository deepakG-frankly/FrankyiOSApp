package com.frankly.page;

import java.io.IOException;

import org.json.JSONException;

import com.frankly.base.Keywords;

public class AppiumInit extends Keywords {

	public void setupForInitialize() throws JSONException{
		try {
			InstallApp();
			propertyFileinitialize();
		} catch (IOException e) {
			APP_LOGS.info(e.getMessage());
	}
	}
	public void terminateDriver(){
		try{
			terminatedriver();
		}catch(Exception e){
			APP_LOGS.info(e.getMessage());
		}

}
}
