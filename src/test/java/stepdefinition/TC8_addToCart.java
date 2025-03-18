package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertTrue;
import PageObject.dogsPage;
import PageObject.homePage;
import Utility.log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC8_addToCart extends log4j{
	WebDriver driver;
	@Given("user is on the product page")
	public void user_is_on_the_product_page() {
		driver = Hooks.driver;
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://petstore.octoperf.com/");
		 writeLog("Starting add to cart test case");
		    homePage home = new homePage(driver);
		    home.clickEnterStore();
		 dogsPage dogs = new dogsPage(driver);
		 dogs.clickDogs();
		 
	}
	@When("the user adds the product to the cart")
	public void the_user_adds_the_product_to_the_cart() {
	    driver.findElement(By.linkText("K9-BD-01")).click();
	    writeLog("Chose a product to add");
	    driver.findElement(By.linkText("Add to Cart")).click();
	    writeLog("Clicked on Add to Cart button");
	}
	@Then("the product should be displayed in the cart")
	public void the_product_should_be_displayed_in_the_cart() {
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   WebElement cartProduct = driver.findElement(By.xpath("//table//tr//td[contains(text(), 'K9-BD-01')]"));
	   assertTrue(cartProduct.isDisplayed(), "The product is not displayed in the cart");
	   writeLog("Product is displayed in the cart");
	}



}
