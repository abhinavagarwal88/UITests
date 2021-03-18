package com.cumcumber.UITests;

import org.openqa.selenium.By;

import com.selenium.common.AGenericTest;

public class AmazonHomepage extends AGenericTest {

	private static By searchBox = By.id("twotabsearchtextbox"); // products search box
	private static By enterSubmitButton = By.id("nav-search-submit-button"); // submit button for search
	private static By signIn = By.id("nav-link-accountList-nav-line-1"); // Account and Link option

	public static void clickSignIn() {
		driver.findElement(signIn).click(); // click on Account and List on top right of amazon.com
	}

	public static void enterSearchItem(String searchString) {
		driver.findElement(searchBox).sendKeys(searchString); // enter search string in search bar
	}

	public static void clickSearchSubmitButton() {
		driver.findElement(enterSubmitButton).click(); // click on submit button adjacent to search bar
	}
}
