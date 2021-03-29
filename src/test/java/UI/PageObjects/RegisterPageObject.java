package UI.PageObjects;

import UI.BeforeAfterTests.BeforeAfterAllTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BeforeAfterAllTests{

    @FindBy(id = "email_create")
    WebElement regEmail;

    @FindBy(name = "SubmitCreate")
    WebElement createAccountButton;

    @FindBy(xpath = "//*[@id=\"id_gender1\"]")
    WebElement mr;

    @FindBy(xpath = "//input[@id=\"id_gender2\"]")
    WebElement mrs;

    @FindBy(name = "customer_firstname")
    WebElement firstName;

    @FindBy(name = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "days")
    WebElement day;

    @FindBy(id = "months")
    WebElement month;

    @FindBy(id = "years")
    WebElement year;

    public void createAccountClick(){
        createAccountButton.click();
    }

    public void createAccount(String emailToCreateAccount){
        regEmail.sendKeys(emailToCreateAccount);
        createAccountClick();
    }

    public RegisterPageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void mrClick(){
        mr.click();
    }

    public void mrsClick(){
        mrs.click();
    }

    public boolean mrChecked(){
        return mr.isSelected();
    }

}
