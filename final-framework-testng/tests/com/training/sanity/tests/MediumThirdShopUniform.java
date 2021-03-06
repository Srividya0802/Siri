package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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
import com.training.pom.CheckoutPom;
import com.training.pom.ProductConfirmPom;
import com.training.pom.SelectedProductPOM;
import com.training.pom.UniformLoginPOM;
import com.training.pom.ViewCartPOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MediumThirdShopUniform {
	private WebDriver driver;
	private String baseUrl;
	private UniformLoginPOM ufrmLgnPom; 
	private SelectedProductPOM selProdPom; 
	private CartPOM cPom;
	private ViewCartPOM vcartPom;
	private CheckoutPom chkoutPom;
	private ProductConfirmPom PdtConfPom;
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
		selProdPom = new SelectedProductPOM(driver);
		cPom = new CartPOM(driver);
		vcartPom = new ViewCartPOM(driver);
		chkoutPom = new CheckoutPom(driver);
		PdtConfPom = new ProductConfirmPom(driver);
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
	public void shopUniform() throws InterruptedException {
		ufrmLgnPom.clickuserAccountBtn();
		ufrmLgnPom.clickLoginBtn();
		ufrmLgnPom.sendUemail("neha@gmail.com");
		ufrmLgnPom.sendPassword("Neha123");
		ufrmLgnPom.clickSubmitLoginBtn();
		ufrmLgnPom.uniformstorelogo.click();
		ufrmLgnPom.clickshopPremiumSchoolUniform();
		ufrmLgnPom.clickRegularTshirt();
		selProdPom.selectChestSize("965");
		selProdPom.clickaddTocartBtn();
		cPom.clickCartBtn();
						//Thread.sleep(1000);
		WebDriverWait webwait = new WebDriverWait(driver,20);
		webwait.until(ExpectedConditions.visibilityOf(cPom.cartProdChstSize));
		//Cart verification
		cPom.verifyCartDetails();
		cPom.cartViewCartBtn.click();
		vcartPom.verifyViewCartDetails();
		//click on checkout and very  title
		vcartPom.viewCartCheckOut.click();
		Assert.assertEquals(driver.getTitle(), "Checkout");
		chkoutPom.checkBillingAdd();
		chkoutPom.clickcontinueBtnoncheckout();
		Thread.sleep(1000);
		chkoutPom.SendAbturorder("Please Deliver between 7am to 10 am");
		driver.findElement(By.id("button-shipping-method")).click();
		WebDriverWait k = new WebDriverWait(driver,20);
		k.until(ExpectedConditions.elementToBeClickable(chkoutPom.AgreetoDeliveryInfo));
		chkoutPom.clickAgreetoDeliveryInfoBtn();
		chkoutPom.clickcontinuetoPayoBtn();
		PdtConfPom.verifyProdConfirmation();
		PdtConfPom.clickconfirmordr();
	}
	
}
