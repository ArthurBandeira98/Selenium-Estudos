package A_Testes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C_TesteAlert {

	@Test
	public void testeAlertSimples() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");
		WebDriver firefox = new FirefoxDriver();
		firefox.get("file:///C:/Users/arthur.antonio/Downloads/campo-treinamento/componentes.html");

		// Clicando no alert
		firefox.findElement(By.xpath("//*[@id=\"alert\"]")).click();
		// pegando o texto do alert
		Alert alert = firefox.switchTo().alert();
		Assert.assertEquals("Alert Simples", alert.getText());
		String texto = alert.getText();
		alert.accept();

		firefox.findElement(By.xpath("//*[@id=\"elementosForm:nome\"]")).sendKeys(texto);
		Assert.assertEquals("Alert Simples", texto);

		firefox.quit();
	}

	@Test
	public void testeAlertConfirm() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");
		WebDriver firefox = new FirefoxDriver();
		firefox.get("file:///C:/Users/arthur.antonio/Downloads/campo-treinamento/componentes.html");

		firefox.findElement(By.id("confirm")).click();
		Alert alerta = firefox.switchTo().alert();
		String texto = alerta.getText();
		Assert.assertEquals("Confirm Simples", texto);
		alerta.accept();
		// cancela o alerta
		// alerta.dismiss();
		String texto2 = alerta.getText();
		Assert.assertEquals("Confirmado", texto2);
		alerta.accept();

		firefox.quit();

	}

	@Test
	public void testePrompt() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");
		WebDriver firefox = new FirefoxDriver();
		firefox.get("file:///C:/Users/arthur.antonio/Downloads/campo-treinamento/componentes.html");

		firefox.findElement(By.id("prompt")).click();
		Alert alerta = firefox.switchTo().alert();
		Assert.assertEquals("Digite um numero", alerta.getText());
		alerta.sendKeys("123456");
		alerta.accept();
		alerta.accept();
		alerta.accept();

		firefox.quit();

	}
}
