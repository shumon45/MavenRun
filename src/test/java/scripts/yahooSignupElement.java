package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class yahooSignupElement {
	
	WebDriver driver;
	
	@BeforeTest
	public void setupTest() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\R\\Desktop\\Libraries\\chromedriver.exe");
		
		driver = new ChromeDriver(); //we should not create another local driver here just point to the global only
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//driver.get("https://login.yahoo.com/account/create");
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Thread.sleep(); >>> should not be used in real script only implicitlyWait should be used as above for BeforeTest annotation
	}
	
	@AfterTest
	public void endtest() {
		
		driver.quit();
		
		
	}
	
	@BeforeMethod
	public void beforeEachTest() {
		
		driver.get("https://login.yahoo.com/account/create");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	@Test(priority=0)
	public void validateElement() {
		
		boolean firstNamepresent = driver.findElement(By.name("firstName")).isDisplayed(); 
		
		
		
		boolean lastNamepresent = driver.findElement(By.id("usernamereg-lastName")).isDisplayed();
		
		
		
		boolean UserNamepresent = driver.findElement(By.xpath("//*[@id=\"usernamereg-yid\"]")).isDisplayed();
		
		
		
		boolean Userpasspresent = driver.findElement(By.id("usernamereg-password")).isDisplayed();
		

		//if it's one test, just add the code here -code related to one test
		
		
		
		Assert.assertTrue(firstNamepresent);
		Assert.assertTrue(lastNamepresent);
		
		
		
		
		
	}
	
	@Test(priority=1)
	public void validateForm() throws InterruptedException {
		
		driver.findElement(By.name("firstName")).sendKeys("Michael");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("usernamereg-lastName")).sendKeys("Scott");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"usernamereg-yid\"]")).sendKeys("mscott@yahoo.com");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("usernamereg-password")).sendKeys("KillYou123");
		
		Thread.sleep(3000);
		
		String expectedResult = ("https://login.yahoo.com/account/create");//("https://login.yahoo.com/account/");
		
		String actualResult = driver.getCurrentUrl(); //same url should be fetched here () -->  https://login.yahoo.com/account/create?
		
		Assert.assertEquals(expectedResult, actualResult); 
		
	}
}
