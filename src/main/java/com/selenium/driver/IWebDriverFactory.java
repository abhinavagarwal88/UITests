package com.selenium.driver;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

/**
 ********************************************************************
 * Interface that provides factory methods for each browser
 * 
 * @version 1.0.0
 ********************************************************************
 */
public interface IWebDriverFactory
{
   WebDriver createElectronDriver() throws IOException;

   WebDriver createChromeDriver();

   WebDriver createFireFoxDriver();

   WebDriver createEdgeDriver();

   WebDriver createIEDriver();

   WebDriver createAndroidDriver();

   WebDriver createIosDriver();
}
