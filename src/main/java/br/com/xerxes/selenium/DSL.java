package br.com.xerxes.selenium;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	/* GERAL */
	
	public void escreve(String idCampo, String texto) {
		driver.findElement(By.id(idCampo)).sendKeys(texto);
	}
	
	public void apaga(String idCampo) {
		driver.findElement(By.id(idCampo)).clear();
	}
	
	public String pegaAtributoCampo(String idCampo, String atributo) {
		return driver.findElement(By.id(idCampo)).getAttribute(atributo);
		
	}
	
	public void clicar(String idCampo) {
		driver.findElement(By.id(idCampo)).click();
	}
	
	public boolean checaEstaSelecionado(String idCampo) {
		return driver.findElement(By.id(idCampo)).isSelected();
	}
	
	public String obterTexto(String idCampo) {
		return driver.findElement(By.id(idCampo)).getText();
	}
	
	/* COMBOBOX */
	
	public void selecionarComboBox(String idCampo, String valor) {
		WebElement element = driver.findElement(By.id(idCampo));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public String pegaCampoSelecionadoCombo(String idCampo) {
		WebElement element = driver.findElement(By.id(idCampo));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public int checaQuantidadeElementosMarcados(String idCampo) {
		WebElement element = driver.findElement(By.id(idCampo));
		Select combo = new Select(element);
		List<WebElement> elementosMarcados = combo.getAllSelectedOptions();
		return elementosMarcados.size();
	}
	
	/* ALERTS */
	
	public String alertGetText(String idAlert) {
		WebElement element = driver.findElement(By.id("alert"));
		element.click();
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public String alertGetTextWithConfirm(String idAlert) {
		WebElement element = driver.findElement(By.id(idAlert));
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return alert.getText();
	}
	
	public String alertGetTextWithDismiss(String idAlert) {
		WebElement element = driver.findElement(By.id(idAlert));
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		return alert.getText();
	}
	
	public Alert alertSetText(String idAlert, String text) {
		WebElement element = driver.findElement(By.id(idAlert));
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
		return alert;
	}
	
	/* LOCATORS */
	
	public WebElement findElementById(String id) {
		return driver.findElement(By.id(id));
	}
	
	public WebElement findElementByLinkText(String linkText) {
		return driver.findElement(By.linkText(linkText));
	}
	
	public WebElement findElementByTagName(String tagName) {
		return driver.findElement(By.tagName(tagName));
	}
	
	public WebElement findElementByClassName(String className) {
		return driver.findElement(By.className(className));
	}

}
