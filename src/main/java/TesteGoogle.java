import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

private WebDriver driver;
	
	@Before
	public void inicializa() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}
	@Test
	public void teste() {
		//System.setProperty("chromeDriver.exe","C:\\\\chromeDriver.exe");
		//WebDriver driver = new ChromeDriver();
		//driver.manage().window().setSize(new Dimension (1200, 765));
		driver.manage().window().maximize();
		//System.out.println(driver.getTitle());
		driver.get("Http://google.com");
		Assert.assertEquals("Google", driver.getTitle());
	}
	
}
