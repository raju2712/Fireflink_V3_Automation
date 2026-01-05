package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createProjectPage {
	
	WebDriver driver;
	
	public createProjectPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='Create Project']")
	private WebElement createProjectText;
	
	@FindBy(id = "name")
	private WebElement nameTF;
	
	@FindBy(id = "select-input-element")
	private WebElement typeDD;
	
	@FindBy(xpath = "//div[@class=\"ff-select-dropdown-wrapper ff-light-theme\"]/descendant::div[text()='Web Service']")
	private WebElement webServiceType;
	
	@FindBy(xpath = "//div[@class=\"ff-select-dropdown-wrapper ff-light-theme\"]/descendant::div[text()='Web']")
	private WebElement webType;
	
	@FindBy(xpath = "//div[@class=\"ff-select-dropdown-wrapper ff-light-theme\"]/descendant::div[text()='Mobile']")
	private WebElement mobileType;
	
	@FindBy(xpath = "//div[@class=\"ff-select-dropdown-wrapper ff-light-theme\"]/descendant::div[text()='Web & Mobile']")
    private WebElement WebAndMobileType;
	
	@FindBy(xpath = "//input[@value='Native']/following-sibling::div/div")
	private WebElement nativeRadioBtn;
	
	@FindBy(xpath = "//input[@value='Hybrid']/following-sibling::div/div")
	private WebElement hybridRadioBtn;
	
	@FindBy(xpath = "//button[@type='button']")
	private WebElement cancelBtn;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement createBtn;

	public WebElement getCreateProjectText() {
		return createProjectText;
	}

	public WebElement getNameTF() {
		return nameTF;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getWebServiceType() {
		return webServiceType;
	}

	public WebElement getWebType() {
		return webType;
	}

	public WebElement getMobileType() {
		return mobileType;
	}

	public WebElement getWebAndMobileType() {
		return WebAndMobileType;
	}

	public WebElement getNativeRadioBtn() {
		return nativeRadioBtn;
	}

	public WebElement getHybridRadioBtn() {
		return hybridRadioBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getCreateBtn() {
		return createBtn;
	}

	
	
	
	
	
}
