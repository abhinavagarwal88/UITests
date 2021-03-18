package com.selenium.helpers;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.selenium.common.AGenericTest;

public class SeleniumHelpers extends AGenericTest {
	private static String url;

	public static WebElement waitUntilElementIsVisible(By locator, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		return element;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String uri) {
		url = uri;
	}

	public static void openAndLoadBrowser(String browser, String uri) throws IOException {
		setUrl(uri);
		beforeMethod(browser, getUrl()); // open browser and load the url
	}

	public static void closeBrowser() {
		afterMethod(); // close the browser after every test
	}

}
