package com.crm.vtiger.genericutils;

import java.util.Random;

import org.apache.poi.hpsf.Date;

/**
 *  This class contains all the generic methods related to java
 * @author shubh
 *
 */
public class JavaUtility {
/**
*   its used to generate the integer RanDom number with in the boundary of 0 to 10000
* @return intData
*/
public int getRanDomNumber() {
	Random ranDom = new Random();
	int ranDomNum = ranDom.nextInt(1000);
	return ranDomNum;
	}

	public String getSystemDate() {
		Date date = new Date();
		String systemDate = date.toString();
		return systemDate;
	}
}
