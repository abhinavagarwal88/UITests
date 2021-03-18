package com.cumcumber.UITests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.common.AGenericTest;
import com.selenium.helpers.SeleniumHelpers;

public class AmazonSearchResultPage extends AGenericTest {
	
	private static By itemName = By.className("a-size-base-plus"); // item name displayed displayed in search results
 	private static By itemPriceCurrency = By.className("a-price-symbol"); //item currency
	private static By itemPriceWhole = By.className("a-price-whole"); //item price whole number
	private static By itemPriceFraction = By.className("a-price-fraction"); //item price fraction number
	private static String itemPrice;
	
	public static String getItemPrice() {
		return itemPrice;
	}

	public static void clickOnSearchResultItem(int searchResultItemNo) {
		driver.findElements(itemName).get(searchResultItemNo -1).click(); //click on 'x' item name 
 	}
	
	public static void setItemPrice(int searchResult) {
		List<WebElement> currency = driver.findElements(itemPriceCurrency); //get list of items currency
		List<WebElement> wholePrice = driver.findElements(itemPriceWhole); //get list of items whole price
		List<WebElement> fractionprice = driver.findElements(itemPriceFraction); //get list of items fraction price
		// get item price for 'x' item found in search result
		itemPrice = currency.get(searchResult - 1).getText() + wholePrice.get(searchResult - 1).getText() +"."+fractionprice.get(searchResult - 1).getText();
	}

}
