package org.Netcracker.pageObjects;

import org.Netcracker.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class CsrLoginPage extends AbstractComponent {

    WebDriver driver;
    public CsrLoginPage(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    @BeforeMethod
    public void goTo(String ServerName){
        driver.get(ServerName);
    }

    @FindBy(css = "#btnExistsCustomer")
    WebElement ExistingCustomerButton;
    @FindBy(id = "IDToken1")
    WebElement userName;
    @FindBy(id = "IDToken2")
    WebElement userPassword;
    @FindBy(css = "input[value=' Log In ']")
    WebElement LoginButton;


    public AddressCheckPage loginApplication(String UserId, String Password) throws InterruptedException {

        waitForElementToAppear(By.cssSelector("#btnExistsCustomer"));
        ExistingCustomerButton.click();
        waitForElementToAppear(By.id("IDToken1"));
        userName.sendKeys(UserId);
        userPassword.sendKeys(Password);
        LoginButton.click();

        AddressCheckPage addressCheck = new AddressCheckPage(driver);
        return addressCheck;
    }

}
