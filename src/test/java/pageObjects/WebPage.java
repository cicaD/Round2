package pageObjects;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class WebPage {
	 private  WebDriver driver;
	 private  String baseURL;
		private  int IMPLICIT_WAIT_SEC = 20;
		private  int EXPLICIT_WAIT_SEC = 20;
		private  final int TIME_TO_POLL_mSEC = 500; // Millisekunder
		private  final int ACTION_WAIT_SEC = 3;


		public WebPage(WebDriver driver) {
		this.driver = driver ;
		 driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_SEC, TimeUnit.SECONDS);
		}

		public WebPage(WebDriver driver, String baseURL) {
			this.driver = driver ;
			this.baseURL = baseURL;
			 driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_SEC, TimeUnit.SECONDS);
			}

		////////////////////  PAGE actions //////////////////////////////////


		public  void goToUrl(String url) throws MalformedURLException{
			openURL(url);
		}
		
		

		public  void loadPage() throws MalformedURLException{
			openURL(baseURL);
		}
		
		
		
		public  WebDriver getWebPageDriver() {
		 return this.driver ;
		}
		
		public void setWebPageDriver(WebDriver driver) {
			 this.driver = driver;
			}
		
		
		public  void maximizeWindow() {
			driver.manage().window().maximize();
		}
		public void deleteAllCookies() {
			driver.manage().deleteAllCookies();
		}

		public String getErrorMessageByCss(String cssPath) {
			return findElement(By.cssSelector(cssPath)).getText();
		}


		public void openURL(String url) throws MalformedURLException {
			driver.get(url);
		}
		

		public String getURL(WebDriver driver) {
			
			return driver.getCurrentUrl().toLowerCase();
		}

		public void reloadPage() {
			driver.navigate().refresh();	
		}


		public String getTitle() {
			return driver.getTitle().toLowerCase();
		}



		////////////////////////////   -ELEMENT ACTIONS ///////////////////////////////////



		public WebElement findElement(By by) {
			WebElement element = null;
			new WebDriverWait(driver, EXPLICIT_WAIT_SEC).until(ExpectedConditions.presenceOfElementLocated(by));
			element = driver.findElement(by);	
			return element;	
		}


		public WebElement findSubElement(By... bys) {
			WebElement element = findElement(bys[0]);
			if (bys.length > 1){
				for (int i=1 ; i< bys.length; i++){
					element = element.findElement(bys[i]);
				}
			}
			return element;	
		}



		public List<WebElement> findElements(By by){
			List<WebElement> elements = null;
			new WebDriverWait(driver, EXPLICIT_WAIT_SEC).until(ExpectedConditions.presenceOfElementLocated(by));
			elements = driver.findElements(by);
			return elements;	
		}


		public String getElementAttribute(By by, String attributeName){
			WebElement element = findElement(by);
			String attribute = element.getAttribute(attributeName);
			System.out.println("Element attribute: " + attributeName + " has value: " + attribute);
			return attribute;
		}


		public void setElementAttribute(WebElement element, String attributeName, String attributeValue) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", 
					element, attributeName, attributeValue);
		}




		public void clickLink(String text) throws IOException{
			WebElement element = findElement(By.partialLinkText(text));	
			element.click();
		}



		
		public void writeInTextField(By by, String textToInput) throws IOException {
			WebElement element = findElement(by);
			
		//	System.out.println( "Populating text field " + element.toString() + "with: " + textToInput);
			try{
			//	getElementInViewPort(element);
				element.click();
				element.clear();
				element.sendKeys(textToInput);
			}catch(StaleElementReferenceException sere){
				System.out.println( "StaleElementReferenceException exception caught... retrying...");
				driver.switchTo().defaultContent();
		//		getElementInViewPort(element);
				element.click();
				element.clear();
				element.sendKeys(textToInput);
			}
		//	System.out.println( "DONE");
		}

		
		
		
		
		
		//-------------------- SUPPORT FUNCTIONS -------------------


		public void sleep(long l) {
			try {
				Thread.sleep(l * 1000);
			} catch (InterruptedException ie) {
				System.err.println(ie.getMessage());
			}
		}


		public boolean stringsWithRemovedSpecCharsContains(String str1 , String str2) {
			boolean matches = false;
			if (removeSpecChar(str1).contains(removeSpecChar(str2)) ||
					removeSpecChar(str2).contains(removeSpecChar(str1))) matches = true;
			return matches;
		}



		public boolean stringsWithRemovedSpecCharsEqual(String str1 , String str2) {
			boolean matches = false;
			if (removeSpecChar(str1).equalsIgnoreCase(removeSpecChar(str2))) matches = true;
			return matches;
		}


		public String removeSpecChar( String inputText) {
			return inputText.replaceAll("[^a-zA-Z0-9]","");
		}


	
	
	
	

}
