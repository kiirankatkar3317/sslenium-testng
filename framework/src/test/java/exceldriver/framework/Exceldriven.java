package exceldriver.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldriven {

	
	public ArrayList<String> getData(String testcasename) throws IOException {
		
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\OneDrive\\Desktop\\exceldriven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("kk")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.rowIterator();
				Row firstrow = rows.next();
				Iterator<Cell> columns = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				while (columns.hasNext()) {
					Cell column1 = columns.next();
					if (column1.getStringCellValue().equalsIgnoreCase("login")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				while (rows.hasNext()) {
					Row firstrow1 =  rows.next();
					
                if(firstrow1.getCell(column).getStringCellValue().equalsIgnoreCase("testcasename")) {
                Iterator<Cell>	columns1= firstrow1.cellIterator();
                	while(columns1.hasNext()) {
                		Cell c = columns1.next();
                		if(c.getCellType()== CellType.STRING) {
                			a.add(c.getStringCellValue());
                		}
                		else {
                			a.add(NumberToTextConverter(c.getNumericCellValue()));			
                		}
                		
                	}
                	
                }
				}
			}

		}
		return a;		
	}
	private String NumberToTextConverter(double numericCellValue) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args){
		// TODO Auto-generated method stub
	

	}

}
