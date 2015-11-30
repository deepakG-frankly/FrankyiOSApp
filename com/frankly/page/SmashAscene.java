package com.frankly.page;

import java.io.IOException;
import java.util.Random;

import org.json.JSONException;

import com.frankly.base.Keywords;

public class SmashAscene extends Keywords{
	public void setupForInitialize() throws JSONException{
		try {
			InstallApp();
			propertyFileinitialize();
		} catch (IOException e) {
			APP_LOGS.info(e.getMessage());
	}
	}
	public void createsmashascene(String MainScree_Xpath,
			String SmashAscene_Name,
			String SelectCategories_Xpath
			){
		try{
			int randomcategory= generateRendomNumber();
			String category=OR.getProperty(SelectCategories_Xpath);
			String Actual_Xpath= category + "/UIACollectionCell["+randomcategory+"]";
			clickByXpath(MainScree_Xpath);
			clickByName(SmashAscene_Name);
			System.out.println(Actual_Xpath);
			clickByRandomXpath(Actual_Xpath);
			Thread.sleep(10000L);
		}catch(Exception e){
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
	public void terminateDriver(){
		try{
			terminatedriver();
		}catch(Exception e){
			APP_LOGS.info(e.getMessage());
		}
	}
	
	/**
	 * @description- Method for generating random number between 1-10
	 * @return- Random number between 1-10
	 */
	public static int generateRendomNumber(){
		try{
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(10);
			if(randomInt==0 || randomInt==1){
				return 2;
			}else{
			return randomInt;
			}
		}catch(Exception e){
			APP_LOGS.info(e.getMessage());
		}
		return 2;

	}
	
}
