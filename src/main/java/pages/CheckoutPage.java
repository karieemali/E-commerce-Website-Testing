package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement fNameTxt;
    @FindBy(id = "BillingNewAddress_LastName")
    WebElement lNameTxt;
    @FindBy(id="BillingNewAddress_Email")
    WebElement emailTxt;
    @FindBy(id ="BillingNewAddress_CountryId")
    WebElement country;
    @FindBy(id = "BillingNewAddress_City")
    WebElement city;
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipTxt;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phone;
    @FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/button[2]")
    WebElement billingAddContinueBtn;
    @FindBy(id = "shippingoption_1")
    WebElement selectShoppingMethod ;
    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
    WebElement shoppingMethodContinueBtn;
    @FindBy(id = "paymentmethod_1")
    WebElement selectPaymentMethod;
    @FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
    WebElement PaymentMethodContinueBtn;

}
