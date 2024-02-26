package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends BasePage
{

    public AmazonHomePage(WebDriver driver) 
    {
		super(driver);
		
		 
    }
    
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchText;
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement SearchButton; 
    @FindBy(xpath = "//span[normalize-space()='New York Great Lash Washable Mascara, Very Black, 1 Tube']")
    private WebElement SelectProduct; 
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement AddtoCart;
    @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
    private WebElement ProceedtoCart;
    
    public void enterProduct(String product)
    {
        waitActions.waitForElementPresent(searchText);
        waitActions.waitForElementIsClickable(searchText);
        searchText.sendKeys(product);
    }
    public void search()
    {
        waitActions.waitForElementPresent(SearchButton);
        SearchButton.click();
       
    }
    
    public void Productsearch()
    {
        waitActions.waitForElementPresent(SelectProduct);
        waitActions.waitForElementIsClickable(SelectProduct);
        SelectProduct.click();
       
    }
    public void AddProduct()
    {
        waitActions.waitForElementPresent(AddtoCart);
        AddtoCart.click();
       
    }
    public void Chectout()
    {
        waitActions.waitForElementPresent(ProceedtoCart);
        ProceedtoCart.click();
       
    }
    
    
    
    
    
    
    
    
    
    }