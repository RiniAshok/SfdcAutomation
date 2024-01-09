package pages;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.CommonUtils;
import utils.FileUtils;

public class CreateOpportunityPage extends BasePage{
	
	public CreateOpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//li[@id='Opportunity_Tab']/a")
	public WebElement opportunityTab;
	
	@FindBy(xpath="//h1[@class='pageType']")
	public WebElement opportunityHomePage;
	
	@FindBy(xpath="//select[@id='fcf']/option")
	public List<WebElement> opportunityDropdownItems;
	
	@FindBy(xpath="//input[@value=' New ']")
	public WebElement newButton;
	
	@FindBy(xpath="//div[@class='content']/h2")
	public WebElement newOpportunityEditPage;
	
	@FindBy(xpath="//input[@id='opp3']")
	public WebElement opportunityNameField;
	
	@FindBy(xpath="//span[@class='lookupInput']/a")
	public WebElement opportunityAccountNameFieldIcon;
	
	@FindBy(xpath="//input[@id='opp9']")
	public WebElement closeDateField;
	
	@FindBy(xpath="//div[@class='buttonBar']/a")
	public WebElement todayButtonInDateField;
	
	@FindBy(xpath="//select[@id='opp11']")
	public WebElement stageSelectField;
	
	@FindBy(xpath="//select[@id='opp6']")
	public WebElement leadSourceSelectField;
	
	@FindBy(xpath="//input[@id='opp17']")
	public WebElement primaryCampaignSourceField;
	
	@FindBy(xpath="//td[@id='bottomButtonRow']/input[1]")
	public WebElement saveButtonInNewOpportunityPage;
	
	@FindBy(xpath="//input[@id='lksrch']")
	public WebElement lookUpSearchField;
	
	@FindBy(xpath="//input[@value=' Go! ']")
	public WebElement goButton;
	
	@FindBy(xpath="//h2[text()='Opportunity Detail']")
	public WebElement newOpportunityDetailsDisplayPage;
	
	@FindBy(xpath="//tr[@class='dataRow even first']/th/a")
	public WebElement opportunityAccountLookupName;
	
	@FindBy(linkText="Opportunity Pipeline")
	public WebElement opportunityPipelineLink;
	
	@FindBy(xpath="//div[@class='content']/h1")
	public WebElement opportunityPipelineDisplayPage;
	
	@FindBy(linkText="Stuck Opportunities")
	public WebElement stuckOpportunityLink;
	
	@FindBy(xpath="//div[@class='content']/h1")
	public WebElement stuckOpportunityDisplayPage;
	
	@FindBy(xpath="//select[@id='quarter_q']")
	public WebElement quarterlySummaryIntervalDropdowns;
	
	@FindBy(xpath="//select[@id='open']")
	public WebElement quarterlysummaryIncludeDropdowns;
	
	@FindBy(xpath="//input[@value='Run Report']")
	public WebElement runReportButton;
	
	@FindBy(xpath="//div[@id='status']")
	public WebElement summaryPage;
	
	
	public void selectOpportunity()
	{
		if(opportunityTab.isDisplayed())
		{
			opportunityTab.click();
		}
	}
	
	public boolean isOpportunityHomePageDisplayed()
	{
		return opportunityHomePage.isDisplayed();
	}
	
	public boolean isNewOpportunityeditPageOpened()
	{
		
		return newOpportunityEditPage.isDisplayed();
		
	}
	
	public boolean verifyOpportunityDropdownItems() throws IOException
	{
		boolean isAllOptionsVerified=true;
		String[] expectedItems = FileUtils.readCreateOpportunityTestData("opportunity.items").split(",");
		
		for(int i=0; i<expectedItems.length;i++)
		{
			String actualOption = opportunityDropdownItems.get(i).getText();
			if(actualOption.equals(expectedItems[i]))
			{
				System.out.println("OpportunityPage  : verifyOpportunitydropdown : Expected option : "+expectedItems[i]+" Actual option: "+actualOption);
			}
			else
			{
				System.out.println("Expected option: "+expectedItems[i]+ " Actual option: "+actualOption);
				isAllOptionsVerified=false;
			}
		
		}
		return isAllOptionsVerified;
	}
	
	public boolean verifyCreateNewOpportunity(WebDriver driver,String opportunityName,String accountName)
	{
		boolean isNewOpportunityCreated=false;
		newButton.click();
		CommonUtils.waitForElement(driver, newOpportunityEditPage);
		Assert.assertTrue(this.isNewOpportunityeditPageOpened(),"Failed to open new opportunity edit page");
		if(opportunityNameField.isDisplayed())
		{
			opportunityNameField.sendKeys(opportunityName);
			opportunityAccountNameFieldIcon.click();
			
			String oldWindow = driver.getWindowHandle();
			Set<String> getAllWindows = driver.getWindowHandles();
			String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
			driver.switchTo().window(getWindow[1]);
			driver.switchTo().frame("searchFrame");
			if(lookUpSearchField.isDisplayed())
			{
				lookUpSearchField.sendKeys(accountName);
				goButton.click();
			}
			driver.switchTo().defaultContent();
			driver.switchTo().frame("resultsFrame");
			CommonUtils.waitForElement(driver,opportunityAccountLookupName);
			opportunityAccountLookupName.click();
			driver.switchTo().window(getWindow[0]);
			CommonUtils.waitForElement(driver, closeDateField);
			if(closeDateField.isDisplayed())
			{
			closeDateField.click();
			}
			if(todayButtonInDateField.isDisplayed())
			{
				 todayButtonInDateField.click();
					
			}
			leadSourceSelectField.click();
			
			Select selectLeadSource = new Select(leadSourceSelectField);
			selectLeadSource.selectByIndex(1);
			
			stageSelectField.click();
			
			Select selectStage = new Select(stageSelectField);
			selectStage.selectByIndex(2);
			
			
			saveButtonInNewOpportunityPage.click();
			if(newOpportunityDetailsDisplayPage.isDisplayed())
			{
				isNewOpportunityCreated=true;
			}
			
		}
		return isNewOpportunityCreated;
	}

	
	public boolean verifyOpportunityPipeline(WebDriver driver)
	{
		boolean isOpportunityPipelinePageDisplayed=false;
		opportunityPipelineLink.click();
		if(opportunityPipelineDisplayPage.isDisplayed())
		{
			isOpportunityPipelinePageDisplayed=true;
		}
		return isOpportunityPipelinePageDisplayed;
		
		
	}
	
	public boolean verifyStuckOpportunityReport(WebDriver driver)
	{
		boolean isStuckOpportunityPageDisplayed=false;
		stuckOpportunityLink.click();
		if(stuckOpportunityDisplayPage.isDisplayed())
		{
			isStuckOpportunityPageDisplayed=true;
		}
		return isStuckOpportunityPageDisplayed;
		
		
	}
	
	public boolean verifyQuarterlySummaryReport(WebDriver driver)
	{
		boolean isSummaryPageDisplayed=false;
		for(int i=0; i<2;i++)
		{
		Select selectInterval = new Select(quarterlySummaryIntervalDropdowns);
		selectInterval.selectByIndex(i);
		 for(int j=0;j<2;j++)
		 {
			 Select selectInclude = new Select(quarterlysummaryIncludeDropdowns);
			 selectInclude.selectByIndex(j);
			 runReportButton.click();
			 if(summaryPage.isDisplayed())
			 {
				 isSummaryPageDisplayed=true; 
				 driver.navigate().back();
				 
			 }
		 }
		
		}
		return isSummaryPageDisplayed;
		
		

	}
}
