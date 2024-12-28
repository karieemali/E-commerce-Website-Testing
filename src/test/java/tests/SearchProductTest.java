package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{

    ProductDetailsPage productDetailsPage;
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchPage;

    @Test
    public void userCanSearchForProduct()
    {
        searchPage =new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        searchPage.productSearch(productName);
        Assert.assertTrue(productDetailsPage.ProductNameBreadCrumb.getText().equalsIgnoreCase(productName));
       // Assert.assertEquals(productDetailsPage.ProductNameBreadCrumb.getText(),productName);
    }
}
