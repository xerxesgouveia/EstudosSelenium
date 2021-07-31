package br.com.xerxes.selenium;
import java.awt.TextField;
import java.util.List;

import org.junit.Assert;
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
	
	@Test
	public void testeTextField() {
		//System.setProperty("webdriver.gecko.driver", "C://Drivers/");
				//WebDriver driver = new FirefoxDriver();
				WebDriver driver = new ChromeDriver();
				//WebDriver driver = new InternetExplorerDriver();
				//driver.manage().window().setSize(new Dimension(1200, 765));
				driver.manage().window().maximize();
				//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
				driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				driver.findElement(By.id("elementosForm:nome")).sendKeys("Xerxes");;
				Assert.assertEquals("Xerxes", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
				driver.quit();
	}
	
	@Test
	public void testeTextArea() {
		//System.setProperty("webdriver.gecko.driver", "C://Drivers/");
				//WebDriver driver = new FirefoxDriver();
				WebDriver driver = new ChromeDriver();
				//WebDriver driver = new InternetExplorerDriver();
				//driver.manage().window().setSize(new Dimension(1200, 765));
				driver.manage().window().maximize();
				//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
				driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("É muito lindo!");;
				Assert.assertEquals("É muito lindo!", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
				driver.quit();
				
	}
	
	@Test
	public void testeRadioButton() {
		//System.setProperty("webdriver.gecko.driver", "C://Drivers/");
				//WebDriver driver = new FirefoxDriver();
				WebDriver driver = new ChromeDriver();
				//WebDriver driver = new InternetExplorerDriver();
				//driver.manage().window().setSize(new Dimension(1200, 765));
				driver.manage().window().maximize();
				//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
				driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				driver.findElement(By.id("elementosForm:sexo:0")).click();
				Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
				driver.quit();
				// elementosForm:sexo:0
	}
	
	@Test
	public void testeCheckBox() {
		//System.setProperty("webdriver.gecko.driver", "C://Drivers/");
				//WebDriver driver = new FirefoxDriver();
				WebDriver driver = new ChromeDriver();
				//WebDriver driver = new InternetExplorerDriver();
				//driver.manage().window().setSize(new Dimension(1200, 765));
				driver.manage().window().maximize();
				//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
				driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
				Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
				driver.quit();
				// elementosForm:comidaFavorita:0
	}
	
	@Test
	public void testeComboBox() {
		//System.setProperty("webdriver.gecko.driver", "C://Drivers/");
				//WebDriver driver = new FirefoxDriver();
				WebDriver driver = new ChromeDriver();
				//WebDriver driver = new InternetExplorerDriver();
				//driver.manage().window().setSize(new Dimension(1200, 765));
				driver.manage().window().maximize();
				//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
				driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
				Select combo = new Select(element);
				//combo.selectByIndex(2);
				//combo.selectByValue("superior");
				combo.selectByVisibleText("Superior");
				Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
				List<WebElement> lista = combo.getOptions();
				Assert.assertEquals(8, lista.size());
				driver.quit();
				// elementosForm:escolaridade
	}
	
	@Test
	public void testeComboBoxMultiplaEscolha() {
		//System.setProperty("webdriver.gecko.driver", "C://Drivers/");
				//WebDriver driver = new FirefoxDriver();
				WebDriver driver = new ChromeDriver();
				//WebDriver driver = new InternetExplorerDriver();
				//driver.manage().window().setSize(new Dimension(1200, 765));
				driver.manage().window().maximize();
				//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
				driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				WebElement element = driver.findElement(By.id("elementosForm:esportes"));
				Select combo = new Select(element);
				combo.selectByVisibleText("Natacao");
				combo.selectByVisibleText("Corrida");
				
				List<WebElement> elementosMarcados = combo.getAllSelectedOptions();
				Assert.assertEquals(2, elementosMarcados.size());
				driver.quit();
				// elementosForm:esportes
	}
	
	@Test
	public void testeButton() {
		//System.setProperty("webdriver.gecko.driver", "C://Drivers/");
				//WebDriver driver = new FirefoxDriver();
				WebDriver driver = new ChromeDriver();
				//WebDriver driver = new InternetExplorerDriver();
				//driver.manage().window().setSize(new Dimension(1200, 765));
				driver.manage().window().maximize();
				//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
				driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				WebElement element = driver.findElement(By.id("buttonSimple"));
				element.click();
				Assert.assertEquals("Obrigado!", element.getAttribute("value"));
				driver.quit();
				// buttonSimple
	}
	
	@Test
	public void testeLink() {
		//System.setProperty("webdriver.gecko.driver", "C://Drivers/");
				//WebDriver driver = new FirefoxDriver();
				WebDriver driver = new ChromeDriver();
				//WebDriver driver = new InternetExplorerDriver();
				//driver.manage().window().setSize(new Dimension(1200, 765));
				driver.manage().window().maximize();
				//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
				driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				
				WebElement element = driver.findElement(By.linkText("Voltar"));
				element.click();
				
				Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
				
				driver.quit();
				// resultado
	}
	
	@Test
	public void testeDiv() {
		//System.setProperty("webdriver.gecko.driver", "C://Drivers/");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new InternetExplorerDriver();
		//driver.manage().window().setSize(new Dimension(1200, 765));
		driver.manage().window().maximize();
		//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement element = driver.findElement(By.tagName("h3"));
		//Assert.assertTrue(element.getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", element.getText());
		
		driver.quit();
		// resultado
	}
	
	@Test
	public void testeSpam() {
		//System.setProperty("webdriver.gecko.driver", "C://Drivers/");
				//WebDriver driver = new FirefoxDriver();
				WebDriver driver = new ChromeDriver();
				//WebDriver driver = new InternetExplorerDriver();
				//driver.manage().window().setSize(new Dimension(1200, 765));
				driver.manage().window().maximize();
				//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
				driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				
				WebElement element = driver.findElement(By.className("facilAchar"));
				//Assert.assertTrue(element.getText().contains("Campo de Treinamento"));
				Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", element.getText());
				
				driver.quit();
				// resultado
	}
	
	@Test
	public void testeAlertSimples() {
		//System.setProperty("webdriver.gecko.driver", "C://Drivers/");
				//WebDriver driver = new FirefoxDriver();
				WebDriver driver = new ChromeDriver();
				//WebDriver driver = new InternetExplorerDriver();
				//driver.manage().window().setSize(new Dimension(1200, 765));
				driver.manage().window().maximize();
				//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
				driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				
				WebElement element = driver.findElement(By.id("alert"));
				element.click();
				Alert alert = driver.switchTo().alert();
				Assert.assertEquals("Alert Simples", alert.getText());
				alert.accept();
				
				driver.quit();
				// resultado
	}
	
	@Test
	public void testeAlertConfirmOK() {
		//System.setProperty("webdriver.gecko.driver", "C://Drivers/");
				//WebDriver driver = new FirefoxDriver();
				WebDriver driver = new ChromeDriver();
				//WebDriver driver = new InternetExplorerDriver();
				//driver.manage().window().setSize(new Dimension(1200, 765));
				driver.manage().window().maximize();
				//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
				driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				
				WebElement element = driver.findElement(By.id("confirm"));
				element.click();
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Assert.assertEquals("Confirmado", alert.getText());
				alert.accept();
				driver.quit();
				// resultado
	}
	
	@Test
	public void testeAlertConfirmCancelar() {
		//System.setProperty("webdriver.gecko.driver", "C://Drivers/");
				//WebDriver driver = new FirefoxDriver();
				WebDriver driver = new ChromeDriver();
				//WebDriver driver = new InternetExplorerDriver();
				//driver.manage().window().setSize(new Dimension(1200, 765));
				driver.manage().window().maximize();
				//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
				driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				
				WebElement element = driver.findElement(By.id("confirm"));
				element.click();
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
				Assert.assertEquals("Negado", alert.getText());
				alert.accept();
				driver.quit();
				// resultado
	}
	
	@Test
	public void testeAlertPrompt() {
		//System.setProperty("webdriver.gecko.driver", "C://Drivers/");
				//WebDriver driver = new FirefoxDriver();
				WebDriver driver = new ChromeDriver();
				//WebDriver driver = new InternetExplorerDriver();
				//driver.manage().window().setSize(new Dimension(1200, 765));
				driver.manage().window().maximize();
				//driver.get("file:///C:/Users/Xerxes%20Gouveia/Documents/Campo%20treinamento/componentes.html");
				driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				
				WebElement element = driver.findElement(By.id("prompt"));
				element.click();
				Alert alert = driver.switchTo().alert();
				alert.sendKeys("15");
				alert.accept();
				Assert.assertEquals("Era 15?", alert.getText());
				alert.accept();
				Assert.assertEquals(":D", alert.getText());
				alert.accept();
				driver.quit();
				// resultado
	}



}
