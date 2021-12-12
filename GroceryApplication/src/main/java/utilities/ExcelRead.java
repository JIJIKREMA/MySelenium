package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public static FileInputStream f;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;

	public static String readStringData(int i,int j) throws IOException
	{
		
		
		//class
		f= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\UserList.xlsx");
		wb = new XSSFWorkbook(f);
		sh= wb.getSheet("Users");
		//interface
		Row r=sh.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
		
	}

	public static String readIntegerData(int i,int j) throws IOException
	{
		//class
		f= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\UserList.xlsx");
		wb = new XSSFWorkbook(f);
		sh= wb.getSheet("sheet1");
		//interface
		Row r=sh.getRow(i);
		Cell c = r.getCell(j);
		int x= (int) c.getNumericCellValue();
		
		return String.valueOf(x);
		
	}
	
}
