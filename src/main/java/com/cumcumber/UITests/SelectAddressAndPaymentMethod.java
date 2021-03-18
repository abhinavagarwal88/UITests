package com.cumcumber.UITests;

import org.openqa.selenium.By;

import com.selenium.common.AGenericTest;
import com.selenium.helpers.SeleniumHelpers;

public class SelectAddressAndPaymentMethod extends AGenericTest{
	
	private static By deliverToAddress = By.className("ship-to-this-address"); //deliver to address button
	private static By continueButton = By.className("a-button-text"); //Continue button for shipping options
	//continue button on payment method page
	private static By continueButtonPayment = By.cssSelector(".a-button-input[name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']");
	
	public static void selectAddress() {
		driver.findElement(deliverToAddress).click(); //select most recent address
	}
	
	public static void clickContinueButton() {
		SeleniumHelpers.waitUntilElementIsVisible(continueButton, driver); // wait till element is displayed as it can be obscured by page load icon
		driver.findElement(continueButton).click(); //click continue button
	}
	
	public static void clickContinueButtonPayment() {
		SeleniumHelpers.waitUntilElementIsVisible(continueButtonPayment, driver);
		driver.findElement(continueButtonPayment).click(); //click continue button
	}

}
