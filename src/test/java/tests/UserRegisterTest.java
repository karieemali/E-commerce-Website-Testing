package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterPage;

import java.time.Duration;

public class UserRegisterTest extends TestBase {

    //create objects
    HomePage homePage;
    UserRegisterPage userRegisterPage;
    LoginPage loginPage;


    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSucessfully()
    {
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        userRegisterPage = new UserRegisterPage(driver);
        userRegisterPage.userRegister("karim","ali","karimali1@gmail.com","123456789");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
       // Assert.assertTrue(userRegisterPage.successMessage.getText().contains("Your registration completed"));

    }

    @Test(dependsOnMethods = {"UserCanRegisterSucessfully"})
    public void registeredUserCanLogout()
    {
        userRegisterPage.UserLogout();
    }

    @Test(dependsOnMethods = {"registeredUserCanLogout"})
    public void registeredUserCanLogin()
    {
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.UserLogin("karimali1@gmail.com","123456789");
        Assert.assertTrue(userRegisterPage.logoutLink.getText().contains("Log out"));
    }

}
