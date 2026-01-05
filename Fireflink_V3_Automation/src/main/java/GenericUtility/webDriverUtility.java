package GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webDriverUtility {
	
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitTillElementIsClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitTillElementIsVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switcWindowUsingUrl(WebDriver driver, String partialUrl) {
		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> iterate = allWindow.iterator();

		while (iterate.hasNext()) {
			String childWindow = iterate.next();
			driver.switchTo().window(childWindow);

			String actualUrl = driver.getCurrentUrl();
			if (actualUrl.contains(partialUrl)) {
				break;
			}
		}
	}
	
	public void switcWindowUsingTiltle(WebDriver driver, String partialTitle) {
		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> iterate = allWindow.iterator();
		
		while(iterate.hasNext()) {
			String childWindow = iterate.next();
			driver.switchTo().window(childWindow);
			
			String actualTitle = driver.getTitle();
			if(actualTitle.contains(partialTitle)) {
				break;
			}
		}
	}
	
	public void handleDropDownbyIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public void handleDropDownByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public void handleDropDownByText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void handleFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void handleFrameByElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void handleFrameById(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}
	
	public void returnToPrevioudFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void returnToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.clickAndHold(element).perform();
	}
	
	public void releaseTheHold(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.release(element).perform();
	}
	
	public void alertPopupByAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void alertPopupByDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String alertPopupText(WebDriver driver) {
		Alert popup = driver.switchTo().alert();
		String alertPopupText = popup.getText();
		return alertPopupText;
	}
	
	public void screenshotOfEntirePage(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src = new File("./errorShots/"+screenshotName+".jpeg");
		FileHandler.copy(temp, src);
	}
	
	public void screenshotOfElement(WebDriver driver, String screenshotName, String xpathOfElement) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
	    File temp = driver.findElement(By.xpath(xpathOfElement)).getScreenshotAs(OutputType.FILE);
	    File src = new File("./errorShots/"+screenshotName+".jpeg");
	    FileHandler.copy(temp, src);
	}
	
	public void scrollPage(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
	}
	
	public void scrollTillElement(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true),"+element+"");
	} //aligns element to the top of the viewport
	
	public void handleElementClickInterceptedException(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void zoomIn(WebDriver driver) throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ADD);
		r.keyRelease(KeyEvent.VK_ADD);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public void zoomOut(WebDriver driver) {
		for(int i=0;i>3;i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
		}
	}

}
