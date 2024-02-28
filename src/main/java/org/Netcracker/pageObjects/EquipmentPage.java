package org.Netcracker.pageObjects;

import org.Netcracker.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EquipmentPage extends AbstractComponent {
    WebDriver driver;
    public EquipmentPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    public void hsiaEquipmentPage() throws InterruptedException {
        nextButton();
        Thread.sleep(5000);
    }
    @FindBy(xpath = "//span[@id='tv-quantity-button']")
    WebElement TvQuantity;
    @FindBy(xpath = "//li[@id='ui-id-5'")
    WebElement QuantityIs;
    @FindBy(xpath = "/span[contains(text(),'How many TVs')]")
    WebElement HowManyTv;
    public void tvEquipmentPage() throws InterruptedException {
        scrollingToTheElement(HowManyTv);
        waitForElementToBeClickable(By.xpath("//span[@id='tv-quantity-button']"));
        TvQuantity.click();
        QuantityIs.click();
        Thread.sleep(5000);
        nextButton();
        Thread.sleep(5000);
    }
    public AppointmentPage addOnEquipmentPage() throws InterruptedException {
        Thread.sleep(3000);
        fluentWaiting(By.xpath("//button[@class='button color-green quote-email js-delivery-method']"));
        nextButton();

        AppointmentPage appointmentPage= new AppointmentPage(driver);
        return appointmentPage;
    }
}
