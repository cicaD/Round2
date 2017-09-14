package searchProductOnEStoreTestStepsDefinition;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;
import pageObjects.HomePage;
import pageObjects.ProductPage;

public class SearchProductOnEStoreTestSteps {
	
	public static WebDriver driver =new FirefoxDriver();
	private HomePage homePage ;
	private ProductPage productPage;
	private String expectedProductTitle = "";
	
	@Given("^User is on E-store \"([^\"]*)\"$")
	public void user_is_on_E_store(String homePageURL) throws Throwable {

	//	driver = new FirefoxDriver();
		homePage = new HomePage(driver, homePageURL);
		homePage.maximizeWindow();
		homePage.loadPage();
	    
	 
	}

	@When("^User enters \"([^\"]*)\"$")
	public void user_enters(String searchText) throws Throwable {
		homePage.enterSearchText(searchText);
		homePage.startSearch();
		//homePage.searchForText(searchText);

	}

	
	@And("^User choose item \"(\\d+)\" from list of displayed items$")
	public void user_choose_item_from_list_of_displayed_items(int itemNr) throws Throwable {
	//	expectedProductTitle = homePage.clickOnItemNrByText(itemNr);
		homePage.clickOnItemNr(itemNr);

	}

	
	@Then("^item with \"([^\"]*)\" is dispalyed on web page$")
	public void item_with_is_dispalyed_on_web_page(String productTitle) throws Throwable {
		productPage = new ProductPage(driver);
		String listedProductTitle = productPage.getProductTitle();
		
		Assert.assertTrue(listedProductTitle.contains(productTitle));
		Assert.assertTrue(listedProductTitle.contains(expectedProductTitle));
	
	 //   driver.quit();
		
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


