package UI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPageObject{
    public WebDriverWait wait;

    @FindBy(id = "email")
    WebElement logEmail;

    @FindBy(id = "passwd")
    WebElement logPassword;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/p[1]/a")
    WebElement forgotPassword;

    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    @FindBy(id = "email_create")
    WebElement regEmail;

    @FindBy(name = "SubmitCreate")
    WebElement createAccountButton;

    @FindBy(id = "create_account_error")
    WebElement createAccountError;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]")
    WebElement loginError;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/form/fieldset/p/button")
    WebElement retrievePassword;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/p")
    WebElement confirmationMessage;

    public SignInPageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public boolean createAccountButtonIsEnabled(){
        return createAccountButton.isEnabled();
    }

    public void createAccountClick(){
        createAccountButton.click();
    }

    public void createAccount(String emailToCreateAccount){
        regEmail.sendKeys(emailToCreateAccount);
        createAccountClick();
    }

    public boolean loginError(){
        return loginError.isEnabled();
    }

    public boolean createAccountErrorIsEnabled(){
        return createAccountError.isEnabled();
    }

    public void enterLogEmail(String email){
        logEmail.sendKeys(email);
    }

    public void enterPassword(String password){
        logPassword.sendKeys(password);
    }

    public void signInButtonClick(){
        signInButton.click();
    }

    public boolean forgotButtonIsEnabled(){
        return forgotPassword.isEnabled();
    }

    public void forgotButtonClick(){
        forgotPassword.click();
    }

    public void retrievePasswordButtonClick(){
        retrievePassword.click();
    }

    public boolean confirmationMessageIsDisplayed(){
        return confirmationMessage.isDisplayed();
    }
}
