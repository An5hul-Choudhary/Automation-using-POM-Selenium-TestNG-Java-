package org.Netcracker.pageObjects;

import org.Netcracker.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressCheckPage extends AbstractComponent {

    WebDriver driver;
    public AddressCheckPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#linkCheckAddress")
    WebElement addressCheck;
    @FindBy( css = "#address")
    WebElement enterAddress;
    @FindBy(xpath = "//ul[@id='ui-id-2']/li/a")
    WebElement suggestedAddress;

    @FindBy(css = "#checkAddressBtn")
    WebElement checkAddressButton;
    @FindBy(xpath = "//span[contains(text(), 'Proceed to customer creation')]")
    WebElement customerCreationButton;
    public CustomerCreation checkAddress(String address){

        waitForElementToAppear(By.cssSelector("#linkCheckAddress"));
        addressCheck.click();
        waitForElementToAppear(By.cssSelector("#street-address-tab"));
        enterAddress.sendKeys(address);
        waitForElementToAppear(By.xpath("//ul[@id='ui-id-2']/li/a"));
        suggestedAddress.click();
        checkAddressButton.click();
        waitForElementToAppear(By.xpath("//span[contains(text(), 'Proceed to customer creation')]"));
        customerCreationButton.click();

        CustomerCreation customerCreation = new CustomerCreation(driver);
        return customerCreation;

    }


}
