package PruebaServicios;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TentingCalidad {
	
	private WebDriver driver;
	
	@Before
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver 2");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:/www.google.com/");
	}
	
	@Test
	public void testGooglePage() {
		
		WebElement searchbox = driver.findElement(By.name("q"));
		
		searchbox.clear();
		
		searchbox.sendKeys("choucair servicios");
		
		searchbox.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("choucair servicios - Google Search", driver.getTitle());
			
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
