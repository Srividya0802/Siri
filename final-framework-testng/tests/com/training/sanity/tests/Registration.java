package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Random; 
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Registration {
	
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
		driver.quit();
	}
	@Test
	public void registerationProcessTest() throws InterruptedException {
		Rpom.clickuserAccountBtn();
		Rpom.clickuserRegisterBtn();
		Rpom.sendFirstName("Srividya");
		Rpom.sendLastName("Gupta");
		Random rand = new Random(); 
		int rand_int = rand.nextInt();
		String email = "siri"+Integer.toString(rand_int);
		Rpom.sendiemail(email);
	    Rpom.sendTelephone("9880978783");
		Rpom.sendAddress1("Jayanagar");
		Rpom.sendCity("Bangalore");
		Rpom.sendPostCode("560082");
		Thread.sleep(1000);
		Rpom.selectCountry("99");
		Thread.sleep(1000);
		Rpom.selectRegion("1489");
		Rpom.sendPassword("vidya123");
		Rpom.sendConfirmPassword("vidya123");
		Rpom.clickNoToSubscribe();
		Rpom.selectCheckPrivPolicy();
		screenShot.captureScreenShot("Reg_Details");
		Rpom.clickContinue();
		String conf_message = "Congratulations! Your new account has been successfully created!";
		Assert.assertEquals(Rpom.successMessage.getText(),conf_message,"Message displayed not matching");
		screenShot.captureScreenShot("SuccessScreen");
	}

}
