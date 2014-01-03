package MercuryTours.TestNG;
//Author Bharath Marrivada - mbr.reddy@gmail.com


import org.testng.*;
import org.testng.TestListenerAdapter;

public class TestNGCustom extends TestListenerAdapter {

	// Take screen shot only for failed test case
	@Override
	public void onTestFailure(ITestResult tr) {
		try {
			MercuryTours.PageObjects.UtilityScript.xScreenShot();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			MercuryTours.PageObjects.UtilityScript.xUpdateTestDetails("FAIL");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		// p2pZions.PageObjects.UtilityScript.xScreenShot();
		try {
			MercuryTours.PageObjects.UtilityScript.xUpdateTestDetails("SKIPPED");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		//p2pZions.PageObjects.UtilityScript.xScreenShot();
		try {
			MercuryTours.PageObjects.UtilityScript.xUpdateTestDetails("PASS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
