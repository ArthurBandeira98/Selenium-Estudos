package A_Testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class J_CadastroComPageObject {

	private WebDriver firefox;
	private H_TesteDSL dsl;
	private I_CampoTreinamentoPage page;

	// @Parameter(value = 0)
	private String nome;

	// @Parameter(value = 1)
	private String sobrenome;

	// @Parameter(value = 2)
	private String sexo;

	// @Parameter(value = 3)
	private String comidaFavorita;

	// @Parameter(value = 4)
	private String esportes;

	// @Parameter(value = 5)
	private String ensino;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");
		firefox = new FirefoxDriver();
		firefox.get("file:///C:/Users/arthur.antonio/Downloads/campo-treinamento/componentes.html");

		dsl = new H_TesteDSL(firefox);
		page = new I_CampoTreinamentoPage(firefox);
	}

	// // cenarios de teste pelos parametros colocados nas variaveis
	// @Parameters
	// public static Collection<Object[]> getCollection() {
	// return Arrays.asList(new Object[][] {
	// {"", "", "", new ArrayList(), new String[] {}, }, {}
	//
	// });
	// }

	@Test
	public void testeCadastroFormulario() {
		page.setNome(nome);
		page.setSobrenome(sobrenome);
		if (sexo.equals("Masculino")) {
			page.setSexoMasculino();
		} else {
			page.setSexoFeminino();
		}
		if (comidaFavorita.equals("Carne")) {
			page.setComidaFavoritaCarne();
		}
		if (comidaFavorita.equals("Frango")) {
			page.setComidaFavoritaFrango();
		}
		if (comidaFavorita.equals("Pizza")) {
			page.setComidaFavoritaPizza();
		}
		page.setEscolaridade(ensino);
		page.setEsportes(esportes);

		page.cadastrado();

	}

	@After
	public void finaliza() {

		Assert.assertTrue(page.setResultado().startsWith("Cadastrado!"));

		firefox.quit();
	}

}
