package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
public class ComparePage extends PageBase{
    public ComparePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Clear list")
    WebElement clearListBtn;
//    @FindBy(css = "table.compare-products-table")
//    WebElement compareTable;
    @FindBy(tagName = "tr")
    public List<WebElement> allRows;
    @FindBy(tagName = "td")
    public List<WebElement> allCols;
    @FindBy(linkText = "Asus N551JK-XO076H Laptop")
    public WebElement firstProd;
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement secondProd;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div[2]/div")
    public WebElement noDataLbl;
    public void clearCompareProducts()
    {
        clickButton(clearListBtn);
    }
    public void compareProducts()
    {
        //Get all rows
        System.out.println(allRows.size());
        //Get data from each row
        for (WebElement row:allRows)
        {
            System.out.println(row.getText() + "\t");
            for (WebElement col:allCols)
            {
                System.out.println(col.getText() + "\t");
            }
        }
    }
}

