package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import listners.SFDCListeners;
import pages.ContactsPage;
import pages.LoginPage;
import utils.FileUtils;

@Listeners(SFDCListeners.class)
public class ContactsTest extends BaseTest{
	

	
	@BeforeMethod
	public void preCondition(@Optional("chrome") String bName, @Optional("false") boolean isHeadless) throws IOException
	{
		BaseTest.setDriver(bName, isHeadless);
		logger.info("ContactTest : precondition : ");
		System.out.println("Before Test");
	}
	
	@AfterMethod
	public void closeDriver()
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.logoutPage(driver);
		System.out.println("Logged out");
		driver.close();
	}

	@Test
	public void createNewContact_TC25() throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		Assert.assertTrue(cp.verifyCreateNewContacts(driver, FileUtils.readContactsTestData("lastName"),FileUtils.readContactsTestData("account.name")));
		test.info("Create new contacts verified");
		
	}
	
	@Test
	public void createNewViewInContactPage_TC26() throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		cp.clickContactLink(driver);
		test.info("Contact link selected");
		Assert.assertTrue(cp.verifyCreateNewViewInContactPage(driver,FileUtils.readContactsTestData("view.name")));
		test.info("Create new view in contact page is verified");
	}

	@Test
	public void checkRecentlyCreatedContact_TC27() throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		cp.clickContactLink(driver);
		test.info("Contact link selected");
		Assert.assertTrue(cp.verifyRecentlyCreatedContact(driver));
		test.info("Recently created contact page is verified");
	}
	
	@Test
	public void checkMyContactView_TC28() throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		cp.clickContactLink(driver);
		test.info("Contact link selected");
		Assert.assertTrue(cp.verifyMyContactViewInContactPage(driver));
		test.info("My Contact view in contact page is verified");
	}
	
	@Test
	public void viewAContact_TC29() throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		cp.clickContactLink(driver);
		test.info("Contact link selected");
		Assert.assertTrue(cp.verifyViewAContact(driver));
		test.info("View Account verified");
		
	}
	
	@Test
	public void checkErrroMessage_TC30() throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		cp.clickContactLink(driver);
		test.info("Contact link selected");
		Assert.assertTrue(cp.verifyErrorMessage(driver,FileUtils.readContactsTestData("unique.name")));
		test.info("Error message verified");
	}
	
	@Test
	public void checkcancelButtonInCreateNewView_TC31() throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		cp.clickContactLink(driver);
		test.info("Contact link selected");
		Assert.assertTrue(cp.verifyCancelButtonInCreateNewViewPage(driver,FileUtils.readContactsTestData("unique.name"),FileUtils.readContactsTestData("view.name")));
		test.info("Cancel button in create view page is verified");
	}
	
	@Test
	public void checkSaveAndNewButton_TC32() throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		cp.clickContactLink(driver);
		test.info("Contact link selected");
		Assert.assertTrue(cp.verifySaveAndNewButton(driver,FileUtils.readContactsTestData("last.name"),FileUtils.readContactsTestData("accountName")));
		test.info("Save and new button is verified");
	}
	
	
}
