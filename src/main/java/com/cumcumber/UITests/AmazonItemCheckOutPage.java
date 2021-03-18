package com.cumcumber.UITests;

import org.openqa.selenium.By;

import com.selenium.common.AGenericTest;

public class AmazonItemCheckOutPage extends AGenericTest{

	private static By itemPrice = By.cssSelector("strong[dir = 'ltr']"); //item price
	
	public static String getItemPrice() {
		return (driver.findElement(itemPrice)).getText(); //get item price
	}
}
