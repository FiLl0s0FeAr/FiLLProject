package UI.PageObjects;

import UI.BeforeAfterTests.BeforeAfterAllTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPageObject{

    public WebDriverWait wait;

    @FindBy(xpath = "//*[text()='Your personal information']")
    WebElement personalInfo;

    @FindBy(id = "email_create")
    WebElement regEmail;

    @FindBy(name = "SubmitCreate")
    WebElement createAccountButton;

    @FindBy(id = "id_gender1")
    WebElement mr;

    @FindBy(xpath = "//input[@id=\"id_gender2\"]")
    WebElement mrs;

    @FindBy(name = "customer_firstname")
    WebElement customerFirstName;

    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(name = "customer_lastname")
    WebElement customerLastName;

    @FindBy(id = "lastname")
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

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement state;

    @FindBy(id = "postcode")
    WebElement postcode;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhone;

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    WebElement accountName;

    public boolean accountNameIsEnabled(){
        wait.until(ExpectedConditions.visibilityOf(accountName));
        return accountName.isEnabled();
    }

    public void registerButtonClick(){
        registerButton.click();
    }

    public void createAccountClick(){
        createAccountButton.click();
    }

    public void createAccount(String emailToCreateAccount){
        regEmail.sendKeys(emailToCreateAccount);
        createAccountClick();
    }

    public RegisterPageObject(WebDriver driver){
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void mrClick(){
        wait.until(ExpectedConditions.visibilityOf(mr));
        mr.click();
    }

    public void mrsClick(){
        mrs.click();
    }

    public void personalInfoClick(){
        personalInfo.click();
    }

    public void customerFirstNameClick(){
        wait.until(ExpectedConditions.visibilityOf(customerFirstName));
        customerFirstName.click();
    }

    public void customerFirstNameSend(String name){
        wait.until(ExpectedConditions.visibilityOf(customerFirstName));
        customerFirstName.sendKeys(name);
    }

    public String getStyleInfoCustomerFirstName(){
        return customerFirstName.getCssValue("color");
    }

    public void customerLastNameClick(){
        wait.until(ExpectedConditions.visibilityOf(customerLastName));
        customerLastName.click();
    }

    public void customerLastNameSend(String surname){
        wait.until(ExpectedConditions.visibilityOf(customerLastName));
        customerLastName.sendKeys(surname);
    }

    public String getStyleInfoCustomerLastName(){
        return customerFirstName.getCssValue("color");
    }

    public void passwordClick(){
        wait.until(ExpectedConditions.visibilityOf(password));
        password.click();
    }

    public void passwordSend(String pass){
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(pass);
    }

    public String getStyleInfoPassword(){
        return password.getCssValue("color");
    }

    public void emailClick(){
        wait.until(ExpectedConditions.visibilityOf(email));
        email.click();
    }

    public String getEmail(){
        return email.getAttribute("value");
    }

    public String getStyleInfoEmail(){
        return email.getCssValue("color");
    }

    public void setDoB(){
        day.click();
        day.sendKeys("4");
        month.click();
        month.sendKeys("December");
        year.click();
        year.sendKeys("1998");
    }

    public String getFirstName(){
        return firstName.getAttribute("value");
    }

    public String getLastName(){
        return lastName.getAttribute("value");
    }

    public void setCompanyName(String companyName){
        company.sendKeys(companyName);
    }

    public void setAddress1(String address){
        address1.sendKeys(address);
    }

    public void setCity(String cityName){
        city.sendKeys(cityName);
    }

    public void setState(String stateName){
        state.sendKeys(stateName);
    }

    public void setPostcode(String code){
        postcode.sendKeys(code);
    }

    public void setMobilePhone(String phone){
        mobilePhone.sendKeys(phone);
    }
}
