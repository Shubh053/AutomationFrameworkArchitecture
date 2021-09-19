package com.crm.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.vtiger.genericutils.SuperClass;

public class HoverMessagePractice extends SuperClass{
	@Test
	public void hoverMessagePractice() {
		WebElement hover = driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"));
		System.out.println(hover.getAttribute("title"));
	}
}
