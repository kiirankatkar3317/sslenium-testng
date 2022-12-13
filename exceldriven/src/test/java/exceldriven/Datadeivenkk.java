package exceldriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Datadeivenkk {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
}
	
	
	@SuppressWarnings("resource")
	public ArrayList<String> getdata1(String Testnamecase) throws IOException {

		ArrayList<String> a=new	ArrayList<String>();	
		FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\OneDrive\\Desktop\\exceldriven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for(int i = 0; i<sheets; i++) {
		if(workbook.getSheetName(i).equalsIgnoreCase("kk")) {
			XSSFSheet exactsheet = workbook.getSheetAt(i);
		Iterator<Row> r = exactsheet.rowIterator();
		while(r.hasNext()) {
			Row firstrow = r.next();
			if(firstrow.getCell(0).getStringCellValue().equalsIgnoreCase(Testnamecase)){
				Iterator<Cell> c =firstrow.cellIterator();
				
				while(c.hasNext()) {
					Cell firstcell =  c.next();	
					if(firstcell.getCellType()==CellType.STRING) {
						System.out.println(a.add(firstcell.getStringCellValue()));
			
					}
					else {
						System.out.println(a.add(NumberToTextConverter.toText(firstcell.getNumericCellValue())));
					}
				}
			
			}
			
		}


		}
		}
return a;
		}
}