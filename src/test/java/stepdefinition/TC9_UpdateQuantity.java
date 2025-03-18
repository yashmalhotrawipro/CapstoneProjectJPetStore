package stepdefinition;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertEquals;

import PageObject.fishPage;
import PageObject.homePage;
import Utility.log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class TC9_UpdateQuantity extends log4j{
	WebDriver driver;
	@Given("the user has a product with some quantity in the cart")
	public void the_user_has_a_product_with_some_quantity_in_the_cart() {
		driver = Hooks.driver;
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://petstore.octoperf.com/");
		 writeLog("Starting testcase for Quantity Update");
		 homePage home = new homePage(driver);
		 home.clickEnterStore();
		 fishPage fish = new fishPage(driver);
		 fish.clickFish();
		 driver.findElement(By.linkText("FI-SW-02")).click();
		 driver.findElement(By.linkText("Add to Cart")).click();
	}
	@When("the user update the qualtity to {string}")
	public void the_user_update_the_qualtity_to(String quant) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		writeLog("Inserting Quantity");
		WebElement quantity = driver.findElement(By.name("EST-3"));
		quantity.clear();
		quantity.sendKeys(quant);
		writeLog("Clicking on update cart");
		driver.findElement(By.xpath("//input[@value='Update Cart']")).click();
	}
	@Then("the cart should reflect the updated quantity which is {string}")
	public void the_cart_should_reflect_the_updated_quantity_which_is(String updatedQuantity){
		WebElement quantity = driver.findElement(By.name("EST-3"));
		assertEquals(quantity.getAttribute("value"), updatedQuantity, "Cart Quantity did not Update");
		writeLog("Quantity is updated");
	}



}
