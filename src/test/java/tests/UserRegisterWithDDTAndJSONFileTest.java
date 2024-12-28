package tests;

import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterPage;

import java.io.IOException;
import java.time.Duration;

public class UserRegisterWithDDTAndJSONFileTest extends TestBase {

    //create objects
    HomePage homePage;
    UserRegisterPage userRegisterPage;
    LoginPage loginPage;



    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSucessfully() throws IOException, ParseException
    {

        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.JsonReader();


        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        userRegisterPage = new UserRegisterPage(driver);
        userRegisterPage.userRegister(jsonReader.firstname,jsonReader.lastname,jsonReader.email,jsonReader.password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
       // Assert.assertTrue(userRegisterPage.successMessage.getText().contains("Your registration completed"));
        userRegisterPage.UserLogout();

        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.UserLogin(jsonReader.email,jsonReader.password);
        Assert.assertTrue(userRegisterPage.logoutLink.getText().contains("Log out"));
        userRegisterPage.UserLogout();
    }
}
