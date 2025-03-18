package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import PageObject.homePage;
import Utility.log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC7_Category extends log4j{
	WebDriver driver;
	@Given("user is in the HomePage")
	public void user_is_in_the_home_page() {
		driver = Hooks.driver;
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://petstore.octoperf.com/");
	    writeLog("Starting category test case");
	    homePage home = new homePage(driver);
	    home.clickEnterStore();
	}
	@When("user clicks on a specific category")
	public void user_clicks_on_a_specific_category() {
	    driver.findElement(By.xpath("//a[img][2]")).click();
	    writeLog("Clicked on a specific category");
	}
	@Then("the product table related to that category should be dispayed")
	public void the_product_table_related_to_that_category_should_be_dispayed() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String expCategoryTitle = "Dogs";
		WebElement categoryTitle = driver.findElement(By.xpath("//h2"));
		String actCategoryTitle = categoryTitle.getText();
		
		assertTrue(categoryTitle.isDisplayed(), "Category title is not displayed");
		assertEquals(actCategoryTitle, expCategoryTitle, "Category title does not match");
		
		WebElement categoryData = driver.findElement(By.xpath("//table//tr//td"));
		assertTrue(categoryData.isDisplayed(), "Product table for the selected category is not displayed");
		writeLog("The related products for that category displayed");
	}
}
