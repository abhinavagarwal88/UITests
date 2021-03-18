package com.selenium.driver;

import java.io.File;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 ********************************************************************
 * WebDriverFactory implementation providing driver building functionality.
 * Builds without the use of third party library
 * 
 * @version 1.0.0
 ********************************************************************
 */
public class WebDriverFactory implements IWebDriverFactory
{
   private static final String DISABLE_EXTENSIONS = "--disable-extensions";

   private static final String DOWNLOAD_PATH_PROP = "download.path";

   private final String DOWNLOAD_PATH;

   public WebDriverFactory()
   {
      DOWNLOAD_PATH = "C://Downloads";
   }

   /**
    * Creates a generic chrome driver using the provided options
    * 
    * Allows resuable generic chrome driver for Chrome browser & electron
    * 
    * @param chromeOptions
    *           options to customize the generic chrome driver
    * @return generic ChomeDriver
    */
   public ChromeDriver createGenericChromeDriver(ChromeOptions chromeOptions)
   {
      // Define constants used for driver creation
      final String DEFAULT_DOWNLOAD_PATH = "download.default_directory";
      final String DEFAULT_CONTENT_SETTINGS_POPUPS = "profile.default_content_settings.popups";
      final int DEFAULT_CONTENT_SETTINGS_POPUPS_VAL = 0;
      final String PREFS_OPTION = "prefs";
      final String TEST_TYPE_ARG = "--test-type";
      final boolean ACCEPT_SSL_CERTS = true;

      WebDriverManager.chromedriver().setup();
      Map<String, Object> chromePrefs = new HashMap<>();
      chromePrefs.put(DEFAULT_CONTENT_SETTINGS_POPUPS, DEFAULT_CONTENT_SETTINGS_POPUPS_VAL);
      chromePrefs.put(DEFAULT_DOWNLOAD_PATH, DOWNLOAD_PATH);

      chromeOptions.setExperimentalOption(PREFS_OPTION, chromePrefs);
      chromeOptions.addArguments(TEST_TYPE_ARG);
      chromeOptions.addArguments(DISABLE_EXTENSIONS);
      DesiredCapabilities capabilities = DesiredCapabilities.chrome();
      capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

      // Setup browser capabilities
      capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
      capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, ACCEPT_SSL_CERTS);
      return new ChromeDriver(capabilities);

   }

   public WebDriver createElectronDriver() throws IOException
   {
      // Define constants used for driver creation
      final String ELECTRON_PATH_PROPERTY = "electron.app.path";
      final String ELECTRON_PATH = System.getProperty(ELECTRON_PATH_PROPERTY);
      File electronPath = new File(ELECTRON_PATH);
      // Setup browser options
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.setBinary(electronPath.getCanonicalFile());
      return createGenericChromeDriver(chromeOptions);

   }

   public WebDriver createChromeDriver()
   {
      return createGenericChromeDriver(new ChromeOptions());
   }

   public WebDriver createFireFoxDriver()
   {
      // Define constants used for driver creation
      final String DEFAULT_DOWNLOAD_PATH = "browser.download.dir";
      final String DEFAULT_DOWNLOAD_FOLDERLIST = "browser.download.folderList";
      final String NEVER_ASK_SAVE_TO_DISK = "browser.helperApps.neverAsk.saveToDisk";
      final String DL_MNG_SHOW_WHEN_STARTING = "browser.download.manager.showWhenStarting";
      final String PDFJS_DISABLED = "pdfjs.disabled";

      final int FOLDER_LIST = 2;
      final String NEVER_ASK = "application/pdf";
      final boolean SHOW_WHEN_START = false;
      final boolean PDFJS_VAL = true;

      WebDriverManager.firefoxdriver().setup();
      FirefoxProfile profile = new FirefoxProfile();
      profile.setPreference(DEFAULT_DOWNLOAD_PATH, DOWNLOAD_PATH);
      profile.setPreference(DEFAULT_DOWNLOAD_FOLDERLIST, FOLDER_LIST);
      profile.setPreference(NEVER_ASK_SAVE_TO_DISK, NEVER_ASK);
      profile.setPreference(DL_MNG_SHOW_WHEN_STARTING, SHOW_WHEN_START);
      profile.setPreference(PDFJS_DISABLED, PDFJS_VAL);
      FirefoxOptions option = new FirefoxOptions();
      option.setProfile(profile);
      return new FirefoxDriver(option);

   }

   public WebDriver createEdgeDriver()
   {
	  System.setProperty("webdriver.edge.driver", "C:\\Users\\B.Test\\.m2\\repository\\webdriver\\MicrosoftWebDriver\\6.17134\\MicrosoftWebDriver.exe");
      //WebDriverManager.edgedriver().version("6.17134").setup();
      return new EdgeDriver();
   }

   public WebDriver createIEDriver()
   {
      WebDriverManager.iedriver().version("3.10").setup();
      DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

      ieCapabilities.setCapability("nativeEvents", false);
      ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
      ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
      ieCapabilities.setCapability("disable-popup-blocking", true);
      ieCapabilities.setCapability("enablePersistentHover", true);
      ieCapabilities.setCapability("ignoreZoomSetting", true);
      return new InternetExplorerDriver(ieCapabilities);
   }

   public WebDriver createAndroidDriver()
   {
	   DesiredCapabilities capabilities = new DesiredCapabilities();
	   capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	   capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	   capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
	   capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	   capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	   

	      AppiumDriver<MobileElement> driver;

	      try
	      {
	         return driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

	      }
	      catch (MalformedURLException e)
	      {
	         throw new RuntimeException(e);
	      }



   }

   public WebDriver createIosDriver()
   {
      return null;
   }

}
