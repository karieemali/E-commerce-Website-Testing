package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
        jse =(JavascriptExecutor) driver;
        actions =new Actions(driver);
    }

    @FindBy(linkText = "Contact us")
    public WebElement contactUSLink;
    @FindBy(linkText = "Register")
    WebElement registerLink ;
    @FindBy(linkText = "Log in")
    WebElement loginLink ;
    @FindBy(id = "customerCurrency")
    WebElement currencyDropDownL;
    @FindBy(linkText = "Computers")
    public WebElement computerMenu;
    @FindBy(linkText = "Notebooks")
    public WebElement notebooksMenu;

    public void openRegisterPage()
    {
        //registerLink.click();
        clickButton(registerLink);
    }

    public void openLoginPage()
    {
        clickButton(loginLink);
    }
    public void openContactUsPage()
    {
        scrollToBottom();
        clickButton(contactUSLink);
    }

    public void changeCurrency()
    {
        select =new Select(currencyDropDownL);
        select.selectByVisibleText("Euro");
    }

    public void selectNotebooksMenu()
    {
        actions.moveToElement(computerMenu).moveToElement(notebooksMenu).click().build().perform();
    }
}
