package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ComplexTestone {

	private WebDriver driver;
	private String baseUrl;
	private RegistrationPOM Rpom;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
			}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		Rpom = new RegistrationPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void registerationProcessTest() throws InterruptedException {
		Rpom.clickuserAccountBtn();
		Rpom.clickuserRegisterBtn();
		Rpom.sendFirstName("Neha");
		Rpom.sendLastName("B");
		Random rand = new Random(1000); 
		int rand_int = rand.nextInt();
		if(rand_int<1)
		{
			rand_int = rand_int*-1;
		}
		String email = "neha"+Integer.toString(rand_int)+"@gmail.com";
		Rpom.sendiemail(email);
	    Rpom.sendTelephone("9880978783");
		Rpom.sendAddress1("Jayanagar");
		Rpom.sendCity("Bangalore");
		Rpom.sendPostCode("560082");
		Thread.sleep(1000);
		Rpom.selectCountry("99");
		Thread.sleep(1000);
		Rpom.selectRegion("1489");
		Rpom.sendPassword("Neha123");
		Rpom.sendConfirmPassword("Neha123");
		Rpom.clickNoToSubscribe();
		Rpom.selectCheckPrivPolicy();
		screenShot.captureScreenShot("Reg_Details");
		Rpom.clickContinue();
		String conf_message = "Congratulations! Your new account has been successfully created!";
		Assert.assertEquals(Rpom.successMessage.getText(),conf_message,"Message displayed not matching"+email);
		//db implementation part is left 
		
		//String lastname = "Vidya";
		  // int len=lastname.length();
		  // Pattern ln = Pattern.compile("[a-zA-Z]{"+len+"}");
	
	}
}
