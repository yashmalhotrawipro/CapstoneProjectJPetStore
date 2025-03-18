package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import PageObject.homePage;
import PageObject.loginPage;
import PageObject.registerPage;
import Utility.log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC4_registerExistingUser extends log4j{
WebDriver driver;
	@Given("the user is on the registration page for existing user")
	public void the_user_is_on_the_registration_page_for_existing_user() {
		driver = Hooks.driver;
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://petstore.octoperf.com/");
	    writeLog("Starting register existing user Test Case");
	    homePage home = new homePage(driver);
	    home.clickEnterStore();
	    loginPage login = new loginPage(driver);
	    login.clickLogin();
	    registerPage registerpage = new registerPage(driver);
	    registerpage.clickRegister();
	    writeLog("Clicked Register Now");
	}
	@When("the user enters {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void the_user_enters(String uname, String pass, String repeatPass, String fname, String lname, String email, String phone, String address1, String address2, String city, String state, String zip, String country) {
		writeLog("Entering credentials");
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("repeatedPassword")).sendKeys(repeatPass);
		driver.findElement(By.name("account.firstName")).sendKeys(fname);
		driver.findElement(By.name("account.lastName")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@name='account.email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='account.phone']")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@name='account.address1']")).sendKeys(address1);
		driver.findElement(By.xpath("//input[@name='account.address2']")).sendKeys(address2);
		driver.findElement(By.xpath("//input[@name='account.city']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@name='account.state']")).sendKeys(state);
		driver.findElement(By.xpath("//input[@name='account.zip']")).sendKeys(zip);
		driver.findElement(By.xpath("//input[@name='account.country']")).sendKeys(country);
		writeLog("Entered all the credentials");
	}
	
	@When("selects the favourite category")
	public void selects_the_favourite_category() {
		writeLog("Selecting favourite category");
	    Select favourite = new Select(driver.findElement(By.name("account.favouriteCategoryId")));
	    favourite.selectByVisibleText("DOGS");
	}
	
	@When("clicks on the Register button for existing user")
	public void clicks_on_the_register_button_for_existing_user() {
		WebElement saveAccInfo = driver.findElement(By.xpath("//input[@name='newAccount']"));
		saveAccInfo.click();
		writeLog("Clicked on Register button");
	}
	@Then("the user should be encountered with an error")
	public void the_user_should_be_encountered_with_an_error() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		assertTrue(driver.getCurrentUrl().contains("https://petstore.octoperf.com/actions/Account.action"));
		assertTrue(driver.getPageSource().contains("Exception Report"));
		writeLog("Encountered with error while registering existing user");
	}
}
