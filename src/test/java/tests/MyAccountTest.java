package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterPage;
import java.time.Duration;

public class MyAccountTest extends TestBase{
    //create objects
    HomePage homePage;
    UserRegisterPage userRegisterPage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    String oldPassword ="123456789";
    String newPassword ="123456";
    String firstName ="kareem";
    String lastName ="Ali";
    String email ="karimali123@gmail.com";


//هنا اها الكود بيتكرر دا عادي عشان عايزين نعمل isolation between testcases
    @Test(priority = 1)
    public void UserCanRegisterSucessfully()
    {
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        userRegisterPage = new UserRegisterPage(driver);
        userRegisterPage.userRegister(firstName,lastName,email,oldPassword);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        Assert.assertTrue(userRegisterPage.successMessage.getText().contains("Your registration completed"));

    }

    @Test(priority = 2)
    public void RegisterUserCanChangePassword()
    {
        myAccountPage =new MyAccountPage(driver);
        userRegisterPage.openMyAccount();
        myAccountPage.openChangePassPage();
        myAccountPage.changePassword(oldPassword,newPassword);
        Assert.assertTrue(myAccountPage.changePasswordResult.getText().contains("Password was changed"));
    }
    @Test(priority = 3)
    public void registeredUserCanLogout()
    {
        userRegisterPage.UserLogout();
    }

    @Test(priority = 4)
    public void registeredUserCanLogin()
    {
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.UserLogin(email,newPassword);
        Assert.assertTrue(userRegisterPage.logoutLink.getText().contains("Log out"));
    }
}
