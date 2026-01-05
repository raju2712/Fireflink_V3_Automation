package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class projectHomePage {
	
	WebDriver driver;
	
	public projectHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='ff-text ff-text--regular projects-label']")
	private WebElement projectName;
	
	/*
	 * Dynamic Xpath written in script
	 */
//	@FindBy(xpath = "//span[text()='V3_Automation']")
//	private WebElement rootName;

	public WebElement getProjectName() {
		return projectName;
	}

//	public WebElement getRootName() {
//		return rootName;
//	}
	
	

}
