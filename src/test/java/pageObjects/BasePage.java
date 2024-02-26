package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtils;

public class BasePage 
{
    WebDriver driver;
    protected WaitUtils waitActions;
 
public BasePage(WebDriver driver) 
{
	 this.driver = driver;
     waitActions = new WaitUtils(driver);
     init();
     
 }
 public void init()
 {
	  PageFactory.initElements(driver, this);// initializes elements annotated with @FindBy in the BasePage class,
 }    
}
