package com.anjali;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.anjali.utils.ChromeUtils;

public class AmazonPriceUtlis {
	public static Double priceFromAmazon(String iteamName) {
		Double price = 9999999999999999999.0;
		ChromeUtils.setChromeDriverSystemProperty();
		WebDriver driver = new ChromeDriver();
		try {

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			// open amazon
			driver.get("http://www.amazon.in/");
			// find searchbox
			WebElement schbox = driver
					.findElement(By.id("twotabsearchtextbox"));
			// send key to searchbox
			schbox.sendKeys(iteamName);
			// find and click search button
			WebElement searchButton = driver.findElement(By
					.xpath("//*[@id='nav-search']/form/div[2]/div/input"));
			searchButton.click();

			WebElement priceOnAmazon = driver
					.findElement(By
							.xpath("//*[@id='result_0']/div/div/div/div[2]/div[2]/div[1]/div[1]/a/span[2]"));
			String priceString = priceOnAmazon.getText();
			System.out.println(priceString);
			priceString = priceString.replaceAll(",", "");
			// System.out.println(priceString);
			price = new Double(priceString);
			// System.out.println(price);

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		return price;

	}
}
