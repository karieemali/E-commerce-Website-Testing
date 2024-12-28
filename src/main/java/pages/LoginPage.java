package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    WebElement emailTxt ;

    @FindBy(id = "Password")
    WebElement passTxt ;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
    WebElement loginBtn ;

    public void UserLogin (String email, String password)
    {
        sendTxt(emailTxt,email);
        sendTxt(passTxt,password);
        clickButton(loginBtn);

    }
}
