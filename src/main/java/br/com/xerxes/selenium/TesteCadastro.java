package br.com.xerxes.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.xerxes.page.CampoTreinamentoPage;

public class TesteCadastro {
	
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
	public void testCadastro() {
		
		
		// Preenchimento dos campos
		
		campoTreinamentoPage.setName("Xerxes");
		campoTreinamentoPage.setLastName("Gouveia");
		campoTreinamentoPage.clickRadioButtonMale();
		campoTreinamentoPage.clickCheckBoxMeat();
		campoTreinamentoPage.comboScholaritySetValue("Superior");
		campoTreinamentoPage.comboSportsSetValue("Natacao");
		campoTreinamentoPage.comboSportsSetValue("Corrida");
		campoTreinamentoPage.clickSubmit();
		
		// Execução dos testes
		
		Assert.assertTrue(campoTreinamentoPage.getResult().contains("Cadastrado!"));
		Assert.assertEquals("Nome: Xerxes", campoTreinamentoPage.getName());
		Assert.assertEquals("Sobrenome: Gouveia", campoTreinamentoPage.getLastName());
		Assert.assertEquals("Sexo: Masculino", campoTreinamentoPage.getGender());
		Assert.assertEquals("Comida: Carne", campoTreinamentoPage.getMeal());
		Assert.assertEquals("Escolaridade: superior", campoTreinamentoPage.getScholarity());
		Assert.assertEquals("Esportes: Natacao Corrida", campoTreinamentoPage.getSports());
	
	}

}
