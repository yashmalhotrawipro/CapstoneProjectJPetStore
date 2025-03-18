package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
WebDriver driver;
WebElement login;

public loginPage(WebDriver driver) {
	this.driver = driver;
}

public void clickLogin() {
	login = driver.findElement(By.linkText("Sign In"));
	login.click();
}
}
