package Z_TesteComExcel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.xml.internal.fastinfoset.sax.Properties;

public class InserindoValorDaPaginaNoExcel {

	WebDriver driver;
	Properties pop;

	@Before
	public void testeExcel() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("file://C:/Users//arthur.antonio//Downloads//campo-treinamento//componentes.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void testando() throws IOException {

		ExcelConfigSetandoValoresDaPaginaNoExcel excel = new ExcelConfigSetandoValoresDaPaginaNoExcel(
				"C://Projetos//amplis//SeleniumWebD//src//main//java//Z_TesteComExcel//teste.xlsx");
		String valores = driver.findElement(By.xpath("//*[@id=\"elementosForm\"]/table/tbody/tr[4]/td[1]/label"))
				.getText();
		excel.read(valores, "Sheet",
				"C://Projetos//amplis//SeleniumWebD//src//main//java//Z_TesteComExcel//teste.xlsx");

	}

}
