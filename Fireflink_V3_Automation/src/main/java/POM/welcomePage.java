package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.propertyFileUtility;

import org.openqa.selenium.WebElement;

public class welcomePage {

		WebDriver driver;
		
		public welcomePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "(//span[text()='Sign In'])[1]")
		private WebElement signInText;
		
		@FindBy(id = "email")
		private WebElement usernameTF;
		
		@FindBy(id = "password")
		private WebElement passwordTF;
		
		@FindBy(xpath = "//button[@type='submit']")
		private WebElement signInBtn;

		public WebElement getSignInText() {
			return signInText;
		}

		public WebElement getUsernameTF() {
			return usernameTF;
		}

		public WebElement getPasswordTF() {
			return passwordTF;
		}

		public WebElement getSignInBtn() {
			return signInBtn;
		}
		
		
		public void sigInBM() throws IOException {
			
			propertyFileUtility putil = new propertyFileUtility();
			String EMAIL = putil.toReadDataFromPropertyFile("email");
			String PASSWORD = putil.toReadDataFromPropertyFile("password");
			
			getUsernameTF().sendKeys(EMAIL);
			getPasswordTF().sendKeys(PASSWORD);
			getSignInBtn().click();
		}
		
		
	}


