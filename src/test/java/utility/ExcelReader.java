package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	/******
	 * Method To fetch data from excel using Apache Poi
	 * 
	 * @return
	 * @throws Exception
	 * 
	 * 
	 **** 
	 * @Creator Avik Guha
	 **/
	@SuppressWarnings("resource")
	public String init_excel(String excel_name_with_extension, Integer sheet_index_starting_from_0, Integer row_index_starting_from_0, Integer column_index_starting_from_0)
			throws Exception {

		String folderPath = "src//test//resources//TestData//"; // keep excel in this folder path
		String element_Image = System.getProperty("user.dir") + File.separator + folderPath + excel_name_with_extension;

		File file = new File(element_Image);
		FileInputStream fis = new FileInputStream(file); // this contains raw data from the excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // creating workbook
		XSSFSheet sheet = workbook.getSheetAt(sheet_index_starting_from_0); // getting the sheet from workbook

		String cellValue = sheet.getRow(row_index_starting_from_0).getCell(column_index_starting_from_0).getStringCellValue(); // fetching data from the
																								// sheet
		return cellValue;
	}
	
	
	/******
	 * Method To fetch data from excel using Apache Poi

	 * @return
	 * @throws Exception
	 * 
	 * Strategy
	 * Create object for XSSFWorkbook class --> get hold of excel
	 * Get access to sheet
	 * Get access to all rows of sheet
	 * Get access to all cells of 1st row and store values in an ArrayList
	 * Get the index of the required parent_cell
	 * Iterate through the rows using the index of parent cell and fetch all the values of that index
	 * Identify index of target_row
	 * Identify index of target_column
	 * Fetch required cell value and return the value
	 * 
	 **** 
	 * @Creator Avik Guha
	 **/
	
	@SuppressWarnings({ "resource", "deprecation" })
	public String fetch_data_from_excel(String excel_name_with_extension, String sheet_name, String parent_cell, String target_row, String target_column)
			throws Exception {

		ArrayList<String> column_header = new ArrayList<String>();
		ArrayList<String> row_header = new ArrayList<String>();
		
		String cellValue = null;

		String folderPath = "src//test//resources//TestData//"; // keep excel in this folder path
		String element_Image = System.getProperty("user.dir") + File.separator + folderPath + excel_name_with_extension;

		File file = new File(element_Image);
		FileInputStream fis = new FileInputStream(file); // this contains raw data from the excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // creating workbook

		Integer sheets = workbook.getNumberOfSheets(); // gives count of total number of sheets

		for (Integer i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheet_name)) {
				XSSFSheet sheet = workbook.getSheetAt(i); // getting the sheet from workbook

				// identify required column by scanning the entire 1st row
				Iterator<Row> rows = sheet.iterator(); // sheet is collection of rows
				Row firstRow = rows.next();
				Iterator<Cell> cell = firstRow.cellIterator(); // row is collection of cells

				Integer column;

				while (cell.hasNext()) {
					Cell cellElement = cell.next();

					if (cellElement.getCellTypeEnum() == CellType.STRING) {
						column_header.add(cellElement.getStringCellValue());
					} else {
						column_header.add(NumberToTextConverter.toText(cellElement.getNumericCellValue()));
					}
				}

				column = column_header.indexOf(parent_cell);

				Iterator<Row> rows2 = sheet.iterator();

				while (rows2.hasNext()) {
					Row r = rows2.next();
					if (r.getCell(column).getCellTypeEnum() == CellType.STRING) {
						row_header.add(r.getCell(column).getStringCellValue());
					} else {
						row_header.add(NumberToTextConverter.toText(r.getCell(column).getNumericCellValue()));
					}
				}

				Integer row_index = row_header.indexOf(target_row);
				Integer column_index = column_header.indexOf(target_column);

				if (sheet.getRow(row_index).getCell(column_index).getCellTypeEnum() == CellType.STRING) {
					cellValue = sheet.getRow(row_index).getCell(column_index).getStringCellValue();
				} else {
					cellValue = NumberToTextConverter
							.toText(sheet.getRow(row_index).getCell(column_index).getNumericCellValue());
				}
			}
		}
		return cellValue;
	}

}
