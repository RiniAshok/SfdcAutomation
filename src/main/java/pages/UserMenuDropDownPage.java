package pages;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.CommonUtils;
import utils.FileUtils;

public class UserMenuDropDownPage extends BasePage{
	
	public UserMenuDropDownPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="userNavLabel")
	public WebElement usermenu;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;
	
	@FindBy(xpath="//a[@title='My Profile']")
	public WebElement myProfile;
	@FindBy(id="profileTab_sfdc.ProfilePlatformFeed")
	public WebElement myProfilePage;

	@FindBy(xpath="//img[@title='Edit Profile']")
	public WebElement editIcon;
	
	@FindBy(xpath="//div[@class='zen']//div//div//div//ul//li[1]//a[@role='tab']")
	public WebElement aboutTab;
	
	@FindBy(id="contactInfoContentId")
	public WebElement iframeAbouttab;
	
	@FindBy(id="tailBreadcrumbNode")
	public WebElement userProfilePageNamedisplay;
	
	@FindBy(xpath="//li[@id='contactTab']/a")
	public WebElement contactTab;
	
	@FindBy(name="lastName")
	public WebElement lastNameTab;
	
	@FindBy(xpath="//div[@class='net-buttons zen-mtl']/input[1]")
	public WebElement saveButton;
	
	@FindBy(xpath="//a[@title='Post']//span[1]")
	public WebElement postLink;
	
	@FindBy(xpath="//body[@contenteditable='true']")
	public WebElement postTextArea;
	
	@FindBy(xpath="//div[@class='bottomBar']//div[1]//span//input")
	public WebElement shareButton;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, publisherRichTextEditor']")
	public WebElement iframe;
	
	@FindBy(xpath="//*[@id='publisherAttachContentPost']")
	public WebElement fileLink;
	
	@FindBy(xpath="//a[@id='chatterUploadFileAction']")
	public WebElement upLoadFile;
	
	@FindBy(xpath="//input[@id='chatterFile']")
	public WebElement chooseFileTab;
	
	@FindBy(xpath="//*[@class='zen-btn']")
	public WebElement cancelUpload;
	
	@FindBy(xpath="(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;
	
	@FindBy(id="displayBadge")
	public WebElement moderatorButton;
	
	@FindBy(xpath="//div[@class='photoUploadSection']/a")
	public WebElement photoUploadButton;
	
	@FindBy(xpath="//iframe[@id='uploadPhotoContentId']")
	public WebElement uploadPhotoIframe;
	
	@FindBy(xpath="//input[@class='fileInput']")
	public WebElement chooseFileButton;
	
	@FindBy(xpath="//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveButton;
	
	@FindBy(id="j_id0:waitingForm")
	public WebElement spinningIcon;
	
	@FindBy(id="j_id0:j_id7:save")
	public WebElement photoSaveButton2;
	
	@FindBy(id="cropWaitingPage:croppingForm")
	public WebElement spinnerWhileCropping;
	
	@FindBy(xpath="//a[@title='My Settings']")
	public WebElement mySettings;
	
	@FindBy(xpath="//a[@class='setupSection']")
	public WebElement mySettingsPage;
	
	@FindBy(id="PersonalInfo")
	public WebElement myPersonalLink;
	
	@FindBy(xpath="//a[@id='LoginHistory_font']")
	public WebElement loginHistoryLink;
	
	@FindBy(xpath="//div[@class='pShowMore']/a")
	public WebElement downloadHistoryLink;
	
	@FindBy(id="RelatedUserLoginHistoryList_title")
	public WebElement loginHistoryPage;
	
	@FindBy(id="DisplayAndLayout_font")
	public WebElement displayAndLayoutLink;
	
	@FindBy(xpath="//a[@id='CustomizeTabs_font']")
	public WebElement customizeMyTab;
	
	@FindBy(xpath="//select[@id='p4']")
	public WebElement customContentAppdropdown;
	
	@FindBy(xpath="//select[@id='duel_select_0']")
	public WebElement availableTabDropdown;
	
	@FindBy(className="rightArrowIcon")
	public WebElement rightArrowButton;
	
	@FindBy(xpath="//img[@class='leftArrowIcon']")
	public WebElement leftArrowButton;
	
	@FindBy(name = "save")
	public WebElement customizeTabSaveButton;
	
	@FindBy(id="duel_select_1")
    public WebElement selectedTabDropdown;
	
	@FindBy(xpath="//select[@id='duel_select_1']/option[@value='report']")
	public WebElement reportTab;
	
	@FindBy(xpath="//li[@id='report_Tab']")
	public WebElement reportTabOnMenu;
	
	@FindBy(xpath="//div[@id='EmailSetup']/a")
	public WebElement emailLink;
	
	@FindBy(xpath="//span[@id='EmailSettings_font']")
	public WebElement myEmailSettingTab;
	
	@FindBy(xpath="//input[@id='sender_name']")
	public WebElement emailNameField;
	
	@FindBy(xpath="//input[@id='sender_email']")
	public WebElement emailAddressField;
	
	@FindBy(xpath="//input[@id='auto_bcc1']")
	public WebElement automaticBccRadioButton;
	
	@FindBy(xpath="//input[@class='btn primary']")
	public WebElement emailPageSaveButton;
	
	@FindBy(xpath="//div[@id='meSaveCompleteMessage']")
	public WebElement mySettingConfirmationPage;
	
	@FindBy(xpath="//span[@id='CalendarAndReminders_font']")
	public WebElement calendarAndRemainderLink;
	
	@FindBy(xpath="//div[@class='setupLeaf']/a[@id='Reminders_font']")
	public WebElement activityRemainderLink;
	
	@FindBy(xpath="//input[@id='testbtn']")
	public WebElement openTestReminderButton;
	
	@FindBy(xpath="//div[@class='home']")
	public WebElement eventPopWindow;
	
	@FindBy(xpath="//a[@title='Developer Console (New Window)']")
	public WebElement developerConsoleLink;
	
	@FindBy(xpath="//div[@id='editors-body']")
	public WebElement consoleWindow;
	
	@FindBy(xpath="//a[@title='Logout']")
	public WebElement logoutLink;
	
	@FindBy(xpath="//div[@id='contentWrapper'][1]")
	public WebElement rightClick;
	
	
	/**
	 * @return true if all options are verified else false
	 * @throws IOException
	 */
	public boolean verifyUserMenuItems() throws IOException
	{
		boolean isAllOptionsVerified= true;
		String[] expectedUserMenuItems = FileUtils.readUserMenuTestData("usermenu.items").split(",");
	
	for(int i=0; i<expectedUserMenuItems.length; i++)
	{
	String actualOption = userMenuOptions.get(i).getText();	
	if(actualOption.equals(expectedUserMenuItems[i]))
		{
			System.out.println("UserMenuPage : verifyUserMenuItems : Expected option: "+expectedUserMenuItems[i]+" Actual option: "+actualOption);
		
		}
	else
		{
		System.out.println("Expected option: "+expectedUserMenuItems[i]+ " Actual option: "+actualOption);
		isAllOptionsVerified = false;
		}
	
	}
	return isAllOptionsVerified;
	}
	
	public boolean selectUserMenuOption(WebDriver driver, String option)
	{
		boolean isOptionSelected = false;
		WebElement userMenuOptions = driver.findElement(By.xpath("//*[text()='"+option+"']"));
	   if(CommonUtils.waitForElement(driver, userMenuOptions))
	   {
		userMenuOptions.click();
		isOptionSelected = true;
	   }
	   
	   return isOptionSelected;
	}
	
	public void selectUserMenu()
	{
		if(usermenu.isDisplayed())
		{
			usermenu.click();
		}
	}
	
	public boolean isMyProfilePageDisplayed()
	{
		return myProfilePage.isDisplayed();
		
		
	}
	public void clickEditIcon(WebDriver driver)
	{
		if(CommonUtils.waitForElement(driver, editIcon))
		if(editIcon.isDisplayed())
		{
			editIcon.click();
		}
		else
		{
			logger.error("UsermenuPage : editIcon : element not found");
		}
	}
	
	public boolean verifyEditContactIframe(WebDriver driver)
	{
		logger.info("UsermenuPage : verify editContactIframe : started");
		boolean isIframeLoaded=false;
		if(CommonUtils.waitForElement(driver, iframeAbouttab))
				{
					driver.switchTo().frame(iframeAbouttab);
					if(aboutTab.isDisplayed() && contactTab.isDisplayed())
					{
						isIframeLoaded=true;
					}
				}
		return isIframeLoaded;
	}
 
	
	
	public boolean verifyLastnameChangeInAboutTab(WebDriver driver, String lastname)
	{
		logger.info("UsermenuPage : verify lastname change : started");
		boolean isLastnameChanged = false;
		if(aboutTab.isDisplayed())
		{
			aboutTab.click();
			lastNameTab.clear();
			lastNameTab.sendKeys(lastname);
			saveButton.click();
			driver.switchTo().parentFrame();
			if(userProfilePageNamedisplay.isDisplayed())
			{
				String actualName= userProfilePageNamedisplay.getText();
				if(actualName.contains(lastname))
				{
					isLastnameChanged = true;
				}
				else
				{
					logger.error("UsermenuPage : lastname : lastname not changed");
				}
			}
			
			
		}
		return isLastnameChanged;
		
	}
	
	public boolean verifyCreatePost(WebDriver driver,String message)
	{
		logger.info("UsermenuPage : verify createPost : started");
		boolean isPostCreated=false;
		CommonUtils.waitForElement(driver, postLink);
		if(postLink.isDisplayed())
		{
			postLink.click();
			driver.switchTo().frame(0);
			postTextArea.sendKeys(message);
			driver.switchTo().defaultContent();
			if(shareButton.isDisplayed())
			{
				shareButton.click();
				isPostCreated=true;
			}
			}
		return isPostCreated;
	}
	
	public boolean verifyFileUpload(WebDriver driver,String filePath) throws InterruptedException
	{
		logger.info("UsermenuPage : verify fileUpload : started");
		boolean isFileUploadSuccess=false;
		if(fileLink.isDisplayed())
		{
			Thread.sleep(3000);
			fileLink.click();
			if(CommonUtils.waitForElement(driver, upLoadFile))
			{
				upLoadFile.click();
			}
			if(CommonUtils.waitForElement(driver, chooseFileTab))
			{
				chooseFileTab.sendKeys(filePath);
				shareButton.click();
				if(CommonUtils.waitForElementToDisappear(driver,cancelUpload))
				{
					if(verifyFilePostElement.isDisplayed())
					{
						isFileUploadSuccess=true;
					}
				}
				
			}
			
		}
		return isFileUploadSuccess;
		
	}
	
	public void clickOnUpdatePhotoButton(WebDriver driver)
	{
		CommonUtils.mouseHover(driver, moderatorButton);
		
		Assert.assertTrue(photoUploadButton.isDisplayed());
		
		photoUploadButton.click();
		
	}
	
	public boolean verifyPhotoUpload(WebDriver driver, String photoFilePath) throws InterruptedException
	{
		logger.info("UsermenuPage : verify PhotoUpload: started");
		boolean isPhotoUploaded=false;
		this.clickOnUpdatePhotoButton(driver);
		Thread.sleep(3000);
		driver.switchTo().frame("uploadPhotoContentId");
		if(CommonUtils.waitForElement(driver, chooseFileButton))
		{
			chooseFileButton.sendKeys(photoFilePath);
			photoSaveButton.click();
		}
			if(CommonUtils.waitForElementToDisappear(driver, spinningIcon) && CommonUtils.waitForElement(driver,photoSaveButton2))
			{
				photoSaveButton2.click();
			}
			if(CommonUtils.waitForElementToDisappear(driver, spinnerWhileCropping))
			{
				isPhotoUploaded=true;
			}
			
		driver.switchTo().parentFrame();
		return isPhotoUploaded;
	}
	
	public boolean isMySettingsPageDisplayed()
	{
		return mySettingsPage.isDisplayed();
	}
	
	public boolean verifyLoginHistory(WebDriver driver)
	{
		logger.info("UsermenuPage : verify login history : started");
		boolean isLoginHistoryShown=false;
		if(myPersonalLink.isDisplayed())
		{
			myPersonalLink.click();
			if(loginHistoryLink.isDisplayed())
			{
				loginHistoryLink.click();
			}
			if(downloadHistoryLink.isDisplayed())
			{
				downloadHistoryLink.click();
			}
			CommonUtils.waitForElement(driver, loginHistoryPage);
			isLoginHistoryShown=true;
		}
		
		return isLoginHistoryShown;
	}
	
	public boolean verifyDisplayAndLayoutLink(WebDriver driver)
	{
		logger.info("UsermenuPage : verify display and layout : started");
		boolean isReportFieldAdded=false;
		if(displayAndLayoutLink.isDisplayed())
		{
			displayAndLayoutLink.click();
		}
		if(customizeMyTab.isDisplayed())
		{
			customizeMyTab.click();
		}
		CommonUtils.waitForElement(driver, customContentAppdropdown);
		Select select= new Select(customContentAppdropdown);
		select.selectByVisibleText("Salesforce Chatter");
		
		Select selectTab= new Select(availableTabDropdown);
		selectTab.selectByVisibleText("Reports");
		rightArrowButton.click();
		//CommonUtils.waitForElement(driver, reportTab);
 	   // Assert.assertTrue(reportTab.isDisplayed());
		customizeTabSaveButton.click();
		driver.navigate().refresh();
		CommonUtils.waitForElement(driver,reportTabOnMenu);
		Actions action = new Actions(driver);
		action.contextClick(rightClick).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		Assert.assertTrue(reportTabOnMenu.isDisplayed());
			
		isReportFieldAdded=true;
			
		this.unselectingReports(driver);
		action.contextClick(rightClick).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		return isReportFieldAdded;
		
	}
	
	public boolean unselectingReports(WebDriver driver)
	{
		logger.info("UsermenuPage : unselectingReports : started");
		boolean isReportsRemoved=false;
		if(displayAndLayoutLink.isDisplayed())
		{
			displayAndLayoutLink.click();
		}
		if(customizeMyTab.isDisplayed())
		{
			customizeMyTab.click();
		}
		
		Select select = new Select(selectedTabDropdown);
		select.selectByVisibleText("Reports");
		leftArrowButton.click();
		customizeTabSaveButton.click();
		driver.navigate().refresh();
		isReportsRemoved=true;
		
		return isReportsRemoved;
		
		
	}
	
	public boolean verifyEmailSetting(WebDriver driver,String emailName,String emailAddress)
	{
		logger.info("UsermenuPage : verify email setting : started");
		boolean isEmailSettingDone=false;
		if(emailLink.isDisplayed())
		{
			emailLink.click();
			if(myEmailSettingTab.isDisplayed())
			{
				myEmailSettingTab.click();
			}
		}
		if(emailNameField.isDisplayed())
		{
			emailNameField.clear();
			emailNameField.sendKeys(emailName);
			emailAddressField.clear();
			emailAddressField.sendKeys(emailAddress);
			automaticBccRadioButton.click();
			emailPageSaveButton.click();
			
		}
		if(mySettingConfirmationPage.isDisplayed())
		{
			isEmailSettingDone=true;
		}
		return isEmailSettingDone;
		
	}
	
	public boolean verifyCalendarandRemainder(WebDriver driver) throws InterruptedException
	{
		logger.info("UsermenuPage : verify calendar and Remainder : started");
		
		boolean isPopUpWindowDisplayed=false;
		if(calendarAndRemainderLink.isDisplayed())
		{
			calendarAndRemainderLink.click();
			if(activityRemainderLink.isDisplayed())
			{
				activityRemainderLink.click();
			}
		}
		if(openTestReminderButton.isDisplayed())
		{
			openTestReminderButton.click();
		}
		Thread.sleep(3000);
		String oldWindow= driver.getWindowHandle();
		Set<String> getAllWindows=driver.getWindowHandles();
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getWindow[1]);
		CommonUtils.waitForElement(driver,eventPopWindow);
		if(eventPopWindow.isDisplayed())
		{
			isPopUpWindowDisplayed=true;
			driver.switchTo().window(oldWindow);
		}
		return isPopUpWindowDisplayed;
		
	}
	
	public boolean verifyDeveloperConsole(WebDriver driver) throws InterruptedException
	{
		logger.info("UsermenuPage : verify developerConsole : started");
		
		boolean isConsoleWindowDisplayed=false;
		String oldWindow= driver.getWindowHandle();
		Set<String> getAllWindows=driver.getWindowHandles();
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getWindow[getAllWindows.size()-1]);
		CommonUtils.waitForElement(driver,consoleWindow);
		if(consoleWindow.isDisplayed())
		{
			isConsoleWindowDisplayed=true;
			
		}
		Thread.sleep(3000);
		driver.switchTo().window(oldWindow);
		return isConsoleWindowDisplayed;
	}
	
	public boolean verifyLogout(WebDriver driver) throws IOException
	{
		logger.info("UsermenuPage : verify logout : started");
		boolean isLoggedOut=false;
		String title = driver.getTitle();
		if(title.equals(FileUtils.readLoginTestData("loginPage.title")))
		{
			isLoggedOut=true;
		}
		return isLoggedOut;
		
				
				
	}
	
	
	
	
}
