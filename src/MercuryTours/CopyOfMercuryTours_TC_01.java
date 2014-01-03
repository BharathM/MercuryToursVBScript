package MercuryTours;
//Author Bharath Marrivada - mbr.reddy@gmail.com

//Each java file can have multiple test cases
//Based on the module or functionality
//All end to end test cases can be grouped in one java file.

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.SeleniumException;

import MercuryTours.PageObjects.TestData_MercuryTours;
import MercuryTours.PageObjects.UtilityScript;
import MercuryTours.PageObjects._01_Initilize;
import MercuryTours.PageObjects._02_Login;
import MercuryTours.PageObjects._03_FindAFlight;
import MercuryTours.PageObjects._04_SelectAFlight;
import MercuryTours.PageObjects._05_BookAFlight;
import MercuryTours.PageObjects._06_FlightConformation;

public class CopyOfMercuryTours_TC_01 extends TestData_MercuryTours {

	WebDriver driver;
	@BeforeMethod
	public void StartDriver() {
		File file = new File("C:/Seleniumjars/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver();      
	}

	@AfterMethod(alwaysRun = true)
	public void StopDriver() throws Exception {
		driver.quit();
	}

	@Test(groups = { "GoogleTest" }, enabled = true,timeOut = 90000)
	public void Test_TC_01_1() throws Exception {
		driver.get("www.google.com");

	}

	//Dummy test cases just for understanding the implementation and reusing the page objects
	@Test(groups = { "MercuryToursTestCases" }, enabled = true)
	public void Test_TC_01_2() throws Exception {
		TestCaseId = "Test_TC_01_2";
		_01_Initilize Initilize = PageFactory.initElements(driver,_01_Initilize.class);
		Initilize.zOpen(Url);
		_02_Login Login = PageFactory.initElements(driver,_02_Login.class);	
		Login.zEnterCrediantials(UserName, UserNameP);
		_03_FindAFlight FindAFlight = PageFactory.initElements(driver,_03_FindAFlight.class);	
		FindAFlight.zTripTypeOneWay();
		FindAFlight.zNumberOfPassengers(NumberOfPassengers);		
	}	

	//Dummy test cases just for understanding the implementation
	@Test(groups = { "MercuryToursTestCases" }, enabled = true)
	public void Test_TC_01_3() throws Exception {
		TestCaseId = "Test_TC_01_3";
		_01_Initilize Initilize = PageFactory.initElements(driver,_01_Initilize.class);
		Initilize.zOpen(Url);
		_02_Login Login = PageFactory.initElements(driver,_02_Login.class);	
		Login.zEnterCrediantials(UserName, UserNameP);
		_03_FindAFlight FindAFlight = PageFactory.initElements(driver,_03_FindAFlight.class);	
		FindAFlight.zTripTypeOneWay();
		FindAFlight.zNumberOfPassengers(NumberOfPassengers);		
	}		

}
