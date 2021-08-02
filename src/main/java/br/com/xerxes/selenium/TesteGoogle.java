package br.com.xerxes.selenium;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TesteGoogle {
	
	WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");

	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void TesteTitulo() {
	
		Assert.assertEquals("Google", driver.getTitle());
	
	}

}
