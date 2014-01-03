package MercuryTours.PageObjects;
//Author Bharath Marrivada - mbr.reddy@gmail.com


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import MercuryTours.PageObjects._01_Initilize;

public class _01_Initilize extends UtilityScript {

	private WebDriver driver;

	public _01_Initilize(WebDriver driver) throws InterruptedException {
		this.driver = driver;
	}

	public _01_Initilize zOpen(String url) throws Exception {
		Print("TestCaseId:"+TestCaseId);
		Print("Start:" + xGetDateTimeIP());
		driver.manage().timeouts().implicitlyWait(ImplicitWait,TimeUnit.SECONDS);
		//Code to mazimize the window. Reason some times Autosuggest will fail if not maximized
		String script = "if (window.screen){window.moveTo(0,0);window.resizeTo(window.screen.availWidth,window.screen.availHeight);};"; 
		((JavascriptExecutor) driver).executeScript(script); 			
		driver.get(url);
		Print(url);
		return this;
	}

}