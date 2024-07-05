package com.inetbanking.testCases;

import com.inetbanking.utilities.ReadConfig;
//import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseClass {
    ReadConfig rc = new ReadConfig();
    public String baseUrl = rc.getApplicationUrl();
    public String username = rc.getUsername();
    public String password = rc.getPassword();
    public static WebDriver driver;
    public static Logger logger;
    public static String screenShotSubFolder;

    @Parameters("Browser")
    @BeforeClass
    public void setUp(String br) {
//        logger =LogManager.getLogger(BaseClass.class);
        logger = LogManager.getLogger("ebanking");
        logger.info("Driver initialized");
//        logger.error("Driver is not initialised");
//        logger.warn("");
//        logger.fatal("");
        if (br.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        if (br.equals("chrome")) {
            driver = new ChromeDriver();
        }
        if (br.equals("ie")) {
            driver = new InternetExplorerDriver();
        }
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(baseUrl);
        driver.manage().window().maximize();

    }

    // this is to capture screenshot using dependency Injection
//    @AfterMethod
//    public void screenShotCapture(ITestResult result){
//        if(result.getStatus()==ITestResult.SUCCESS){
//            captureScreenshot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName());
//        }
//
//    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    // This is common Method if any listerns method is failed
    public void captureScreenshot(String filename) {
        // to avoid overriding of screenshots
if(screenShotSubFolder==null) {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
   screenShotSubFolder = dateTime.format(timeFormatter);
}
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File("./Screenshots/"+screenShotSubFolder+"/"+ filename+".jpg");
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");
    }

    public static String randomStr(){

        String generatedString= RandomStringUtils.randomAlphabetic(5);
        return generatedString;

    }

    public static String randomNumber(){

        String generatedNumber= RandomStringUtils.randomNumeric(8);
        return generatedNumber;

    }

}
