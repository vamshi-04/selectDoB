package miniproject;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverSetup {
	
	static String URL="https://www.facebook.com/";
	static String location;
	static WebDriver driver;
	
	public static WebDriver getWebDriver() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select the browser\nEnter 1 for Chrome \n2 for FireFox");
		int ch = sc.nextInt();
		switch(ch) {
		case 1 : {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamshi Krishna\\eclipse-workspace\\miniproject.selectDoB\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
			}
		case 2 : {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vamshi Krishna\\eclipse-workspace\\miniproject.selectDoB\\Drivers\\geckodriver.exe");
			FirefoxBinary firefoxBinary = new FirefoxBinary();
			FirefoxProfile profile = new FirefoxProfile();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setProfile(profile);
			firefoxOptions.setBinary(firefoxBinary);
            driver = new FirefoxDriver(firefoxOptions);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            break;
			}
		default: {
			System.out.println("Not a valid option\nEnter a valid number");
			System.exit(0);
			}
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		sc.close();
		return driver;
	}
}
