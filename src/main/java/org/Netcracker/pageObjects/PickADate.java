package org.Netcracker.pageObjects;

import org.Netcracker.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PickADate extends AbstractComponent {

    WebDriver driver;
    public PickADate(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[contains(text(), 'Please choose when to activate services:')]")
    WebElement ActivateService;
    @FindBy(xpath = "//label/span[contains(text(), 'Appointment')]")
    WebElement Appoint;
    public ReviewOrderPage appointmentSelection(){
        waitForElementToAppear(By.xpath("//div[contains(text(), 'Please choose when to activate services:')]"));
        scrollingToTheElement(ActivateService);
        waitForElementToBeClickable(By.xpath("//label/span[contains(text(), 'Appointment')]"));
        Appoint.click();
        nextButton();

        ReviewOrderPage reviewOrderPage = new ReviewOrderPage(driver);
        return reviewOrderPage;
    }
}
