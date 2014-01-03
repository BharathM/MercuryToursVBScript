package MercuryTours.PageObjects;
//Author Bharath Marrivada - mbr.reddy@gmail.com


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _03_FindAFlight extends UtilityScript {

	private WebDriver driver;

	public _03_FindAFlight(WebDriver driver) throws InterruptedException {
		this.driver = driver;
	}

	public void zTripTypeOneWay() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='oneway']")).click();
	}

	public void zTripTypeRoundTrip() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='roundtrip']")).click();
	}

	public void zNumberOfPassengers(String Values_1to4)
			throws InterruptedException {
		driver.findElement(
				By.xpath("//select[@name='passCount']/option[@value='"
						+ Values_1to4 + "']")).click();
	}

	public void zDepartingFrom(String DepartingPlace)
			throws InterruptedException {
		driver.findElement(
				By.xpath("//select[@name='fromPort']/option[@value='"
						+ DepartingPlace + "']")).click();
	}

	public void zDepartingOnMonth(String Month_1to12)
			throws InterruptedException {
		driver.findElement(
				By.xpath("//select[@name='fromMonth']/option[@value='"
						+ Month_1to12 + "']")).click();
	}

	public void zDepartingOnDay(String Day_1to31) throws InterruptedException {
		driver.findElement(
				By.xpath("//select[@name='fromDay']/option[@value='"
						+ Day_1to31 + "']")).click();
	}

	public void zArrivingIn(String ArrivingPlace) throws InterruptedException {
		driver.findElement(
				By.xpath("//select[@name='toPort']/option[@value='"
						+ ArrivingPlace + "']")).click();
	}

	public void zReturningOnMonth(String Month_1to12)
			throws InterruptedException {
		driver.findElement(
				By.xpath("//select[@name='toMonth']/option[@value='"
						+ Month_1to12 + "']")).click();
	}

	public void zReturingOnDay(String Day_1to31) throws InterruptedException {
		driver.findElement(
				By.xpath("//select[@name='toDay']/option[@value='" + Day_1to31
						+ "']")).click();
	}

	public void zEconomyClass() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='Coach']")).click();
	}

	public void zBusinessClass() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='Business']")).click();
	}

	public void zFirstClass() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='First']")).click();
	}

	public _03_FindAFlight zContinue() throws InterruptedException {
		driver.findElement(By.name("findFlights")).click();
		Wait(3000);
		return this;
	}

}
