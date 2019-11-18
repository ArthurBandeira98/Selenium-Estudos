package A_Testes;

import org.openqa.selenium.WebDriver;

public class I_CampoTreinamentoPage {

	private H_TesteDSL dsl;

	public I_CampoTreinamentoPage(WebDriver firefox) {
		dsl = new H_TesteDSL(firefox);
	}

	public void setNome(String nome) {
		dsl.escreve("elementosForm:nome", nome);
	}

	public void setSobrenome(String sobrenome) {
		dsl.escreve("elementosForm:sobrenome", sobrenome);
	}

	public void setSexoMasculino() {
		dsl.botaoRadio("elementosForm:sexo:0");
	}

	public void setSexoFeminino() {
		dsl.botaoRadio("elementosForm:sexo:1");
	}

	public void setComidaFavoritaCarne() {
		dsl.botaoRadio("elementosForm:comidaFavorita:0");
	}

	public void setComidaFavoritaFrango() {
		dsl.botaoRadio("elementosForm:comidaFavorita:1");
	}

	public void setComidaFavoritaPizza() {
		dsl.botaoRadio("elementosForm:comidaFavorita:2");
	}

	public void setEscolaridade(String ensino) {
		dsl.comboSimples("elementosForm:escolaridade", ensino);
	}

	public void setEsportes(String esportes) {
		dsl.comboVarios("elementosForm:esportes", esportes);
	}

	public void cadastrado() {
		dsl.botaoClick("elementosForm:cadastrar");
	}

	public String setResultado() {
		return dsl.obterValorCampo("/html/body/center/div[2]/span");
	}

}
