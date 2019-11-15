package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPOM {
private WebDriver driver; 
	
	public CartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	
	@FindBy(xpath="//*[@id='cart']")
	public WebElement cart;
	
	@FindBy(xpath="//*[@id='cart']/ul/li[1]/table/tbody/tr/td[2]/a")
	private WebElement cartProd;
	
	@FindBy(xpath="//*[@id='cart']/ul/li[1]/table/tbody/tr/td[2]/small")
	private WebElement cartProdChstSize;
	
	@FindBy(xpath="//*[@id='cart']/ul/li[1]/table/tbody/tr/td[4]")
	private WebElement cartProdAmt;
	
	@FindBy(xpath="//*[@id='cart']/ul/li[2]/div/table/tbody/tr[1]/td[1]/strong")
	private WebElement cartSubTot;
	
	@FindBy(xpath="//*[@id='cart']/ul/li[2]/div/table/tbody/tr[1]/td[2]")
	private WebElement cartSubTotAmt;
	
	@FindBy(xpath="//*[@id='cart']/ul/li[2]/div/table/tbody/tr[2]/td[1]/strong")
	private WebElement cartCGST;
	
	@FindBy(xpath="//*[@id='cart']/ul/li[2]/div/table/tbody/tr[2]/td[2]")
	private WebElement cartCGSTAmt;
	
	@FindBy(xpath="//*[@id='cart']/ul/li[2]/div/table/tbody/tr[3]/td[1]/strong")
	private WebElement cartSGST;
	
	@FindBy(xpath="//*[@id='cart']/ul/li[2]/div/table/tbody/tr[3]/td[2]")
	private WebElement cartSGSTAmt;
	
	@FindBy(xpath="//*[@id='cart']/ul/li[2]/div/table/tbody/tr[4]/td[2]")
	private WebElement cartNetAmt;
	
	@FindBy(xpath="//*[@id='cart']/ul/li[2]/div/p/a[1]/strong")
	public WebElement cartViewCartBtn;
	
	
	public void verifyCartDetails() {
		Assert.assertEquals(cartProd.getText(),"REGULAR T-SHIRTS (Rust)");
		Assert.assertEquals(cartProdChstSize.getText(), "Chest Size 24");
        Assert.assertEquals(cartProdAmt.getText(),"₹368");
        Assert.assertEquals(cartSubTot.getText(), "Sub-Total");
        Assert.assertEquals(cartSubTotAmt.getText(),"₹350");
        Assert.assertEquals(cartCGST.getText(), "CGST @ 2.5%");
        Assert.assertEquals(cartCGSTAmt.getText(),"₹9");
        Assert.assertEquals(cartSGST.getText(),"SGST @ 2.5%");
        Assert.assertEquals(cartSGSTAmt.getText(),"₹9");
        Assert.assertEquals(cartNetAmt.getText(),"₹368");                   
	}

	
	public void clickCartBtn() {
		this.cart.click(); 
	}
}
