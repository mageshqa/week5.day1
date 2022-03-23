package testngpractice;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelTestData {

	public static String[][] getData(String excelFilePath) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook(excelFilePath);

		XSSFSheet sheet = book.getSheetAt(0);

		int rowCount = sheet.getLastRowNum();
		int colsCount = sheet.getRow(0).getLastCellNum();

		System.out.println("Rows Count is " + rowCount);
		System.out.println("Columns Count is " + colsCount);

		String[][] data = new String[rowCount][colsCount];

		for (int i = 1; i <= rowCount; i++) {
			XSSFRow eachRow = sheet.getRow(i);

			for (int j = 0; j < colsCount; j++) {
				XSSFCell eachCols = eachRow.getCell(j);
				String eachCell = eachCols.getStringCellValue();
				data[i - 1][j] = eachCell;
				// System.out.println(eachCell);
			}
		}

		book.close();

		return data;

	}
}
