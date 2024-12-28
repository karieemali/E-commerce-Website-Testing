package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "small-searchterms")
    WebElement searchTxtBox;
    @FindBy(xpath = "//*[@id=\"small-search-box-form\"]/button")
    WebElement searchBtn;

    //AutoSuggest
    @FindBy(id = "ui-id-1")
    List <WebElement> productList;

    public void productSearch(String productName)
    {
        sendTxt(searchTxtBox,productName);
        clickButton(searchBtn);
    }

    public void productSearchUsingAutoSuggest(String searchTxt) throws InterruptedException {
        sendTxt(searchTxtBox,searchTxt);
        Thread.sleep(1000);
        productList.get(0).click();

    }

}
