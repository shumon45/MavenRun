package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.yahooSignUP;

public class yahooTest {
	
	
	WebDriver driver;
	yahooSignUP ys; //created the object of the class as global variable 
	
	@BeforeTest
	public void setupTest() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\R\\Desktop\\Libraries\\chromedriver.exe");
		driver = new ChromeDriver(); //we should not create another local driver here just point to the global only
		
		ys = new yahooSignUP(driver); //we have to pass the driver here when we setup the value of the driver 
		
		
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
		
		boolean firstNamepresent = ys.getfirstName().isDisplayed(); 
		
		
		
		boolean lastNamepresent = ys.getlastName().isDisplayed();
		
		
		
		boolean UserNamepresent = ys.getuserName().isDisplayed();
		
		
		
		boolean Userpasspresent = ys.getpassword().isDisplayed();
		

		//if it's one test, just add the code here -code related to one test
	}
	
	@Test(priority=1)
	public void validateForm() throws InterruptedException {
		
		ys.getfirstName().sendKeys("Michael");
		
		Thread.sleep(2000);
		
		ys.getlastName().sendKeys("Scott");
		
		Thread.sleep(2000);
		
		ys.getuserName().sendKeys("mscott@yahoo.com");
		
		Thread.sleep(2000);
		
		ys.getpassword().sendKeys("KillYou123");
		
		Thread.sleep(3000);
		
	}

}
