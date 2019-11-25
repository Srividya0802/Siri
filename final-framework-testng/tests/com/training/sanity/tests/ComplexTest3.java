package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviderUniform;
import com.training.generics.ScreenShot;
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ComplexTest3 extends LoginDataProviderUniform{
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
	@Test(dataProvider="excel-inpt")
	public void registerationProcessTest(String f,String L,String mail,String phone,String Add1,String Add2,String city,String pcode,String cntry,String Regn,String pwd,String pwdconfirm) throws InterruptedException, ParseException {
		Rpom.clickuserAccountBtn();
		Rpom.clickuserRegisterBtn();
		Rpom.sendFirstName(f);
		Rpom.sendLastName(L);
	//	Random rand = new Random(1000); 
		//int rand_int = rand.nextInt();
		//if(rand_int<1)
		//{rand_int = rand_int*-1;}
		//String email1= mail;
		//String emailfinal = mail;
		Rpom.sendiemail(mail);
		Rpom.sendTelephone(phone);
		Rpom.sendAddress1(Add1);
		Rpom.sendAddress2(Add2);
		Rpom.sendCity(city);
		Rpom.sendPostCode(pcode);
		Thread.sleep(1000);
		Rpom.selectCountry("99");
		Thread.sleep(1000);
		Rpom.selectRegiondatadriven(Regn);
		Rpom.sendPassword(pwd);
		Rpom.sendConfirmPassword(pwdconfirm);
		Rpom.clickNoToSubscribe();
		Rpom.selectCheckPrivPolicy();
		screenShot.captureScreenShot("Reg_Details");
		Assert.assertTrue(mail.contains("@"));
		Assert.assertTrue(mail.contains(".com"));
		try {
	int i=	Integer.parseInt(phone);
		System.out.println(i+" is Valid phone number");}
		catch(NumberFormatException ex)
		{System.out.println(" Invalid phone");
		}
		Rpom.clickContinue();
		String conf_message = "Congratulations! Your new account has been successfully created!";
		Assert.assertEquals(Rpom.successMessage.getText(),conf_message,"Message displayed not matching"+mail);
		//db implementation part is left 
		
		//String lastname = "Vidya";
		  // int len=lastname.length();
		  // Pattern ln = Pattern.compile("[a-zA-Z]{"+len+"}");
	
	}

}
