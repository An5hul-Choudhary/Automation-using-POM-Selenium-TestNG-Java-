package org.Netcracker.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class AbstractComponent {

    WebDriver driver;
    JavascriptExecutor jse;
    public AbstractComponent(WebDriver driver) {
        this.driver=driver;
        this.jse = (JavascriptExecutor) driver;
    }
    public void waitForElementToAppear(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }
    public void waitForElementToBeClickable(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }
    public void fluentWaiting(By findBy){
        FluentWait fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.elementToBeClickable(findBy));
    }
    public void scrollingToTheElement(WebElement element){
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    @FindBy(css = "#next")
    WebElement next;
    public void nextButton() {
        fluentWaiting(By.cssSelector("#next"));
        next.click();
    }


}
