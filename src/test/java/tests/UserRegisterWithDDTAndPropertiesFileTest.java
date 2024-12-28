package tests;

import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterPage;

import java.time.Duration;

public class UserRegisterWithDDTAndPropertiesFileTest extends TestBase {
    //create objects
    HomePage homePage;
    UserRegisterPage userRegisterPage;
    LoginPage loginPage;

    String firstname = LoadProperties.userData.getProperty("firstname");
    String lastname = LoadProperties.userData.getProperty("lastname");
    String email = LoadProperties.userData.getProperty("email");
    String password = LoadProperties.userData.getProperty("password");


    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSucessfully()
    {
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        userRegisterPage = new UserRegisterPage(driver);
        userRegisterPage.userRegister(firstname,lastname,email,password);
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
        loginPage.UserLogin(email,password);
        Assert.assertTrue(userRegisterPage.logoutLink.getText().contains("Log out"));
    }
}
