package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.excelFileUtility;

public class licencePage {
	
	WebDriver driver;

	public licencePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'LIC26441')]")
	private WebElement LIC26441_Text;
	
	@FindBy(xpath = "//span[contains(text(),'LIC26441')]/ancestor::div[@class=\"ff-col-3 _license_name_column_e9pac_16\"]/descendant::div[@class='ff-radio-wrapper']")
	private WebElement LIC26441_RadioBtn;
	
	@FindBy(xpath = "//span[contains(text(),'LIC26448')]/ancestor::div[@class=\"ff-col-3 _license_name_column_e9pac_16\"]/descendant::div[@class='ff-radio-wrapper']")
	private WebElement LIC26448_RadioBtn;
	
	@FindBy(xpath = "//span[contains(text(),'LIC1026510')]/ancestor::div[@class=\"ff-col-3 _license_name_column_e9pac_16\"]/descendant::div[@class='ff-radio-wrapper']")
	private WebElement LIC1026510_RadioBtn;
	
	@FindBy(xpath = "//span[contains(text(),'LIC26464')]/ancestor::div[@class=\"ff-col-3 _license_name_column_e9pac_16\"]/descendant::div[@class='ff-radio-wrapper']")
	private WebElement LIC26464_RadioBtn;
	
	@FindBy(id = "password")
	private WebElement authPopupPasswordTF;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement authPopupContinueBtn;
	
	@FindBy(xpath = "//button[@type='button']")
	private WebElement authPopupCancelBtn;
	
	@FindBy(xpath = "//div[@class='icon-click-layer']")
	private WebElement allProjectsAccordion;
	
	@FindBy(xpath = "//div[@class='ff-projects-icons']/following-sibling::div[text()='All Projects']")
	private WebElement allProjectsOption;
	
	@FindBy(xpath = "//div[text()='All Projects']")
	private WebElement allProjects;
	
	public WebElement getLIC26441_Text() {
		return LIC26441_Text;
	}

	public WebElement getLIC26441_RadioBtn() {
		return LIC26441_RadioBtn;
	}

	public WebElement getLIC26448_RadioBtn() {
		return LIC26448_RadioBtn;
	}

	public WebElement getLIC1026510_RadioBtn() {
		return LIC1026510_RadioBtn;
	}

	public WebElement getLIC26464_RadioBtn() {
		return LIC26464_RadioBtn;
	}

	public WebElement getAuthPopupContinueBtn() {
		return authPopupContinueBtn;
	}

	public WebElement getAuthPopupCancelBtn() {
		return authPopupCancelBtn;
	}
	
	public WebElement getAuthPopupPasswordTF() {
		return authPopupPasswordTF;
	}
	
	public WebElement getAllProjectsAccordion() {
		return allProjectsAccordion;
	}
	
	public WebElement getAllProjectsOption() {
		return allProjectsOption;
	}
	
	public WebElement getAllProjects() {
		return allProjects;
	}

	public void changeLicenceToLIC1026510() throws IOException, InterruptedException {
		
		homePage hp = new homePage(driver);
		excelFileUtility eutil = new excelFileUtility();
		
		String LICENSE_PASSWORD = eutil.toGetDataFromExcelSheet("Sheet1", 5, 0);
		
		hp.getLicence().click();
		getLIC1026510_RadioBtn().click();
		getAuthPopupPasswordTF().sendKeys(LICENSE_PASSWORD);
		getAuthPopupContinueBtn();
		System.out.println("<============Licence changed to LIC26441============>");
	
	}
	
	
}
