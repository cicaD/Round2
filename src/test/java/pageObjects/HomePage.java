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
	
	private static By h2ProductTitle = By.cssSelector("h2.a-size-base.s-inline.s-access-title.a-text-normal']");
//	private static By testLocator = By.xpath("//*[@class='a-size-base s-inline s-access-title a-text-normal']");
//	private static By testLocator = By.cssSelector("h2[class='a-size-base s-inline s-access-title a-text-normal']");
	private static By testLocator = By.cssSelector("a.a-link-normal.aok-inline-block");
//	private static By h2ProductTitle = By.xpath("//a[@class='a-link-normal s-access-detail-page s-color-twister-title-link a-text-normal']/h2");
	
	private static By divProductRow = By.className("a-row");
	private static By inputSearch = By.className("nav-input");

	private static By tagPageBody =By.tagName("body");
	private static By tagA =By.tagName("a");

	
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
		
		clickOnItemNrByText(2);
		
		
	Select select = new Select(findElement(selectSortBy)); // Price: High to Low
	select.deselectAll();
	select.selectByVisibleText(text);

	}
	
	
	public void clickOnItemNr(int itemNr) {
		List<WebElement> searchedItems = findElements(imgProducts);
		if (searchedItems.size()>itemNr-1) {
			searchedItems.get(itemNr-1).click();
		}else throw new IndexOutOfBoundsException("Not so many items to click on");
		}
	
	
	
	public String clickOnItemNrByText(int itemNr) {
		String itemText = "";	
		List<WebElement> searchedItems = findElements(testLocator);
			if (searchedItems.size()>itemNr-1) {
				WebElement selectedItem = searchedItems.get(itemNr-1);		
				selectedItem.click();
				itemText = selectedItem.getText();
			}else throw new IndexOutOfBoundsException("Not so many items to click on");
			System.out.println("Item title:" + itemText);
			return itemText;
		}
	
	
	
	
}
