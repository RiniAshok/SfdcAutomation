package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import constants.FileConstants;
import listners.SFDCListeners;
import pages.LoginPage;
import pages.UserMenuDropDownPage;
import utils.CommonUtils;
import utils.FileUtils;


@Listeners(SFDCListeners.class)
public class UserMenuDropDownTest extends BaseTest {
	@org.testng.annotations.Parameters ({"browserName" , "isHeadless"}) 
	@BeforeMethod
	public void preCondition(@Optional("chrome") String bName, @Optional("false") boolean isHeadless) throws IOException
	{
		BaseTest.setDriver(bName, isHeadless);
		logger.info("BaseTest : precondition : ");
		
		System.out.println("Before Test");
	}
	
	//@AfterMethod
	public void closeDriver()
	{
		WebDriver driver=BaseTest.getDriver();
		driver.close();
	}
	
    @Test
    
    public void selectUserMenu_TC05() throws IOException
    {
    	WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
    	UserMenuDropDownPage up = new UserMenuDropDownPage(driver);
		up.selectUserMenu();
		test.info("Usermenu selected");
		Assert.assertTrue(up.verifyUserMenuItems(), "Failed to verify");
		test.info("UsermenuItems verified successfully");
    }
	
	@Test
	
	public void selectMyProfile_TC06() throws IOException, InterruptedException
	{
		System.out.println("Test Methods");
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		UserMenuDropDownPage up = new UserMenuDropDownPage(driver);
		up.selectUserMenu();
		test.info("Usermenu selected");
		Assert.assertTrue(up.verifyUserMenuItems(), "Failed to verify");
		test.info("UsermenuItems are veified");
		Assert.assertTrue(up.selectUserMenuOption(driver, "My Profile"),"");
		test.info("My profile option selected from UsermenuItems");
		CommonUtils.waitForElement(driver,up.myProfile );
		test.info("Waiting for My Profile page");
		Assert.assertTrue(up.isMyProfilePageDisplayed(), "Failed to load My Profile page");
		test.info("My profile page is displayed successfully");
		up.clickEditIcon(driver);
		Assert.assertTrue(up.verifyEditContactIframe(driver), "Failed to load iFrame");
		test.info("Contact is edited successfully");
		Assert.assertTrue(up.verifyLastnameChangeInAboutTab(driver,FileUtils.readUserMenuTestData("user.lastname")));
		test.info("Lastname changed successfully");
		Assert.assertTrue(up.verifyCreatePost(driver,FileUtils.readUserMenuTestData("post.message")));
		test.info("New post created");
		Assert.assertTrue(up.verifyFileUpload(driver, FileConstants.TEST_FILE_PATH));
		test.info("File is uploaded successfully");
		Assert.assertTrue(up.verifyPhotoUpload(driver, FileConstants.PHOTO_FILE_PATH));
		test.info("VerifyPhotoUpload done successfully");
		
	}
	
  @Test
	
	public void selectMySettings_TC07() throws IOException, InterruptedException
	{
	  	WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		UserMenuDropDownPage up = new UserMenuDropDownPage(driver);
		up.selectUserMenu();
		test.info("Usermenu selected");
		Assert.assertTrue(up.verifyUserMenuItems(), "Failed to verify");
		test.info("UsermenuItems are verified");
		Assert.assertTrue(up.selectUserMenuOption(driver, "My Settings"),"");
		test.info("My Settings option is selected from UsermenuItems");
		CommonUtils.waitForElement(driver,up.mySettings);
		test.info("Waiting for my settings page");
		Assert.assertTrue(up.isMySettingsPageDisplayed(), "Failed to load My Settings Page");
		test.info("My Settings page is displayed successfully");
		up.verifyLoginHistory(driver);
		test.info("Login history is downloaded");
		Assert.assertTrue(up.verifyDisplayAndLayoutLink(driver));
		test.info("Reports tab is added to the main tab");
		Assert.assertTrue(up.verifyEmailSetting(driver,FileUtils.readUserMenuTestData("email.name"),FileUtils.readUserMenuTestData("email.address")));
		test.info("Verification email is sent");
		Assert.assertTrue(up.verifyCalendarandRemainder(driver), "Event pop up window not displayed");
		test.info("VerifyCalendarandRemainder done successfully");
	}
		
	
	//@Test
	
	public void selectDeveloperConsole_TC08() throws IOException, InterruptedException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		UserMenuDropDownPage up = new UserMenuDropDownPage(driver);
		up.selectUserMenu();
		test.info("Usermenu selected");
		Assert.assertTrue(up.verifyUserMenuItems(), "Failed to verify");
		test.info("UsermenuItems verified successfully");
		Assert.assertTrue(up.selectUserMenuOption(driver, "Developer Console"),"");
		test.info("Developer console option selected");
		Assert.assertTrue(up.verifyDeveloperConsole(driver));
		test.info("Developer window functionality verified");
		
	}
	
	//@Test
	
	public void selectLogout_TC09() throws IOException
	{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		UserMenuDropDownPage up = new UserMenuDropDownPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		up.selectUserMenu();
		test.info("Usermenu selected");
		Assert.assertTrue(up.verifyUserMenuItems(), "Failed to verify");
		test.info("Usermenu Items verified");
		Assert.assertTrue(up.selectUserMenuOption(driver, "Logout"),"");
		test.info("Logout option selected");
		Assert.assertTrue(up.verifyLogout(driver),"Failed to verify logout");
		test.info("Logged out successfully");
		
	}
}


