package UI.BeforeAfterTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class PreconditionBeforeAfterAllTests {

    public String baseURL = "http://automationpractice.com/index.php";
    public WebDriver driver;

    @BeforeMethod(description = "Configure driver and base url before tests")
    public void beforeSuit(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);

        driver = new ChromeDriver(options);
        driver.get(baseURL);
    }

    @AfterSuite
    public void afterSuite(){
        driver.quit();
    }
}
