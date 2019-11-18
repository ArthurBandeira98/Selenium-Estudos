package Z_TesteComExcel;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfigInserindoValoresNaPaginaViaExcel {

	private XSSFWorkbook wb;
	private XSSFSheet sheet;

	public ExcelConfigInserindoValoresNaPaginaViaExcel(String excelPath) {
		try {
			FileInputStream fis = new FileInputStream(excelPath);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String readData(int row, int column, String aba) {

		sheet = wb.getSheet(aba);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

}
