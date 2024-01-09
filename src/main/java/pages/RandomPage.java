package pages;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.CommonUtils;
import utils.FileUtils;

public class RandomPage extends BasePage{
	
	public RandomPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Home")
	public WebElement homeTabLink;
	
	@FindBy(xpath="//div[@class='content']/span/h1/a")
	public WebElement firstNameLastNameLink;
	
	@FindBy(linkText="Hide Feed")
	public WebElement homePage;
	
	@FindBy(xpath="//img[@title='Edit Profile']")
	public WebElement editIcon;
	
	@FindBy(xpath="//div[@class='zen']//div//div//div//ul//li[1]//a[@role='tab']")
	public WebElement aboutTab;
	
	@FindBy(id="contactInfoContentId")
	public WebElement iframeArea;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement emailField;
	
	@FindBy(xpath="//li[@id='aboutTab']/a")
	public WebElement aboutTabLink;
	
	@FindBy(xpath="//input[@id='lastName']")
	public WebElement lastNameField;
	
	@FindBy(xpath="//div[@class='net-buttons zen-mtl']/input[1]")
	public WebElement saveButton;
	
	@FindBy(xpath="//span[@id='tailBreadcrumbNode']")
	public WebElement firstAndLastnameOnTopLeftarea;
	
	@FindBy(xpath="//span[@id='userNavLabel']")
	public WebElement userMenuTab;
	
	@FindBy(linkText="My Profile")
	public WebElement myProfiletab;
	
	@FindBy(xpath="//li[@id='AllTab_Tab']/a/img")
	public WebElement plusButton;
	
	@FindBy(xpath="//div[@class='content']/h1")
	public WebElement allTabsPage;
	
	@FindBy(xpath="//input[@value='Customize My Tabs']")
	public WebElement customizeMyTab;
	
	@FindBy(xpath="//div[@class='content']/h1")
	public WebElement customizeMyTabPage;
	
	@FindBy(xpath="//select[@id='duel_select_1']")
	public WebElement selectedTabDropdown;
	
	@FindBy(xpath="//select[@id='duel_select_0']")
	public WebElement availableTabDropdown;
	
//	@FindBy(xpath="//input[@value=' Save ']")
	@FindBy(name = "save")
	public WebElement saveTabButton;
	
//	@FindBy(xpath="//div[@class='duelingText']")
	@FindBy(className = "leftArrowIcon")
	public WebElement removeButton;
	
	@FindBy(linkText="Assets Tab")
	public WebElement assetTab;
	
	@FindBy(xpath="//span[@class='pageDescription']/a")
	public WebElement currentDateLink;
	
	@FindBy(xpath="//div[@class='content']/h1")
	public WebElement calendarForFirstNameLastnamePage;
	
	@FindBy(xpath="//div[@class='content']/h2")
	public WebElement CalendarNewEventPage;
	
	@FindBy(xpath="//div[@id='p:f:j_id25:j_id61:28:j_id64']/a")
	public WebElement eighpmLink;
	
	@FindBy(xpath="//div[@class='content']/h2")
	public WebElement calendarNewEventPage;
	
	@FindBy(xpath="//img[@class='comboboxIcon']")
	public WebElement subjectComboIcon;
	
	@FindBy(xpath="//li[@class='listItem4']/a")
	public WebElement otherLink;
	
	@FindBy(xpath="//input[@id='EndDateTime_time']")
	public WebElement endTimeField;
	
	@FindBy(xpath="//div[@id='timePickerItem_42']")
	public WebElement ninePMLink;
	
	@FindBy(xpath="//td[@id='topButtonRow']/input[1]")
	public WebElement timeSaveButton;
	
	@FindBy(xpath="//div[@class='multiLineEventBlock dragContentPointer']/span/a")
	public WebElement otherLinkInResultPage;
	
	@FindBy(xpath="//div[@id='p:f:j_id25:j_id61:20:j_id64']/a")
	public WebElement fourPMLink;
	

	@FindBy(xpath="//div[@id='timePickerItem_38']")
	public WebElement sevenPMLink;
	
	@FindBy(xpath="//input[@id='IsRecurrence']")
	public WebElement recurrenceChkbox;
	
	@FindBy(xpath="//input[@id='rectypeftw']")
	public WebElement weeklyRadioButton;
	
	@FindBy(xpath = "//a[@title='Logout']")
	public WebElement logout;
	
	@FindBy(xpath="//input[@id='RecurrenceEndDateOnly']")
	public WebElement recurrenceEndDate;
	
	@FindBy(xpath="//td[@id='topButtonRow']/input[1]")
	public WebElement saveButtonInCalendarPage;
	
	@FindBy(xpath="//img[@class='monthViewIcon']")
	public WebElement monthViewIcon;
	
	@FindBy(xpath="//div[@class='content']/h1")
	public WebElement firstnameLastNameCalViewResultPage;
	
	@FindBy(xpath="//select[@id='duel_select_0']/option[@value='Asset']")
	public WebElement assetTabInAvailableDropdown;
	
	
	
	
	
	public boolean isHomePageOpened()
	{
		return homePage.isDisplayed();
	}
	
	public boolean verifyFirstAndLastnameDisplayed(WebDriver driver) throws IOException
	{
		boolean isFirstAndLastnameDisplayed=false;
		if(homeTabLink.isDisplayed())
		{
			homeTabLink.click();
			Assert.assertTrue(this.isHomePageOpened());
			if(homePage.isDisplayed())
			{
				if(firstNameLastNameLink.getAttribute("href") != null)
				{
				System.out.println("This is a hyperlink");
				}
			}
			 firstNameLastNameLink.click();
			 String currentTitle=driver.getTitle();
			 userMenuTab.click();
			 myProfiletab.click();
			 String profileTitle= driver.getTitle();
			 Assert.assertEquals(currentTitle,profileTitle,"Current title and MyProfile title are not same");
			 isFirstAndLastnameDisplayed=true;
		}
		return isFirstAndLastnameDisplayed;
	}
	
	public boolean verifyLastnameUpdated(WebDriver driver,String lastName)
	{
		boolean isLastnameUpdated=false;
		if(editIcon.isDisplayed())
		{
			editIcon.click();
		}
		CommonUtils.waitForElement(driver,iframeArea);
		driver.switchTo().frame(iframeArea);
		if(emailField.isDisplayed())
		{
			System.out.println("Contact tab is selected");
		}
		
		aboutTabLink.click();
		if(lastNameField.isDisplayed())
		{
			lastNameField.clear();
			lastNameField.sendKeys(lastName);
			saveButton.click();
			
		}
		driver.switchTo().defaultContent();
		CommonUtils.waitForElement(driver,firstAndLastnameOnTopLeftarea);
		if(firstAndLastnameOnTopLeftarea.isDisplayed())
		{
			String[] lname = firstAndLastnameOnTopLeftarea.getText().split(" ");
			Assert.assertEquals(lname[1], lastName);
			String[] uname = userMenuTab.getText().split(" ");
			Assert.assertEquals(uname[1], lastName);
			 isLastnameUpdated=true;
		}
		return  isLastnameUpdated;
			
	}
	
	public boolean isAllTabPageOpened()
	{
		return  allTabsPage.isDisplayed();
	}
	
	public boolean verifyCustomizeTab(WebDriver driver) throws InterruptedException
	{
		if(plusButton.isDisplayed())
		{
			plusButton.click();
		}
		Assert.assertTrue(isAllTabPageOpened(),"Failed to open allTabPage");
		if(customizeMyTab.isDisplayed())
		{
			customizeMyTab.click();
			String mainWindow = driver.getWindowHandle();
			
			CommonUtils.waitForElement(driver, customizeMyTabPage);
			Select select = new Select(selectedTabDropdown);
			select.selectByVisibleText("Assets");
			removeButton.click();
		    Thread.sleep(3000);

			//driver.switchTo().window(mainWindow);
			
			Select select1 = new Select(availableTabDropdown);
			List<WebElement> allOptions = select1.getOptions();
			List<String> availableOptions = allOptions.stream().map(option -> option.getText()).toList();
			Assert.assertTrue(availableOptions.contains("Assets"));
			driver.switchTo().window(mainWindow);
			saveTabButton.click();
			
			try {
				assetTab.isDisplayed();
				return false;
			} catch (NoSuchElementException e) {
				// Confirms that the asset tab is not present.
				return true;
			}
		}
		return false;
	}
	
	public boolean verifyTabOptionNotPresent(WebDriver driver, String tabOption) {
		try {
			return !(driver.findElement(By.linkText(tabOption)).isDisplayed());
		} catch (NoSuchElementException e) {
			return true;
		}
	}
	
	public boolean verifyBlockEventInCalendar(WebDriver driver)
	{
		boolean isEventRemainderSet=false;
		if(homeTabLink.isDisplayed())
		{
			homeTabLink.click();
			Assert.assertTrue(this.isHomePageOpened());
			currentDateLink.click();
			if(eighpmLink.isDisplayed())
			{
				eighpmLink.click();
				CommonUtils.waitForElement(driver,calendarNewEventPage);
			}
				if(subjectComboIcon.isDisplayed())
				{
					subjectComboIcon.click();
					String oldWindow = driver.getWindowHandle();
					Set<String> getAllWindows = driver.getWindowHandles();
					String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
					driver.switchTo().window(getWindow[1]);
					driver.manage().window().maximize();
					otherLink.click();
					driver.switchTo().window(oldWindow);
				}
					if(endTimeField.isDisplayed())
					{
						endTimeField.click();
						ninePMLink.click();
						timeSaveButton.click();
						if(otherLinkInResultPage.isDisplayed())
						{
						isEventRemainderSet=true;
						}
					if(otherLinkInResultPage.getAttribute("href")!=null)
					{
						System.out.println("It is a hyperlink");
					}
						
					}
					}
		return isEventRemainderSet;
	}
	
	public void verifyEventBlockWithWeeklyRecurrance(WebDriver driver) {
		Assert.assertTrue(homeTabLink.isDisplayed());
		homeTabLink.click();
		Assert.assertTrue(this.isHomePageOpened());
		currentDateLink.click();
		Assert.assertTrue(calendarForFirstNameLastnamePage.isDisplayed());
		fourPMLink.click();
			
			
		Assert.assertTrue(calendarNewEventPage.isDisplayed());
		subjectComboIcon.click();
		 
		String oldWindow = driver.getWindowHandle();
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getWindow[1]);
		otherLink.click();
		driver.switchTo().window(oldWindow);
		Assert.assertTrue(endTimeField.isDisplayed());
		
		endTimeField.click();
		sevenPMLink.click();
		recurrenceChkbox.click();
		Assert.assertTrue(weeklyRadioButton.isDisplayed());
			
		weeklyRadioButton.click();
			 
		String timeFormat = "MM/dd/yyyy";
		String startTime = CommonUtils.getDatePlusN(0, timeFormat);
		String endTime = CommonUtils.getDatePlusN(14, timeFormat);
		
		recurrenceEndDate.sendKeys(endTime);
		saveButtonInCalendarPage.click();
		
		monthViewIcon.click();
		Assert.assertTrue(firstnameLastNameCalViewResultPage.isDisplayed());
		
		//Validating the calendar view
		String midweek = CommonUtils.getDatePlusN(7, "M/d/yyyy");
		String midweekIdentifier = String.format("//*[@title='Day View - %s']", midweek);
		
		WebElement midweekElement = driver.findElement(By.xpath(midweekIdentifier));
		WebElement parent = midweekElement.findElement(By.xpath(".."));
		WebElement calDayEvent = parent.findElement(By.xpath("following-sibling::*"));
		List<WebElement> childElements = calDayEvent.findElements(By.xpath("*"));
		
		System.out.println("###########################");
		System.out.println(childElements);
		for (WebElement element: childElements) {
			WebElement event = element.findElement(By.xpath("//span[@class='event']"));
			System.out.println(event.getText());
			WebElement eventNameLink = element.findElement(By.xpath("//a"));
			System.out.println(element.findElements(By.xpath("//a")).size());
			System.out.println(eventNameLink);
			System.out.println(eventNameLink.getText());
		}
		Assert.assertTrue(childElements.stream().anyMatch(element -> element.getAccessibleName().equals("Other")));
		System.out.println("###########################");
	}

}
