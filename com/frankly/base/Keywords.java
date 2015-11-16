package com.frankly.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;

public class Keywords {
	private IOSDriver driver;
	public static String deviceName = "iPhone 6";
	public static Properties CONFIG=null;
	public static Properties OR=null;
	public static Logger APP_LOGS = Logger.getLogger(Keywords.class);;
	/**
	 * @description- Method for install the app in specific device
	 */
	public void InstallApp(){
		APP_LOGS.info("Installing the app in device");
		try {
			File file =new File(System.getProperty("user.dir")+"/Frankly.app");
			DesiredCapabilities capabilities= new DesiredCapabilities();
			capabilities.setCapability("appium.version", "1.4.13");
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("platformVersion", "8.1");
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("app", file.getAbsolutePath());
			driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			APP_LOGS.info(e.getMessage());
		}
	}
	/**
	 * @description- Method for initializing the property file
	 */
	public void propertyFileinitialize() throws IOException, JSONException {
		APP_LOGS.info("initializing the property file");
		try{
				CONFIG=new Properties();
				OR= new Properties();
				FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"/src/com/frankly/config/config.properties");
				CONFIG.load(fs);
				 fs=new FileInputStream(System.getProperty("user.dir")+"/src/com/frankly/config/OR.properties");
				OR.load(fs);
	  }catch(Exception e){
		  APP_LOGS.info(e.getMessage());
	  }
	}

	/**
	 * @description- Method for terminating the driver
	 */
	public void terminatedriver(){
		APP_LOGS.info("quuiting the drive");
		try{
			driver.quit();
		}catch(Exception e){
			APP_LOGS.info(e.getMessage());	
		}
	}
		/**
		 * @description- Method for clicking on a button using name
		 */
		public void clickByName(String elementName){
			APP_LOGS.info("Clicking on a element by its name");
			try{
				driver.findElement(By.name(OR.getProperty(elementName))).click();
				Thread.sleep(5000L);
			}catch(Exception e){
			e.getMessage();
			}
		}
		/**
		 * @description- Method for sending the string into textfield
		 */
		public void writeTextByXpath(String elementXpath){
			APP_LOGS.info("Clicking on a element by its xpath");
			try{
				driver.findElement(By.xpath(OR.getProperty(elementXpath))).click();
				driver.findElement(By.xpath(OR.getProperty(elementXpath))).sendKeys("deepak");
			}catch(Exception e){
			e.getMessage();
			}
		}
}
