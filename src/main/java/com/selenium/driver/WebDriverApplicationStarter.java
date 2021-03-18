package com.selenium.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 ********************************************************************
 * Runner class to do web driver setup for the current Application
 * This is generic setup that can run against most driver implementations
 * 
 * @version 1.0.0
 ********************************************************************
 */
public class WebDriverApplicationStarter
{
   private WebDriver driver;
   private String startURL;

   public WebDriverApplicationStarter(WebDriver webDriver) {
      this.driver = webDriver;
   }
   
   public WebDriverApplicationStarter(WebDriver webDriver, String startURL) {
      this(webDriver);
      this.startURL = startURL;
   }
   
   /**
    * Start & Setup web driver
    */
   public void start() {
      if(startURL != null) {
    	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
         driver.get(startURL);
         // Wrapped inside here due to not being supported by Electron (Only browser not requiring startURL)
        driver.manage().window().maximize();
      }
      else
      {
         JavascriptExecutor js = (JavascriptExecutor) driver;  
         js.executeScript("require('electron').remote.BrowserWindow.getFocusedWindow().maximize();");
      }
   }
}

