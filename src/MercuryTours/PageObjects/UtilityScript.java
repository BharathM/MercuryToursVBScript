package MercuryTours.PageObjects;
//Author Bharath Marrivada - mbr.reddy@gmail.com


import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import org.testng.Reporter;

public class UtilityScript extends TestData {

	// Get date time with System IP
	public static java.lang.String xGetDateTimeIP() throws Exception {
		// get current date time with Date() to create unique file name
		DateFormat dateFormat = new SimpleDateFormat("hh_mm_ssaa_dd_MMM_yyyy");
		// get current date time with Date()
		Date date = new Date();
		// To identify the system
		InetAddress ownIP = InetAddress.getLocalHost();
		return (dateFormat.format(date) + "_IP" + ownIP.getHostAddress());
	}

	public static void Wait(int MilliSec) throws InterruptedException {
		Thread.sleep(MilliSec);
	}

	public static void Print(String Text) {
		System.out.println(Text);
		Reporter.log(Text);
		String Temp = Text;
		sMessages = sMessages + Temp.replaceAll(" ", "_") + "#";
		//System.out.println(Temp);
		//System.out.println(sMessages);
	}

	public void xKillIEs() throws Exception {
		// I felt this is not closing the IEs effectively, so started relaying
		// on VB script
		Wait(3000);
		/*
		 * final String KILL = "taskkill /IM "; String processName =
		 * "iexplore.exe"; // IE process Runtime.getRuntime().exec(KILL +
		 * processName);
		 */

		File directory = new File(".");
		try {
			Runtime.getRuntime().exec(
					"wscript.exe " + directory.getCanonicalPath()
							+ "\\KillIEs.vbs");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Wait(5000); // Allow OS to kill the process
	}

	public static void xScreenShot() throws InterruptedException {
		try {

			String NewFileNamePath;

			java.awt.Dimension resolution = Toolkit.getDefaultToolkit()
					.getScreenSize();
			Rectangle rectangle = new Rectangle(resolution);

			// Get the dir path
			File directory = new File(".");
			// System.out.println(directory.getCanonicalPath());

			// get current date time with Date() to create unique file name
			DateFormat dateFormat = new SimpleDateFormat(
					"MMM_dd_yyyy__hh_mm_ssaa");
			// get current date time with Date()
			Date date = new Date();
			// System.out.println(dateFormat.format(date));

			// To identify the system
			InetAddress ownIP = InetAddress.getLocalHost();
			// System.out.println("IP of my system is := "+ownIP.getHostAddress());

			NewFileNamePath = directory.getCanonicalPath() + "\\ScreenShots\\"
					+ TestCaseId + "___" + dateFormat.format(date) + "_"
					+ ownIP.getHostAddress() + ".png";
			Print(NewFileNamePath);

			// Capture the screen shot of the area of the screen defined by the
			// rectangle
			Robot robot = new Robot();
			BufferedImage bi = robot.createScreenCapture(new Rectangle(
					rectangle));
			ImageIO.write(bi, "png", new File(NewFileNamePath));
			NewFileNamePath = "<a href=" + NewFileNamePath + ">ScreenShot"
					+ "</a>";
			// Place the reference in TestNG web report
			Reporter.log(NewFileNamePath);
			Wait(3000);

		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void xUpdateTestDetails(String Status) throws Exception   {
		File directory = new File(".");
		if (TestCaseId == ""){
			TestCaseId = "IdNotDefined";
		}
		String Temp = TestCaseId + "_" + Status;
		Temp = Temp.replaceAll(" ", "_");
		Print("End:" + xGetDateTimeIP());
		Print (Temp);
		//Print (sMessages);
		if (TestCaseId != "DontConsiderIt"){
			try {
				Runtime.getRuntime().exec(
						"wscript.exe " + directory.getCanonicalPath()
						+ "\\UpdateTestDetails.vbs "+ Temp + " " + sMessages);
				TestCaseId = "";
				sMessages = "";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			TestCaseId = "";
			sMessages = "";
		}

		Wait(15000); //Allow VB script to complete the task
	}		

}
