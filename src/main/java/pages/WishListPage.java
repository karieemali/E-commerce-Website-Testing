package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement productCell;
    @FindBy(css = "h1")
    public WebElement wishListHeader;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[8]/button")
    public WebElement removeProductFromWishList;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div")
    public WebElement emptyWishListLbl;

    public void removeProductFromWishList()
    {
        clickButton(removeProductFromWishList);
    }


}
