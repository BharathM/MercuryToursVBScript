package MercuryTours;
//Author Bharath Marrivada - mbr.reddy@gmail.com

import java.io.File;

import org.testng.annotations.Test;

import MercuryTours.PageObjects.UtilityScript;

public class initilize extends UtilityScript {
	@Test
	public void Test_initilize_main() throws Exception {
		TestCaseId = "DontConsiderIt";
		File directory = new File (".");
		try{Runtime.getRuntime().exec("wscript.exe "+directory.getCanonicalPath()+"\\initilize.vbs" );
		}
		  catch(Exception e){e.printStackTrace();
		}
		xKillIEs();  
		Wait(3000);
 }

}