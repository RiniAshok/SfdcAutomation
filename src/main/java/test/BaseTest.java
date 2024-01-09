package test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FileConstants;

/**The purpose of this class is to have common methods across all the test classes
 * 
 */
public class BaseTest {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	static Logger logger = LogManager.getLogger();
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> threadExtentTest = new ThreadLocal<ExtentTest>();
	
	@BeforeSuite
	public void configuration()
	{
	    extent = new ExtentReports();
	    logger.info("BaseTest : configuration : Report configuration started");
		ExtentSparkReporter report = new ExtentSparkReporter(FileConstants.REPORT_FOLDER_PATH);
		logger.info("BaseTest : configuration : Report configuration finished");
		extent.attachReporter(report);
	}
	
	@AfterSuite
	public void tearDown()
	{
		extent.flush();
		logger.info("BaseTest : tearDown : After suite finished");
	}
	
	public static void setDriver(String bName, boolean isHeadless) {
		WebDriver driver = BaseTest.getBrowserType(bName, isHeadless);
		threadLocalDriver.set(driver);
	}
	
	public static WebDriver getDriver()
	{
		return threadLocalDriver.get();
	}
	
	@AfterMethod 
	public static void removeDriver()
	{
		BaseTest.getDriver().close();
		threadLocalDriver.remove();
		BaseTest.threadExtentTest.remove();
	}

	/**This method configures and return browser object
	 * @param browserName eg.chrome,safari,etc
	 * @return browser object
	 */
	public static WebDriver getBrowserType(String browserName, boolean isHeadless)
	{
		WebDriver driver;
		String browser = browserName.toLowerCase();
		switch(browser)
		{
		case "chrome":
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--headless");
			driver = new ChromeDriver(co);
			logger.info("BaseTest : getBrowserType : Chrome Browser configured");
			break;
			
		case "safari":
			driver = new SafariDriver();
			logger.info("BaseTest : getBrowserType : Safari Browser configured");
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			logger.info("BaseTest : getBrowserType : Firefox Browser configured");
			break;
				
		case "edge":
			driver = new EdgeDriver();
			logger.info("BaseTest : getBrowserType : Edge Browser configured");
			break;
			
		default:
			driver = null;
			logger.info("BaseTest : getBrowserType : Invalid browser configuration");
		}
		
		return driver;
		
		

	}

}
