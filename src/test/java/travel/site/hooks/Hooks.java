package travel.site.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import travel.site.factory.DriverFactory;

import java.time.Duration;

public class Hooks {
    WebDriver driver;
    @Before
    public void setUp(){
       driver= DriverFactory.initDriver();
    }


    @After
    public void close_driver (Scenario scenario){

            String scenarioName = scenario.getName();

            if (scenario.isFailed()){
                TakesScreenshot takescreenshot = (TakesScreenshot) driver;
                byte[] screenShot = takescreenshot.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenShot,"image/png",scenarioName+"_failureScreenshot");
            }

        driver.quit();
    }
}
