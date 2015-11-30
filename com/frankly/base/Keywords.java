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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;

public class Keywords {
	private IOSDriver driver;
	public static String deviceName = "iPhone 5s";
	public static Properties CONFIG=null;
	public static Properties OR=null;
	public static Logger APP_LOGS = Logger.getLogger(Keywords.class);;
	/**
	 * @description- Method for install the app in specific device
	 */
	public void InstallApp(){
		APP_LOGS.info("Installing the app in device");
		try {
			// file path for installing the app in simulator
			//File file =new File(System.getProperty("user.dir")+"/Frankly.app");
			// file path for installing the app in real device
			File deviceFile=new File(System.getProperty("user.dir")+"/Frankly.ipa");
			DesiredCapabilities capabilities= new DesiredCapabilities();
			capabilities.setCapability("appium.version", "1.4.13");
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("platformVersion", "8.4");
			// desire capabilities for simulator
			capabilities.setCapability("deviceName", deviceName);
			// desire capabilities for real device
			capabilities.setCapability("deviceName", "iPhone(2)(2bdd1872de84cba5440ecd96da9ca93c6f91fe5d)");
			// load the file path for simulator
			//capabilities.setCapability("app", file.getAbsolutePath());
			// load the file path for real device
			capabilities.setCapability("app", deviceFile.getAbsolutePath());
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
				Thread.sleep(5000L);
				driver.findElement(By.name(OR.getProperty(elementName))).click();
				Thread.sleep(5000L);
			}catch(Exception e){
				APP_LOGS.info(e.getMessage());
			}
		}
		/**
		 * @description- Method for sending the string into textfield
		 */
		public void writeTextByXpath(String elementXpath,String userdata){
			APP_LOGS.info("Clicking on a element by its xpath enter data");
			try{
				driver.findElement(By.xpath(OR.getProperty(elementXpath))).click();
				driver.findElement(By.xpath(OR.getProperty(elementXpath))).sendKeys(OR.getProperty((userdata)));
			}catch(Exception e){
				APP_LOGS.info(e.getMessage());
			}
			}
			/**
			 * @description- Method for accepting the alert
			 */
			public void acceptalert(){
				APP_LOGS.info("Clicking on a element by its xpath");
				try{
					driver.findElement(By.name("OK")).click();
					Alert alert = driver.switchTo().alert();
					alert.accept();
					alert.dismiss();
				}catch(Exception e){
					APP_LOGS.info(e.getMessage());
				}
			}
				/**
				 * @description- Method for click on button by xpath
				 */
				public void clickByXpath(String elementxpath){
					APP_LOGS.info("Clicking on a element by its xpath");
					try{
						driver.findElement(By.xpath(OR.getProperty(elementxpath))).click();
					}catch(Exception e){
						APP_LOGS.info(e.getMessage());
					}
				}
				/**
				 * @description- Method for clicking on a textfield by linkText
				*/
				public void clickBylinkText(String elementlinkText){
					APP_LOGS.info("Clicking on a element by its linkText");
					try{
						driver.findElement(By.linkText(OR.getProperty(elementlinkText))).click();
					}catch(Exception e){
						APP_LOGS.info(e.getMessage());
					}
				}
				/**
				 * @description- Method for clicking on link through its xpath which is dynamic generated
				*/
				public void clickByRandomXpath(String elementxpath){
					APP_LOGS.info("Clicking on a element by its random generated xpath");
					try{
						driver.findElement(By.xpath(elementxpath)).click();
					}catch(Exception e){
						APP_LOGS.info(e.getMessage());
					}
				}
					/**
					 * @description- Method for verify the page heading by  its name
					*/
				public boolean validateExpectedText(String elementName, String expected_data){
					APP_LOGS.info("Clicking on a element by its linkText");
					try{
						String Actual_Value = driver.findElement(By.name(OR.getProperty(elementName))).getText();
						if(Actual_Value.contains(OR.getProperty(expected_data))){
							return true;
						}
						else{
							return false;
						}
					}catch(Exception e){
						APP_LOGS.info(e.getMessage());
						}
						return true;
					}
}
