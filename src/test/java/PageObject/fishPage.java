package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class fishPage {
WebDriver driver;
WebElement Fish;

public fishPage(WebDriver driver) {
	this.driver = driver;
}

public void clickFish() {
	Fish = driver.findElement(By.xpath("//area[@alt='Fish']"));
	Fish.click();
}
}
