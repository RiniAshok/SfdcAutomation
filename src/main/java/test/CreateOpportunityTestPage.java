package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listners.SFDCListeners;
import pages.CreateOpportunityPage;
import pages.LoginPage;
import utils.FileUtils;

@Listeners(SFDCListeners.class)
public class CreateOpportunityTestPage extends BaseTest {
	

	
	@BeforeMethod
	public void preCondition() throws IOException
	{
		driver = BaseTest.getBrowserType("chrome");
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		System.out.println("Before Test");
	}
	
	@AfterMethod
	public void closeDriver()
	{
		driver.close();
	}
	
	@Test
	
	public void selectOpportunityDropdown_TC15() throws IOException
	{
		CreateOpportunityPage cop = new CreateOpportunityPage(driver);
		cop.selectOpportunity();
		test.info("Opportunity tab selected");
		Assert.assertTrue(cop.isOpportunityHomePageDisplayed(),"Failed to display opportunity home page");
		test.info("Opportunities home page displayed");
		Assert.assertTrue(cop.verifyOpportunityDropdownItems(),"Failed to verify dropdown items");
		test.info("Verified opportunities dropdown items");
		
	}

	@Test
	
	public void verifyCreateNewOpportunity_TC16() throws IOException
	{
		CreateOpportunityPage cop = new CreateOpportunityPage(driver);
		cop.selectOpportunity();
		test.info("Opportunity tab selected");
		Assert.assertTrue(cop.isOpportunityHomePageDisplayed(),"Failed to display opportunity home page");
		test.info("Opportunities home page displayed");
		Assert.assertTrue(cop.verifyCreateNewOpportunity(driver,FileUtils.readCreateOpportunityTestData("opportunity.name"),FileUtils.readCreateOpportunityTestData("opportunity.accountName")));
		test.info("Create new opportunity verified");
	}
	
	@Test
	
	public void verifyOpportunityPipelineReport_TC17()
	{
		CreateOpportunityPage cop = new CreateOpportunityPage(driver);
		cop.selectOpportunity();
		test.info("Opportunity tab selected");
		Assert.assertTrue(cop.isOpportunityHomePageDisplayed(),"Failed to display opportunity home page");
		test.info("Opportunities home page displayed");
		Assert.assertTrue(cop.verifyOpportunityPipeline(driver),"Failed to display opportunity pipeline page");
		test.info("Opportunity pipeline verified");
	}

	@Test
	
	public void verifyStuckOpportunityReport_TC18()
	{
		CreateOpportunityPage cop = new CreateOpportunityPage(driver);
		cop.selectOpportunity();
		test.info("Opportunity tab selected");
		Assert.assertTrue(cop.isOpportunityHomePageDisplayed(),"Failed to display opportunity home page");
		test.info("Opportunities home page displayed");
		Assert.assertTrue(cop.verifyStuckOpportunityReport(driver),"Failed to display opportunity pipeline page");
		test.info("Verified stuck opportunity report");
	}
	
    @Test
	
	public void verifyQuarterlySummaryReport_TC19()
	{
		CreateOpportunityPage cop = new CreateOpportunityPage(driver);
		cop.selectOpportunity();
		test.info("Opportunity tab selected");
		Assert.assertTrue(cop.isOpportunityHomePageDisplayed(),"Failed to display opportunity home page");
		test.info("Opportunities home page displayed");
		Assert.assertTrue(cop.verifyQuarterlySummaryReport(driver),"Failed to display opportunity pipeline page");
		test.info("Quarterly summary report verified");
	}

	
}
