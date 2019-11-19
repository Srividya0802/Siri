package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckoutPom {
private WebDriver driver; 
	
	public CheckoutPom(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id=collapse-payment-address']/div/form/div[1]/label/input")
	private WebElement existingaddress;
	
	@FindBy(xpath="//*[@id='payment-existing']/select")
	private WebElement Add;
	
	@FindBy(id="button-payment-address")
	private WebElement checkoutcontinue;
	
	@FindBy(id="button-shipping-address")
	private WebElement checkoutcontinuesecondtime;
	
	@FindBy(name="comment")
	private WebElement Abturorder;
	
	
	@FindBy(xpath="//*[@id='button-shipping-method']")
	private WebElement continueposttextentry;
	
	
	@FindBy(xpath="//div[@id='collapse-payment-method']/div/div[2]/div/input[1]")
	public WebElement AgreetoDeliveryInfo;
	
	@FindBy(xpath="//*[@id='button-payment-method']")
	private WebElement continuetoPay;
	
	public void clickexistingaddressRadioBtn() {
		this.existingaddress.click();
		Assert.assertTrue(this.existingaddress.isSelected());
}
	
	public void checkBillingAdd(){
		String S = "Neha B, Jayanagar, Bangalore, Karnataka, India";
		Select existadd = new Select(Add);
		Assert.assertEquals(existadd.getFirstSelectedOption().getText(), S);
	}
	
	public void clickcontinueBtnoncheckout() {
				this.checkoutcontinue.click();
				this.checkoutcontinuesecondtime.click();
}
		
	
	public void SendAbturorder(String text) throws InterruptedException {
		this.Abturorder.clear();
		this.Abturorder.sendKeys(text);
		Thread.sleep(1000);
		//Assert.assertEquals(Abturorder.,"Please Deliver between 7am to 10 am");
		}
	
	public void clickcontinueposttextentry() throws InterruptedException {
				this.continueposttextentry.click();
}
	
	public void clickAgreetoDeliveryInfoBtn() {
		
		this.AgreetoDeliveryInfo.click();
		Assert.assertTrue(this.AgreetoDeliveryInfo.isSelected());
}
	
	public void clickcontinuetoPayoBtn() {
		this.continuetoPay.click();
		
}
}
