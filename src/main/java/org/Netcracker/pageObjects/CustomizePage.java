package org.Netcracker.pageObjects;

import org.Netcracker.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomizePage extends AbstractComponent {
    WebDriver driver;

    public CustomizePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hsiaCustomize() throws InterruptedException {
        waitForElementToBeClickable(By.xpath("//button[contains(text(),'Internet')]"));
        nextButton();
    }

    @FindBy(xpath = "(//button[@id='proceed'])[2]")
    WebElement proceed;

    public void tvCustomize() throws InterruptedException {
        waitForElementToAppear(By.xpath("//div[@id='conCateName']"));
        nextButton();
        waitForElementToBeClickable(By.xpath("(//button[@id='proceed'])[2]"));
        proceed.click();
        Thread.sleep(10000);
    }

    @FindBy(xpath = "(//div[@class='wiz-feature__caption'][normalize-space()='No'])[1]")
    WebElement NoHpNumber;
    @FindBy(xpath = "(//div[@class='wiz-feature__caption'][normalize-space()='No'])[2]")
    WebElement NoPhoneBookName;

    public EquipmentPage hpCustomize() throws InterruptedException {
        scrollingToTheElement(NoHpNumber);
        NoHpNumber.click();
        Thread.sleep(2000);
        scrollingToTheElement(NoPhoneBookName);
        NoPhoneBookName.click();
        nextButton();
        Thread.sleep(10000);

        EquipmentPage equipmentPage = new EquipmentPage(driver);
        return equipmentPage;
    }


}
