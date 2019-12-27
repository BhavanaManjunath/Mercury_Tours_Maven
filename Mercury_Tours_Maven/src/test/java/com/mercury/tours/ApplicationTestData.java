package com.mercury.tours;

import org.testng.annotations.DataProvider;

public class ApplicationTestData {

	@DataProvider(name="Login")
	public Object[][] getdataFromatDataProvider(){
		return new Object[][]{
			{"testing","testing"},
			{"dixit","dixit"},
			{"testabhi","testabhi"}
		};
	}
		//This is to read excel data
		@DataProvider(name="LoginDataXls")
		public Object[][] ReadExcel_generic () throws Exception {
			Readexcel_XLS_example excel= new Readexcel_XLS_example();
			Object[][] trstObjArray=excel.getExcelData("C:\\selenium Traning\\WorkSpace\\Mercury_Tours_Maven\\Book1.xls","SignOn");
			System.out.println(trstObjArray); 
			return trstObjArray;
		}
	
////This is to read excelxlsx data
@DataProvider(name="LoginDataXlsx")
public Object[][] ExcelXLSx() throws Exception {
	Readexcel_XLS_example excel= new Readexcel_XLS_example();
	Object[][] trstObjArray=excel.getExcelData("C:\\selenium Traning\\WorkSpace\\Mercury_Tours_Maven\\Book1.xlsx","SignOn");
	System.out.println(trstObjArray); 
	return trstObjArray;
}
}
	

