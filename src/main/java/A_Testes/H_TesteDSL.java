package A_Testes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class H_TesteDSL {

	// ações de componentes que podem ser usados muitas vezes
	private WebDriver firefox;

	public H_TesteDSL(WebDriver firefox) {
		super();
		this.firefox = firefox;
	}

	public void escreve(String id_campo, String texto_campo) {
		firefox.findElement(By.id(id_campo)).sendKeys(texto_campo);
	}

	public void botaoRadio(String id_campo) {
		firefox.findElement(By.id(id_campo)).click();
	}

	public void comboSimples(String id_campo, String texto_visivel) {
		WebElement elemento = firefox.findElement(By.id(id_campo));
		Select combo = new Select(elemento);
		combo.selectByVisibleText(texto_visivel);
	}

	public String obterValorCombo(String id_campo) {
		WebElement elemento = firefox.findElement(By.id(id_campo));
		Select combo = new Select(elemento);
		return combo.getFirstSelectedOption().getText();
	}

	public void comboVarios(String id_campo, String texto_visivel) {
		WebElement elemento = firefox.findElement(By.id(id_campo));
		Select combo = new Select(elemento);
		combo.selectByVisibleText(texto_visivel);
	}

	public void botaoClick(String id_campo) {
		firefox.findElement(By.id(id_campo)).click();
	}

	public String obterValorCampo(String xpath) {
		return firefox.findElement(By.xpath(xpath)).getText();
	}

	/************** Tabela *****************/

	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao) {
		// procurar coluna do registro
		WebElement tabela = firefox.findElement(By.xpath("//*[@id=\"elementosForm:tableUsuarios\"]"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		// encontrar a linha do registro

		// procurar coluna do botao

		// clicar na celula do botao

	}

	private int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath("./thead/tr"));
		int idColuna = -1;
		for (int i = 0; i < colunas.size(); i++) {
			if (colunas.get(i).getText().equals(coluna)) {
				idColuna = i + 1;
				break;
			}
		}
		return idColuna;
	}

}
