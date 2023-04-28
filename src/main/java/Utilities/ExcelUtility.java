package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileInputStream f;

	public static ArrayList<String> getString(String file_path, String sheet) throws IOException {
		f = new FileInputStream(System.getProperty(file_path));
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		ArrayList<String> ExcelRows = new ArrayList<String>();
		int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
		for (int i = 0; i <= rowCount; i++) {
			Row row = sh.getRow(i);
			int cellCount = row.getLastCellNum();
			for (int j = 0; j < cellCount; j++) {
				ExcelRows.add(row.getCell(j).getStringCellValue());
			}
		}
		return ExcelRows;
	}

	public static ArrayList<String> getRow(String file_path, String sheet, int rownum) throws IOException {
		f = new FileInputStream(System.getProperty(file_path));
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		ArrayList<String> ExcelRows = new ArrayList<String>();
		Row row = sh.getRow(rownum);
		int cellCount = row.getLastCellNum();
		for (int j = 0; j < cellCount; j++) {
			ExcelRows.add(row.getCell(j).getStringCellValue());
		}
		return ExcelRows;
	}

	public static String getString(int i, int j, String file_path, String sheet) throws IOException {
		f = new FileInputStream(file_path);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	}

	public static String getNumeric(int i, int j, String file_path, String sheet) throws IOException {
		f = new FileInputStream(System.getProperty(file_path));
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		int value = (int) c.getNumericCellValue();
		return String.valueOf(value);
	}

	public static void setValues(String file_path, String sheet) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(file_path);
		wb.write(outputStream);

	}

	public static void setValues(String file_path, String sheet, String data) throws IOException {
		f = new FileInputStream(file_path);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheetAt(0);
		int lastRow = sh.getLastRowNum();
		for (int i = 0; i <= lastRow; i++) {
			Row r = sh.getRow(i);
			Cell c = r.createCell(2);
			c.setCellValue(data);
		}
		FileOutputStream fos = new FileOutputStream(file_path);
		wb.write(fos);
		fos.close();

	}
}
