package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.UserRegisterPage;
import tests.TestBase;

public class UserRegistration extends TestBase {
    HomePage homePage;
    UserRegisterPage userRegisterPage;
    @Given("The user in the home page")
    public void the_user_in_the_home_page() {
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
    }
    @When("I click on register link")
    public void i_click_on_register_link() {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }

    /*@When("I entered the user data")
    public void i_entered_the_user_data() {
       userRegisterPage = new UserRegisterPage(driver);
       userRegisterPage.userRegister("karim","ali","ka@gmail.com","123456789");
    }*/

    //data driven with BBD
    @When("I entered {string} , {string} , {string} , {string}")
    public void i_entered(String firstname, String lastname, String email, String password) {
        userRegisterPage = new UserRegisterPage(driver);
        userRegisterPage.userRegister(firstname,lastname,email,password);
    }
    @Then("The registration page displayed successfully")
    public void the_registration_page_displayed_successfully() {
        userRegisterPage.UserLogout();
    }
}
