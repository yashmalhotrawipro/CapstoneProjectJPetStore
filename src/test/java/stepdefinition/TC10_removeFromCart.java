package stepdefinition;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import PageObject.homePage;
import PageObject.reptilesPage;
import Utility.log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class TC10_removeFromCart extends log4j{
	WebDriver driver;
	@Given("the user has a product in the cart")
	public void the_user_has_a_product_in_the_cart() {
		driver = Hooks.driver;
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://petstore.octoperf.com/");
		 writeLog("Starting Test Case to remove product from cart");
		 homePage home = new homePage(driver);
		 home.clickEnterStore();
		 reptilesPage reptiles = new reptilesPage(driver);
		 reptiles.clickReptiles();
		 driver.findElement(By.linkText("RP-SN-01")).click();
		 driver.findElement(By.linkText("Add to Cart")).click();
	}
	@When("the user remove the product from the cart")
	public void the_user_remove_the_product_from_the_cart() {
		writeLog("Removing the product from the cart");
		 driver.findElement(By.linkText("Remove")).click();
	}
	@Then("the cart should be empty with a message {string}")
	public void the_cart_should_be_empty_with_a_message(String string){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		assertTrue(driver.getPageSource().contains("Your cart is empty.")); 
		writeLog("Product is removed from the cart");
	}



}
