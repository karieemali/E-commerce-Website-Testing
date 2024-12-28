package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "strong.current-item")
    public WebElement ProductNameBreadCrumb;
    @FindBy(xpath = "//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[9]/div[3]/button")
    WebElement emailFriendBtn;
    @FindBy(id = "price-value-4")
    public WebElement productPriceLbl;
    @FindBy(linkText = "Add your review")
    public WebElement addReviewLink;
    @FindBy(id = "add-to-wishlist-button-4")
    public WebElement addToWishListBtn;
    @FindBy(linkText = "wishlist")
    public WebElement WishListLink;
    @FindBy(xpath = "//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[9]/div[2]/button")
    public WebElement compareBtn;
    @FindBy(linkText = "product comparison")
    public WebElement compareLink;
    @FindBy(id = "add-to-cart-button-4")
    public WebElement addProdToCardBtn;
    @FindBy(linkText = "shopping cart")
    public WebElement cartLink;

    public void openSendEmail()
    {
        clickButton(emailFriendBtn);
    }
    public void openAddReviewPage()
    {
        clickButton(addReviewLink);
    }
    public void AddProductToWishList()
    {
        clickButton(addToWishListBtn);
    }
    public void redirectToWishListPage()
    {
        clickButton(WishListLink);
    }
    public void AddProductToCompareList()
    {
        clickButton(compareBtn);
    }
    public void redirectToComparePage()
    {
        clickButton(compareLink);
    }
    public void AddProductToCart()
    {
        clickButton(addProdToCardBtn);
    }
    public void redirectToCartPage()
    {
        clickButton(cartLink);
    }
}
