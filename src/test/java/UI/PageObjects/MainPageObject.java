package UI.PageObjects;

import UI.BeforeAfterTests.BeforeAfterAllTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageObject extends BeforeAfterAllTests {

    @FindBy(xpath = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")
    WebElement headerSignIn;

    @FindBy(xpath = "//a[text()='Contact us']")
    WebElement headerContactUs;

    @FindBy(xpath = "//a[text()='Women']")
    WebElement women;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    WebElement dresses;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
    WebElement tshirts;

    @FindBy(xpath = "//*[@id=\"footer\"]/div/section[2]/div/div/ul/li/a")
    WebElement footerCategotyWomen;

    @FindBy(id = "search_query_top")
    WebElement searchField;

    @FindBy(name = "submit_search")
    WebElement submitSearch;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    WebElement searchError;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[2]/div/div[2]")
    WebElement searchResult;

    public MainPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void headerSignInClick(){
        headerSignIn.click();
    }

    public void headerContactUsClick(){
        headerContactUs.click();
    }

    public void womenClick(){
        women.click();
    }

    public void dressesClick(){
        dresses.click();
    }

    public void tshirtsClick(){
        tshirts.click();
    }

    public void footerCategoryWomenClick(){
        footerCategotyWomen.click();
    }

    public void submitSearchClick(){
        submitSearch.click();
    }

    public void enterSearchQuery(String query){
        searchField.sendKeys(query);
        submitSearchClick();
    }

    public boolean searchErrorIsDisplayed(){
        return searchError.isDisplayed();
    }

    public boolean searchResultIsDisplayed(){
        return searchResult.isDisplayed();
    }
}
