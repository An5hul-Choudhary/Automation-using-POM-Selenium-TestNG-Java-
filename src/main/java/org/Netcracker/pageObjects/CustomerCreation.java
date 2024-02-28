package org.Netcracker.pageObjects;

import org.Netcracker.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class CustomerCreation extends AbstractComponent {

    WebDriver driver;
    StringBuilder randomLastName;
    public CustomerCreation(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name='firstName']")
    WebElement firstname;
    @FindBy(css = "input[name='lastName']")
    WebElement lastname;
    @FindBy(css = "input[name='email']")
    WebElement email;
    @FindBy(css = "button[class*='js-create-btn']")
    WebElement createButton;
    @FindBy(id = "select-month-button")
    WebElement monthDropdown;
    @FindBy(xpath = "//ul[@id='select-month-menu']//li[text()='Jun']")
    WebElement month;
    @FindBy(id = "select-day-button")
    WebElement dayDropdown;
    @FindBy(xpath = "//ul[@id='select-day-menu']//li[text()='30']")
    WebElement day;
    @FindBy(id = "select-year-button")
    WebElement yearDropdown;
    @FindBy(xpath = "//ul[@id='select-year-menu']//li[text()='1999']")
    WebElement year;
    @FindBy(id = "select-province-button")
    WebElement provinceDropdown;
    @FindBy(xpath = "//ul[@id='select-province-menu']//li[text()='BC']")
    WebElement province;
    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    WebElement continueButton;
    @FindBy(css = "#healthCareCard")
    WebElement healthCard;
    @FindBy(css = "#health_care_card")
    WebElement healthCareCard;
    @FindBy(xpath = "//span[contains(text(),'I authorize TELUS and any other person')]")
    WebElement authorizationCheckbox;
    @FindBy(css = "button[class*='jsValidateCreditCheckInfo']")
    WebElement validateButton;
    @FindBy(css = "button[class*='jsCreditCheckNextButton']")
    WebElement creditCheckNextButton;


    public StringBuilder randomLastNameGeneration(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        randomLastName = new StringBuilder();
        Random random = new Random();

        // Generate a random length for the lastname (e.g., between 5 and 10 characters)
        int lastNameLength = random.nextInt(6) + 5;

        // Generate the random lastname
        for (int i = 0; i < lastNameLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            randomLastName.append(characters.charAt(randomIndex));
        }
        return randomLastName;
    }

    public SelectPage creationOfCustomer(String fName){

        //Entering name and Email
        waitForElementToAppear(By.cssSelector("input[name='firstName']"));
        firstname.sendKeys(fName);
        lastname.sendKeys(randomLastNameGeneration());
        email.sendKeys(randomLastNameGeneration() + "@mail.com");
        createButton.click();

        //Entering DOB and Verification
        waitForElementToAppear(By.id("select-month-button"));
        monthDropdown.click();
        month.click();
        dayDropdown.click();
        day.click();
        yearDropdown.click();
        year.click();
        provinceDropdown.click();
        province.click();
        continueButton.click();
        waitForElementToAppear(By.cssSelector("#healthCareCard"));
        healthCard.click();
        healthCareCard.sendKeys("9999999999");
        authorizationCheckbox.click();
        validateButton.click();
        waitForElementToAppear(By.cssSelector("button[class*='jsCreditCheckNextButton']"));
        creditCheckNextButton.click();

        SelectPage selectPage = new SelectPage(driver);
        return selectPage;

    }

}
