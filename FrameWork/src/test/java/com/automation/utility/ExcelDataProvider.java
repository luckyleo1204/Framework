package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
		XSSFWorkbook wb;
	public  ExcelDataProvider() 
	{
		File f=new File("./TestData/Data.xlsx");
		try {
			FileInputStream fis=new FileInputStream(f.getAbsoluteFile());
			 wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to Read Excel File"+e.getMessage());
		}
		
	}
	
	public String  getStringData(String sheetName, int row, int col)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	
	public double  getNumericData(String sheetName, int row, int col)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
	
	public String  getStringData(int  SheetIndex, int row, int col)
	{
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(col).getStringCellValue();
	}
	
	public double  getNumericData(int  SheetIndex, int row, int col)
	{
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(col).getNumericCellValue();
	}


}
