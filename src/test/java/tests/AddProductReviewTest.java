package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import java.time.Duration;
public class AddProductReviewTest extends TestBase{

    //1) user registration
    HomePage homePage;
    UserRegisterPage userRegisterPage;
    ProductDetailsPage productDetailsPage;
    SearchPage searchPage;
    ProductReviewPage productReviewPage;
    String productName ="Apple MacBook Pro 13-inch";
    String EmailFriend ="aaa@gmail.com";
    String Txt="hello,it is good product";


    @Test(priority = 1)
    public void UserCanRegisterSucessfully()
    {
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        userRegisterPage = new UserRegisterPage(driver);
        userRegisterPage.userRegister("karim","ali","karimali12@gmail.com","123456789");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        Assert.assertTrue(userRegisterPage.successMessage.getText().contains("Your registration completed"));
    }

    //2) Search for product
    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest() throws InterruptedException {
        searchPage =new SearchPage(driver);
        searchPage.productSearchUsingAutoSuggest("MacB");
        productDetailsPage =new ProductDetailsPage(driver);
        Assert.assertEquals(productDetailsPage.ProductNameBreadCrumb.getText(),productName);
    }

    //3) add review
    @Test(priority = 3)
    public void RegisterUserCanReviewProduct()
    {
        productDetailsPage.openAddReviewPage();
        productReviewPage =new ProductReviewPage(driver);
        productReviewPage.AddProductReview("Test","Good Test");
        Assert.assertTrue(productReviewPage.reviewNotification.getText().contains("Product review is successfully added."));
    }

    //4) user logout
    @Test(priority = 4)
    public void registeredUserCanLogout()
    {
        userRegisterPage.UserLogout();
    }
}
