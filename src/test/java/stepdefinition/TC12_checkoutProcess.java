package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import PageObject.birdsPage;
import PageObject.catsPage;
import PageObject.dogsPage;
import PageObject.fishPage;
import PageObject.homePage;
import PageObject.loginPage;
import PageObject.reptilesPage;
import Utility.log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC12_checkoutProcess extends log4j{
	WebDriver driver;
	@Given("user is logged in with username {string} and password {string} and has products in the cart")
	public void user_is_logged_in_with_username_and_password_and_has_products_in_the_cart(String uname, String pass) {
		driver = Hooks.driver;
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://petstore.octoperf.com/");
	    writeLog("Starting test case for checkout process");
	    homePage home = new homePage(driver);
		home.clickEnterStore();
		loginPage login = new loginPage(driver);
		login.clickLogin();
		driver.findElement(By.name("username")).sendKeys(uname);
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys(pass);
		driver.findElement(By.name("signon")).click();
		
		writeLog("Adding Birds product to the cart");
		 birdsPage birds = new birdsPage(driver);
		 birds.clickBird();
		 driver.findElement(By.linkText("AV-CB-01")).click();
		 driver.findElement(By.linkText("Add to Cart")).click();
		 driver.findElement(By.xpath("//a[img][1]")).click();
		 
		 writeLog("Adding Dogs product to the cart");
		 dogsPage dogs = new dogsPage(driver);
		 dogs.clickDogs();
		 driver.findElement(By.linkText("K9-RT-01")).click();
		 driver.findElement(By.linkText("Add to Cart")).click();
		 driver.findElement(By.xpath("//a[img][1]")).click();
		 
		 writeLog("Adding Reptiles product to the cart");
		 reptilesPage reptiles = new reptilesPage(driver);
		 reptiles.clickReptiles();
		 driver.findElement(By.linkText("RP-SN-01")).click();
		 driver.findElement(By.linkText("Add to Cart")).click();
		 driver.findElement(By.xpath("//a[img][1]")).click();
		 
		 writeLog("Adding Fish product to the cart");
		 fishPage fish = new fishPage(driver);
		 fish.clickFish();
		 driver.findElement(By.linkText("FI-FW-02")).click();
		 driver.findElement(By.xpath("//a[contains(text(), 'Add to Cart')][1]")).click();
		 driver.findElement(By.xpath("//a[img][1]")).click();
		 
		 writeLog("Adding Cats product to the cart");
		 catsPage cats = new catsPage(driver);
		 cats.clickCats();
		 driver.findElement(By.linkText("FL-DLH-02")).click();
		 driver.findElement(By.xpath("//a[contains(text(), 'Add to Cart')][1]")).click();
		 
	}
	@When("the user proceeds to checkout")
	public void the_user_proceeds_to_checkout() {
		writeLog("Checking out with products in the cart");
		WebElement checkoutButton = driver.findElement(By.linkText("Proceed to Checkout"));
		checkoutButton.click();
	}
	@When("selects a payment method and fills the billing details")
	public void selects_a_payment_method_and_fills_the_billing_details() {
		writeLog("Selecting payment method and filling billing details");
		driver.findElement(By.xpath("//input[@name='newOrder']")).click();
	}
	@When("reviews and confirms the order")
	public void reviews_and_confirms_the_order() {
		writeLog("Reviewing and Confirming order");
		driver.findElement(By.linkText("Confirm")).click();
	}
	@Then("the order confirmation message {string} should be displayed")
	public void the_order_confirmation_message_should_be_displayed(String confirmationMessage) {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		assertTrue(driver.getPageSource().contains(confirmationMessage));
		writeLog("Confirmation message is displayed");
	}
}
