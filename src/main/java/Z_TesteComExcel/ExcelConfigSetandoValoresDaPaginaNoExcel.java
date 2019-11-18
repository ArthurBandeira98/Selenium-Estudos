package Z_TesteComExcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfigSetandoValoresDaPaginaNoExcel {

	private XSSFWorkbook wb;
	private XSSFSheet sheet;

	public ExcelConfigSetandoValoresDaPaginaNoExcel(String excelPath) {
		try {
			FileInputStream fis = new FileInputStream(excelPath);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void read(String valor, String aba, String path) throws IOException {
		sheet = wb.getSheet(aba);
		XSSFRow rowT = sheet.createRow(2);
		XSSFCell cellT = rowT.createCell(0);
		cellT.setCellValue(valor);
		FileOutputStream out = new FileOutputStream(path);
		wb.write(out);
		out.close();

	}

}
