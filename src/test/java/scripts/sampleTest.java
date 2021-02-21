package scripts;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sampleTest {

	
	@BeforeTest
	
	public void setupTest() {
		
		System.out.println("This is before Test");
		
	}
	
	
	//with each annotation we need to create a method, a function
	@Test
	public void cmainTest() {
		
		System.out.println("This is main Test 1");
			//most of the time we compare string value
		Assert.assertEquals("Test", "Test");
		
	}
	//since there are 2 test annotation, the Script will run alphabetically therefore, bmainTest would execute first and amainTest will execute second
	@Test
	public void bmainTestOne() {
		Assert.assertEquals("Test1", "Test1");
		System.out.println("This is main Test 2");
	}
	
	
	
	@AfterTest
	public void finishTest() {
		
		System.out.println("This is after Test");
		
		
		
	}
	
	
}
