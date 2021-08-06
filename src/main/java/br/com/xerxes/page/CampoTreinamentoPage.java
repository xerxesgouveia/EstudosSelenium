package br.com.xerxes.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import br.com.xerxes.selenium.DSL;

public class CampoTreinamentoPage {
	
	private DSL dsl;
	
	public CampoTreinamentoPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void setName(String name) {
		dsl.escreve("elementosForm:nome", name);
	}
	
	public String getNameField() {
		return dsl.pegaAtributoCampo("elementosForm:nome","value");
	}
	
	public void setLastName(String lastName) {
		dsl.escreve("elementosForm:sobrenome", lastName);
	}
	
	public void setSugestoes(String sugestao) {
		dsl.escreve("elementosForm:sugestoes", sugestao);
	}
	
	public String getSugestoes() {
		return dsl.pegaAtributoCampo("elementosForm:sugestoes","value");
	}
	
	public void clickRadioButtonMale() {
		dsl.clicar("elementosForm:sexo:0");
	}
	
	public boolean getRadioButtonSelectedMale() {
		return dsl.checaEstaSelecionado("elementosForm:sexo:0");
	}
	
	public boolean getCheackBoxMeat() {
		return dsl.checaEstaSelecionado("elementosForm:comidaFavorita:0");
	}
	
	public void clickCheckBoxMeat() {
		dsl.clicar("elementosForm:comidaFavorita:0");
	}
	
	public void comboScholaritySetValue(String value) {
		dsl.selecionarComboBox("elementosForm:escolaridade", value);
	}
	
	public String comboScholarityGetSelectedValue() {
		return dsl.pegaCampoSelecionadoCombo("elementosForm:escolaridade");
	}
	
	public void comboSportsSetValue(String value) {
		dsl.selecionarComboBox("elementosForm:esportes", value);
	}
	
	public int comboSportsCheckQuantity() {
		return dsl.checaQuantidadeElementosMarcados("elementosForm:esportes");
	}
	
	public void clickSubmit() {
		dsl.clicar("elementosForm:cadastrar");
	}
	
	public void clickButtonSimple() {
		dsl.clicar("buttonSimple");
	}
	
	public String getButtonValue() {
		return dsl.pegaAtributoCampo("buttonSimple", "value");
	}
	
	public void clickBack() {
		dsl.findElementByLinkText("Voltar").click();
	}
	
	public String getTextDiv() {
		return dsl.findElementByTagName("h3").getText();
	}
	
	public String getTextSpam() {
		return dsl.findElementByClassName("facilAchar").getText();
	}
	
	public String getTextAlert() {
		return dsl.alertGetText("alert");
	}
	
	public String getTextAlertConfirmOK() {
		return dsl.alertGetTextWithConfirm("confirm");
	}
	
	public String getTextAlertConfirmAndCancel() {
		return dsl.alertGetTextWithDismiss("confirm");
	}
	
	public Alert testAlertPrompt(String value) {
		return dsl.alertSetText("prompt", value);
	}
	
	public String getResult() {
		return dsl.obterTexto("resultado");
	}
	
	public String getName() {
		return dsl.obterTexto("descNome");
	}
	
	public String getLastName() {
		return dsl.obterTexto("descSobrenome");
	}
	
	public String getGender() {
		return dsl.obterTexto("descSexo");
	}
	
	public String getMeal() {
		return dsl.obterTexto("descComida");
	}
	
	public String getScholarity() {
		return dsl.obterTexto("descEscolaridade");
	}
	
	public String getSports() {
		return dsl.obterTexto("descEsportes");
	}
	
	public void apagaNome() {
		dsl.apaga("elementosForm:nome");
	}
	

}
