package com.crm.vtiger.genericutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class contains all the generic methods related to excel  sheet
 * @author shubh
 *
 */
public class ExcelUtility {
		/**
		 *  its used read the data from excel base don below arguments 
		 * @param sheetName
		 * @param rowNum
		 * @param celNum
		 * @return Data
		 * @throws Throwable
		 */
		public String getDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable {
			FileInputStream fis  = new FileInputStream(IpathConstants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			DataFormatter format = new DataFormatter();
			String data = format.formatCellValue(sh.getRow(rowNum).getCell(celNum));
//			Row row = sh.getRow(rowNum);
//			String data = row.getCell(celNum).getStringCellValue();
			wb.close();
			return data;
		}
		/**
		 * used to get the last used row number on specified Sheet
		 * @param sheetName
		 * @return
		 * @throws Throwable
		 */
		public int getRowCount(String sheetName) throws Throwable {
			FileInputStream fis  = new FileInputStream(IpathConstants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			wb.close();
			return sh.getLastRowNum();
		}
		
		public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable {
			FileInputStream fis  = new FileInputStream(IpathConstants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			Cell cel = row.createCell(celNum);
			cel.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(IpathConstants.ExcelPath);
			wb.write(fos);
			wb.close();
		}
		
		/**
		 * this method is used to fetch different data from excel sheet for same test case
		 * @param SheetName
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public Object[][] getExcelData(String SheetName) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(SheetName);
			int lastRow = sheet.getLastRowNum();
			int lastCell = sheet.getRow(0).getLastCellNum();
			
			Object [][] data = new Object [lastRow] [lastCell];
			
			for(int i = 0; i < lastRow; i++) {
				for (int j = 0; j < lastCell; j++) {
					data [i] [j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
			return data;
		}
}
