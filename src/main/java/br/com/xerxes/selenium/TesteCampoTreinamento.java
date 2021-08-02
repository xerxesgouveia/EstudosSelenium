package br.com.xerxes.selenium;

import java.awt.TextField;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);

	}
	
	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void testeTextField() {

		dsl.escreve("elementosForm:nome", "Xerxes");
		Assert.assertEquals("Xerxes", dsl.pegaAtributoCampo("elementosForm:nome", "value"));
		
	}

	@Test
	public void testeTextArea() {
		
		dsl.escreve("elementosForm:sugestoes", "É muito lindo!");
		Assert.assertEquals("É muito lindo!", dsl.pegaAtributoCampo("elementosForm:sugestoes", "value"));
		
	}

	@Test
	public void testeRadioButton() {
		dsl.clicar("elementosForm:sexo:0");
		Assert.assertTrue(dsl.checaEstaSelecionado("elementosForm:sexo:0"));
		
	}

	@Test
	public void testeCheckBox() {

		dsl.clicar("elementosForm:comidaFavorita:0");
		Assert.assertTrue(dsl.checaEstaSelecionado("elementosForm:comidaFavorita:0"));
		
	}

	@Test
	public void testeComboBox() {
		dsl.selecionarComboBox("elementosForm:escolaridade", "Superior");
		Assert.assertEquals("Superior", dsl.pegaCampoSelecionadoCombo("elementosForm:escolaridade"));
		
	}

	@Test
	public void testeComboBoxMultiplaEscolha() {

		dsl.selecionarComboBox("elementosForm:esportes", "Natacao");
		dsl.selecionarComboBox("elementosForm:esportes", "Corrida");
		Assert.assertEquals(2, dsl.checaQuantidadeElementosMarcados("elementosForm:esportes"));
		
	}

	@Test
	public void testeButton() {

		dsl.clicar("buttonSimple");
		Assert.assertEquals("Obrigado!", dsl.pegaAtributoCampo("buttonSimple", "value"));
		
	}

	@Test
	public void testeLink() {

		WebElement element = driver.findElement(By.linkText("Voltar"));
		element.click();
		//dsl.clicar(idCampo);

		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
	}

	@Test
	public void testeDiv() {

		WebElement element = driver.findElement(By.tagName("h3"));
		// Assert.assertTrue(element.getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", element.getText());

	}

	@Test
	public void testeSpam() {

		WebElement element = driver.findElement(By.className("facilAchar"));
		// Assert.assertTrue(element.getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", element.getText());

	}

	@Test
	public void testeAlertSimples() {

		WebElement element = driver.findElement(By.id("alert"));
		element.click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Alert Simples", alert.getText());
		alert.accept();
	}

	@Test
	public void testeAlertConfirmOK() {

		WebElement element = driver.findElement(By.id("confirm"));
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();
	}

	@Test
	public void testeAlertConfirmCancelar() {

		WebElement element = driver.findElement(By.id("confirm"));
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		alert.accept();
	}

	@Test
	public void testeAlertPrompt() {

		WebElement element = driver.findElement(By.id("prompt"));
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("15");
		alert.accept();
		Assert.assertEquals("Era 15?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
	}

}
