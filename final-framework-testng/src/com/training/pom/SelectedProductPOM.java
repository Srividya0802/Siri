package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SelectedProductPOM {
private WebDriver driver; 
	
	public SelectedProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-option376")
	public WebElement chestsize;
	
	@FindBy(id="button-cart")
	public WebElement addTocart;
	
	@FindBy(className="alert-success")
	public WebElement MesgAfterAddToCart;
	
	@FindBy(xpath="//*[@id='cart']")
	public WebElement cart;
	
	
	
	public void selectChestSize(String csz) {
		Select cSize = new Select(chestsize);
		cSize.selectByValue(csz);
		Assert.assertTrue(cSize.getFirstSelectedOption().getText().contains("24"));
			}
	
	public void clickaddTocartBtn() {
		this.addTocart.click(); 
		Assert.assertTrue(MesgAfterAddToCart.getText().contains("Success: You have added REGULAR T-SHIRTS (Rust) to your shopping cart!"));
			}
	
	
	
		
	
}