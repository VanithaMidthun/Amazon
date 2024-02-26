package utilities;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils
{

    WebDriver driver;

    public WaitUtils(WebDriver driver){
        this.driver = driver;
    }
 // Waits for the visibility of the specified WebElement.
    public WebElement waitForElementPresent(WebElement webElement) {
        ExpectedCondition<?> condition = ExpectedConditions.visibilityOf(webElement);
        return (WebElement)this.waitWithCondition(condition, 60, "Element by " + webElement.toString() + " still not present after 60 seconds wait");
    }

    public WebElement waitForElementIsClickable(WebElement webElement) {
        ExpectedCondition<?> condition;
        condition = ExpectedConditions.elementToBeClickable(webElement);
        return (WebElement) waitWithCondition(condition, 60,
                "Element still not clickable " + "after " + 60 + " seconds wait");
    }
    
    // Generic method to wait for a specified condition with timeout and handling exceptions.
    public <T> T waitWithCondition(ExpectedCondition<T> condition, int timeout, String messageForException) {
        int cycles = 12;  // number of attempts to wait for the condition.
        int count = 0;    // track of the number of attempts made.

        while(count < cycles) {
            try {
                FluentWait<WebDriver> wait = (new WebDriverWait(this.driver, Duration.ofSeconds((long)(timeout / cycles)))).pollingEvery(Duration.ofMillis(200L));
                return wait.until(condition);
            } catch (StaleElementReferenceException var7) {
                ++count;
            } catch (TimeoutException var8) {
                ++count;
            } catch (NoSuchElementException var9) {
                ++count;
            }
        }

        throw new Error(messageForException + ": " + condition);
    }
}

