package stepdefinition;

import java.time.Duration;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import PageObject.homePage;
import Utility.log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC6_searchProduct extends log4j {
	WebDriver driver;
	@Given("the user is in the HomePage")
	public void the_user_is_in_the_home_page() {
		driver = Hooks.driver;
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://petstore.octoperf.com/");
	    writeLog("Starting Test Case to search products");
	    homePage home = new homePage(driver);
	    home.clickEnterStore();
	}
	@When("user enters {string} in the search bar")
	public void user_enters_in_the_search_bar(String productName) {
		writeLog("Entering product name");
      WebElement searchBar = driver.findElement(By.name("keyword"));
      searchBar.sendKeys(productName);
	}
	@When("user clicks on the search button")
	public void user_clicks_on_the_search_button() {
		writeLog("Clicking search button");
	    driver.findElement(By.name("searchProducts")).click();
	}
	@Then("search results should display relevant products")
	public void search_results_should_display_relevant_products() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    WebElement productData = driver.findElement(By.xpath("//table//tr//td"));
	    assertTrue(productData.isDisplayed(), "Search results table should contain products");
	    writeLog("Relevant products are displayed");
	}
}
