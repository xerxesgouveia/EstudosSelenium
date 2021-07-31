package br.com.xerxes.selenium;

import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TesteFrames {
	
	@Test
	public void testFrame() {
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new InternetExplorerDriver();
		//driver.manage().window().setSize(new Dimension(1200, 765));
		driver.manage().window().maximize();
		//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
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
