package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductsToCompareTest extends TestBase{

    String firstNameProd = "Apple MacBook Pro 13-inch";
    String lastNameProd = "Asus N551JK-XO076H Laptop";

    //1) search 1 prod && Add compare
    //2) search 2 prod && Add compare
    //3) clear list

    ProductDetailsPage productDetailsPage;
    HomePage homePage;
    ComparePage comparePage;
    SearchPage searchPage;

    @Test(priority = 1)
    public void UserCanCompareProd() throws InterruptedException {
        productDetailsPage =new ProductDetailsPage(driver);
        homePage =new HomePage(driver);
        comparePage =new ComparePage(driver);
        searchPage =new SearchPage(driver);

        searchPage.productSearchUsingAutoSuggest("MacB");
        Assert.assertTrue(productDetailsPage.ProductNameBreadCrumb.getText().contains(firstNameProd));
        productDetailsPage.AddProductToCompareList();

        searchPage.productSearchUsingAutoSuggest("Asus");
        Assert.assertTrue(productDetailsPage.ProductNameBreadCrumb.getText().contains(lastNameProd));
        productDetailsPage.AddProductToCompareList();

        Thread.sleep(1000);
        //driver.get("https://demo.nopcommerce.com" + "/compareproducts");
        productDetailsPage.redirectToComparePage();
        Assert.assertTrue(comparePage.firstProd.getText().equals("Asus N551JK-XO076H Laptop"));
        Assert.assertTrue(comparePage.secondProd.getText().equals("Apple MacBook Pro 13-inch"));
        comparePage.compareProducts();
    }
    @Test(priority = 2)
    public void UserCanClearCompareList()
    {
        comparePage.clearCompareProducts();
        Assert.assertTrue(comparePage.noDataLbl.getText().contains("You have no items to compare."));
    }
}
