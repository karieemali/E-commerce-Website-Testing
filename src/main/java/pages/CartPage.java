package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "updatecart")
    WebElement removeCheck;
    @FindBy(id = "open-estimate-shipping-popup")
    WebElement estimateShopping;
    @FindBy(id = "itemquantity11227")
    WebElement quantityTxt ;
    @FindBy(xpath = "//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[6]")
    public WebElement totalLbl;
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement ProdNameInCart;
    @FindBy(id = "checkout")
    public WebElement checkoutBtn;
    @FindBy(id = "termsofservice")
    public WebElement selectCheckBoxAgree;

    public void removeProductFromCart()
    {
        clickButton(removeCheck);
    }

    public void updateQuantityInCart(String quantity)
    {
        //Clear quantity
        clearText(quantityTxt);
        sendTxt(quantityTxt,quantity);
        clickButton(estimateShopping);
    }

    public void ClickOnCheckoutBtn()
    {
        clickButton(selectCheckBoxAgree);
        clickButton(checkoutBtn);
    }
}
