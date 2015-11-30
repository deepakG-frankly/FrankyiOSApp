package com.frankly.page;

import java.io.IOException;

import org.json.JSONException;

import com.frankly.base.Keywords;

public class RecordAVlog extends Keywords{
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
		try{
			clickByName(GetStartedBtnName);
			clickByName(LoginBtnName);
			clickByXpath(UserNameTextFieldXpath);
			writeTextByXpath(UserNameTextFieldXpath,UserName);
			clickByName(NextBtn_Name);
			writeTextByXpath(LoginPasswordTextFieldXpath,Password);
			clickByName(NextBtn_Name);
		}catch(Exception e){
			APP_LOGS.info(e.getMessage());
		}
	}
	public void uploadavlog(String RecordAvlog_Name,
			String RecordBtn_Xpath,
			String DeleteBtn_Xpath,
			String RecoderNxtBtn_Name,
			String VideoHeading_Xapth,
			String videoheadingText){
		try{
			clickByName(RecordAvlog_Name);
			clickByXpath(RecordBtn_Xpath);
			Thread.sleep(10000L);
			clickByXpath(RecordBtn_Xpath);
			clickByName(RecoderNxtBtn_Name);
			writeTextByXpath(VideoHeading_Xapth,videoheadingText);
			clickByName(RecoderNxtBtn_Name);	
		}catch(Exception e){
			APP_LOGS.info(e.getMessage());
		}
	}
	public void uploadavloginsegments(String MainScree_Xpath,
			String RecordAvlog_Name,
			String RecordBtn_Xpath,
			String DeleteBtn_Xpath,
			String RecoderNxtBtn_Name,
			String VideoHeading_Xapth,
			String videoheadingText){
		try{
			clickByXpath(MainScree_Xpath);
			clickByName(RecordAvlog_Name);
			clickByXpath(RecordBtn_Xpath);
			Thread.sleep(10000L);
			clickByXpath(RecordBtn_Xpath);
			clickByXpath(RecordBtn_Xpath);
			Thread.sleep(10000L);
			clickByXpath(RecordBtn_Xpath);
			clickByName(RecoderNxtBtn_Name);
			writeTextByXpath(VideoHeading_Xapth,videoheadingText);
			clickByName(RecoderNxtBtn_Name);	
		}catch(Exception e){
			APP_LOGS.info(e.getMessage());
		}
	}
	public void uploaddeletesegment(String MainScree_Xpath,
			String RecordAvlog_Name,
			String RecordBtn_Xpath,
			String DeleteBtn_Xpath,
			String RecoderNxtBtn_Name,
			String VideoHeading_Xapth,
			String videoheadingText){
		try{
			clickByXpath(MainScree_Xpath);
			clickByName(RecordAvlog_Name);
			clickByXpath(RecordBtn_Xpath);
			Thread.sleep(10000L);
			clickByXpath(RecordBtn_Xpath);
			clickByXpath(RecordBtn_Xpath);
			Thread.sleep(10000L);
			clickByXpath(RecordBtn_Xpath);
			clickByXpath(DeleteBtn_Xpath);
			clickByXpath(DeleteBtn_Xpath);
			clickByName(RecoderNxtBtn_Name);
			writeTextByXpath(VideoHeading_Xapth,videoheadingText);
			clickByName(RecoderNxtBtn_Name);	
		}catch(Exception e){
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
