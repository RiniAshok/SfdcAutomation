package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listners.SFDCListeners;
import pages.LoginPage;
import pages.RandomPage;
import utils.FileUtils;

@Listeners(SFDCListeners.class)
public class RandonScenariosTestPage extends BaseTest{
	
	
	@BeforeMethod
	public void preCondition() throws IOException
	{
		driver = BaseTest.getBrowserType("chrome");
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		System.out.println("Before Test");
	}
	
	//@AfterMethod
	public void closeDriver()
	{
		LoginPage lp = new LoginPage(driver);
		lp.logoutPage(driver);
		System.out.println("Logged out");
		driver.close();
	}
	
	//@Test
	public void checkFirstAndLastnameDisplayedInHomePage_TC33() throws IOException
	{
		RandomPage rp = new RandomPage(driver);
		Assert.assertTrue(rp.verifyFirstAndLastnameDisplayed(driver));
		test.info("Firstname and lastname verified");
	}
	
	//@Test
	public void checkEditedLastnameIsUpdated_TC34() throws IOException
	{
		RandomPage rp = new RandomPage(driver);
		Assert.assertTrue(rp.verifyFirstAndLastnameDisplayed(driver));
		test.info("Firstname and lastname verified");
		Assert.assertTrue(rp.verifyLastnameUpdated(driver,FileUtils.readRandomScenarioTestData("update.lastname")));
		test.info("Updated lastname verified");
	}
	
	//@Test
	public void verifyTabCustomization_TC35() throws InterruptedException, IOException
	{
		RandomPage rp = new RandomPage(driver);
		Assert.assertTrue(rp.verifyCustomizeTab(driver));
		test.info("Customize tab is verified");
		LoginPage lp = new LoginPage(driver);
		lp.logoutPage(driver);
		test.info("Logged out successfully");
		lp.loginPage(driver);
		test.info("Logged in successfully");
		rp.verifyTabOptionNotPresent(driver, "Assets Tab");
		test.info("Tab option not present is verified");
	}
	
	//@Test
	public void blockingAnEventInCalendar_TC36()
	{
		RandomPage rp = new RandomPage(driver);
		Assert.assertTrue(rp.verifyBlockEventInCalendar(driver));
		test.info("Event block in calendar is verified");
	}
	
	@Test
	public void blockingAnEventWithRecurrance_TC37()
	{
		RandomPage rp = new RandomPage(driver);
		rp.verifyEventBlockWithWeeklyRecurrance(driver);
		test.info("Event block with weekly recurrance is verified ");
		
		
	}

}
