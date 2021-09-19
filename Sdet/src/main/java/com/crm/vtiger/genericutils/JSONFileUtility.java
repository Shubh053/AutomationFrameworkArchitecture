package com.crm.vtiger.genericutils;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

/**
 *  This is a generic method to read the data from json file
 * @author shubham
 *
 */

public class JSONFileUtility {
	public String readDataFromJson(String key) throws Throwable {
		// read the data from json file
		FileReader file = new FileReader("./CommonData.json");
		
		// convert the json file into java object
		JSONParser jsonObj = new JSONParser();
		Object javaObj = jsonObj.parse(file);
		
		// type cast java object into hashmap
		HashMap map = (HashMap) javaObj;
		String value = map.get(key).toString();
		
		// return the value
		return value;
	}
	
	
	
}
