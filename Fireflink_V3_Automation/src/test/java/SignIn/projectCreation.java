//package signIn;
package SignIn;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseClass.baseClass;
import GenericUtility.excelFileUtility;
import GenericUtility.javaUtility;
import GenericUtility.webDriverUtility;
import POM.createProjectPage;
import POM.homePage;
import POM.licencePage;
import POM.projectHomePage;
import POM.welcomePage;

public class projectCreation extends baseClass {

	javaUtility jutil = new javaUtility();
	excelFileUtility eutil = new excelFileUtility();
	webDriverUtility wutil = new webDriverUtility();

	@Test
	public void CreateWebserviceProject() throws EncryptedDocumentException, IOException, InterruptedException {

		welcomePage wp = new welcomePage(driver);
		homePage hp = new homePage(driver);
		createProjectPage cp = new createProjectPage(driver);
		projectHomePage php = new projectHomePage(driver);
		licencePage lp = new licencePage(driver);

		String RANDOM_NAME = jutil.getRandomName() + "_Webservice";
		String ExpectedCreateProjectSliderText = eutil.toGetDataFromExcelSheet("Sheet1", 3, 0);

		wp.sigInBM();
		lp.changeLicenceToLIC1026510();
		wutil.handleElementClickInterceptedException(driver, lp.getAllProjects());

//		List<WebElement> overlays =
//			    driver.findElements(By.xpath("//div[contains(@class,'ff-modal-overlay')]"));
//
//			if (!overlays.isEmpty()) {
//			    System.out.println("Overlay is present");
//			} else {
//			    System.out.println("Overlay is NOT present");
//			}
//			
//			if (!overlays.isEmpty() && overlays.get(0).isDisplayed()) {
//			    System.out.println("Overlay is visible and blocking UI");
//			}

		hp.getPlusProjectBtn().click();
		WebElement SliderHeader = cp.getCreateProjectText();
		wutil.waitTillElementIsVisible(driver, SliderHeader);
		String ActualSliderHeaderText = SliderHeader.getText();
		Assert.assertEquals(ActualSliderHeaderText, ExpectedCreateProjectSliderText);

		boolean createBtnStatus = cp.getCreateBtn().isEnabled();
		Assert.assertEquals(createBtnStatus, false);

		cp.getNameTF().sendKeys(RANDOM_NAME);
		cp.getTypeDD().click();
		cp.getWebServiceType().click();
		boolean createBtnStatus1 = cp.getCreateBtn().isEnabled();
		Assert.assertEquals(createBtnStatus1, true);
		cp.getCreateBtn().click();

		String ActualProjName = php.getProjectName().getText();
		String ActualProjNameWithoutDots = ActualProjName.substring(0, ActualProjName.length() - 3);
		Assert.assertEquals(RANDOM_NAME.contains(ActualProjNameWithoutDots), true);
		//Assert.assertEquals(ActualProjName, RANDOM_NAME);
		
		String ActualRootName = driver.findElement(By.xpath("//span[@class='tree-table-td-content-text']/span[contains(text(),'"+RANDOM_NAME+"')]")).getText();
		Assert.assertEquals(ActualRootName, RANDOM_NAME);
		System.out.println("<==============Web Service type Project Created with name " + RANDOM_NAME + "==============>");

	}

	

}
