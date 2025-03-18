package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registerPage {
WebDriver driver;
WebElement register;
public registerPage(WebDriver driver) {
	this.driver = driver;
}

public void clickRegister() {
	register = driver.findElement(By.linkText("Register Now!"));
	register.click();
}
}
