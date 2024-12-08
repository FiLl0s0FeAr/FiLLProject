package UI.TestsPages.MainPage;

import UI.PageObjects.MainPageObject;
import UI.BeforeAfterTests.BeforeAfterAllTests;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainCategory extends BeforeAfterAllTests {

    MainPageObject mainPageObject;

    @BeforeMethod
    public void mainPageInit(){
        mainPageObject = new MainPageObject(driver);
    }

    @Test
    @Description("Check title after click on women category")
    public void testTitleAfterClickWomenCategory(){
        mainPageObject.womenClick();

        String actualWomenTitle = driver.getTitle();
        String expectedWomenTitle = "Women - My Store";

        Assert.assertEquals(actualWomenTitle, expectedWomenTitle);
    }

    @Test
    @Description("Check title after click on dresses category")
    public void testTitleAfterClickDressesCategory(){
        mainPageObject.dressesClick();

        String actualDressesTitle = driver.getTitle();
        String expectedDressesTitle = "Dresses - My Store";

        Assert.assertEquals(actualDressesTitle, expectedDressesTitle);
    }

    @Test
    @Description("Check title after click on t-shirts category")
    public void testTitleAfterClickTShirtsCategory(){
        mainPageObject.tshirtsClick();

        String actualTshirtsTitle = driver.getTitle();
        String expectedTshirtsTitle = "T-shirts - My Store";

        Assert.assertEquals(actualTshirtsTitle, expectedTshirtsTitle);
    }
}
