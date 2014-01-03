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

//Uncomment if you want to make your screen shot functionality work.
//@Listeners({ MercuryTours.TestNG.TestNGCustom.class, MercuryTours.TestNG.TestNGCustomeListener.class })
public class MercuryTours_TC_01 extends TestData_MercuryTours {

	//private static WebDriver driver;
	static WebDriver driver;
	@BeforeMethod
	public static void StartDriver() {
	            File file = new File("C:/Seleniumjars/IEDriverServer.exe");
	            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	            driver = new InternetExplorerDriver();         

/*		try {
			driver = new InternetExplorerDriver();
		} catch (SeleniumException ex) {
			Print("Before method fail");
			ex.printStackTrace();
		}	*/	
		
/*		//Download chromedriver.exe from http://code.google.com/p/chromedriver/downloads/list and place in following location 
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");               
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);*/
        
/*	    FirefoxProfile Profile = new FirefoxProfile();
        Profile.setPreference("browser.safebrowsing.malware.enabled", false);
        driver = new FirefoxDriver(Profile);*/
		
		//Safari driver still in experimental stage and run only on Mac
		//For Windows need to relay on Selenium1 or RC		
		
		
	}

	@AfterMethod(alwaysRun = true)
	public void StopDriver() throws Exception {
		driver.quit();
/*		try {
			driver.quit();
			xKillIEs();
		} catch (SeleniumException ex) {
			Print("After method fail");
			xKillIEs();
			ex.printStackTrace();
		}*/
	}

	@Test(groups = { "MercuryToursTestCases" }, enabled = true,timeOut = 90000)
	public void Test_TC_01_1() throws Exception {
		TestCaseId = "Test_TC_01_1"; //Used with the test log creation, same id as manual test case id
		_01_Initilize Initilize = PageFactory.initElements(driver,_01_Initilize.class);
		Initilize.zOpen(Url);
		_02_Login Login = PageFactory.initElements(driver,_02_Login.class);	
		Login.zEnterCrediantials(UserName, UserNameP);
		_03_FindAFlight FindAFlight = PageFactory.initElements(driver,_03_FindAFlight.class);	
		FindAFlight.zTripTypeOneWay();
		FindAFlight.zNumberOfPassengers(NumberOfPassengers);
		FindAFlight.zDepartingFrom("London");
		FindAFlight.zDepartingOnDay("2");
		FindAFlight.zDepartingOnMonth("2");
		FindAFlight.zArrivingIn("Seattle");
		FindAFlight.zFirstClass();
		FindAFlight.zContinue();
		_04_SelectAFlight SelectAFlight = PageFactory.initElements(driver,_04_SelectAFlight.class);
		SelectAFlight.zDepartFlightSelection();
		SelectAFlight.zContinue();
		_05_BookAFlight BookAFlight = PageFactory.initElements(driver,_05_BookAFlight.class);	
		BookAFlight.zPassengerDetails("FirstName1", "LastName1", "HNML", "0");
		BookAFlight.zPassengerDetails("FirstName2", "LastName2", "HNML", "1");
		BookAFlight.zPassengerDetails("FirstName3", "LastName3", "HNML", "2");
		BookAFlight.zPassengerDetails("FirstName4", "LastName4", "HNML", "3");	
		BookAFlight.zCardDetails("123456789111");
		BookAFlight.zContinue();
		_06_FlightConformation FlightConformation = PageFactory.initElements(driver,_06_FlightConformation.class);
		FlightConformation.zGetConformationNumber();
		FlightConformation.zLogOut();
		
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
