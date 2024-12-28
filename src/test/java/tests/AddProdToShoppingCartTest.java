package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProdToShoppingCartTest extends TestBase{

    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;

    String prodName = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void UserCanSearchWithAutoSuggest() throws InterruptedException {
        searchPage =new SearchPage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        productDetailsPage =new ProductDetailsPage(driver);
        Assert.assertEquals(productDetailsPage.ProductNameBreadCrumb.getText(),prodName);
    }
    @Test(priority = 2)
    public void UserCanAddProdToCart() throws InterruptedException {
        cartPage = new CartPage(driver);
        productDetailsPage =new ProductDetailsPage(driver);
        productDetailsPage.AddProductToCart();
        Thread.sleep(1000);
        productDetailsPage.redirectToCartPage();
        //driver.get("https://demo.nopcommerce.com" + "/cart");
        Assert.assertTrue(cartPage.ProdNameInCart.getText().contains(prodName));
        Assert.assertTrue(cartPage.totalLbl.getText().contains("3,600"));
    }
    @Test(priority = 3)
    public void UserCanRemoveProdFromCart()
    {
        cartPage = new CartPage(driver);
        cartPage.removeProductFromCart();
    }
}
