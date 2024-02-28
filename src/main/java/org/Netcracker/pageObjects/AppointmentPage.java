package org.Netcracker.pageObjects;

import org.Netcracker.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentPage extends AbstractComponent {
    WebDriver driver;
    JavascriptExecutor jse;
    public AppointmentPage(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
        this.jse = (JavascriptExecutor) driver;
    }
    @FindBy(xpath = "//div[@class='calendar__body-td js-day ']")
    WebElement day;
    @FindBy(xpath = "//div[contains(text(),'1 PM - 3 PM')]")
    WebElement timing;
    public ContactPage selectingAppointment() throws InterruptedException {
        Thread.sleep(10000);
        waitForElementToBeClickable(By.xpath("//span[@class='select-appointment__description-date-text' " +
                "and contains(text(),'PureFibre Internet Gigabit')]"));
        jse.executeScript("window.scrollBy(0,3000)");
        waitForElementToBeClickable(By.xpath("//div[@class='calendar__body-td js-day ']"));
        day.click();
        waitForElementToBeClickable(By.xpath("//div[contains(text(),'1 PM - 3 PM')]"));
        scrollingToTheElement(timing);
        timing.click();
        nextButton();

        ContactPage contactPage = new ContactPage(driver);
        return contactPage;
    }
}
