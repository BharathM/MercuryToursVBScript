package MercuryTours;
//Author Bharath Marrivada - mbr.reddy@gmail.com


import java.io.File;

import org.testng.annotations.Test;

import MercuryTours.PageObjects.UtilityScript;

public class SendEmail extends UtilityScript {
	@Test
	public void Test_SendEmail_main() throws InterruptedException {
		TestCaseId = "DontConsiderIt";
		Wait(3000);
		File directory = new File(".");
		// Print(MethodName);
		try {
			Runtime.getRuntime().exec(
					"wscript.exe " + directory.getCanonicalPath()
							+ "\\sendemail.vbs c");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
