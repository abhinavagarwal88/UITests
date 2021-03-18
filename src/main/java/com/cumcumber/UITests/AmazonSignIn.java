package com.cumcumber.UITests;

import org.openqa.selenium.By;

import com.selenium.common.AGenericTest;

public class AmazonSignIn extends AGenericTest{
	
	private static By username_textfield = By.id("ap_email"); //email/user name field
	private static By password_textfield = By.id("ap_password"); //password field
	private static By continue_button = By.id("continue"); //continue button
	private static By signIn_button = By.id("signInSubmit"); // submit button
	
	
	public static void enterUserName(String username) {
		driver.findElement(username_textfield).sendKeys(username); //enter user name
	}
	
	public static void enterPassword(String password) {
		driver.findElement(password_textfield).sendKeys(password); //enter password
	}
	
	public static void clickContinueButton() {
		driver.findElement(continue_button).click(); //click continue button
	}
	
	public static void clickSignInButton() {
		driver.findElement(signIn_button).click(); //click sign in button
	}
}
