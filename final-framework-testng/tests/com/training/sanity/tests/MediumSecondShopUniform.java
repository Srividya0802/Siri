package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CartPOM;
import com.training.pom.SelectedProductPOM;
import com.training.pom.UniformLoginPOM;
import com.training.pom.ViewCartPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MediumSecondShopUniform {

	private WebDriver driver;
	private String baseUrl;
	private UniformLoginPOM ufrmLgnPom; 
	private SelectedProductPOM selProdPom; 
	private CartPOM cPom;
	private ViewCartPOM vcartPom;
	private static Properties properties;
	private ScreenShot screenShot;
	
//http://uniformm1.upskills.in
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
		selProdPom = new SelectedProductPOM(driver);
		cPom = new CartPOM(driver);
		vcartPom = new ViewCartPOM(driver);
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
	public void shopUniform() throws InterruptedException {
		
		ufrmLgnPom.clickshopPremiumSchoolUniform();
		ufrmLgnPom.clickRegularTshirt();
		selProdPom.selectChestSize("965");
		selProdPom.clickaddTocartBtn();
		cPom.clickCartBtn();
				//Thread.sleep(1000);
		WebDriverWait webwait = new WebDriverWait(driver,20);
		webwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='cart']/ul/li[1]/table/tbody/tr/td[2]/small"))));
		//Cart verification
		cPom.verifyCartDetails();
		cPom.cartViewCartBtn.click();
		vcartPom.verifyViewCartDetails();
		//click on checkout and very  title
		vcartPom.viewCartCheckOut.click();
		Assert.assertEquals(driver.getTitle(), "Checkout");
		
	}
}
