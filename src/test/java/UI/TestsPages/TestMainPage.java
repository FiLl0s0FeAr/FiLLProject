package UI.TestsPages;

import UI.PageObjects.MainPageObject;
import UI.BeforeAfterTests.PreconditionBeforeAfterAllTests;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMainPage extends PreconditionBeforeAfterAllTests {

    MainPageObject mainPageObject;

    @BeforeMethod
    public void mainPageInit(){
         mainPageObject = new MainPageObject(driver);
    }

    @Test
    @Description("Get title")
    public void testTitle(){
        String actualResult = mainPageObject.getTitleOfMainPage();
        String expectedResult = "My Store";
        Assert.assertEquals(actualResult, expectedResult);
    }
}