package simple;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002 {
	
    @Test
	public void forgotPassword() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebDriverWait w = new WebDriverWait(driver,20);
	driver.manage().window().maximize();
	driver.get("http://uniformm1.upskills.in");
	driver.findElement(By.className("fa-user"));
driver.findElement(By.linkText("Login"));
driver.findElement(By.id("input-email")).sendKeys("siri@gmail.com");
driver.findElement(By.id("input-password")).sendKeys("pwd");
driver.findElement(By.xpath("//input[@value='Login']")).click();
String error_msg= driver.findElement(By.className("alert-danger")).getText();
Assert.assertEquals(error_msg, " Warning: No match for E-Mail Address and/or Password.");
driver.findElement(By.linkText("Forgotten Password")).click();
driver.findElement(By.id("input-email")).sendKeys("sriv0802@gmail.com");
driver.findElement(By.xpath("//input[@value='Continue']")).click();
String confirm_message = driver.findElement(By.className("alert-success")).getText();
Assert.assertEquals(confirm_message, "An email with a confirmation link has been sent your email address.");
}
}
