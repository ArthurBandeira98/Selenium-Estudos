package A_Testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class D_CadastroFormulario {

	private WebDriver firefox;
	private H_TesteDSL dsl;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");
		firefox = new FirefoxDriver();
		firefox.get("file:///C:/Users/arthur.antonio/Downloads/campo-treinamento/componentes.html");

		dsl = new H_TesteDSL(firefox);
	}

	@Test
	public void testeCadastroFormulario() {
		dsl.escreve("elementosForm:nome", "Arthur");
		dsl.escreve("elementosForm:sobrenome", "Bandeira");

		dsl.botaoRadio("elementosForm:sexo:0");

		dsl.botaoRadio("elementosForm:comidaFavorita:0");

		dsl.comboSimples("elementosForm:escolaridade", "Superior");

		dsl.comboVarios("elementosForm:esportes", "Futebol");
		dsl.comboVarios("elementosForm:esportes", "Karate");
		dsl.comboVarios("elementosForm:esportes", "Natacao");

		dsl.botaoClick("elementosForm:cadastrar");

	}

	@After
	public void finaliza() {
		Assert.assertEquals("Cadastrado!", dsl.obterValorCampo("/html/body/center/div[2]/span"));

		firefox.quit();
	}

}
