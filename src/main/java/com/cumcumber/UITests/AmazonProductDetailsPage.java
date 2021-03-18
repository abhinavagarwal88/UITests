package com.cumcumber.UITests;

import org.openqa.selenium.By;

import com.selenium.common.AGenericTest;

public class AmazonProductDetailsPage extends AGenericTest{
	
	private static By addToCartButton = By.id("add-to-cart-button"); //add to cart button
	private static By productPrice = By.id("newBuyBoxPrice"); //product price
	
	public static String getProductPrice() {
		return driver.findElement(productPrice).getText(); // get product price
	}
	
	public static void clickAddToCartButton() {
		driver.findElement(addToCartButton).click(); //click on add to cart button
	}

}
