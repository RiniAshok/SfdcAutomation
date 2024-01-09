package constants;

import utils.CommonUtils;

public class FileConstants {
	
	public static final String LOGIN_TESTDATA_FILE_PATH = System.getProperty("user.dir")+"/src/main/resources/loginTestData.properties";
	
	public static final String USER_MENU_TESTDATA_FILE_PATH=System.getProperty("user.dir")+"/src/main/resources/UserMenuTestData.properties";

	public static final String TEST_FILE_PATH="/Users/riniashok/Desktop/image.PNG";
	
	public static final String PHOTO_FILE_PATH="/Users/riniashok/Desktop/seaview.jpg";
	
	public static final String ACCOUNT_TESTDATA_FILE_PATH=System.getProperty("user.dir")+"/src/main/resources/CreateAccountTestData.properties";
	
	public static final String OPPORTUNITY_TESTDATA_FILE_PATH=System.getProperty("user.dir")+"/src/main/resources/CreateOpportunityTestData.properties";

	public static final String LEAD_TESTDATA_FILE_PATH=System.getProperty("user.dir")+"/src/main/resources/CreateLeadTestData.properties";
	
	public static final String CONTACTS_TESTDATA_FILE_PATH=System.getProperty("user.dir")+"/src/main/resources/ContactTestData.properties";

	public static final String RANDOMSCENARIO_TESTDATA_FILE_PATH=System.getProperty("user.dir")+"/src/main/resources/RandomScenariosTestData.properties";
	
	public static final String SCREENSHOT_FOLDER_PATH=System.getProperty("user.dir")+"/src/test/resources/screenshots/"+CommonUtils.getDateAndTimeStamp()+".PNG";
	
	public static final String REPORT_FOLDER_PATH=System.getProperty("user.dir")+"/src/test/resources/SFDC_"+CommonUtils.getDateAndTimeStamp()+".html";
}
