package miniproject;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Implementation {

	
	static WebDriver driver;
	HighLightandScreenshot screenshot;
	Implementation() throws IOException{
		screenshot = new HighLightandScreenshot();
		FileIO file = new FileIO();
		file.getElements();
	}
	
	//getting the webDriver
	@BeforeTest
	public WebDriver createDriver() {
		driver = DriverSetup.getWebDriver();
		return driver;
	}
	
	//Clicking on the Create A New Account Link
	@Test
	public void clickCreateAccount() throws InterruptedException, IOException {
		//Create a new account page
		WebElement element1 = driver.findElement(By.xpath("//a[normalize-space()='Create New Account']"));				
		screenshot.highlightElement(driver,element1);
		screenshot.takeScreenshot(driver, "Create New Account");
		element1.click();
	}
	
	//setting the User Details
	@Test(dependsOnMethods="clickCreateAccount")
	public void setDetails() throws InterruptedException, IOException {
		
		
		//firstname
		WebElement element2 = driver.findElement(By.name("firstname"));
		element2.sendKeys(FileIO.fname);
		screenshot.highlightElement(driver, element2);
		screenshot.takeScreenshot(driver,"firstname");
		Thread.sleep(1000);
		
		//lastname
		WebElement element3 = driver.findElement(By.name("lastname"));
		element3.sendKeys(FileIO.lname);
		screenshot.highlightElement(driver, element3);
		screenshot.takeScreenshot(driver,"lastname");
		Thread.sleep(1000);
		
		//Mobile
		WebElement element4 = driver.findElement(By.name("reg_email__"));
		element4.sendKeys(FileIO.mobile);
		screenshot.highlightElement(driver, element4);
		screenshot.takeScreenshot(driver,"mobile");
		Thread.sleep(1000);
		
		//Password
		WebElement element5 = driver.findElement(By.id("password_step_input"));
		element5.sendKeys(FileIO.password);
		screenshot.highlightElement(driver, element5);
		screenshot.takeScreenshot(driver,"password");
		Thread.sleep(1000);
	}
	
	//selecting Date Of Birth from DropDown Menu
	@Test(dependsOnMethods="setDetails")
	public void selectDoB() throws InterruptedException, IOException {
		
		//Year
		Select yyyy = new Select(driver.findElement(By.id("year")));
		yyyy.selectByValue(FileIO.year);
		WebElement element8 = driver.findElement(By.id("year"));
		screenshot.highlightElement(driver,element8);
		screenshot.takeScreenshot(driver,"password");
		Thread.sleep(1000);
		
		//Month
		Select mon = new Select(driver.findElement(By.id("month")));
		mon.selectByIndex((FileIO.month)-1);
		Thread.sleep(1000);
		WebElement element7 = driver.findElement(By.id("month"));
		screenshot.highlightElement(driver,element7);
		screenshot.takeScreenshot(driver,"month");
		
		//Date
		Select date = new Select(driver.findElement(By.id("day")));
		Thread.sleep(1000);
		date.selectByVisibleText(FileIO.day);
		WebElement element6 = driver.findElement(By.id("day"));
		screenshot.highlightElement(driver,element6);
		screenshot.takeScreenshot(driver,"day");

	}
	
	//Method for selecting the gender
	@Test(dependsOnMethods="selectDoB")
	public void selectGender() throws InterruptedException, IOException {
		
		//gender
		if(FileIO.gender.equalsIgnoreCase("male")) {
			WebElement element9 = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/span[1]/span[2]/label[1]"));
			element9.click();
			screenshot.highlightElement(driver,element9);
			screenshot.takeScreenshot(driver,"Gender");
		}
		else if(FileIO.gender.equalsIgnoreCase("female")) {
			WebElement element9 = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/span[1]/span[1]/label[1]"));
			element9.click();
			screenshot.highlightElement(driver,element9);
			screenshot.takeScreenshot(driver,"Gender");
		}
		else {
			WebElement element9 = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/span[1]/span[3]/label[1]"));
			element9.click();
			screenshot.highlightElement(driver,element9);
			screenshot.takeScreenshot(driver,"Gender");
		}
	}
	
	//Close the browser
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
