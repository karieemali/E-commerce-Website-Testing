package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase {
    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FriendEmail")
    WebElement emailFriendTxt;
//    @FindBy(id = "YourEmailAddress")
//    WebElement emailAddTxt;
    @FindBy(id = "PersonalMessage")
    WebElement textArea;
    @FindBy(name = "send-email")
    WebElement sendEmailBtn;
    @FindBy(css = "div.result")
    public WebElement messageNotification;

    public void SendEmailToFriend(String friendEmail ,String personalMessage)
    {
        sendTxt(emailFriendTxt,friendEmail);
        sendTxt(textArea,personalMessage);
        clickButton(sendEmailBtn);
    }

}

