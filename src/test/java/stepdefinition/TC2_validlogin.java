package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertTrue;
import PageObject.homePage;
import PageObject.loginPage;
import Utility.log4j;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC2_validlogin extends log4j{
	WebDriver driver;
	@Given("the user is on the login page for valid login")
	public void the_user_is_on_the_login_page_for_valid_login() {
	    driver = Hooks.driver;
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://petstore.octoperf.com/");
	    writeLog("Starting valid Login Test Case");
	}
	@When("the user enters valid username {string} and password {string}")
	public void the_user_enters_valid_username_and_password(String uname, String pass) throws InterruptedException {
		homePage home = new homePage(driver);
		home.clickEnterStore();
		loginPage login = new loginPage(driver);
		login.clickLogin();
		driver.findElement(By.name("username")).sendKeys(uname);
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys(pass);
		writeLog("Entered valid username and password");
	}
	
	@And("clicks on the login button for valid login")
	public void clicks_on_the_login_button() {
		driver.findElement(By.name("signon")).click();
		writeLog("Clicked login Button");
	}
	@Then("the user should redirected to home page with a welcome message")
	public void the_user_should_redirected_to_home_page() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		writeLog("User is logging in...");
		assertTrue(driver.getCurrentUrl().contains("https://petstore.octoperf.com/actions/Catalog.action"));
		assertTrue(driver.getPageSource().contains("Welcome"));
		writeLog("User logged in successfully");
	}
	



}
