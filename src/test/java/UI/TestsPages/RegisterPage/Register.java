package UI.TestsPages.RegisterPage;

import UI.PageObjects.RegisterPageObject;
import UI.BeforeAfterTests.BeforeAfterAllTests;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Register extends BeforeAfterAllTests {

    RegisterPageObject registerPageObject;

    @BeforeClass
    public void setRegisterURL(){
        String baseRegisterURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        driver.get(baseRegisterURL);

        registerPageObject = new RegisterPageObject(driver);

        String email = "ti51@ukr.net";
        registerPageObject.createAccount(email);

        String expectedCreateAccountURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        String actualCreateAccountURL = driver.getCurrentUrl();

        Assert.assertEquals(actualCreateAccountURL, expectedCreateAccountURL);
    }

}
