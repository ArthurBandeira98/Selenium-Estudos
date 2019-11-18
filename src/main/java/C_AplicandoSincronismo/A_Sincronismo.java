package C_AplicandoSincronismo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import A_Testes.H_TesteDSL;

public class A_Sincronismo {

	private WebDriver firefox;
	private H_TesteDSL dsl;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");
		firefox = new FirefoxDriver();
		firefox.get("file://C://Users//arthur.antonio//Downloads//campo-treinamento//componentes.html");

		dsl = new H_TesteDSL(firefox);
	}

	@Test
	public void testeEsperaFixa() throws InterruptedException {

		dsl.botaoClick("buttonDelay");
		Thread.sleep(5000);
		dsl.escreve("novoCampo", "teste");

	}

	@Test
	public void testeEsperaImplicita() {
		firefox.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dsl.botaoClick("buttonDelay");
		dsl.escreve("novoCampo", "teste");
		firefox.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	@Test
	public void testeEsperaExplicita() {
		dsl.botaoClick("buttonDelay");
		WebDriverWait wait = new WebDriverWait(firefox, 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("novoCampo")));
		dsl.escreve("novoCampo", "teste");
	}

	@After
	public void finaliza() throws IOException {
		firefox.quit();
	}

}
