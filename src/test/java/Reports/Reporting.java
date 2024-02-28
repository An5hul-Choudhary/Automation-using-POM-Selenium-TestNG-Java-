package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting {


    public static ExtentReports reportingMethod(){

        String path = System.getProperty("user.dir")+ "//index.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setReportName("FirstReport");
        sparkReporter.config().setDocumentTitle("Test Results");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Tester", "Anshul");
        return extentReports;

    }

    /*
    @Test
    public void googleSearch(){

        ExtentTest test = extentReports.createTest("Initial Demo");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.cssSelector("#APjFqb")).sendKeys("HelloIndia");

        Actions act = new Actions(driver);
        act.keyDown(Keys.ENTER);

        test.pass("Test Case Passed");
        test.addScreenCaptureFromBase64String("Passed");
        extentReports.flush();
    }
     */

}
