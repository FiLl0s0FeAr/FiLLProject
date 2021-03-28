package UI.PageObjects;

import UI.BeforeAfterTests.BeforeAfterAllTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageObject extends BeforeAfterAllTests {


    @FindBy(xpath="/html/body/div/div[2]/div/div[2]/div/ul/li[1]/a")
    WebElement title;

    public MainPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getTitleOfMainPage(){
        return title.getText();
    }
}
