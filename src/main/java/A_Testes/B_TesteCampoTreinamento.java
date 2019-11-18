package A_Testes;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class B_TesteCampoTreinamento {

	// executando javascript
	// WebDriver driver;

	// @Test
	// public void testJavaScript() {
	//
	//
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// js.executeScript("alert('Testando js via java script')");
	// js.executeScript("document.getELementById('elementForm:nome').value='Escrito
	// via JAVASCRIPT'");
	// }

	@Test
	public void testeField() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");

		WebDriver firefox = new FirefoxDriver();

		firefox.get("file:///C:/Users/arthur.antonio/Downloads/campo-treinamento/componentes.html");

		firefox.manage().window().maximize();
		// preeche o campo
		firefox.findElement(By.id("elementosForm:nome")).sendKeys("Arthur");
		firefox.findElement(By.id("elementosForm:sobrenome")).sendKeys("Bandeira");
		// pega o valor do campo e valida o teste
		Assert.assertEquals("Arthur", firefox.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		Assert.assertEquals("Bandeira", firefox.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));

		firefox.quit();

	}

	@Test
	public void testeRadioButton() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");

		WebDriver firefox = new FirefoxDriver();

		firefox.get("file:///C:/Users/arthur.antonio/Downloads/campo-treinamento/componentes.html");

		firefox.manage().window().maximize();

		// elemento button
		firefox.findElement(By.id("elementosForm:sexo:0")).click();
		// chegagem se está selecionado
		Assert.assertTrue(firefox.findElement(By.id("elementosForm:sexo:0")).isSelected());

		firefox.quit();
	}

	@Test
	public void testeComboSimples() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");

		WebDriver firefox = new FirefoxDriver();

		firefox.get("file:///C:/Users/arthur.antonio/Downloads/campo-treinamento/componentes.html");

		firefox.manage().window().maximize();

		// seleciona um elemento da lista combo box
		WebElement elemento = firefox.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(elemento);
		// seleciona pelo codigo
		// combo.selectByIndex(4);

		// seleciona pelo value do elemento
		// combo.selectByValue("Superior");

		// Seleciona pelo texto visivel
		combo.selectByVisibleText("Superior");
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());

		firefox.quit();

	}

	@Test
	public void testeVerificaValoresComboSimples() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");

		WebDriver firefox = new FirefoxDriver();

		firefox.get("file:///C:/Users/arthur.antonio/Downloads/campo-treinamento/componentes.html");

		firefox.manage().window().maximize();

		// seleciona um elemento da lista combo box
		WebElement elemento = firefox.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(elemento);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());

		boolean encontrou = false;

		for (WebElement option : options) {
			if (option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);

		firefox.quit();

	}

	@Test
	public void testeComboVarios() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");

		WebDriver firefox = new FirefoxDriver();

		firefox.get("file:///C:/Users/arthur.antonio/Downloads/campo-treinamento/componentes.html");

		firefox.manage().window().maximize();

		// seleciona um elemento da lista combo box
		WebElement elemento = firefox.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(elemento);
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Futebol");
		combo.selectByVisibleText("Karate");

		// Desmarcar alguma coisa
		combo.deselectByVisibleText("Corrida");

		// Valida a quantidade de elementos marcados, se é true ou false
		List<WebElement> allSelectedOptios = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptios.size());

		firefox.quit();

	}

	@Test
	public void testeInteragirLinks() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");

		WebDriver firefox = new FirefoxDriver();

		firefox.get("file:///C:/Users/arthur.antonio/Downloads/campo-treinamento/componentes.html");

		// Clica em um link que na maioria das vezes não possui elemento
		firefox.findElement(By.linkText("Voltar")).click();

		Assert.assertEquals("Voltou!", firefox.findElement(By.id("resultado")).getText());

		firefox.quit();

	}

	@Test
	public void testeBuscarTextoPagina() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");

		WebDriver firefox = new FirefoxDriver();

		firefox.get("file:///C:/Users/arthur.antonio/Downloads/campo-treinamento/componentes.html");
		// pega todo o texto da pagina pelo BODY
		// System.out.println(firefox.findElement(By.tagName("body")).getText());

		// Verifica se o BODY contem o texto q eu especifiquei
		// Assert.assertTrue(firefox.findElement(By.tagName("body")).getText().contains("Campo
		// de Treinamento"));

		// Busca o texto em um campo especifico
		Assert.assertEquals("Campo de Treinamento", firefox.findElement(By.tagName("h3")).getText());

		firefox.quit();

	}

}
