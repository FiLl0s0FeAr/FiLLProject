package UI.TestsPages.MainPage;

import UI.PageObjects.MainPageObject;
import UI.BeforeAfterTests.BeforeAfterAllTests;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Header extends BeforeAfterAllTests {

    MainPageObject mainPageObject;

    @BeforeMethod
    public void mainPageInit(){
        mainPageObject = new MainPageObject(driver);
    }

    @Test
    @Description("Check title My Store")
    public void testTitle(){
        String actualMainTitle = driver.getTitle();
        String expectedMainTitle = "My Store";
        Assert.assertEquals(actualMainTitle, expectedMainTitle);
    }

    @Test
    @Description
    public void testURLAfterClickContactUs(){
        mainPageObject.headerContactUsClick();

        String expectedContactUs = "http://automationpractice.com/index.php?controller=contact";
        String actualContactUs = driver.getCurrentUrl();

        Assert.assertEquals(actualContactUs, expectedContactUs);
    }

    @Test
    @Description("Check url after click on sign in")
    public void testURLAfterClickSignIn(){
        mainPageObject.headerSignInClick();

        String expectedSignIn = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        String actualSignIn = driver.getCurrentUrl();

        Assert.assertEquals(actualSignIn, expectedSignIn);
    }

    @Test
    @Description("Search with invalid data")
    public void testSearchWithInvalidData(){
        String query = "";

        mainPageObject.enterSearchQuery(query);

        Assert.assertTrue(mainPageObject.searchErrorIsDisplayed());
    }

    @Test
    @Description
    public void testSearchWithValidData(){
        String query = "Printed Dress";

        mainPageObject.enterSearchQuery(query);

        Assert.assertTrue(mainPageObject.searchResultIsDisplayed());
    }
}
