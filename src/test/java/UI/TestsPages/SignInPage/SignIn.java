package UI.TestsPages.SignInPage;

import UI.PageObjects.SignInPageObject;
import UI.BeforeAfterTests.BeforeAfterAllTests;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignIn extends BeforeAfterAllTests {

    SignInPageObject signInPageObject;

    @BeforeMethod
    public void setSignInURL(){
        String baseSignInURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        driver.get(baseSignInURL);
    }

    @BeforeMethod
    public void signInPageInit(){
        signInPageObject = new SignInPageObject(driver);
    }

    @Test
    @Description("Click on create account button without enter email")
    public void testCreateAccountWithoutEmail(){
        Assert.assertTrue(signInPageObject.createAccountButtonIsEnabled());

        signInPageObject.createAccountClick();
        Assert.assertTrue(signInPageObject.createAccountErrorIsEnabled());
    }

    @Test
    @Description("Create account with invalid email")
    public void testCreateAccountWithInvalidEmail(){
        signInPageObject.createAccount("InvalidEmail");

        Assert.assertTrue(signInPageObject.createAccountErrorIsEnabled());
    }

    @Test
    @Description("Create account with valid email")
    public void testCreateAccountWithValidEmail(){
        String email = "ti51@ukr.net";
        signInPageObject.createAccount(email);

        String expectedCreateAccountURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        String actualCreateAccountURL = driver.getCurrentUrl();

        Assert.assertEquals(actualCreateAccountURL, expectedCreateAccountURL);
    }
}
