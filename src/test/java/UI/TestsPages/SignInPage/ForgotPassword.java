package UI.TestsPages.SignInPage;

import UI.PageObjects.SignInPageObject;
import UI.BeforeAfterTests.BeforeAfterAllTests;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPassword extends BeforeAfterAllTests {

    SignInPageObject signInPageObject;

    @BeforeMethod
    public void setSignInURL(){
        String baseForgotPasswordURL = "http://automationpractice.com/index.php?controller=password";
        driver.get(baseForgotPasswordURL);
    }

    @BeforeMethod
    public void signInPageInit(){
        signInPageObject = new SignInPageObject(driver);
    }

    @Test
    @Description("Forgot password with invalid email")
    public void testForgotPasswordWithInvalidEmail(){
        String email = "123";

        signInPageObject.enterLogEmail(email);
        signInPageObject.retrievePasswordButtonClick();

        Assert.assertTrue(signInPageObject.loginError());
    }

    @Test
    @Description("Forgot password with valid email")
    public void testForgotPasswordWithValidEmail(){
        String email = "ti51@ukr.net";

        signInPageObject.enterLogEmail(email);
        signInPageObject.retrievePasswordButtonClick();

        Assert.assertTrue(signInPageObject.confirmationMessageIsDisplayed());
    }
}
