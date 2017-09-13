package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends WebPage{
	
	private static By txtBoxSearch = By.id("twotabsearchtextbox");
	private static By selectSortBy = By.id("sort");
	private static By imgProducts = By.className("s-access-image");
	private static By h2ProductName = By.className("a-size-base");
	private static By inputSearch = By.className("nav-input");
	private static By tagPageBody =By.tagName("body");
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public HomePage(WebDriver driver , String baseURL) {
		super(driver , baseURL);
		// TODO Auto-generated constructor stub
	}
	
	public void enterSearchText(String searchText) throws IOException {
		writeInTextField(txtBoxSearch, searchText);
		WebElement searchBox = findElement(txtBoxSearch);
		
		}
	
	public void searchForText(String searchText) throws IOException {
		writeInTextField(txtBoxSearch, searchText);
		WebElement searchBox = findElement(txtBoxSearch);
		searchBox.click();
		}
	
	public void startSearch() throws IOException {
		WebElement search = findElement(inputSearch);
		search.click();
		}
	
	public void sortByVisibleText(String text) {
	Select select = new Select(findElement(selectSortBy)); // Price: High to Low
	select.deselectAll();
	select.selectByVisibleText(text);

	}
	
	
	public void clickOnItemNr(int itemNr) {
		List<WebElement> searchedItems = findElements(imgProducts);
		if (searchedItems.size()>0) {
			searchedItems.get(itemNr-1).click();
		}
		}
	
	public String clickOnItemNrByText(int itemNr) {
		String itemText = "";
		List<WebElement> searchedItems = findElements(h2ProductName);
			if (searchedItems.size()>0) {
				WebElement selectedItem = searchedItems.get(itemNr-1);		
				selectedItem.click();
				itemText = selectedItem.getText();
			}
			return itemText;
		}
	
	
	
	
}
