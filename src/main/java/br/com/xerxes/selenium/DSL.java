package br.com.xerxes.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	public void escreve(String idCampo, String texto) {
		driver.findElement(By.id(idCampo)).sendKeys(texto);
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
	
	public String obterTexto(String idCampo) {
		return driver.findElement(By.id(idCampo)).getText();
	}

}
