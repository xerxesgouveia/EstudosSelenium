package br.com.xerxes.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.xerxes.page.CampoTreinamentoPage;

public class TesteCampoTreinamento {

	WebDriver driver;
	CampoTreinamentoPage campoTreinamentoPage;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		campoTreinamentoPage = new CampoTreinamentoPage(driver);

	}
	
	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void testeTextField() {

		campoTreinamentoPage.setName("Xerxes");
		Assert.assertEquals("Xerxes", campoTreinamentoPage.getNameField());
		
	}
	
	@Test
	public void testeTextField2() {
		
		campoTreinamentoPage.setName("Xerxes");
		campoTreinamentoPage.apagaNome();
		campoTreinamentoPage.setName("Falcão");

		Assert.assertEquals("Falcão", campoTreinamentoPage.getNameField());
		
	}


	@Test
	public void testeTextArea() {
		
		campoTreinamentoPage.setSugestoes("É muito lindo!");
		Assert.assertEquals("É muito lindo!", campoTreinamentoPage.getSugestoes());
		
	}

	@Test
	public void testeRadioButton() {
		
		campoTreinamentoPage.clickRadioButtonMale();
		Assert.assertTrue(campoTreinamentoPage.getRadioButtonSelectedMale());
		
	}

	@Test
	public void testeCheckBox() {

		campoTreinamentoPage.clickCheckBoxMeat();
		Assert.assertTrue(campoTreinamentoPage.getCheackBoxMeat());
		
	}

	@Test
	public void testeComboBox() {
		campoTreinamentoPage.comboScholaritySetValue("Superior");
		Assert.assertEquals("Superior", campoTreinamentoPage.comboScholarityGetSelectedValue());
		
	}

	@Test
	public void testeComboBoxMultiplaEscolha() {

		campoTreinamentoPage.comboSportsSetValue("Natacao");
		campoTreinamentoPage.comboSportsSetValue("Corrida");
		Assert.assertEquals(2, campoTreinamentoPage.comboSportsCheckQuantity());
		
	}

	@Test
	public void testeButton() {
		
		campoTreinamentoPage.clickButtonSimple();
		Assert.assertEquals("Obrigado!", campoTreinamentoPage.getButtonValue());
		
	}

	@Test
	public void testeLink() {
		campoTreinamentoPage.clickBack();
		Assert.assertEquals("Voltou!", campoTreinamentoPage.getResult());
	}

	@Test
	public void testeDiv() {

		Assert.assertEquals("Campo de Treinamento", campoTreinamentoPage.getTextDiv());

	}

	@Test
	public void testeSpam() {

		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", campoTreinamentoPage.getTextSpam());

	}

	@Test
	public void testeAlertSimples() {

		Assert.assertEquals("Alert Simples", campoTreinamentoPage.getTextAlert());

	}

	@Test
	public void testeAlertConfirmOK() {

		Assert.assertEquals("Confirmado", campoTreinamentoPage.getTextAlertConfirmOK());
		
	}

	@Test
	public void testeAlertConfirmCancelar() {

		Assert.assertEquals("Negado", campoTreinamentoPage.getTextAlertConfirmAndCancel());

	}

	@Test
	public void testeAlertPrompt() {

		Alert alert = campoTreinamentoPage.testAlertPrompt("15");
		Assert.assertEquals("Era 15?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
	}

}
