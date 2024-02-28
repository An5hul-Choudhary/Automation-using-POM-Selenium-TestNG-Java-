package org.Netcracker.pageObjects;

import org.Netcracker.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingInfoPage extends AbstractComponent {
    WebDriver driver;
    JavascriptExecutor jse;
    public BillingInfoPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
        this.jse = (JavascriptExecutor) driver;
    }
    @FindBy(xpath = "(//i[@class='wiz-checkbox__icon'])[2]")
    WebElement checkbox;
    @FindBy(css = "#shippingSaveContactButton")
    WebElement saveButton;
    @FindBy(xpath = "//button[@class='button color-green button-width-tds jsValidateAddress']")
    WebElement validateAddress;
    public SubmittedOrder billDetails(){
        waitForElementToBeClickable(By.xpath("(//i[@class='wiz-checkbox__icon'])[2]"));
        jse.executeScript("window.scrollBy(0, 600)");
        checkbox.click();
        saveButton.click();
        waitForElementToAppear(By.xpath("//span[@class='link js-edit-link']"));
        waitForElementToBeClickable(By.xpath
                ("//button[@class='button color-green button-width-tds jsValidateAddress']"));
        jse.executeScript("window.scrollBy(0, 400)");
        validateAddress.click();
        nextButton();

        SubmittedOrder submittedOrder = new SubmittedOrder(driver);
        return submittedOrder;
    }
}
