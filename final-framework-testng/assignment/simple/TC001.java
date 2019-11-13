package simple;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;



public class TC001 {
	
	@Test
	public void Registeration() 
	{ WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebDriverWait w = new WebDriverWait(driver,20);
	driver.manage().window().maximize();
	driver.get("http://uniformm1.upskills.in");
	
	w.until(ExpectedConditions.elementToBeClickable(By.className("fa-user")));
	driver.findElement(By.className("fa-user")).click();
	
	w.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));
	driver.findElement(By.linkText("Register")).click();
	
		driver.findElement(By.id("input-firstname")).sendKeys("Srividya");
		
		
	driver.findElement(By.id("input-lastname")).sendKeys("Gupta");
	
	driver.findElement(By.id("input-email")).sendKeys("sriv0802@gmail.com");
	
	driver.findElement(By.id("input-telephone")).sendKeys("9880963635");
	driver.findElement(By.id("input-address-1")).sendKeys("Jayanagar");
	
	driver.findElement(By.id("input-city")).sendKeys("Bangalore");
	
	driver.findElement(By.id("input-postcode")).sendKeys("560082");
	
	Select country = new Select(driver.findElement(By.id("input-country")));
		country.selectByValue("99");
		Select region = new Select(driver.findElement(By.id("input-zone")));
		region.selectByValue("1489");
		driver.findElement(By.id("input-password")).sendKeys("vidya123");
		driver.findElement(By.id("input-confirm")).sendKeys("vidya123");
		
		if(!driver.findElement(By.xpath("//label[contains(text(),'Subscribe')]/following::div[@class='col-sm-10']/label[2]")).isSelected())
		{
			driver.findElement(By.xpath("//label[contains(text(),'Subscribe')]/following::div[@class='col-sm-10']/label[2]")).click();
		}
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String conf_message = "Congratulations! Your new account has been successfully created!";
		WebElement ele = driver.findElement(By.xpath("//div[@id='content']/p[1]"));
			Assert.assertEquals(ele.getText(),conf_message,"Message displayed not matching");
		
	      
	} 
 
}
