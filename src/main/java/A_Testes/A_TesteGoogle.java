package A_Testes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class A_TesteGoogle {

	@Test
	public void teste() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		// maximiza a tela do firefox
		driver.manage().window().maximize();

		// abre o google
		driver.get("https://www.google.com");

		// transforma em teste a requisição abaixo
		Assert.assertEquals("Google", driver.getTitle());

		// Fecha o driver
		driver.close();

		// fecha todas as instancias do gecko
		driver.quit();

	}

}
