package GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelFileUtility {
	
	public String toGetDataFromExcelSheet(String sheetName, int row, int cell)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(row).getCell(cell).toString();
		return value;
	}

	/*
	 * 
	 */
	public int toGetLastRowCount(String sheetName) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int value = wb.getSheet(sheetName).getLastRowNum();
		return value;
	}
	
	/*
	 * 
	 */
	public String toReturnDatatoExcel(String sheetName, int row, int cell, Date data ) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).createRow(row).createCell(cell, CellType.STRING).setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/testData.xlsx");
		wb.write(fos);
		return sheetName;
		
	}

}
