package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPOM {
	
private WebDriver driver; 
	
	public RegistrationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="fa-user")
	private WebElement userAccount; 
	
	@FindBy(linkText="Register")
	private WebElement register;
	
	@FindBy(id="input-firstname")
	private WebElement firstName; 
	
	@FindBy(id="input-lastname")
	private WebElement lastname; 
	
	@FindBy(id="input-email")
	private WebElement iemail; 
	
	@FindBy(id="input-telephone")
	private WebElement iphone;
	
	@FindBy(id="input-address-1")
	private WebElement add1;
	
	@FindBy(id="input-address-2")
	private WebElement add2;
	
	@FindBy(id="input-city")
	private WebElement city; 
	
	@FindBy(id="input-postcode")
	private WebElement postalcode;
	
	@FindBy(id="input-country")
	private WebElement cntry;
	
	@FindBy(id="input-zone")
	private WebElement zone;
	
	@FindBy(id="input-password")
	private WebElement ipwd;
	
	@FindBy(id="input-confirm")
	private WebElement cpwd;
	
	@FindBy(xpath="//label[contains(text(),'Subscribe')]/following::div[@class='col-sm-10']/label[2]")
	private WebElement noToSubscribe;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkPrivPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement cont;
	
	@FindBy(xpath="//div[@id='content']/p[1]")
	public WebElement successMessage;
	
	
	
	public void selectRegion(String rid) {
		Select regId = new Select(zone);
		regId.selectByValue(rid);
	}
	
	
	public void selectRegiondatadriven(String rid) {
		Select regId = new Select(zone);
		regId.selectByVisibleText(rid);
	}
	 
		
		public void selectCountry(String cid) {
		Select selCountry = new Select(cntry);
		selCountry.selectByValue(cid);
		
	}
	
	public void sendFirstName(String fname) {
		this.firstName.clear();
		this.firstName.sendKeys(fname);
			}
	
	public void sendLastName(String lname) {
		this.lastname.clear();
		this.lastname.sendKeys(lname);
			}
	
	public void sendTelephone(String ph) {
		this.iphone.clear();
		this.iphone.sendKeys(ph);
			}
	
	public void sendAddress1(String ad) {
		this.add1.clear();
		this.add1.sendKeys(ad);
			}
	
	public void sendAddress2(String ad) {
		this.add2.clear();
		this.add2.sendKeys(ad);
			}
	
	public void sendCity(String c) {
		this.city.clear();
		this.city.sendKeys(c);
			}
	
	public void sendPostCode(String pcode) {
		this.postalcode.clear();
		this.postalcode.sendKeys(pcode);
			}
	
	public void sendPassword(String pwd) {
		this.ipwd.clear();
		this.ipwd.sendKeys(pwd);
			}
	
	
	public void sendConfirmPassword(String cpd) {
		this.cpwd.clear();
		this.cpwd.sendKeys(cpd);
			}
	
	
	public void sendiemail(String email) {
		this.iemail.clear(); 
		this.iemail.sendKeys(email); 
	}
	
	public void clickuserAccountBtn() {
		this.userAccount.click(); 
	}

	public void clickuserRegisterBtn() {
		this.register.click(); 
	}

	
	public void clickNoToSubscribe() {
		this.noToSubscribe.click(); 
	}
	
	
	public void selectCheckPrivPolicy() {
		this.checkPrivPolicy.click(); 
	}
	
	
	public void clickContinue() {
		this.cont.click(); 
	}
	
}
