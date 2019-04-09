import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class teste {
	@Test
	public void primeiroteste () throws InterruptedException {
		
		System.setProperty("chromeDriver.exe","C:\\\\chromeDriver.exe");
		WebDriver conection = new ChromeDriver();
		//conection.get("http://www.google.com.br");
		conection.manage().window().maximize();
		System.out.println(conection.getTitle());
		System.out.println(conection.getCurrentUrl());
		
		
		/*driver.findElement(By.xpath("//form[@id='tsf']/div[2]/div/div/div/div/input")).sendKeys("formulario prontos online");
		driver.findElement(By.xpath("//div[3]/center/input")).click();
		driver.findElement(By.xpath("//div[3]/div/div/div/div/div/a/h3")).click();
		driver.findElement(By.xpath("//div[10]/div[2]/a")).click();
		driver.findElement(By.xpath("//form[@id='form']/div/div[2]/div/div/div[2]/div/input")).sendKeys("Laércio Gonçalves");
		//driver.findElement(By.xpath("//form[@id='form']/div/div[2]/div/div/div[2]/div/input[2]")).sendKeys("de Andrade");*/
		Thread.sleep(2000);
		Thread.sleep(2000);
		conection.navigate().to("https://starhml.enterprisetrn.corp/star-boarding-web/login.jsp");
		Thread.sleep(2000);
		Thread.sleep(2000);
		conection.findElement(By.id("userName")).sendKeys("T2412rfl");
		conection.findElement(By.id("password")).sendKeys("C!elo_1234");
		conection.findElement(By.id("loginButton")).click();
		conection.findElement(By.id("frmGeneralSearch:mskClientIdentification")).sendKeys("077202");
		conection.findElement(By.id("frmGeneralSearch:generalSearchId")).click();
		Actions action = new Actions(conection);
	
	}
	
	

}
