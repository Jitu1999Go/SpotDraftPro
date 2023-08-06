package SeleniumPractice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class SpotDraft {

	    public static WebDriver driver;	
		
		@BeforeClass
		public void openApp() throws InterruptedException
		{
		
			driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			 driver.manage().window().maximize();
			driver.get("https://www.goodreads.com/");
			
		}
			
			@BeforeMethod
			public void login() throws Throwable
			{
		
				 driver.findElement(By.xpath("//a[text()='Sign In']")).click();
			     driver.findElement(By.className("gr-button--facebook__icon")).click();
			     driver.findElement(By.id("email")).sendKeys("Boharepaige@yahoo.com", Keys.TAB,"Romanreigns",Keys.ENTER);
			
			     Thread.sleep(20000);
			}
			     
			     @AfterMethod
			     public void logout(){
			         driver.findElement(By.xpath("//span[@class='Avatar__image']")).click();
			         driver.findElement(By.xpath("//a[text()='Sign out']")).click();
			    
			     
			     
			     
			}


}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	