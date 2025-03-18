import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
features = {"src/test/resources/features"},
glue = {"stepdefinition"},
tags = "",
plugin = {"pretty","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", "html:target/cucumber-report.html"}, monochrome = true
)
public class testrunner extends AbstractTestNGCucumberTests
{
}