package UI.TestsPages.WomenPage;

import UI.PageObjects.BuyPageObject;
import UI.BeforeAfterTests.BeforeAfterAllTests;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dresses extends BeforeAfterAllTests {

    BuyPageObject buyPageObject;

    @BeforeMethod
    public void setBuyDressURL(){
        String baseDressURL = "http://automationpractice.com/index.php?id_product=3&controller=product";
        driver.get(baseDressURL);
    }

    @BeforeMethod
    public void buyDressInit(){
        buyPageObject = new BuyPageObject(driver);
    }

    @Test
    @Description("Full buy one dress without any condition payment bank")
    public void fullBuyOneDressWithoutAnyConditionPaymentBank(){

        String email = "ti51@ukr.net";
        String password = "simplePassword";
        String url = "http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment";

        buyPageObject.addToCartP1ButtonClick();
        buyPageObject.cartClick();
        driver.navigate().refresh();
        buyPageObject.proccedToBuyButtonClick();

        buyPageObject.enterLogEmail(email);
        buyPageObject.enterPassword(password);
        buyPageObject.signInButtonClick();

        buyPageObject.proceedButtonAfterSignInClick();
        buyPageObject.cgvClick();
        buyPageObject.proceedButtonAfterCGV();

        buyPageObject.payByBankClick();
        buyPageObject.confirmOrderButtonClick();

        Assert.assertNotEquals(driver.getCurrentUrl(), url);
    }

    @Test
    @Description("Full buy one dress without any condition payment yourself")
    public void fullBuyOneDressWithoutAnyConditionPaymentBYourself(){

        String email = "ti51@ukr.net";
        String password = "simplePassword";
        String url = "http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment";

        buyPageObject.addToCartP1ButtonClick();
        buyPageObject.cartClick();
        driver.navigate().refresh();
        buyPageObject.proccedToBuyButtonClick();

        buyPageObject.enterLogEmail(email);
        buyPageObject.enterPassword(password);
        buyPageObject.signInButtonClick();

        buyPageObject.proceedButtonAfterSignInClick();
        buyPageObject.cgvClick();
        buyPageObject.proceedButtonAfterCGV();

        buyPageObject.payByYourselfClick();
        buyPageObject.confirmOrderButtonClick();

        Assert.assertNotEquals(driver.getCurrentUrl(), url);
    }
}
