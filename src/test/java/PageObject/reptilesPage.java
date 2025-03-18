package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class reptilesPage {
WebDriver driver;
WebElement Reptiles;
public reptilesPage(WebDriver driver) {
	this.driver = driver;
}

public void clickReptiles() {
	Reptiles =  driver.findElement(By.xpath("//area[@alt='Reptiles']"));
	Reptiles.click();
}
}
