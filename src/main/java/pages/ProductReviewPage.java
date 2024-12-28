package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{
    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTitle;
    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewTxt;
    @FindBy(id = "addproductrating_5")
    WebElement ratingResult5Btn;
    @FindBy(id = "add-review")
    WebElement submitReviewBtn;
    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
    public WebElement reviewNotification;

    public void AddProductReview(String revTitle,String revTxt)
    {
        sendTxt(reviewTitle,revTitle);
        sendTxt(reviewTxt,revTxt);
        clickButton(ratingResult5Btn);
        clickButton(submitReviewBtn);
    }
}
