package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Change password")
    WebElement changePasswordLink;

    @FindBy(id = "OldPassword")
    WebElement oldPassword;

    @FindBy(id = "NewPassword")
    WebElement newPassword;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div[2]/form/div[2]/button")
    WebElement changePassBtn;

    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
    public WebElement changePasswordResult;

    public void openChangePassPage()
    {
        clickButton(changePasswordLink);
    }

    public void changePassword(String oldPass , String newPass)
    {
        sendTxt(oldPassword,oldPass);
        sendTxt(newPassword,newPass);
        sendTxt(confirmPassword,newPass);
        clickButton(changePassBtn);
    }

}
