package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPOM {
	
private WebDriver driver; 
	
	public ForgotPasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="input-email")
	private WebElement email; 
	
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement cont;
	
	
	@FindBy(className="alert-success")
	public WebElement confirmationmail;
	
	
	public void clickcontBtn() {
		this.cont.click(); 
	}
	
	public void sendiemail(String email1) {
		this.email.clear(); 
		this.email.sendKeys(email1); 
	}
	
	

}
