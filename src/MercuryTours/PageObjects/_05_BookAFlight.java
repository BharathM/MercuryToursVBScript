package MercuryTours.PageObjects;
//Author Bharath Marrivada - mbr.reddy@gmail.com


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class _05_BookAFlight extends UtilityScript  {
	
    private WebDriver driver;
    
    public _05_BookAFlight(WebDriver driver) throws InterruptedException {
    	this.driver = driver;
    }

    public void zPassengerDetails (String FirstName, String LastName, String Meal, String IndexStartFrom0) throws InterruptedException {
    	driver.findElement(By.name("passFirst"+IndexStartFrom0)).sendKeys(FirstName);
    	driver.findElement(By.name("passLast"+IndexStartFrom0)).sendKeys(LastName);
    	driver.findElement(By.xpath("//select[@name='pass."+IndexStartFrom0+".meal']/option[@value='"+ Meal +"']")).click();
    }	
    
    public void zCardDetails (String CardNumber) throws InterruptedException {
    	driver.findElement(By.name("creditnumber")).sendKeys(CardNumber);
    }	    
    
    public _05_BookAFlight zContinue () throws InterruptedException  {
	    driver.findElement(By.name("buyFlights")).click();
	    Wait(3000);
	    return this;
    }    

}
