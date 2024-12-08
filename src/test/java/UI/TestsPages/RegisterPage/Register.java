package UI.TestsPages.RegisterPage;

import UI.PageObjects.RegisterPageObject;
import UI.BeforeAfterTests.BeforeAfterAllTests;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Register extends BeforeAfterAllTests {

    RegisterPageObject registerPageObject;

    @BeforeClass
    public void setRegisterURL(){
        String baseRegisterURL = "http://automationpractice.com/index.php?controller=authentication";
        driver.get(baseRegisterURL);

        registerPageObject = new RegisterPageObject(driver);

        String email = "ti555555@ukr.net";
        registerPageObject.createAccount(email);
    }

    @Test
    @Description("Choose gender Mr and Mrs")
    public void testGenderMR(){
        registerPageObject.mrClick();
        registerPageObject.mrsClick();
    }

    @Test
    @Description("check customer first name, last name, password red field")
    public void testRedField(){

        registerPageObject.customerFirstNameClick();
        registerPageObject.personalInfoClick();
        Assert.assertEquals(registerPageObject.getStyleInfoCustomerFirstName(), "rgba(241, 51, 64, 1)");

        registerPageObject.customerLastNameClick();
        registerPageObject.personalInfoClick();
        Assert.assertEquals(registerPageObject.getStyleInfoCustomerLastName(), "rgba(241, 51, 64, 1)");

        registerPageObject.passwordClick();
        registerPageObject.personalInfoClick();
        Assert.assertEquals(registerPageObject.getStyleInfoPassword(), "rgba(241, 51, 64, 1)");
    }

    @Test
    @Description("check customer first name, last name, email, password green field")
    public void testGreenFields(){

        registerPageObject.customerFirstNameClick();
        registerPageObject.customerFirstNameSend("Sergey");
        registerPageObject.personalInfoClick();
        Assert.assertEquals(registerPageObject.getStyleInfoCustomerFirstName(), "rgba(53, 179, 63, 1)");

        registerPageObject.customerLastNameClick();
        registerPageObject.customerLastNameSend("Rublyov");
        registerPageObject.personalInfoClick();
        Assert.assertEquals(registerPageObject.getStyleInfoCustomerLastName(), "rgba(53, 179, 63, 1)");

        Assert.assertEquals(registerPageObject.getEmail(), "ti555555@ukr.net");
        registerPageObject.emailClick();
        registerPageObject.personalInfoClick();
        Assert.assertEquals(registerPageObject.getStyleInfoEmail(), "rgba(53, 179, 63, 1)");

        registerPageObject.passwordClick();
        registerPageObject.passwordSend("simplePassword");
        registerPageObject.personalInfoClick();
        Assert.assertEquals(registerPageObject.getStyleInfoPassword(), "rgba(53, 179, 63, 1)");
    }

    @Test
    @Description("full registration with valid data")
    public void testFullValidRegistration(){
        String email = "ti555555@ukr.net";
        String name = "Serget";
        String surname = "Rublyov";
        String password = "simplePassword";
        String company = "A-level";
        String address = "Address";
        String city = "Kharkiv";
        String state = "Texas";
        String postcode = "12345";
        String phone = "+38 093 555 5555";

        registerPageObject.createAccount(email);
        registerPageObject.mrClick();

        registerPageObject.customerFirstNameClick();
        registerPageObject.customerFirstNameSend(name);
        registerPageObject.customerLastNameClick();
        registerPageObject.customerLastNameSend(surname);
        registerPageObject.passwordClick();
        registerPageObject.passwordSend(password);
        registerPageObject.setDoB();

        Assert.assertEquals(registerPageObject.getFirstName(), name);
        Assert.assertEquals(registerPageObject.getLastName(), surname);

        registerPageObject.setCompanyName(company);
        registerPageObject.setAddress1(address);
        registerPageObject.setCity(city);
        registerPageObject.setState(state);
        registerPageObject.setPostcode(postcode);
        registerPageObject.setMobilePhone(phone);

        registerPageObject.registerButtonClick();
        Assert.assertTrue(registerPageObject.accountNameIsEnabled());
    }
}
