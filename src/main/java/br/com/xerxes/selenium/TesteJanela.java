package br.com.xerxes.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteJanela {
	
	@Test
	public void testJanela() {
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new InternetExplorerDriver();
		//driver.manage().window().setSize(new Dimension(1200, 765));
		driver.manage().window().maximize();
		//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Teste janela");
		String texto = driver.findElement(By.tagName("textarea")).getAttribute("value");
		
		driver.close();
		driver.switchTo().window("");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(texto);
		Assert.assertEquals("Teste janela", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
		
	}
	
	@Test
	public void testJanela2() {
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new InternetExplorerDriver();
		//driver.manage().window().setSize(new Dimension(1200, 765));
		driver.manage().window().maximize();
		//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		
		driver.findElement(By.id("buttonPopUpHard")).click();
		//driver.getWindowHandle();
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Teste janela");
		String texto = driver.findElement(By.tagName("textarea")).getAttribute("value");
		
		driver.close();
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(texto);
		Assert.assertEquals("Teste janela", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
		
	}

}
