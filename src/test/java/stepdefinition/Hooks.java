package stepdefinition;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
public class Hooks {
	public static WebDriver driver;
	public static ExtentReports extent = new ExtentReports ("C:\\Users\\Administrator\\Desktop\\Selenuim\\CapstoneProject\\Reports\\testreports.html", true);;
   public static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
  
   @Before
   public void beforeScenario(Scenario scenario) {
       ExtentTest test = extent.startTest(scenario.getName());
       testThread.set(test);
      driver = new EdgeDriver();
   }
   @After
   public void afterScenario(Scenario scenario) {
       ExtentTest test = testThread.get();
       if (scenario.isFailed()) {
           test.log(LogStatus.FAIL, "Scenario failed: " + scenario.getName());
           File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
           String screenshotPath ="C:\\Users\\Administrator\\Desktop\\Selenuim\\CapstoneProject\\Screenshots\\"+ scenario.getName() +  ".jpeg";
           try {
               FileUtils.copyFile(src, new File(screenshotPath));
               test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
           } catch (IOException e) {
               e.printStackTrace();
               test.log(LogStatus.WARNING, "Failed to save screenshot: " + e.getMessage());
           }
       } else {
           test.log(LogStatus.PASS, "Scenario passed: " + scenario.getName());
       }
       extent.flush();
		
		  if (driver!= null) { driver.quit(); driver = null; }
		
   }
}

