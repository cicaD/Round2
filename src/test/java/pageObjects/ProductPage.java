package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends WebPage{
	
	private static By h1ProductTitle = By.id("productTitle");
	private static By tagPageBody =By.tagName("body");
	

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getProductTitle() {		
		WebElement productTitle = findElement(h1ProductTitle);
		return productTitle.getText();

		}
	
	
	

}
