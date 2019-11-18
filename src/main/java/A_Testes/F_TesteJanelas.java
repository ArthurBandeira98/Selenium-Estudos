package A_Testes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class F_TesteJanelas {

	@Test
	public void testeJanela() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");
		WebDriver firefox = new FirefoxDriver();
		firefox.get("file:///C:/Users/arthur.antonio/Downloads/campo-treinamento/componentes.html");

		firefox.findElement(By.id("buttonPopUpEasy")).click();
		firefox.switchTo().window("Popup");
		firefox.findElement(By.tagName("textarea")).sendKeys("Teste");
		firefox.close();
		firefox.switchTo().window("");
		firefox.findElement(By.tagName("textarea")).sendKeys("Teste");
		String texto = firefox.findElement(By.id("elementosForm:sugestoes")).getText();
		Assert.assertEquals("Teste", texto);

	}

}
