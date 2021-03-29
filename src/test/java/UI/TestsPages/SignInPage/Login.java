package UI.TestsPages.SignInPage;

import UI.PageObjects.SignInPageObject;
import UI.BeforeAfterTests.BeforeAfterAllTests;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends BeforeAfterAllTests {

    SignInPageObject signInPageObject;

    @BeforeMethod
    public void setSignInURL(){
        String baseForgotPasswordURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        driver.get(baseForgotPasswordURL);
    }

    @BeforeMethod
    public void signInPageInit(){
        signInPageObject = new SignInPageObject(driver);
    }

    @Test
    @Description("Login with valid data")
    public void testLogInWithValidData(){
        String email = "ti51@ukr.net";
        String password = "simplePassword";

        signInPageObject.enterLogEmail(email);
        signInPageObject.enterPassword(password);

        signInPageObject.signInButtonClick();

        String expectedProfileURL = "http://automationpractice.com/index.php?controller=my-account";
        String acturalProfileURL = driver.getCurrentUrl();

        Assert.assertEquals(acturalProfileURL, expectedProfileURL);
    }

    @Test
    @Description("Try to login with invalid email")
    public void testLogInWithInvalidEmail(){
        String email = "";
        String password = "";

        signInPageObject.enterLogEmail(email);
        signInPageObject.enterPassword(password);

        signInPageObject.signInButtonClick();

        Assert.assertTrue(signInPageObject.loginError());
    }

    @Test
    @Description("Try to login with invalid email")
    public void testLogInWithInvalidPassword(){
        String email = "ti51@ukr.net";
        String password = "";

        signInPageObject.enterLogEmail(email);
        signInPageObject.enterPassword(password);

        signInPageObject.signInButtonClick();

        Assert.assertTrue(signInPageObject.loginError());
    }

    @Test
    @Description("Test forgot password button")
    public void testForgotButton(){
        Assert.assertTrue(signInPageObject.forgotButtonIsEnabled());
        signInPageObject.forgotButtonClick();

        String expectedForgotPasswordURL = "http://automationpractice.com/index.php?controller=password";
        String actualForgotPasswordURL = driver.getCurrentUrl();

        Assert.assertEquals(actualForgotPasswordURL, expectedForgotPasswordURL);
    }

}
