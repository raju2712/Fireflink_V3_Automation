package SignIn;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseClass.baseClass;
import GenericUtility.excelFileUtility;
import GenericUtility.javaUtility;
import GenericUtility.propertyFileUtility;
import GenericUtility.webDriverUtility;
import POM.homePage;
import POM.welcomePage;


public class signIn extends baseClass {
	
	webDriverUtility wutil = new webDriverUtility();
	excelFileUtility eutil = new excelFileUtility();
	propertyFileUtility putil = new propertyFileUtility();
	javaUtility jutil = new javaUtility();

	@Test
	public void signingIn() throws IOException, InterruptedException {
		
		welcomePage wp = new welcomePage(driver);
		homePage hp = new homePage(driver);
		
		String EMAIL = putil.toReadDataFromPropertyFile("email");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		String ExpectedText = eutil.toGetDataFromExcelSheet("Sheet1", 1, 0);
				
		//String PROJECT_NAME = eutil.toGetDataFromExcelSheet("Sheet1", 3, 1);
		//String ExpectedProjName = eutil.toGetDataFromExcelSheet("Sheet1", 3, 1);
		//String ExpectedRootName = eutil.toGetDataFromExcelSheet("Sheet1", 3, 1);
		 		
		String ActualText = wp.getSignInText().getText();
		Assert.assertEquals(ActualText, ExpectedText);
		
		wp.getUsernameTF().sendKeys(EMAIL);
		wp.getPasswordTF().sendKeys(PASSWORD);
		wp.getSignInBtn().click();
				
		boolean visibilityOfProfileIcon = hp.getProfileIcon().isDisplayed();
		Assert.assertEquals(visibilityOfProfileIcon, true);
		System.out.println("<===============Home Page Displayed================>");
		
	}

}
