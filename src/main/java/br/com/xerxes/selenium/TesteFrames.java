package br.com.xerxes.selenium;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TesteFrames {
	
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
	public void testFrame() {
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		alert.accept();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		Assert.assertEquals("Frame OK!", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
	}

}
