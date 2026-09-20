package POM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			wait.until(ExpectedConditions.invisibilityOfElementLocated(
			        By.id("loader")));

			wait.until(ExpectedConditions.elementToBeClickable(getSignInBtn()));
			
			getUsernameTF().sendKeys(EMAIL);
			getPasswordTF().sendKeys(PASSWORD);
			getSignInBtn().click();
		}
		
		
	}


