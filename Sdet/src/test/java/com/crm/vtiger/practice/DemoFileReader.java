package com.crm.vtiger.practice;

import com.crm.vtiger.genericutils.JSONFileUtility;

public class DemoFileReader {
	public static void main(String[] args) throws Throwable {
		JSONFileUtility jsonLib = new JSONFileUtility();
		String val = jsonLib.readDataFromJson("password");
		System.out.println(val);
	}
}
