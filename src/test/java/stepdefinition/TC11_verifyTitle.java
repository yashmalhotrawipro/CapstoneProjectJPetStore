package stepdefinition;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;
import PageObject.homePage;
import Utility.log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TC11_verifyTitle extends log4j{
	WebDriver driver;
	@Given("user is on the homepage")
	public void user_is_on_the_homepage() {
		driver = Hooks.driver;
	    driver.get("https://petstore.octoperf.com/");
	    writeLog("Starting test case to verify title");
	    homePage home = new homePage(driver);
	    home.clickEnterStore();
	}
	@Then("the page title should be {string}")
	public void the_page_title_should_be(String expectedTitle) {
		writeLog("Verifying Title");
	    String actualTitle = driver.getTitle();
	    assertEquals(actualTitle, expectedTitle, "Page Title does not match the expected title");
	}



}
