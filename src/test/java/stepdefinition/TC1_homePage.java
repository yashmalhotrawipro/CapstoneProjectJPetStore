package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import PageObject.homePage;
import Utility.log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_homePage extends log4j{
WebDriver driver;

@Given("User is in the Welcome Page")
public void user_is_in_the_welcome_page() {
    driver = Hooks.driver;
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://petstore.octoperf.com/");
    writeLog("Starting homepage verification");
}
@When("he clicks on Enter the Store")
public void he_clicks_on_enter_the_store() {
    homePage home = new homePage(driver);
    home.clickEnterStore();
    writeLog("Clicked Enter the Store button");
}
@Then("he should be navigated to homepage")
public void he_should_be_navigated_to_homepage() {
	 writeLog("Home Page appears");
}

	
}
