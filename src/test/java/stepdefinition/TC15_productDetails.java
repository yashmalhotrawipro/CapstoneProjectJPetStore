package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;
import PageObject.fishPage;
import PageObject.homePage;
import Utility.log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TC15_productDetails extends log4j {
	WebDriver driver;
	@Given("user is on the product details page")
	public void user_is_on_the_products_details_page() {
	    driver = Hooks.driver;
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://petstore.octoperf.com/");
	    writeLog("Starting Product details validation Test Case");
	    homePage home = new homePage(driver);
		home.clickEnterStore();
		fishPage fish = new fishPage(driver);
		fish.clickFish();
		driver.findElement(By.linkText("FI-SW-01")).click();
		driver.findElement(By.linkText("EST-1")).click();
		writeLog("directed to the product details page");
	}
	@Then("the product details should be displayed correctly")
	public void the_product_details_should_be_displayed_correctly() {
		WebElement productTitle = driver.findElement(By.xpath("//font[contains(text(),'Large')]"));
		assertTrue(productTitle.isDisplayed(), "Product Title is not Displayed");
	    WebElement productPrice = driver.findElement(By.xpath("//table//tr[6]//td"));
	    assertTrue(productPrice.isDisplayed(), "Product price is not displayed");
	    assertTrue(driver.getPageSource().contains("Salt Water fish from Australia"),"Product description not found");
	    writeLog("product details verified");
	}
}
