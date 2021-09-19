package com.crm.vtiger.practice;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.vtiger.genericutils.CommonUtility;

public class LenskartSuggestionHandling {
	public static void main(String[] args) {
		CommonUtility wb = new CommonUtility();
		WebDriver driver = new ChromeDriver();
		wb.maximizeWindow(driver);
		wb.waitUntilPageLoad(driver);
		driver.get("https://www.lenskart.com/");
		driver.findElement(By.className("search_input-bar")).click();
		List <WebElement> list = driver.findElements(By.className("trending"));
		for(WebElement w : list) {
			System.out.println(w.getText());
		}
		driver.close();
	}
}
