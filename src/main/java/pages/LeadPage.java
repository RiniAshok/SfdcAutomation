package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.CommonUtils;
import utils.FileUtils;

public class LeadPage extends BasePage{
	
	public LeadPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(linkText="Leads")
	public WebElement leadTabLink;
	
	@FindBy(xpath="//select[@id='fcf']/option")
	public List<WebElement> leadViewDropdown;
	
	@FindBy(xpath="//select[@id='fcf']")
	public WebElement dropdownField;
	
	@FindBy(xpath="//input[@value=' Go! ']")
	public WebElement leadGoButton;
	
	@FindBy(xpath="//input[@value='New Lead']")
	public WebElement todaysLeadPage;
	
	@FindBy(xpath="//input[@value=' New ']")
	public WebElement newButton;
	
	@FindBy(xpath="//div[@class='content']/h2")
	public WebElement newLeadPage;
	
	@FindBy(xpath="//input[@id='name_lastlea2']")
	public WebElement lastnameField;
	
	@FindBy(xpath="//input[@id='lea3']")
	public WebElement companyNameField;
	
	@FindBy(xpath="//td[@id='topButtonRow']/input[1]")
	public WebElement saveButton;
	
	@FindBy(xpath="//*[@id=\"ep\"]/div[1]/table/tbody/tr/td[1]/h2")
	public WebElement newLeadDetailPage;
	
	@FindBy(xpath="//select[@class='title']/option[@selected]")
	public WebElement finalDefaultLeadViewPage;
	
	@FindBy(xpath="//div[@id='userNavButton']")
	public WebElement userMenuTab;
	
	@FindBy(linkText="Logout")
	public WebElement logoutLink;
	
	public String isLeadHomePageDispalyed(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public void clickLeadTab(WebDriver driver)
	{
		if(leadTabLink.isDisplayed())
		{
		leadTabLink.click();
		}
		else
		{
			System.out.println("leadTab Element not found");
		}
		
	}
	
	public boolean verifyLeadDropdown(WebDriver driver) throws IOException
	{
		boolean isAllOptionsVerified=true;
		String[] expectedItem = FileUtils.readLeadTestData("lead.dropdownOption").split(",");
		for(int i=0; i<expectedItem.length;i++)
		{
			String actualOption = leadViewDropdown.get(i).getText();
			if(actualOption.equals(expectedItem[i]))
			{
				System.out.println("LeadPage : verifyLeadDropdown : Expected option :"+expectedItem[i] +" Actual option: "+actualOption);
			}
			else
			{
				System.out.println("Expected :"+expectedItem[i]+" Actual :"+actualOption);
				isAllOptionsVerified=false;
			}
		}
		return isAllOptionsVerified;
	}
	
	public boolean verifyTodaysLeadDropdown(WebDriver driver)
	{
		boolean isTodaysLeadPageDisplayed=false;
		if(dropdownField.isDisplayed())
		{
			Select select = new Select(dropdownField);
			select.selectByVisibleText("Today's Leads");
			if(leadGoButton.isDisplayed())
			{
			leadGoButton.click();
			}
			if(todaysLeadPage.isDisplayed())
			{
				isTodaysLeadPageDisplayed=true;
			}
		}
		return isTodaysLeadPageDisplayed;
		
	}
	
	public boolean verifyDefaultViewInLeadDropdown(WebDriver driver) throws IOException
	{

		boolean isDefaultViewDisplayed=false;
		if(dropdownField.isDisplayed())
		{
			Select select = new Select(dropdownField);
			select.selectByVisibleText("My Unread Leads");
			leadGoButton.click();
			userMenuTab.click();
			logoutLink.click();
		}
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(driver);
		this.clickLeadTab(driver);
		Assert.assertEquals(this.isLeadHomePageDispalyed(driver),FileUtils.readLeadTestData("lead.homePage.title"));
		leadGoButton.click();
		if(finalDefaultLeadViewPage.isDisplayed())
		{
			Assert.assertEquals(finalDefaultLeadViewPage.getText(),"My Unread Leads", "Expected and actual are not same");
			isDefaultViewDisplayed=true;
		}
		return isDefaultViewDisplayed;
	}
	
	public boolean isNewLeadPageOpened()
	{
		return newLeadPage.isDisplayed();
	}
	
	public boolean verifyCreateNewLead(WebDriver driver) throws IOException
	{
		boolean isNewLeadCreated=false;
		newButton.click();
		Assert.assertTrue(this.isNewLeadPageOpened(),"Failed to open new lead page");
		if(lastnameField.isDisplayed())
		{
			lastnameField.sendKeys(FileUtils.readLeadTestData("lead.lastName"));
			companyNameField.sendKeys(FileUtils.readLeadTestData("lead.companyName"));
			saveButton.click();
		}
		CommonUtils.waitForElement(driver,newLeadDetailPage);
		if(newLeadDetailPage.isDisplayed())
		{
			isNewLeadCreated=true;
		}
		return isNewLeadCreated;
	}

}
