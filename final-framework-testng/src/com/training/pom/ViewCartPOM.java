package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ViewCartPOM {
	
private WebDriver driver; 
	
	public ViewCartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(css="#content > form > div > table > tbody > tr > td.text-center > a > img")
	public  WebElement viewCartImg;
	
	@FindBy(xpath="//*[@id='content']/form/div/table/tbody/tr/td[2]/a")
	private WebElement viewCartProdName;
	
	@FindBy(xpath="//*[@id='content']/form/div/table/tbody/tr/td[2]/small")
	private WebElement viewCartProdSize;
	
	@FindBy(xpath="//*[@id='content']/form/div/table/tbody/tr/td[3]")
	private WebElement viewCartProdModel;
	

	@FindBy(xpath="//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input")
	private WebElement viewCartProdQty;
	
	@FindBy(xpath="//*[@id='content']/form/div/table/tbody/tr/td[5]")
	public WebElement viewCartUnitPrice;
	
	@FindBy(xpath="//*[@id='content']/form/div/table/tbody/tr/td[6]")
	private WebElement viewCartUnitTot;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div[2]/a")
	public WebElement viewCartCheckOut;
	
	public void verifyViewCartDetails() {
		Assert.assertTrue(viewCartImg.isDisplayed());
		Assert.assertEquals(viewCartProdName.getText(), "REGULAR T-SHIRTS (Rust)");
		Assert.assertEquals(viewCartProdSize.getText(), "Chest Size: 24");
		Assert.assertEquals(viewCartProdModel.getText(),"TBSW-Nur-8th");
		Assert.assertEquals(viewCartProdQty.getAttribute("Value"),"1");
		Assert.assertEquals(viewCartUnitPrice.getText(),"₹368");
		Assert.assertEquals(viewCartUnitTot.getText(),"₹368");	
			}
}
