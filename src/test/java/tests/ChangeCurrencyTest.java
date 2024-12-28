package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
public class ChangeCurrencyTest extends TestBase {
    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    String productName ="Apple MacBook Pro 13-inch";
    SearchPage searchPage;

    @Test(priority = 1)
    public void UserCanChangeCurrency()
    {
        homePage =new HomePage(driver);
        homePage.changeCurrency();
    }

    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest() throws InterruptedException {
        searchPage =new SearchPage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        productDetailsPage =new ProductDetailsPage(driver);
        Assert.assertEquals(productDetailsPage.ProductNameBreadCrumb.getText(),productName);
        Assert.assertTrue(productDetailsPage.productPriceLbl.getText().contains("€"));
        System.out.println(productDetailsPage.productPriceLbl.getText());
    }
}
