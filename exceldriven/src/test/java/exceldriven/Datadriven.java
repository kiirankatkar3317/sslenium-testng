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

public class Datadriven {
	
	@SuppressWarnings("resource")
	public ArrayList<String> getData(String Testcasename) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\OneDrive\\Desktop\\exceldriven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("kk")) {
				XSSFSheet exactsheet = workbook.getSheetAt(i);
				Iterator<Row> rows = exactsheet.rowIterator();
				Row firstline = rows.next();
				Iterator<Cell> ce = firstline.cellIterator();
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("purchase")) {

						column = k;
					}
					k++;
				}
				System.out.println(column);

				while (rows.hasNext()) {
					Row rowsofexel = rows.next();
					if (rowsofexel.getCell(0).getStringCellValue().equalsIgnoreCase(Testcasename)) {
						Iterator<Cell> ce1 = rowsofexel.cellIterator();
						while (ce1.hasNext()) {
							Cell kk = ce1.next();
							if(kk.getCellType()== CellType.STRING) {
								a.add(kk.getStringCellValue());			
							}
							else {
								a.add(NumberToTextConverter.toText(kk.getNumericCellValue()));
							}
					
						}
					}
				}
			}
		}
		return a;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		}
}