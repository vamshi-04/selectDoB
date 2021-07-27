package miniproject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class HighLightandScreenshot {
	
	public static WebDriver driver;
	
	//A method for highlighting the element
	public void highlightElement(WebDriver driver, WebElement ele) throws InterruptedException {
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].style.border='4px solid yellow'", ele);
		Thread.sleep(2000);
	}
	
	//A method for taking the screenshot
	public void takeScreenshot(WebDriver driver, String filename) throws InterruptedException, IOException{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("C:\\Users\\Vamshi Krishna\\eclipse-workspace\\miniproject.selectDoB\\Screenshots\\screenshot-"+filename+".jpg"));
	}
	
}
