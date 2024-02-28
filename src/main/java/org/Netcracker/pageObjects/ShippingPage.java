package org.Netcracker.pageObjects;

import org.Netcracker.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends AbstractComponent {

    WebDriver driver;
    public ShippingPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//label[@for='last-name'])[2]")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='delivery-notes']")
    WebElement deliveryNotes;
    @FindBy(xpath = "//button[@id='shippingSaveContactButton']")
    WebElement save;
    public BillingInfoPage shipInfo(){
        waitForElementToAppear(By.xpath("(//label[@for='last-name'])[2]"));
        scrollingToTheElement(lastName);
        deliveryNotes.sendKeys("Shipment");
        save.click();
        nextButton();

        BillingInfoPage billingInfoPage = new BillingInfoPage(driver);
        return billingInfoPage;

    }
}
