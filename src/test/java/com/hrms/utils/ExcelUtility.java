package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	 static Workbook book;
	 static Sheet sheet;
/**
 * method to open an excel file and catches the exceptions
 * @param filePath
 */
	public static void openExcel(String filePath) {

		try {
			FileInputStream fis = new FileInputStream(filePath);
			book = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * method to get the row and cell and pass a new value
	 * @param index
	 * @param index1
	 * @param value
	 */
	public static void getRow_getCell_setCellValue(int index, int index1, String value) {
		 sheet.getRow(index).getCell(index1).setCellValue(value);
	}
	/**
	 * method to get create a row, create a cell and pass value
	 * @param index
	 * @param index1
	 * @param value
	 */
	public static void createRow_createCellValue(int index, int index1, String value) {
		 sheet.createRow(index).createCell(index1).setCellValue(value);
	}
	
	/**
	 * method to get the row and create a cell and pass the value
	 * @param index
	 * @param index1
	 * @param value
	 */
	public static void getRow_createCellValue(int index, int index1, String value) {
		 sheet.getRow(index).createCell(index1).setCellValue(value);
	}

	
/**
 * method to get the sheet we need
 * @param sheetName
 */
	public static void getSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
	}
/**
 * method to return the number of rows
 * @return
 */
	public static int getRowsCount() {
		return sheet.getPhysicalNumberOfRows();
	}
/**
 * method to return the number of collumns
 * @param rowNum
 * @return
 */
	public static int getColsCount(int rowNum) {
		return sheet.getRow(rowNum).getPhysicalNumberOfCells();
	}
/**
 * method to get and return the specific cell and convert it into String
 * @param rowIndex
 * @param colIndex
 * @return
 */
	public static String getCellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}
/**
 * method to get and return the data from excel file and store it into List of maps
 * @param filePath
 * @param sheet
 * @return
 */
	public static List<Map<String, String>> excelToListMap(String filePath, String sheet) {

		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map;

		openExcel(filePath);
		getSheet(sheet);

		for (int r = 1; r < getRowsCount(); r++) {
			map = new LinkedHashMap<>();

			for (int c = 0; c < getColsCount(r); c++) { 

				String key = getCellData(0, c);
				String value = getCellData(r, c);
				map.put(key, value);
			}
			list.add(map);
		}
		return list;
	}

	
}
