package com.crm.vtiger.practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadFromXml {
	@Test
	public void readDataFromXml(XmlTest xmlobj) {
		System.out.println(xmlobj.getParameter("browser"));
		System.out.println(xmlobj.getParameter("url"));
	}
}
