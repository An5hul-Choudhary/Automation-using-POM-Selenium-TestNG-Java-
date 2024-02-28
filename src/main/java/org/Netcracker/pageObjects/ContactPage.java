package org.Netcracker.pageObjects;

import org.Netcracker.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends AbstractComponent {
    WebDriver driver;
    public ContactPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#phoneNumber")
    WebElement PhoneNumber;

    public PickADate addingContact(){
        waitForElementToAppear(By.cssSelector("#phoneNumber"));
        PhoneNumber.sendKeys("9999999999");
        nextButton();

        PickADate pickADate = new PickADate(driver);
        return pickADate;
    }
}
