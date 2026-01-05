package BaseClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import GenericUtility.excelFileUtility;
import GenericUtility.propertyFileUtility;
import GenericUtility.webDriverUtility;

public class baseClass {
	
	
public WebDriver driver = null;
	
	webDriverUtility wutil = new webDriverUtility();
	excelFileUtility eutil = new excelFileUtility();
	propertyFileUtility putil = new propertyFileUtility();
	
	@BeforeSuite
	public void StartingDBconnection() {
		System.out.println("<==========Connecting to DB============>");
	}
	
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		System.out.println("<==============Launching to Browser=============>");
		 
		// To handle Google Password Protection Password 👇
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		Map<String, Object> prefs = new HashMap();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);

		options.setExperimentalOption("prefs", prefs);
		 
		 if(BROWSER.contains("chrome")) {
			 driver = new ChromeDriver(options);
		 }else if(BROWSER.contains("edge")) {
			 driver = new EdgeDriver();
		 }else if (BROWSER.contains("firefox")) {
			 driver = new FirefoxDriver();
		 }
		 wutil.maximize(driver);
		 wutil.implicitWait(driver);
		 
		 String URL = putil.toReadDataFromPropertyFile("url");
		 driver.get(URL);
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("<=================Closing Browser================>");
		driver.close();
	}
	
	
	@AfterSuite
	public void ClosingDBconnection() {
		System.out.println("<==========disconnectiong DB============>");
	}

}
