package Z_TesteComExcel;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.xml.internal.fastinfoset.sax.Properties;

public class InserindoValoresNaPaginaViaExcel {

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
	public void teste() throws InterruptedException {

		ExcelConfigInserindoValoresNaPaginaViaExcel excel = new ExcelConfigInserindoValoresNaPaginaViaExcel(
				"C://Projetos//amplis//SeleniumWebD//src//main//java//Z_TesteComExcel//teste.xlsx");

		driver.findElement(By.id("elementosForm:nome")).sendKeys(excel.readData(1, 0, "Sheet"));
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys(excel.readData(1, 1, "Sheet"));

	}

	@After
	public void closeTest() {
		// driver.quit();
	}

}
