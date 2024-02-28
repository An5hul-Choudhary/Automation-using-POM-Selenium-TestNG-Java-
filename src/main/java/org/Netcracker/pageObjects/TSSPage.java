package org.Netcracker.pageObjects;

import org.Netcracker.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TSSPage extends AbstractComponent {
    WebDriver driver;
    JavascriptExecutor jse;
    public TSSPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
        this.jse = (JavascriptExecutor)driver;
    }
    @FindBy(xpath = "//div[@data-value='no']")
    WebElement ValueNo;
    public ShippingPage tssNo(){
        waitForElementToBeClickable(By.xpath("//div[@data-value='no']"));
        jse.executeScript("window.scrollBy(0, 1000)");
        ValueNo.click();
        //Thread.sleep(2000);
        nextButton();

        ShippingPage shippingPage = new ShippingPage(driver);
        return shippingPage;
    }
}
