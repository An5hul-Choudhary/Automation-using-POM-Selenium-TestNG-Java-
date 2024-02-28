package org.Netcracker.pageObjects;

import org.Netcracker.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmittedOrder extends AbstractComponent {
    WebDriver driver;
    public SubmittedOrder(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='order-result__header-title']")
    WebElement orderResult;
    public void orderSubmitCheck() throws InterruptedException {
        Thread.sleep(8000);
        fluentWaiting(By.xpath("//div[@class='order-result__header-title']"));
        System.out.println(orderResult.getText());
    }
}
