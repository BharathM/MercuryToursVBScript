package MercuryTours.PageObjects;
//Author Bharath Marrivada - mbr.reddy@gmail.com


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class _04_SelectAFlight extends UtilityScript  {
	
    private WebDriver driver;
    
    public _04_SelectAFlight(WebDriver driver) throws InterruptedException {
    	this.driver = driver;
    }

    public void zDepartFlightSelection () throws InterruptedException {
    	//Implement logic to choose the flight based on Airline, Price
    	//Selected Second option (ODD numbers 3 5 7 8 there are some blank divs between)
    	driver.findElement(By.xpath("//tr[5]/td/input[@name='outFlight']")).click();
    }	
    
    public void zReturnFlightSelection () throws InterruptedException {
    	//Implement logic to choose the flight based on Airline, Price
    	driver.findElement(By.xpath("//input[@name='inFlight'][1]")).click();
    }    
    
    public _04_SelectAFlight zContinue () throws InterruptedException  {
	    driver.findElement(By.name("reserveFlights")).click();
	    Wait(3000);
	    return this;
    }    

}
