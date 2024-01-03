package utilPackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {
	
//This method takes two parameters - filePath (the path to the Excel file) and sheetName (the name of the sheet from which data needs to be read).
//It returns a 2D array (Object[][]) representing the data from the Excel sheet.

public static Object[][] getDataFromExcel(String filePath, String sheetName) throws InvalidFormatException, IOException
{
//here getting excel data to an 2D(3x2) array using getDataFromExcel(path,value)

		Object[][] data;
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		Workbook wb = WorkbookFactory.create(inputStream);
		Sheet s = wb.getSheet(sheetName);
//It uses Apache POI (WorkbookFactory.create(inputStream)) to handle reading Excel files.

		// sheet range
		//we get how many rows and columns exist
		int rowCount = s.getLastRowNum(); //4
		int colCount = s.getRow(0).getLastCellNum();//2

		// set data
		//It iterates through each row and column, excluding the header row, and populates the 2D array with cell values.
		data = new Object[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j <= colCount - 1; j++) {
				if (!getCellValue(s, 0, j).equals("")) {
					data[i - 1][j] = getCellValue(s, i, j);
				}
			}
		}
	
		return data;
	}

// Get cell value at given row and column
//It checks the cell type and converts the cell value to a string to handle different data types.
	
	private static String getCellValue(Sheet sheet, int row, int col) {
		String value = "";
		if (sheet.getRow(row).getCell(col) == null) {
			value = "";
		} else if (sheet.getRow(row).getCell(col).getCellType() == Cell.CELL_TYPE_STRING) {
			value = sheet.getRow(row).getCell(col).getStringCellValue();
		} else {
			sheet.getRow(row).getCell(col).setCellType(Cell.CELL_TYPE_STRING);
			value = sheet.getRow(row).getCell(col).getStringCellValue();
		}
		return value;
	}
}
//Overall, this class allows you to read data from an Excel file, skipping empty cells and creating a 2D array of data. Make sure you handle exceptions appropriately, such as catching InvalidFormatException and IOException. Additionally, consider closing the input stream after reading the Excel file.
