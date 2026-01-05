package SignIn;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.baseClass;
import GenericUtility.excelFileUtility;
import POM.homePage;
import POM.licencePage;
import POM.welcomePage;

public class licenseChange extends baseClass{
	
	excelFileUtility eutil = new excelFileUtility();
	
	@Test
	public void changeLicenseTo26441() throws IOException {
		
		welcomePage wp = new welcomePage(driver);
		homePage hp = new homePage(driver);
		licencePage lp = new licencePage(driver);
		
		String LICENSE_PASSWORD = eutil.toGetDataFromExcelSheet("Sheet1", 5, 0);
		
		wp.sigInBM();
		hp.getLicence().click();
		lp.getLIC26441_RadioBtn().click();
		lp.getAuthPopupPasswordTF().sendKeys(LICENSE_PASSWORD);
		lp.getAuthPopupContinueBtn();
		System.out.println("<============Licence changed to LIC26441============>");
		lp.getAllProjectsAccordion().click();
		lp.getAllProjectsOption().click();
		
	}
	
	

}
