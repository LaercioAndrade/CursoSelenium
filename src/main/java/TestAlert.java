import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {

	private WebDriver driver;
	
	@Before
	public void inicializa() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html" );
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}
	
	@Test
	public void deveInterargirComAlertSimples() {
	
		
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", alert.getText());
		alert.accept();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
}
	@Test
	public void deveInterargirComAlertConfirm() {
		driver.findElement(By.id("confirm")).click();
		Alert alerta = driver.switchTo().alert();;
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.accept();
		Assert.assertEquals("Confirmado", alerta.getText());
		alerta.accept();
		
		
		driver.findElement(By.id("confirm")).click();
		alerta = driver.switchTo().alert();;
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.dismiss();
		Assert.assertEquals("Negado", alerta.getText());
		alerta.dismiss();
	}
	
	@Test
	public void deveInterargirComPrompt() {	
		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alerta.getText());
		alerta.sendKeys("12");
		alerta.accept();
		Assert.assertEquals("Era 12?", alerta.getText());
		alerta.accept();
		Assert.assertEquals(":D", alerta.getText());
	}
}