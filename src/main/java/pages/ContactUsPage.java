package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FullName")
    WebElement fullNameTxt;
    @FindBy(id ="Email")
    WebElement emailTxt;
    @FindBy(id ="Enquiry")
    WebElement enquiryTxt;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/form/div[2]/button")
    WebElement submitBtn;
    @FindBy(css = "div.result")
    public WebElement successMessage;

    public void contactUS(String fullName ,String email ,String enquiry)
    {
        sendTxt(fullNameTxt,fullName);
        sendTxt(emailTxt,email);
        sendTxt(enquiryTxt,enquiry);
        clickButton(submitBtn);
    }
}
