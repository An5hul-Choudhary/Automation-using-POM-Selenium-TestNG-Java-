package org.Netcracker.pageObjects;

import org.Netcracker.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPage extends AbstractComponent {

    WebDriver driver;

    public SelectPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//app-top-product)[1]")
    WebElement Internet;
    @FindBy(xpath = "(//app-top-product)[2]")
    WebElement Tv;
    @FindBy(xpath = "(//app-top-product)[3]")
    WebElement Phone;
    @FindBy(xpath = "//h2[contains(text(),'Pick from these')]")
    WebElement commitmentsView;
    @FindBy(xpath = "(//div[@class='commitment__header'])[1]")
    WebElement internetCommitment;
    @FindBy(xpath = "//h2[normalize-space()='Choose your Internet']")
    WebElement internetView;
    @FindBy(xpath = "//div[@class='product-offering__name' and contains(text(),'PureFibre Internet Gigabit')]")
    WebElement Internet1G;
    @FindBy(xpath = "(//div[@class='product-offering-category'])[3]")
    WebElement tvTLO;
    @FindBy(xpath = "(//app-product-offering-verical)[1]")
    WebElement tvSLO;
    @FindBy(xpath = "(//div[@class='product-offerings__items']/h2[contains(text(), 'Home')])[2]")
    WebElement homePhoneView;
    @FindBy(xpath = "(//app-product-offering-verical)[3]")
    WebElement HomePhone;
    @FindBy(xpath = "//button[@class='button _wider _next']")
    WebElement nextSelect;


    public CustomizePage addPlans() throws InterruptedException {

        waitForElementToBeClickable(By.xpath("(//app-top-product)[1]"));
        Internet.click();
        Thread.sleep(1000);
        waitForElementToBeClickable(By.xpath("(//app-top-product)[2]"));
        Tv.click();
        Thread.sleep(1000);
        waitForElementToBeClickable(By.xpath("(//app-top-product)[3]"));
        Phone.click();
        addCommitment();
        Thread.sleep(15000);
        addInternetPlan();
        addTvPlan();
        addHpPlan();
        Thread.sleep(5000);
        nextCsrButton();

        CustomizePage customizePage = new CustomizePage(driver);
        return customizePage;
    }

    public void addCommitment() {
        waitForElementToAppear(By.xpath("//h2[contains(text(),'Pick from these')]"));
        scrollingToTheElement(commitmentsView);
        //selecting the commitment
        fluentWaiting(By.xpath
                ("(//div[@class='commitment__header'])[1]"));
        internetCommitment.click();
    }

    public void addInternetPlan() {
        scrollingToTheElement(internetView);
        fluentWaiting(By.xpath
                ("//div[@class='product-offering__name' and contains(text(),'PureFibre Internet Gigabit')]"));
        Internet1G.click();
    }

    public void addTvPlan() throws InterruptedException {
        scrollingToTheElement(tvTLO);
        waitForElementToBeClickable(By.xpath("(//div[@class='product-offering-category'])[3]"));
        tvTLO.click();
        Thread.sleep(5000);
        scrollingToTheElement(tvSLO);
        waitForElementToBeClickable(By.xpath("(//app-product-offering-verical)[1]"));
        tvSLO.click();
        Thread.sleep(10000);
    }
    public void addHpPlan() throws InterruptedException {
        scrollingToTheElement(homePhoneView);
        waitForElementToBeClickable(By.xpath("(//app-product-offering-verical)[3]"));
        HomePhone.click();
        Thread.sleep(5000);
    }
    public void nextCsrButton() throws InterruptedException {
        fluentWaiting(By.xpath("//button[@class='button _wider _next']"));
        nextSelect.click();
        fluentWaiting(By.xpath("//app-spinner"));
        Thread.sleep(10000);
    }
}
