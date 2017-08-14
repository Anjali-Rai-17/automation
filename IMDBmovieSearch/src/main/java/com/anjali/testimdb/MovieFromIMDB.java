package com.anjali.testimdb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.anjali.utils.ChromeUtils;


public class MovieFromIMDB {

	public static List<String> imdb250List(String sortBy) {
		List<String> movieList = new ArrayList<String>();
		ChromeUtils.setChromeDriverSystemProperty();
		WebDriver driver = new ChromeDriver();

		try {
			// open imdb
			driver.get("http://www.imdb.com/chart/top");
			// find sorting dropdown and click
			WebElement element = driver.findElement(By.name("sort"));
			element.click();
			// sortby= ranking, release date, imdb rating, no. of rating, your
			// rating
			Select se = new Select(element);
			se.selectByVisibleText(sortBy);
			element.click();
			// find all 250 movies based on sorting and print them.
			for (int i = 1; i <= 250; i++) {
				String xpath = "//*[@id=\"main\"]/div/span/div/div/div[3]/table/tbody/tr["
						+ i + "]/td[2]/a";
				WebElement movieNameElement = driver.findElement(By
						.xpath(xpath));
				String movieName = movieNameElement.getText();
				movieList.add(movieName);
			}

			System.out.println(movieList);// movieList=list of movie provided by
											// excel

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		return movieList;
	}

	public static List<String> imdbGenereList(String genere, String sortBy) {
		List<String> movieList = new ArrayList<String>();
		ChromeUtils.setChromeDriverSystemProperty();
		WebDriver driver = new ChromeDriver();

		try {
			// open imdb
			driver.get("http://www.imdb.com/search/title?genres=" + genere
					+ "&sort=" + sortBy);
			// find all 250 movies based on sorting and print them.
			for (int i = 1; i <= 50; i++) {

				String xpath = "//*[@id=\"main\"]/div/div/div[3]/div[" + i
						+ "]/div[3]/h3/a[1]";
				WebElement movieNameElement = driver.findElement(By
						.xpath(xpath));
				String movieName = movieNameElement.getText();
				movieList.add(movieName);
			}

			System.out.println(movieList);// movieList=list of movie provided by
											// excel

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// driver.quit();
		}
		return movieList;
	}
}
