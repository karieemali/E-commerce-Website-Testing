package tests;

import data.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterPage;

import java.io.IOException;
import java.time.Duration;

public class UserRegisterWithDDTAndExcelFileTest extends TestBase{

    //create objects
    HomePage homePage;
    UserRegisterPage userRegisterPage;
    LoginPage loginPage;


    @DataProvider(name = "ExcelData")
    public Object[][] userRegisterData() throws IOException {
       //get data from Excel reader class
        ExcelReader ER = new ExcelReader();
        return ER.getExcelData();
    }

    @Test(priority = 1, alwaysRun = true,dataProvider = "ExcelData")
    public void UserCanRegisterSucessfully(String firstname , String lastname , String email , String password)
    {
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        userRegisterPage = new UserRegisterPage(driver);
        userRegisterPage.userRegister(firstname,lastname,email,password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        // Assert.assertTrue(userRegisterPage.successMessage.getText().contains("Your registration completed"));

        userRegisterPage.UserLogout();

        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.UserLogin(email,password);
        Assert.assertTrue(userRegisterPage.logoutLink.getText().contains("Log out"));
        userRegisterPage.UserLogout();
    }
}
