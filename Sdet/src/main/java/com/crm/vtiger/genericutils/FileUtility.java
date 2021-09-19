package com.crm.vtiger.genericutils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.json.simple.parser.JSONParser;

/**
 *  This class is to get data from different files and Databases
 * @author shubh
 *
 */
public class FileUtility {

	/**
	 * this method is used to get data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
		public String getDataFromProperty(String key) throws IOException  {
			FileInputStream fis = new FileInputStream(IpathConstants.PropertiesPath);
			Properties pobj = new Properties();
			pobj.load(fis);
			String value = (String) pobj.getProperty(key);
			return value;
		}
		
		public String getDataFromJson(String key) throws Throwable {
			FileReader file = new FileReader(IpathConstants.JsonPath);
			JSONParser jsonObj = new JSONParser();
			Object javaObj = jsonObj.parse(file);
			HashMap map = (HashMap) javaObj;
			String value = map.get(key).toString();
			return value;
		}
}
