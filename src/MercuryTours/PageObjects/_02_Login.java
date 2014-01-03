package MercuryTours.PageObjects;
//Author Bharath Marrivada - mbr.reddy@gmail.com


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class _02_Login extends UtilityScript {
	private WebDriver driver;

	public _02_Login(WebDriver driver) throws InterruptedException {
		this.driver = driver;
	}

	public _02_Login zEnterCrediantials(String UserNameTxt, String PasswordTxt)
			throws InterruptedException {
		Wait(3000);
		driver.findElement(By.name("userName")).sendKeys(UserNameTxt);
		driver.findElement(By.name("password")).sendKeys(UserNameTxt);
		//driver.findElement(By.name("login")).click();
		click(driver.findElement(By.name("login")));
		Print("UserName:" + UserNameTxt);
		Print("---Login");
		Wait(3000);
		return this;
	}
	
	public void click(WebElement element)  {
		long start;
		start = System.currentTimeMillis();
		element.click();
		Print (driver.getTitle() + " - " + (System.currentTimeMillis() - start) + " MilliSec");
	}	

}