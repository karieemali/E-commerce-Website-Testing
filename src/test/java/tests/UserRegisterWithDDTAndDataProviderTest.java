package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterPage;

import java.time.Duration;

public class UserRegisterWithDDTAndDataProviderTest extends TestBase{

    //create objects
    HomePage homePage;
    UserRegisterPage userRegisterPage;
    LoginPage loginPage;




    @DataProvider(name = "testData")
    public static Object [][] userData()
    {
        return new Object [][]
        {
            {"karim","ali","kareeem@gmail.com","123456"},
            {"islam","ali","eslam@gmail.com","123456"}
        };
    }
    @Test(priority = 1, alwaysRun = true, dataProvider = "testData")
    public void UserCanRegisterSucessfully(String fName, String lName, String email, String pass)
    {
        //UserRegister
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        userRegisterPage = new UserRegisterPage(driver);
        userRegisterPage.userRegister(fName,lName,email,pass);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        userRegisterPage.UserLogout();

        //UserLogin
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.UserLogin(email,pass);
        Assert.assertTrue(userRegisterPage.logoutLink.getText().contains("Log out"));
        userRegisterPage.UserLogout();
    }
}
