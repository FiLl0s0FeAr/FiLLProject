package UI.PageObjects;

import UI.BeforeAfterTests.BeforeAfterAllTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyPageObject {

    public WebDriverWait wait;

    @FindBy(xpath = "//*[@id='add_to_cart']/button")
    WebElement addToCartP1Button;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement proccedToCheckoutButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement proccedToBuyButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
    WebElement proceedButtonAfterSignIn;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button")
    WebElement proceedButtonAfterCGV;

    @FindBy(id = "email")
    WebElement logEmail;

    @FindBy(id = "passwd")
    WebElement logPassword;

    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    @FindBy(id = "cgv")
    WebElement cgv;
    
    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    WebElement payByBank;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
    WebElement payByYourself;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    WebElement confirmOrderButton;

    @FindBy(xpath = "//*[@id=\"list\"]/a")
    WebElement list;

    @FindBy(id = "grid")
    WebElement grid;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    WebElement cart;

    public void proceedButtonAfterCGV(){
        proceedButtonAfterCGV.click();
    }

    public void proceedButtonAfterSignInClick(){
        proceedButtonAfterSignIn.click();
    }

    public void gridClick(){
        wait.until(ExpectedConditions.visibilityOf(grid));
        grid.click();
    }

    public void cartClick(){
        addToCartP1ButtonClick();
        cart.click();
    }

    public void listClick(){
        //wait.until(ExpectedConditions.visibilityOf(list));
        list.click();
    }

    public void confirmOrderButtonClick(){
        confirmOrderButton.click();
    }

    public void payByBankClick(){
        payByBank.click();
    }

    public void payByYourselfClick(){
        payByYourself.click();
    }

    public void cgvClick(){
        cgv.click();
    }

    public void signInButtonClick(){
        signInButton.click();
    }

    public void enterLogEmail(String email){
        logEmail.sendKeys(email);
    }

    public void enterPassword(String password){
        logPassword.sendKeys(password);
    }

    public void proccedToBuyButtonClick(){
        proccedToBuyButton.click();
    }

    public void proccedToCheckoutButtonClick(){
        proccedToCheckoutButton.click();
    }

    public void addToCartP1ButtonClick(){
        //wait.until(ExpectedConditions.visibilityOf(addToCartP1Button));
        addToCartP1Button.click();
    }

    public BuyPageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
