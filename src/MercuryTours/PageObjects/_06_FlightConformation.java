package MercuryTours.PageObjects;
//Author Bharath Marrivada - mbr.reddy@gmail.com


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class _06_FlightConformation extends UtilityScript  {
	
    private WebDriver driver;
    
    public _06_FlightConformation(WebDriver driver) throws InterruptedException {
    	this.driver = driver;
    }

    public void zGetConformationNumber () throws InterruptedException {
    	Print(driver.findElement(By.xpath("//tr/td/b/font/font/b/font[1]")).getText());
    }	
    
    public _06_FlightConformation zLogOut () throws InterruptedException  {
	    driver.findElement(By.xpath("//tbody/tr/td[3]/a")).click();
	    Print("---Logout---");
	    Wait(3000);
	    return this;
    }       
    

}
