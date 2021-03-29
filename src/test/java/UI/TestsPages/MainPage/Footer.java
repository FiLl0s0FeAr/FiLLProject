package UI.TestsPages.MainPage;

import UI.PageObjects.MainPageObject;
import UI.BeforeAfterTests.BeforeAfterAllTests;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Footer extends BeforeAfterAllTests {

    MainPageObject mainPageObject;

    @BeforeMethod
    public void mainPageInit(){
        mainPageObject = new MainPageObject(driver);
    }

    @Test
    @Description
    public void testFooterCategoryWomenLink(){
        mainPageObject.footerCategoryWomenClick();

        String expectedFooterCategoryWomenLink = "http://automationpractice.com/index.php?id_category=3&controller=category";
        String actualFooterCategoryWomenLink = driver.getCurrentUrl();

        Assert.assertEquals(actualFooterCategoryWomenLink, expectedFooterCategoryWomenLink);
    }
}
