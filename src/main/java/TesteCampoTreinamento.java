import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html" );
	dsl = new DSL (driver);
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}
	
	
	@Test
	public void testeTextField(){
		dsl.escreve("elementosForm:nome","Teste de escrita");
		Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));
}
	
	@Test
	public void deveInteragirComTextArea() {
		dsl.escreve("elementosForm:sugestoes","teste\n\nasasasas\nUltima Linha");
		Assert.assertEquals("teste", dsl.obterValorCampo("elementosForm:sugestoes"));
}
	
	@Test
	public void deveInteragirComRadioButton() {
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
}
	
	@Test
	public void deveInteragirComCheckBox() {
		dsl.clicarRadio("elementosForm:comidaFavorita:2"));
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));
}

	@Test
	public void deveInteragirComCombo() {
		dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
		}

	@Test
	public void deveVerificarValoresCombo() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
	
		boolean encontrou = false;
		for(WebElement option:options) {
			if(option.getText().equals("Mestrado")) {
			encontrou = true;	
			break;	
			}
		}
		Assert.assertTrue(encontrou);
}	
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
	
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		//desmarcar
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
}
	
	@Test
	public void deveInteragirComBotoes() {
		WebElement  botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		driver.findElement(By.id("buttonSimple")).click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
	@Test
	@Ignore
	public void deveInteragirComLinks() {
		driver.findElement(By.linkText("Voltar")).click();
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	}
		
	@Test
	public void deveBuscarTextoNaPagina() {
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
	}
}