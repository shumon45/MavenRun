package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class yahooSighUp {
	
	//declaring WebDriver as global variable to be used in @AfterTest as driver was already used in local variable with @BeforeTest
	WebDriver driver; //Global driver created
	int x; //this is global x 
	
	
	@BeforeTest
	public void setupTest() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\R\\Desktop\\Libraries\\chromedriver.exe");
		
		driver = new ChromeDriver(); //we should not create another local driver here just point to the global one
		x = 12; //automatically pointing to the global variable 
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://login.yahoo.com/account/create");
		
		Thread.sleep(3000);
		
	}

	@Test
	public void mainTest() throws InterruptedException {
		
		//System.out.println("This is mainTest");
		
		//finding the web elements we should put under the @Test annotation
		
		driver.findElement(By.name("firstName")).sendKeys("Michael");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("usernamereg-lastName")).sendKeys("Scott");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"usernamereg-yid\"]")).sendKeys("mscott@yahoo.com");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("usernamereg-password")).sendKeys("KillYou123");
		
		Thread.sleep(3000);
		
	}
	
	@AfterTest
	public void finishTest() {
		
		//System.out.println(x);
		driver.quit();
		
	}
	
	
}
