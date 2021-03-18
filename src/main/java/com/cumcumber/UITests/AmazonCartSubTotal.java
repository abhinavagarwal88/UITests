package com.cumcumber.UITests;

import org.openqa.selenium.By;

import com.selenium.common.AGenericTest;
import com.selenium.helpers.SeleniumHelpers;

public class AmazonCartSubTotal extends AGenericTest {
	
	private static By cartSubTotal = By.className("a-color-price"); // item price
	private static By proceedToCheckOutButton = By.id("hlb-ptc-btn-native"); //proceed to checkout button
	
	public static String getCartSubTotal() {
		SeleniumHelpers.waitUntilElementIsVisible(cartSubTotal, driver);
		return driver.findElement(cartSubTotal).getText(); //get item price
	}
	
	public static void clickProceedToCheckOutButton() {
		driver.findElement(proceedToCheckOutButton).click(); //click proceed to checkout page
	}

}
