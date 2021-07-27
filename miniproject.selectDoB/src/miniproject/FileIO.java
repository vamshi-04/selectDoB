package miniproject;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileIO {
	private static XSSFWorkbook workbook;
	static String fname = null;
	static String lname = null;
	static String mobile = null;
	static String password = null;
	static String gender = null;
	static String day = null;
	static String year = null;
	static int month;
	
	//Getting the inputs from provided Excel Sheet
	public void getElements() throws IOException {
		
		//location of Excel Sheet
		String path = ".\\Resources\\inputSet.xlsx";
		FileInputStream fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		XSSFSheet s = workbook.getSheetAt(0);
		
		//firstname
		fname = s.getRow(0).getCell(0).getStringCellValue();
		//lastname
		lname = s.getRow(0).getCell(1).getStringCellValue();
		//mobile
		mobile = Long.toString((long) s.getRow(0).getCell(2).getNumericCellValue());
		//password
		password = s.getRow(0).getCell(3).getStringCellValue();
		//day
		day = Integer.toString((int) s.getRow(0).getCell(4).getNumericCellValue());
		//month
		month = (int) s.getRow(0).getCell(5).getNumericCellValue();
		//year
		year= Integer.toString((int) s.getRow(0).getCell(6).getNumericCellValue());
		//gender
		gender = s.getRow(0).getCell(7).getStringCellValue();
	}
}
