package A_Testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class G_TesteOrganizado {

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
	public void testeCadastroNome() {
		dsl.escreve("elementosForm:nome", "Arthur");
		dsl.escreve("elementosForm:sobrenome", "Bandeira");
	}

	@Test
	public void testeRadioButtons() {
		dsl.botaoRadio("elementosForm:sexo:0");
		dsl.botaoRadio("elementosForm:comidaFavorita:0");
	}

	@Test
	public void testeComboSimples() {
		dsl.comboSimples("elementosForm:escolaridade", "Superior");
		dsl.obterValorCombo("elementosForm:escolaridade");
	}

	@Test
	public void testeComboVarios() {
		dsl.comboVarios("elementosForm:esportes", "Futebol");
		dsl.comboVarios("elementosForm:esportes", "Natacao");
		dsl.comboVarios("elementosForm:esportes", "Karate");
	}

	@After
	public void finaliza() {

		firefox.quit();
	}

}
