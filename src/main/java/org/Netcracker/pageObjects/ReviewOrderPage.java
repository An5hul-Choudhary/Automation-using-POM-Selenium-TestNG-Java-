package org.Netcracker.pageObjects;

import org.Netcracker.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewOrderPage extends AbstractComponent {

    WebDriver driver;
    JavascriptExecutor jse;
    public ReviewOrderPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
        this.jse = (JavascriptExecutor)driver;
    }
    @FindBy(id = "termsConditnsIcon")
    WebElement TnCcheckbox;
    public TSSPage acceptTnC(){
        waitForElementToAppear(By.cssSelector("#termsConditnsLbl"));
        jse.executeScript("window.scrollBy(0,3000)");
        TnCcheckbox.click();
        driver.findElement(By.cssSelector("#next")).click();

        TSSPage tssPage = new TSSPage(driver);
        return tssPage;

    }
}
