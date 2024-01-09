package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.CommonUtils;
import utils.FileUtils;

public class CreateAnAccountPage extends BasePage{

	public CreateAnAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='Accounts Tab']")
	public WebElement accountsLink;

	@FindBy(xpath="//div[@class='content']/h2")
	public WebElement accountsPage;
	
	@FindBy(xpath="//input[@value=' New ']")
	public WebElement newButton;
	
	@FindBy(xpath="//h2[@class='pageDescription']")
	public WebElement newAccountsPage;
	
	@FindBy(xpath="//div[@class='requiredInput']/input[@id='acc2']")
	public WebElement accountNameField;
	
	@FindBy(xpath="//select[@id='acc6']")
	public WebElement selectDropdown;
	
	@FindBy(xpath="//select[@id='00NHo00000SxYya']")
	public WebElement priorityDropdown;
	
	@FindBy(xpath="//td[@class='pbButtonb']/input[@value=' Save ']")
	public WebElement accountsPageSaveButton;
	
	@FindBy(xpath="//div[@class='textBlock']")
	public WebElement newAccountsDetailDisplayPage;
	
	@FindBy(xpath="//span[@class='fFooter']/a[2]")
	public WebElement createNewViewButton;
	
	@FindBy(xpath="//h2[@class='pageDescription']")
	public WebElement createNewViewPage;
	
	@FindBy(xpath="//input[@id='fname']")
	public WebElement viewNameField;
	
	@FindBy(xpath="//input[@id='devname']")
	public WebElement viewUniqueNameField;
	
	@FindBy(xpath="//input[@class='btn primary']")
	public WebElement viewPageSaveButton;
	
	@FindBy(xpath="//select[@class='title']/option[@selected='selected']")
	public WebElement accountViewList;
	
	@FindBy(linkText="Edit")
	public WebElement editLink;
	
	@FindBy(xpath = "//td[starts-with(@class, 'x-grid3-col x-grid3-cell x-grid3-td-Name')]")
	public List<WebElement> accountNamesInResult;
	
	@FindBy(xpath="//h2[@class='pageDescription']")
	public WebElement editViewPage;
	
	@FindBy(xpath="//select[@id='fcol1']")
	public WebElement filtersFieldDropdown;
	
	@FindBy(xpath="//select[@id='fop1']")
	public WebElement operatorFieldDropdown;
	
	@FindBy(xpath="//input[@id='fval1']")
	public WebElement valueField;
	
	@FindBy(xpath="//select[@id='fcf']")
	public WebElement viewDropdown;
	
	//@FindBy(xpath="//div[@title='Action']/a")
	//public WebElement activityColumnPage;
	
	
	@FindBy(xpath="//div[@class='content']/h1")
	public WebElement mergeAccountsPage;
	
	@FindBy(xpath="//div[@class='toolsContentRight']/div/div/ul/li[4]/span/a")
	public WebElement meregeAccountLink;
	
	@FindBy(xpath="//input[@id='srch']")
	public WebElement searchAccountField;
	
	@FindBy(xpath="//input[@name='srchbutton']")
	public WebElement findAccountButton;
	
	@FindBy(xpath="//input[@type='checkbox']")
	public List<WebElement> checkboxes;
	
	@FindBy(xpath="//div[@class='pbBottomButtons']/input[1]")
	public WebElement mergeAccountNextButton;
	
	@FindBy(xpath="//div[@class='bWizardBlock tertiaryPalette']/div[1]")
	public WebElement mergeAccountStep2Page;
	
	@FindBy(xpath="//div[@class='pbTopButtons']/input[2]")
	public WebElement mergeButton;
	
	@FindBy(xpath="//th[@scope='row'][1]")
	public WebElement mergedAccountResult;
	
	@FindBy(xpath="//div[@class='lbBody']/ul/li[2]/a")
	public WebElement accountsWithLastActivityLink;
	
	@FindBy(xpath="//div[@id='ext-gen147']")
	public WebElement dateFieldDropdown;
	
	@FindBy(xpath="//div[@class='x-combo-list-item']")
	public WebElement createdDateOptionFromDropdown;
	
	@FindBy(xpath="//img[@id='ext-gen152']")
	public WebElement calendarFromIcon;
	
	@FindBy(xpath="//button[@id='ext-gen281']")
	public WebElement todaysDateButtonFromIcon;
	
	@FindBy(xpath="//img[@id='ext-gen154']")
	public WebElement calendarToIcon;
	
	@FindBy(xpath="//button[@id='ext-gen296']")
	public WebElement todaysDateButtonToIcon;
	
	@FindBy(xpath="//div[@id='ext-gen363']/div")
	public WebElement loadingSpinWheel;
	
	@FindBy(xpath="//button[@id='ext-gen49']")
	public WebElement saveButtonInUnsavedReportPage;
	
	@FindBy(xpath="//input[@id='saveReportDlg_reportNameField']")
	public WebElement reportNameField;
	
	@FindBy(xpath="//input[@id='saveReportDlg_DeveloperName']")
	public WebElement reportUniqueName;
	
	@FindBy(xpath="//table[@id='dlgSaveAndRun']/tbody/tr[2]/td[2]/em/button")
	public WebElement saveAndRunReportButton;
	
	@FindBy(xpath="//div[@class='content']/h1")
	public WebElement finalReportPageWithReportName;
	
	
	public boolean isMyAccountsPageDisplayed(WebDriver driver)
	{
		return accountsPage.isDisplayed();
		
	}
	
	public void clickAccountsLink(WebDriver driver)
	{
		if(accountsLink.isDisplayed())
		{
			accountsLink.click();
		}
	}
	
	public boolean verifyAccountsPage(WebDriver driver,String accountName)
	{
		logger.info("createAccountsPage: verify accountPage : started");
		boolean isNewAccountCreated=false;
		if(newButton.isDisplayed())
		{
			newButton.click();
		}
		CommonUtils.waitForElement(driver, newAccountsPage);
		if(accountNameField.isDisplayed())
		{
			accountNameField.sendKeys(accountName);
		}
		Select select = new Select(selectDropdown);
		select.selectByIndex(6);
		
		Select selectPriority = new Select(priorityDropdown);
		selectPriority.selectByIndex(1);
		
		accountsPageSaveButton.click();
		if(newAccountsDetailDisplayPage.isDisplayed())
		{
		isNewAccountCreated=true;
		}
		
		return isNewAccountCreated;
		 
		
	}
	
	public void compareStrings(String s1, String s2)
	{
		Assert.assertEquals(s1, s2);
	}
	
	public boolean verifyCreateViewPage(WebDriver driver, String viewName) throws IOException
	{
		logger.info("createAccountsPage: verify createViewPage : started");
		
		boolean isNewViewCreated=false;
		if(createNewViewButton.isDisplayed())
		{
			createNewViewButton.click();
		}
		CommonUtils.waitForElement(driver, createNewViewPage);
		if(viewNameField.isDisplayed())
		{
			viewNameField.sendKeys(viewName);
			viewUniqueNameField.click();
			viewPageSaveButton.click();
				
		}
		this.compareStrings(accountViewList.getText(),FileUtils.readCreateAccountTestData("view.name"));
		isNewViewCreated=true;
		return isNewViewCreated;
		
	}
	
	public String isEditPageOpened(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public boolean verifyEditViewPage(WebDriver driver,String viewName,String newViewName, String value) throws InterruptedException, IOException
	{
		logger.info("createAccountsPage: verify editViewPage : started");
		
		boolean isViewEdited=false;
		if(viewDropdown.isDisplayed())
		{
		viewDropdown.click();
		Select select = new Select(viewDropdown);
		select.selectByVisibleText(viewName);;
		}
		Thread.sleep(3000);
		editLink.click();
		CommonUtils.waitForElement(driver, editViewPage);
		Assert.assertEquals(this.isEditPageOpened(driver),FileUtils.readCreateAccountTestData("editViewPage.title"));
		viewNameField.clear();
		viewUniqueNameField.clear();
		viewNameField.sendKeys(newViewName);
		viewUniqueNameField.click();
		
		Select selectFilterField = new Select(filtersFieldDropdown);
		selectFilterField.selectByVisibleText("Account Name");
		
		Select operator = new Select(operatorFieldDropdown);
		operator.selectByVisibleText("contains");
		valueField.clear();
		valueField.sendKeys(value);
		viewPageSaveButton.click();
		if( accountViewList.isDisplayed())
		{
			for(WebElement accountNameElement : accountNamesInResult)
			{
				Assert.assertTrue(accountNameElement.getText().toLowerCase().contains(value));
				Assert.assertEquals(accountViewList.getText(), newViewName);
				isViewEdited = true;
			}
		}
		return isViewEdited;	
	}
	
	public void clickCheckboxes(WebDriver driver, int numberOfCheckBoxesToBeChecked)
	{
		if (checkboxes.size() < numberOfCheckBoxesToBeChecked) {
			System.out.println("Nothing to be done, lesser than " + numberOfCheckBoxesToBeChecked + " present.");
		} else {
			for (int i=numberOfCheckBoxesToBeChecked; i<checkboxes.size(); i++) {
				checkboxes.get(i).click();
			}
		}
	}
	
	public static void switchToAlert(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public boolean verifyMergeAccountPage(WebDriver driver, String accountName)
	{
		logger.info("createAccountsPage: verify mergeaccountPage : started");
		boolean isAccountMerged=false;
		meregeAccountLink.click();
		if( mergeAccountsPage.isDisplayed())
		{
			 searchAccountField.sendKeys(accountName);
			 findAccountButton.click();
			 CommonUtils.waitForElements(driver, checkboxes);
			 clickCheckboxes(driver, 2);
			 mergeAccountNextButton.click();
			 CommonUtils.waitForElement(driver, mergeAccountStep2Page);
			 if(mergeButton.isDisplayed())
			 {
				 mergeButton.click();
				 this.switchToAlert(driver);
			 }
			 Assert.assertEquals(mergedAccountResult.getText(), accountName);
			 isAccountMerged=true;
			 
		}
		return isAccountMerged;
	}
	
	public String isUnsavedReportPageOpened(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public boolean verifyCreateAccountReport(WebDriver driver, String reportName) throws IOException, InterruptedException
	{
		logger.info("createAccountsPage: verify createAccountReport : started");
		boolean isReportCreatedSaved=false;
		accountsWithLastActivityLink.click();
		Assert.assertEquals(this.isUnsavedReportPageOpened(driver),FileUtils.readCreateAccountTestData("unsavedReport.title"), "Failed to verify unsaved report page display");
		if(dateFieldDropdown.isDisplayed())
		{
			dateFieldDropdown.click();
			createdDateOptionFromDropdown.click();
		}
			calendarFromIcon.click();
			CommonUtils.waitForElement(driver,todaysDateButtonFromIcon);
			todaysDateButtonFromIcon.click();
			calendarToIcon.click();
			CommonUtils.waitForElement(driver,todaysDateButtonToIcon);
			todaysDateButtonToIcon.click();
			saveButtonInUnsavedReportPage.click();
			String oldWindow = driver.getWindowHandle();
			Set<String> getAllWindows = driver.getWindowHandles();
			String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
			driver.switchTo().window(getWindow[0]);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			if(reportNameField.isDisplayed())
			{
				reportNameField.sendKeys(reportName);
				reportUniqueName.click();
				CommonUtils.waitForElement(driver, saveAndRunReportButton);
				Thread.sleep(3000);
				saveAndRunReportButton.click();
				
			}
			Assert.assertTrue(finalReportPageWithReportName.isDisplayed());
			isReportCreatedSaved=true;

		
		
		return isReportCreatedSaved;
		
		
	}
}