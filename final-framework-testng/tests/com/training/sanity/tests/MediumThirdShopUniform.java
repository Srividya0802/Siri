package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.UniformLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MediumThirdShopUniform {
	private WebDriver driver;
	private String baseUrl;
	private UniformLoginPOM ufrmLgnPom; 
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
		ufrmLgnPom = new UniformLoginPOM(driver); 
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
	public void shopUniform() {
		ufrmLgnPom.clickuserAccountBtn();
		ufrmLgnPom.clickLoginBtn();
		ufrmLgnPom.sendUemail("Neha@gmail.com");
		ufrmLgnPom.sendPassword("Neha123");
		ufrmLgnPom.clickSubmitLoginBtn();
		driver.findElement(By.xpath(("//div[@id='banner0']/div/a/img"))).click();
		driver.findElement(By.xpath("//*[@id='featured-grid']/div[2]/div/div/div[1]/a/img")).click();
		Select chestsize= new Select(driver.findElement(By.id("input-option382")));
		chestsize.selectByValue("975");
		driver.findElement(By.id("button-cart")).click();
		//Actions cart = new Actions(driver);
		//cart.moveToElement(driver.findElement(By.xpath("//div[@class='btn-group btn-block']")));
		driver.findElement(By.xpath("//div[@class='btn-group btn-block']")).click();
		driver.findElement(By.xpath("//*[@id='cart']/ul/li[2]/div/p/a[1]/strong")).click();
		//View Cart Verification
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[1]/a/img")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[2]/a ")).getText(), "REGULAR T-SHIRTS (YELLOW)");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[2]/small ")).getText(), "Chest Size: 20");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[3]")).getText(),"TBSM-NUR-3rdSTD");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input")).getAttribute("Value"),"1");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[5]")).getText(),"₹368");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[6]")).getText(),"₹368");
		driver.findElement(By.xpath("//*[id='content']/div[2]/div[2]/a")).click();
		
	}
	
}
