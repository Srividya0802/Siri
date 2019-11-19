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
	
	@FindBy(xpath="//div[@id='logo']/h1/a")
	public WebElement uniformstorelogo;
	
	@FindBy(className="alert-danger")
	public WebElement errMesg;
	
	
	@FindBy(linkText="Forgotten Password")
	private WebElement forgtpwd;
	
	@FindBy(xpath="//*[@id='banner0']/div/a/img")
	public WebElement shopPremiumSchoolUniform;
	
	@FindBy(xpath="//*[@id='featured-grid']/div[2]/div/div/div[1]/a/img")
	public WebElement RegularTshirt;
	
	public void sendUemail(String mail) {
		this.iemail.clear();
		this.iemail.sendKeys(mail);
		}
	
	public void clickshopPremiumSchoolUniform() {
		this.shopPremiumSchoolUniform.click();
		}
	
	public void clickRegularTshirt() {
		this.RegularTshirt.click();
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
	
	public void clickBtn(WebElement xyz) {
	xyz.click(); 
			}

}
