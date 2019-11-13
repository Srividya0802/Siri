package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformLoginPOM {
private WebDriver driver; 
	
	public UniformLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(className="fa-user")
	private WebElement userAccount; 
	
	@FindBy(linkText="Login")
	private WebElement loginBtn; 
	
	
	@FindBy(id="input-email")
	private WebElement iemail; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	
	@FindBy(xpath="//div/div[2]/div/form/input")
	private WebElement submit_login;
	
	@FindBy(className="alert-danger")
	public WebElement errMesg;
	
	
	@FindBy(linkText="Forgotten Password")
	private WebElement forgtpwd;
	
	
	public void sendUemail(String mail) {
		this.iemail.clear();
		this.iemail.sendKeys(mail);
	}
	
	public void sendPassword(String pass) {
		this.password.clear(); 
		this.password.sendKeys(pass); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
			}
	
	public void clickSubmitLoginBtn() {
		this.submit_login.click(); 
			}
	
	public void clickForgotPasswordLnk() {
		this.forgtpwd.click(); 
			}
	
	public void clickuserAccountBtn() {
		this.userAccount.click(); 
			}

}
