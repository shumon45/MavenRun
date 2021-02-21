package scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sampleTest1 {
	
	
	
@BeforeTest
	
	public void setupTest() {
		
		System.out.println("This is before Test");
		
	}
	

@BeforeMethod //After Method gets executed before each test run 
	public void beforeEachTest() {
	
	
	System.out.println("This is before method");
	
	
}

@AfterMethod //After Method gets executed after each test run 
	public void afterEachTest() {
	
	
	
	
	System.out.println("This is After Method");
}


	
	//with each annotation we need to create a method, a function
	@Test(priority=0)
	public void validateElement() {
		
		System.out.println("This is Validate Element");
			
		
		
	}
	//since there are 2 test annotation, the Script will run alphabetically therefore, bmainTest would execute first and amainTest will execute second
	@Test(priority=1)
	public void validateLink() {
		
		
		
		System.out.println("This is Validate Link");
	}
	
	@Test(priority=2)
	public void validateMenu() {
		
		
		
		System.out.println("This is Validate Menu"); }
	
	
	
	@AfterTest
	public void finishTest() {
		
		System.out.println("This is after Test");
		
		
		
	}

}
