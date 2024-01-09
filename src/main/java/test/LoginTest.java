package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listners.SFDCListeners;
import pages.LoginPage;
import utils.FileUtils;

@Listeners(SFDCListeners.class)
public class LoginTest extends BaseTest {
	
	
	
	//@Test(enabled=true, groups = "smoke")
	public void errorMessage_TC01() throws IOException
	{
		WebDriver driver = BaseTest.getBrowserType("chrome");
		LoginPage lp = new LoginPage(driver);
		driver.get(FileUtils.readLoginTestData("prod.app.url"));
		test.info("Launching the url");
		Assert.assertEquals(lp.isLoginPageOpened(driver),FileUtils.readLoginTestData("loginPage.title"));
		test.info("Login page displayed");
		lp.enterUsername(FileUtils.readLoginTestData("prod.username"));
		test.info("Username entered");
		lp.password.clear();
		test.info("Password field cleared");
		lp.clickLoginButton();
		test.info("Login button is clicked");
		String message = lp.errorMessage.getText();
		System.out.println(message);
		Assert.assertEquals(message, FileUtils.readLoginTestData("err.message"),"Error message not displayed as expected");
		test.info("Verified error message");
	}
	//@Test(enabled=true, groups = "smoke")
	public void login_TC02() throws IOException
	{
		WebDriver driver = BaseTest.getBrowserType("chrome");
		LoginPage lp = new LoginPage(driver);
		driver.get(FileUtils.readLoginTestData("prod.app.url"));
		test.info("Launching the url");
		Assert.assertEquals(lp.isLoginPageOpened(driver),FileUtils.readLoginTestData("loginPage.title"));
		test.info("Login page displayed");
		lp.username.sendKeys(FileUtils.readLoginTestData("prod.username"));
		test.info("Username entered");
		lp.password.sendKeys(FileUtils.readLoginTestData("prod.password"));
		test.info("Password entered");
		lp.clickLoginButton();
		test.info("Login button clicked");
		Assert.assertEquals(lp.isHomePageOpened(driver),FileUtils.readLoginTestData("homePage.title"));
		test.info("Home page displayed");
	}
	
	@Test
	
	public void checkRememberMe_TC03() throws IOException, InterruptedException
	{
		WebDriver driver = BaseTest.getBrowserType("chrome");
		LoginPage lp = new LoginPage(driver);
		driver.get(FileUtils.readLoginTestData("prod.app.url"));
		test.info("Launching the url");
		Assert.assertEquals(lp.isLoginPageOpened(driver),FileUtils.readLoginTestData("loginPage.title"));
		test.info("Login page displayed");
		lp.enterUsername(FileUtils.readLoginTestData("prod.username"));
		test.info("Correct username entered");
		lp.enterPassword(FileUtils.readLoginTestData("prod.password"));
		test.info("Correct password entered");
		Assert.assertEquals(lp.getUsername(),FileUtils.readLoginTestData("prod.username"));
		Assert.assertNotNull(lp.getPassword());
		lp.selectrememberMeCheckBox();
		test.info("Checkbox selected");
		lp.clickLoginButton();
		test.info("Login button clicked");
		Assert.assertEquals(lp.isHomePageOpened(driver),FileUtils.readLoginTestData("homePage.title"));
		test.info("Home page displayed");
		lp.clickUserMenu();
		test.info("Usermenu selected");
		lp.clickLogout();
		test.info("Logout selected");
		Thread.sleep(3000);
		Assert.assertEquals(lp.isLoginPageOpened(driver),FileUtils.readLoginTestData("loginPage.title"));
		test.info("Logged out successfully");
		String userfield = driver.findElement(By.id("username")).getAttribute("value");
		System.out.println(userfield);
		Assert.assertEquals(userfield, FileUtils.readLoginTestData("prod.username"),"Username is same as typed");
		if(!userfield.isEmpty() && lp.rememberMe.isSelected())
		{
			System.out.println("Username is populated and checkbox is selected");
		}
		else
		{
			System.out.println("Username and checkbox has to be selected after logout");
		}
	}
	
	//@Test
	
	public void clickForgotPassword_TC04A() throws IOException
	{
		WebDriver driver = BaseTest.getBrowserType("chrome");
		LoginPage lp = new LoginPage(driver);
		driver.get(FileUtils.readLoginTestData("prod.app.url"));
		test.info("Launching the url");
		Assert.assertEquals(lp.isLoginPageOpened(driver),FileUtils.readLoginTestData("loginPage.title"));
		test.info("Login page displayed");
		lp.clickForgotPassword();
		test.info("Forgot password option selected");
		Assert.assertEquals(lp.isForgotPasswordPageOpened(driver),FileUtils.readLoginTestData("forgotPasswordPage.title"));
		test.info("Password reset page displayed");
		lp.enterUsernameToResetPassword(FileUtils.readLoginTestData("prod.username"));
		test.info("Username entered ");
		lp.clickContinue();
		Assert.assertEquals(lp.isPasswordResetMessagePageOpened(driver),FileUtils.readLoginTestData("passwordResetMessagePage.title"));
		test.info("Verification email for resetting password is sent");
	}
	
	//@Test
    public void invalidLogin_TC04B() throws IOException, InterruptedException
    {
		WebDriver driver = BaseTest.getBrowserType("chrome");
		LoginPage lp = new LoginPage(driver);
		driver.get(FileUtils.readLoginTestData("prod.app.url"));
		test.info("Launching the url");
		Assert.assertEquals(lp.isLoginPageOpened(driver),FileUtils.readLoginTestData("loginPage.title"));
		test.info("Login page displayed");
		lp.enterUsername(FileUtils.readLoginTestData("invalid.username"));
		test.info("Incorrect username entered");
		lp.enterPassword(FileUtils.readLoginTestData("invalid.password"));
		test.info("Incorret password entered");
		Thread.sleep(3000);
		//Assert.assertEquals(lp.getUsername(),FileUtils.readLoginTestData("invalid.username"));
		//Assert.assertNotNull(lp.getPassword());
		lp.clickLoginButton();
		Assert.assertEquals(lp.getLoginErrorText(), FileUtils.readLoginTestData("error.message"),"Error message not displayed as expected");
		test.info("Verified error message successfully");
    }
}
