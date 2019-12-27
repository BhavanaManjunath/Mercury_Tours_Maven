package com.mercury.tours;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readexcel_XLSX_example2 {
private static XSSFSheet ExcelWSheet;
private static  XSSFWorkbook ExcelWBook;
//This method is to read the test data from the excel
public String[][] getExcelData(String fileName,String sheetName) throws EncryptedDocumentException,IOException{
String[][] arrayExcelData=null;
FileInputStream ExcelFile =new FileInputStream(fileName);
ExcelWBook= new XSSFWorkbook(ExcelFile);
ExcelWSheet=ExcelWBook.getSheet(sheetName);
int TotalNoofrows=ExcelWSheet.getLastRowNum();
int TotalNoofcols_0=ExcelWSheet.getRow(0).getLastCellNum();
arrayExcelData=new String[TotalNoofrows][ TotalNoofcols_0];

for(int i=0;i<TotalNoofrows;i++)

{
int TotalNoofcols=ExcelWSheet.getRow(0).getLastCellNum();

for(int j=0;j<TotalNoofcols;j++){
	arrayExcelData[i][j]=ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
	System.out.println(arrayExcelData[i][j]);
}
}
System.out.println(arrayExcelData);
return arrayExcelData;
}
}
