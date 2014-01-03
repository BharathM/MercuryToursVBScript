package MercuryTours;
//Author Bharath Marrivada - mbr.reddy@gmail.com


import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.SeleniumException;

import MercuryTours.PageObjects.TestData_MercuryTours;
import MercuryTours.PageObjects.UtilityScript;
import MercuryTours.PageObjects._01_Initilize;
import MercuryTours.PageObjects._02_Login;
import MercuryTours.PageObjects._03_FindAFlight;

public class MercuryTours_TC_03 extends TestData_MercuryTours {

	InternetExplorerDriver driver;

	@BeforeClass(alwaysRun = true)
	protected void setUp() throws Exception {
		try {
			driver = new InternetExplorerDriver();
		} catch (SeleniumException ex) {
			Print("Before method fail");
			ex.printStackTrace();
		}
	}

	@AfterClass(alwaysRun = true)
	protected void tearDown() throws Exception {
		try {
			driver.quit();
			xKillIEs();
		} catch (SeleniumException ex) {
			Print("After method fail");
			xKillIEs();
			ex.printStackTrace();
		}
	}

	//Dummy test cases just for understanding the implementation
	@Test(groups = { "MercuryToursTestCases1" }, enabled = true)
	public void Test_TC_03_1() throws Exception {
		TestCaseId = "Test_TC_03_1";
		_01_Initilize Initilize = PageFactory.initElements(driver,_01_Initilize.class);
		Initilize.zOpen(Url);
		_02_Login Login = PageFactory.initElements(driver,_02_Login.class);	
		Login.zEnterCrediantials(UserName, UserNameP);
		_03_FindAFlight FindAFlight = PageFactory.initElements(driver,_03_FindAFlight.class);	
		FindAFlight.zTripTypeOneWay();
		FindAFlight.zNumberOfPassengers(NumberOfPassengers);
		
	}
}
