package exceldriver.framework;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datadrive {

	DataFormatter formatter = new DataFormatter();
	@Test(dataProvider = "get")
	public void initializedata(String Name, String Middle, String Surname) {
		
		
		System.out.println(Name+Middle+Surname);
		
	}
	
	
	
	
	@DataProvider(name = "get")
	public Object[][] getData() throws IOException {
FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\OneDrive\\Desktop\\Exceldriven1.xlsx");
XSSFWorkbook workbook = new XSSFWorkbook(fis);
XSSFSheet sheet = workbook.getSheetAt(0);
int rowcount = sheet.getPhysicalNumberOfRows();

XSSFRow row = sheet.getRow(0);
int columncount = row.getLastCellNum();

Object data[][] = new Object[rowcount-1][columncount];

for (int i = 0; i < rowcount-1 ; i++) {
	XSSFRow row1 = sheet.getRow(i+1);
	for(int i1=0; i1< columncount; i1++)
	{
		XSSFCell cell = row1.getCell(i1);
		data[i][i1] = formatter.formatCellValue(cell);
	}
}
return data;



	
	}

		
	}	
	
	
	
	
