package utils;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FileConstants;
import constants.WaitConstants;

public class CommonUtils {
	
  public static boolean waitForElement(WebDriver driver, WebElement element)
  {
	  boolean isElementClickable = false;
	  WebDriverWait wait = new WebDriverWait(driver,WaitConstants.WAIT_FOR_ELEMENT);
	  try
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(element));
		  isElementClickable = true;
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return isElementClickable;
	  
  }
  
  public static boolean waitForElements(WebDriver driver, List<WebElement> elements)
  {
	  return elements.stream().allMatch(element -> waitForElement(driver, element));
  }
  
  public static boolean waitForElementToDisappear(WebDriver driver, WebElement element)
  {
	  boolean isElementInvisible = false;
	  WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT_TO_DISAPPEAR);
	  try
	  {
		  wait.until(ExpectedConditions.invisibilityOf(element));
		  isElementInvisible = true;
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return isElementInvisible;
  }
  
  public static void mouseHover(WebDriver driver, WebElement element)
  {
	  Actions action = new Actions(driver);
	  action.moveToElement(element).build().perform();
  }
  
  public static String getScreenshot(WebDriver driver)
  {
	  String filepath = FileConstants.SCREENSHOT_FOLDER_PATH;
	  TakesScreenshot screen = (TakesScreenshot) driver ;
	  File src = screen.getScreenshotAs(OutputType.FILE);
	  File dst = new File(filepath);
	  src.renameTo(dst);
	  return filepath;
  }
  
  public static String getDateAndTimeStamp()
  {
	  return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
  }
  
  public static String getDatePlusN(int numberOfDays, String format)
  {
	  SimpleDateFormat sdf = new SimpleDateFormat(format);
	  Calendar c = Calendar.getInstance();
	  c.setTime(new Date()); // Using today's date
	  c.add(Calendar.DATE, numberOfDays); // Adding numberOf days
	  String output = sdf.format(c.getTime());
	  return output;
  }
}
