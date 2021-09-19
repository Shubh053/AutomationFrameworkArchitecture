package com.crm.vtiger.genericutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	public String getDataFromProperty(String key) throws IOException  {
		FileInputStream fis = new FileInputStream("./CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = (String) pobj.getProperty(key);
		return value;
	}
}
