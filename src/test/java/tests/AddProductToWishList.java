package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishList extends TestBase{

    String productName ="Apple MacBook Pro 13-inch";
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    WishListPage wishListPage;

    @Test(priority = 1)
    public void UserCanSearchWithAutoSuggest() throws InterruptedException {
        searchPage =new SearchPage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        productDetailsPage =new ProductDetailsPage(driver);
        Assert.assertEquals(productDetailsPage.ProductNameBreadCrumb.getText(),productName);
    }
    @Test(priority = 2)
    public void UserCanAddProdToWishList()
    {
        productDetailsPage =new ProductDetailsPage(driver);
        productDetailsPage.AddProductToWishList();
        productDetailsPage.redirectToWishListPage();
        wishListPage =new WishListPage(driver);
        Assert.assertTrue(wishListPage.wishListHeader.isDisplayed());
        Assert.assertTrue(wishListPage.productCell.getText().contains(productName));
    }
    @Test(priority = 3)
    public void UserCanRemoveProd()
    {
        wishListPage =new WishListPage(driver);
        wishListPage.removeProductFromWishList();
        Assert.assertTrue(wishListPage.emptyWishListLbl.getText().contains("The wishlist is empty!"));
    }
}
