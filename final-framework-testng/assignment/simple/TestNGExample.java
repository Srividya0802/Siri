package simple;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TestNGExample {

	@BeforeMethod
	public void bmethod()  {
		System.out.println("Before method");
		Assert.assertEquals("vidya", "siri");
		
	}
	
	@Test
	public void tmethod()  {
		System.out.println("Test method");
			}
	
	@AfterMethod
	public void amethod() {
System.out.println("After method");
		
	}}
