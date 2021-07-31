package br.com.xerxes.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class TesteRegrasNegocio {
	
	WebDriver driver;
	
	@Test
	public void testRegraNome() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		// Teste da regra de neg�cio
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		alert.accept();
		driver.quit();
		
		
	}
	
	@Test
	public void testRegraSobreNome() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		// Teste da regra de neg�cio
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Xerxes");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		alert.accept();
		driver.quit();
		
		
	}
	
	@Test
	public void testRegraSexo() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		// Teste da regra de neg�cio
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Xerxes");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gouveia");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		alert.accept();
		driver.quit();
		
		
	}
	
	@Test
	public void testRegraAlimento() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		// Teste da regra de neg�cio
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Xerxes");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gouveia");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		alert.accept();
		driver.quit();
		
		
	}
	
	@Test
	public void testRegraEsporte() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		// Teste da regra de neg�cio
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Xerxes");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gouveia");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("O que eh esporte?");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		alert.accept();
		driver.quit();
		
		
	}

}
