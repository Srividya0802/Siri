package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductConfirmPom {
	private WebDriver driver; 
	public ProductConfirmPom(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//*[@id='collapse-checkout-confirm']/div/div[1]/table/tbody/tr/td[1]/a")
	public  WebElement proddesc;
	
	@FindBy(xpath="//*[@id='collapse-checkout-confirm']/div/div[1]/table/tbody/tr/td[1]/small")
	public WebElement proddescsize;
	
	@FindBy(xpath="//*[@id='collapse-checkout-confirm']/div/div[1]/table/tbody/tr/td[2]")
	public WebElement prodModel;
	
	@FindBy(xpath="//*[@id='collapse-checkout-confirm']/div/div[1]/table/tbody/tr/td[3]")
	private WebElement qty;
	
	@FindBy(xpath="//*[@id='collapse-checkout-confirm']/div/div[1]/table/tbody/tr/td[5]")
	private WebElement tot;
	
	@FindBy(id="button-confirm")
	private WebElement confirmordr;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement confirmordrMsg;

	
	public void verifyProdConfirmation() {
		System.out.println(proddesc.getText());
		System.out.println(prodModel.getText());
		Assert.assertTrue(proddesc.getText().contains("REGULAR T-SHIRTS (Rust)"));
		Assert.assertEquals(prodModel.getText(),"TBSW-Nur-8th");
		Assert.assertEquals(qty.getText(), "1");
		Assert.assertEquals(tot.getText(),"₹368");
			}
	
	public void clickconfirmordr() throws InterruptedException {
		this.confirmordr.click();
		Thread.sleep(1000);
		Assert.assertEquals(confirmordrMsg.getText(),"YOUR ORDER HAS BEEN PLACED!");
	}
}
