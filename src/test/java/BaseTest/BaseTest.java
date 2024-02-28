package BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.Netcracker.pageObjects.CsrLoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public String server;
    public static String addressId;
    public CsrLoginPage loginPage;

    public WebDriver setDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Resources\\GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        String serverName = prop.getProperty("server");
        server = "http://telus" + serverName + ".netcracker.com:6810";
        addressId = prop.getProperty("addressId");

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addExtensions(new File(System.getProperty("user.dir") + "\\NDGIMIBANHLABGDGJCPBBNDIEHLJCPFH_5_2_0_0.crx"));
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1440,900));
        return driver;
    }

    public CsrLoginPage launchApplication() throws IOException {

        driver = setDriver();
        loginPage = new CsrLoginPage(driver);
        loginPage.goTo(server);
        return loginPage;

    }
    @AfterMethod
    public void closeDriver(){
        driver.close();
    }

    public String getScreenshot(String testName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user,dir")+"//reports//"+testName+".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user,dir")+"//reports//"+testName+".png";

    }
}
