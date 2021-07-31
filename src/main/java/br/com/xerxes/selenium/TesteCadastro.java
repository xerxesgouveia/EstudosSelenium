package br.com.xerxes.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
	
	WebDriver driver;
	WebElement element;
	Select combo;
	
	@Test
	public void testCadastro() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		// Preenchimento dos campos
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Xerxes");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gouveia");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		element = driver.findElement(By.id("elementosForm:escolaridade"));
		combo = new Select(element);
		combo.selectByVisibleText("Superior");
		element = driver.findElement(By.id("elementosForm:esportes"));
		combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		
		element = driver.findElement(By.id("elementosForm:cadastrar"));
		element.click();
		
		// Execução dos testes
		
		element = driver.findElement(By.id("resultado"));
		Assert.assertTrue(element.getText().contains("Cadastrado!"));
		element = driver.findElement(By.id("descNome"));
		Assert.assertEquals("Nome: Xerxes", element.getText());
		element = driver.findElement(By.id("descSobrenome"));
		Assert.assertEquals("Sobrenome: Gouveia", element.getText());
		element = driver.findElement(By.id("descSexo"));
		Assert.assertEquals("Sexo: Masculino", element.getText());
		element = driver.findElement(By.id("descComida"));
		Assert.assertEquals("Comida: Carne", element.getText());
		element = driver.findElement(By.id("descEscolaridade"));
		Assert.assertEquals("Escolaridade: superior", element.getText());
		element = driver.findElement(By.id("descEsportes"));
		Assert.assertEquals("Esportes: Natacao Corrida", element.getText());
		
		driver.quit();
		
		
	}

}
