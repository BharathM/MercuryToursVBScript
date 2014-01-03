package MercuryTours.PageObjects;
//Author Bharath Marrivada - mbr.reddy@gmail.com



public class TestData_MercuryTours extends UtilityScript {
	
	//Data Specific to the project. Don't have direct reference to page objects, only the test cases
	//This will help us to use the same page objects for multiple clients if they use same common code with slight differences
	//I feel this is one of the efficient ways to pass data to the test, instead of excel, notepad, TestNG xml
	public static final String Url = "http://newtours.demoaut.com/";
	
	public static final String UserName = "qtp123";
	public static final String UserNameP = "qtp123";
	
	public static final String NumberOfPassengers = "4";

}
