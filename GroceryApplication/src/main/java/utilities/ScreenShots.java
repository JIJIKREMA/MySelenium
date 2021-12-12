package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShots {

	public void captureScreenShots(WebDriver driver,String imageName) throws IOException {
		//interface
		TakesScreenshot scrShot =(TakesScreenshot)driver;
		//getScreenshotAs is a method
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
		
		//taking current system time
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		
		//Creating a folder
		String dest = System.getProperty("user.dir")+"//OUTPUTSCREENSHOT//";
		  File f1=new File(dest);
		  if (!f1.exists()){
			    f1.mkdirs();
			}
		
		//defining a string folder path in project location toadd screen shots.
		String finalPath = System.getProperty("user.dir")+"//OUTPUTSCREENSHOT//"+imageName+timeStamp+".png";
		
		//changing the path defined in the string and convert to path
		File finalDestination=new File(finalPath);
		
		FileHandler.copy(screenShot, finalDestination);
	}
}
