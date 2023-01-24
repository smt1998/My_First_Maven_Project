package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	public static WebDriver driver;
	
	public static void captureScreen(WebDriver driver, String name) throws IOException {
		
				//step-1 location to store
		
				String path = System.getProperty("user.dir")+"\\screenshots\\"+name+"_" +getCurrentDate()+".png";
				
				//step-2 using take screenshot reference
				TakesScreenshot tss = (TakesScreenshot) driver;
				
				//step-3 
				File sourceFile = tss.getScreenshotAs(OutputType.FILE);
				
				//step-4 Using file object
				File destinationFile = new File (path);
				
				//step-5 Using File handler
				FileHandler.copy(sourceFile, destinationFile);
				
				System.out.println("screenshot capture successfully");
				
				
		
	}
	
	public static String getCurrentDate() throws IOException {
		
		  DateFormat date   =new SimpleDateFormat ("yyyy-MM-dd hh:mm");
		  
		  Calendar cal = Calendar.getInstance();
		  
		  String currentDate = date.format(cal.getTime());
		  
		  captureScreen(driver,"sumit");
		return currentDate;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(getCurrentDate());
	}

}
