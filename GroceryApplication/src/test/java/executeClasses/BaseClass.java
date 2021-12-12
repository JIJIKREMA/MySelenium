package executeClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.stream.FileCacheImageInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.ScreenShots;

public class BaseClass {
	WebDriver driver;
	ScreenShots screenSh;
	public static Properties property;
	
	public static void basic() throws IOException {
		property= new Properties();
		//Reading the file details
		FileInputStream fp=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
		property.load(fp);
	
	}

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser) throws IOException {
		
		basic();
		
		if(browser.equalsIgnoreCase("chrome")){
		System.setProperty(property.getProperty("chromDriver"), System.getProperty("user.dir")+property.getProperty("chromPath"));

		driver = new ChromeDriver();
		}
		
//		else if(browser.equalsIgnoreCase("edge")) {
//			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\msedgedriver.exe");
//
//			driver = new EdgeDriver();
//		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty(property.getProperty("fireFoxDriver"), System.getProperty("user.dir")+property.getProperty("fireFoxPath"));

			driver = new FirefoxDriver();
		}
		
	
		
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
		}
	
	@AfterMethod
	public void afterMethod(ITestResult iTestResult) throws IOException {
		if(iTestResult.getStatus()==iTestResult.FAILURE) {
		screenSh= new ScreenShots();
		screenSh.captureScreenShots(driver,iTestResult.getName());
		}
		
		driver.close();
	}
}
