package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterPage extends PageBase {

    //create constructor
    public UserRegisterPage(WebDriver driver) {
        super(driver);
    }

    //create WebElements
    @FindBy(id = "gender-male")
    WebElement genderRdoBtn;

    @FindBy(id = "FirstName")
    WebElement fName;

    @FindBy(id = "LastName")
    WebElement lName;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Passwordd")
    WebElement pass;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPass;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div[1]")
    public WebElement successMessage;

    @FindBy(linkText = "Log out")
    public WebElement logoutLink;

    @FindBy(linkText = "My account")
    public WebElement MyAccountLink;


    //create methods to WebElements
    public void userRegister(String firstName, String lastName, String Email ,String password)
    {
        clickButton(genderRdoBtn);
        //fName.sendKeys(firstName);
        sendTxt(fName,firstName);
        sendTxt(lName,lastName);
        sendTxt(email,Email);
        sendTxt(pass,password);
        sendTxt(confirmPass,password);
        clickButton(registerBtn);

    }

    public void UserLogout()
    {
        clickButton(logoutLink);
    }

    public void openMyAccount()
    {
        clickButton(MyAccountLink);
    }


}
