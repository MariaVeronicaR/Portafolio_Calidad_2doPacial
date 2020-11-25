package com.mayab.calidad.cross_browser;


import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class CrossB {
	private static void pause(long mils) {
		  try {
			  Thread.sleep(mils);
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	  }
	
	 public static final String USERNAME = "veronicam";
	  public static final String ACCESS_KEY = "6fea824d-702b-4912-8c21-8bad49f3198c";
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	  
	public static void main(String[] args) throws Exception {
		 DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("name", "testChrome");
		    caps.setCapability("platform", "Windows 10");
		    caps.setCapability("version", "latest");
		    caps.setCapability("browserName", "chrome");
		    caps.setCapability("build", "Selenium_Saucelabs_1");
		    
		    //macOS :firefox
		    DesiredCapabilities cap1 = new DesiredCapabilities();
		    cap1.setCapability("name", "testFirefox");
		    cap1.setCapability("platform", "macOS 10.13");
		    cap1.setCapability("version", "12.0");
		    cap1.setCapability("browserName", "firefox");
		    cap1.setCapability("build", "Selenium_Saucelabs_1");
		    
		  
		    WebDriver driver;
		    
		    
		    driver = new RemoteWebDriver(new URL(URL), cap1);

		    
		    driver.get("https://www.google.com/");
		    driver.findElement(By.name("q")).click();
		    driver.findElement(By.name("q")).clear();
		    driver.findElement(By.name("q")).sendKeys("covid");
		    driver.findElement(By.id("tsf")).submit();
		    assertEquals("covid - Google Search", driver.getTitle());
		    boolean finalResult = false;
			if(driver.getTitle().equals("covid - Google Search")) {
				finalResult = true;
			}else {
				finalResult = false;
			}
			if (finalResult){
			      ((JavascriptExecutor)driver).executeScript("sauce:job-result=passed");
			    }
			    else {
			      ((JavascriptExecutor)driver).executeScript("sauce:job-result=failed");
			    }
		    driver.quit();
	}

}