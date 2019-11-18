package A_Testes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class E_TesteFrames {

	@Test
	public void testeInteragirComFrames() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\arthur.antonio\\Desktop\\Gecko_Driver\\geckodriver.exe");
		WebDriver firefox = new FirefoxDriver();
		firefox.get("file:///C:/Users/arthur.antonio/Downloads/campo-treinamento/componentes.html");

		firefox.switchTo().frame("frame1");
		firefox.findElement(By.id("frameButton")).click();
		Alert alerta = firefox.switchTo().alert();
		Assert.assertEquals("Frame OK!", alerta.getText());
		alerta.accept();

		firefox.quit();

	}

}
