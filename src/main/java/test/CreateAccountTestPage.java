package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listners.SFDCListeners;
import pages.CreateAnAccountPage;
import pages.LoginPage;
import utils.FileUtils;

@Listeners(SFDCListeners.class)
public class CreateAccountTestPage extends BaseTest{
	

	
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
	
	@Test(priority=1)
	
	public void createAccount_TC10() throws IOException
	{
		CreateAnAccountPage cp = new CreateAnAccountPage(driver);
		cp.clickAccountsLink(driver);
		Assert.assertTrue(cp.isMyAccountsPageDisplayed(driver), "Failed to download MyAccounts page");
		test.info("My Accounts page is displayed");
		Assert.assertTrue(cp.verifyAccountsPage(driver,FileUtils.readCreateAccountTestData("account.name")));
		test.info("Accounts page is verified");
	}
	
	@Test(priority=2)
	
	public void createNewView_TC11() throws IOException
	{
		CreateAnAccountPage cp = new CreateAnAccountPage(driver);
		cp.clickAccountsLink(driver);
		Assert.assertTrue(cp.isMyAccountsPageDisplayed(driver), "Failed to download MyAccounts page");
		test.info("My Accounts page is displayed");
		Assert.assertTrue(cp.verifyCreateViewPage(driver,FileUtils.readCreateAccountTestData("view.name")));
		test.info("Create view page verified");
	}
	
	@Test(priority=3)
	
	public void editView_TC12() throws IOException, InterruptedException
	{
		CreateAnAccountPage cp = new CreateAnAccountPage(driver);
		cp.clickAccountsLink(driver);
		Assert.assertTrue(cp.isMyAccountsPageDisplayed(driver), "Failed to download MyAccounts page");
		test.info("My Accounts page is displayed");
		Assert.assertTrue(cp.verifyEditViewPage(driver,FileUtils.readCreateAccountTestData("view.name"),FileUtils.readCreateAccountTestData("newView.name"),FileUtils.readCreateAccountTestData("value")));
		test.info("Edit view page verified");
	}
	
	@Test(priority=4)
	
	public void mergeAccount_TC13() throws IOException
	{
		CreateAnAccountPage cp = new CreateAnAccountPage(driver);
		cp.clickAccountsLink(driver);
		Assert.assertTrue(cp.isMyAccountsPageDisplayed(driver), "Failed to download MyAccounts page");
		test.info("My Accounts page is displayed");
		Assert.assertTrue(cp.verifyMergeAccountPage(driver, FileUtils.readCreateAccountTestData("account.name")),"Failed to verify merged account");
		test.info("Merge account page verified");
	}
	
	@Test(priority=5)
	
	public void createAccountReport_TC14() throws IOException, InterruptedException
	{
		CreateAnAccountPage cp = new CreateAnAccountPage(driver);
		cp.clickAccountsLink(driver);
		Assert.assertTrue(cp.isMyAccountsPageDisplayed(driver), "Failed to download MyAccounts page");
		test.info("My Accounts page is displayed");
		Assert.assertTrue(cp.verifyCreateAccountReport(driver,FileUtils.readCreateAccountTestData("report.name")));
		test.info("Create account report verified");
	}

}
