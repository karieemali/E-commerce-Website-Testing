package tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class UserRegisterWithDDTAndCSVFileTest extends TestBase {

    //create objects
    HomePage homePage;
    UserRegisterPage userRegisterPage;
    LoginPage loginPage;

    CSVReader reader;


    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSucessfully() throws IOException, CsvValidationException {
        //get path of CSV file
        String CSV_file =System.getProperty("user.dir") + "/src/test/java/data/userData.csv";
        reader = new CSVReader(new FileReader(CSV_file));

        String [] csvCell;
        //while loop will be executed till the last value in csv file
        while((csvCell = reader.readNext()) != null)
        {
            String firstname = csvCell[0];
            String lastname = csvCell[1];
            String email = csvCell[2];
            String password = csvCell[3];

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
}
