package stepdefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertTrue;
import PageObject.homePage;
import PageObject.loginPage;
import Utility.log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC14_logout extends log4j{
	WebDriver driver;
	@Given("the user is logged in")
	public void the_user_is_logged_in() {
		driver = Hooks.driver;
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://petstore.octoperf.com/");
	    writeLog("Starting Logout Test Case");
	    homePage home = new homePage(driver);
		home.clickEnterStore();
		loginPage login = new loginPage(driver);
		login.clickLogin();
		driver.findElement(By.name("username")).sendKeys("yash");
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("yash123");
		driver.findElement(By.name("signon")).click();
		writeLog("User is logged in");
	}
	@When("the user clicks the logout button")
	public void the_user_clicks_the_logout_button() {
	    driver.findElement(By.linkText("Sign Out")).click();
	    writeLog("clicked log out button");
	}
	@Then("the user should be logged out from the application")
	public void the_user_should_be_logged_out_from_the_application() {
	    List<WebElement> logoutButton = driver.findElements(By.linkText("Sign Out"));
	    assertTrue(logoutButton.isEmpty(), "Logout button is still present, user might not be logged out");
	    writeLog("user is logged out and redirected to the log in page");
	    writeLog("verifying logout message");
	    assertTrue(driver.getPageSource().contains("You are logged out successfully"), "Logout message does not appear");
	    writeLog("verification result fails");
	}



}
