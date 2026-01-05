package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	
	WebDriver driver;
	
	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[local-name()='svg' and @viewBox='0 0 66 82']")
	private WebElement profileIcon;
	
	@FindBy(xpath = "//div[text()='All Projects']")
	private WebElement Allprojects;
	
	@FindBy(xpath = "//div[text()='Configuration']")
	private WebElement Configuration;
	
	@FindBy(xpath = "//div[text()='Integrations']")
	private WebElement Integrations;
	
	@FindBy(xpath = "//div[text()='Dashboard']")
	private WebElement Dashboard;
	
	@FindBy(xpath = "//div[text()='Licenses']")
	private WebElement Licence;
	
	@FindBy(xpath = "//div[@class='ff-search-icon']")
	private WebElement searchIcon;
	
	@FindBy(xpath = "//div[text()='Project']")
	private WebElement plusProjectBtn;

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getAllprojects() {
		return Allprojects;
	}

	public WebElement getConfiguration() {
		return Configuration;
	}

	public WebElement getIntegrations() {
		return Integrations;
	}

	public WebElement getDashboard() {
		return Dashboard;
	}

	public WebElement getLicence() {
		return Licence;
	}

	public WebElement getSearchIcon() {
		return searchIcon;
	}

	public WebElement getPlusProjectBtn() {
		return plusProjectBtn;
	}
	
	

}
