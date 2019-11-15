package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.UniformLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MediumNegativeLogin extends LoginDataProviders {
	
	private WebDriver driver;
	private String baseUrl;
	private UniformLoginPOM ufrmLgnPom; 
	private static Properties properties;
	private ScreenShot screenShot;
	//MediumNegativeLogin mn = new MediumNegativeLogin();

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		ufrmLgnPom = new UniformLoginPOM(driver); 
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
	
	@Test(dataProvider="excel-inputs")
	public void positiveLoginProcess(String email,String password) {
		ufrmLgnPom.clickuserAccountBtn();
		ufrmLgnPom.clickLoginBtn();
		ufrmLgnPom.sendUemail(email);
		ufrmLgnPom.sendPassword(password);
		ufrmLgnPom.clickSubmitLoginBtn();
		Assert.assertEquals(ufrmLgnPom.errMesg.getText(), "Warning: No match for E-Mail Address and/or Password.");
	}
	

}
