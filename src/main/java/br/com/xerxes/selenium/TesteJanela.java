package br.com.xerxes.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteJanela {
	
	WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void testJanela() {

		
		
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Teste janela");
		String texto = driver.findElement(By.tagName("textarea")).getAttribute("value");
		
		driver.close();
		driver.switchTo().window("");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(texto);
		Assert.assertEquals("Teste janela", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

		
	}
	
	@Test
	public void testJanela2() {

			
		driver.findElement(By.id("buttonPopUpHard")).click();
		//driver.getWindowHandle();
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Teste janela");
		String texto = driver.findElement(By.tagName("textarea")).getAttribute("value");
		
		driver.close();
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(texto);
		Assert.assertEquals("Teste janela", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

		
	}

}
