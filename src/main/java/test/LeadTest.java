package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listners.SFDCListeners;
import pages.LeadPage;
import pages.LoginPage;
import utils.FileUtils;

@Listeners(SFDCListeners.class)
public class LeadTest extends BaseTest{

	

	
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
	
	@Test(enabled=true, groups = "smaoke")
	
	public void testLeadTab_TC20() throws IOException
	{
		LeadPage lead = new LeadPage(driver);
		lead.clickLeadTab(driver);
		test.info("Lead tab selected");
		Assert.assertEquals(lead.isLeadHomePageDispalyed(driver),FileUtils.readLeadTestData("lead.homePage.title"));
		test.info("Lead home page is displayed");
		
	}
	 
	//@Test
	public void testLeadTabDropdown_TC21() throws IOException
	{
		LeadPage lead = new LeadPage(driver);
		lead.clickLeadTab(driver);
		test.info("Lead tab selected");
		Assert.assertEquals(lead.isLeadHomePageDispalyed(driver),FileUtils.readLeadTestData("lead.homePage.title"));
		test.info("Lead home page is displayed");
		Assert.assertTrue(lead.verifyLeadDropdown(driver),"Failed to verify lead dropdown");
		test.info("Lead dropdown verified");
	}
	
	//@Test
	
	public void checkDefaultView_TC22() throws IOException
	{
		LeadPage lead = new LeadPage(driver);
		lead.clickLeadTab(driver);
		test.info("Lead tab selected");
		Assert.assertEquals(lead.isLeadHomePageDispalyed(driver),FileUtils.readLeadTestData("lead.homePage.title"));
		test.info("Lead home page is displayed");
		Assert.assertTrue(lead.verifyDefaultViewInLeadDropdown(driver));
		test.info("Default view in lead dropdown is verified");
		
	}
	
	//@Test
	
	public void verifyTodaysLead_TC23() throws IOException
	{
		LeadPage lead = new LeadPage(driver);
		lead.clickLeadTab(driver);
		test.info("Lead tab selected");
		Assert.assertEquals(lead.isLeadHomePageDispalyed(driver),FileUtils.readLeadTestData("lead.homePage.title"));
		test.info("Lead home page is displayed");
		Assert.assertTrue(lead.verifyTodaysLeadDropdown(driver));
		test.info("Todays lead dropdown is verified");
	}
	
	//@Test
	
	public void createNewLead_TC24() throws IOException
	{
		LeadPage lead = new LeadPage(driver);
		lead.clickLeadTab(driver);
		test.info("Lead tab selected");
		Assert.assertEquals(lead.isLeadHomePageDispalyed(driver),FileUtils.readLeadTestData("lead.homePage.title"));
		test.info("Lead home page is displayed");
		Assert.assertTrue(lead.verifyCreateNewLead(driver), "Failed to create new lead");
		test.info("create new lead verified");
		
	}
}
