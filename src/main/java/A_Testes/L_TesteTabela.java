package A_Testes;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class L_TesteTabela {

	private WebDriver firefox;
	private H_TesteDSL dsl;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");
		firefox = new FirefoxDriver();
		firefox.get("file:///C:/Users/arthur.antonio/Downloads/campo-treinamento/componentes.html");
	}

	@Test
	public void teste() {

	}

}
