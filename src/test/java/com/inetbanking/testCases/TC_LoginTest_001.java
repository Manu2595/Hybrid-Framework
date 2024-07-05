package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass {


    // Before @Test baseclass methods will execute first
    @Test
    public void loginTest(){
//driver.get(baseUrl);
logger.info("Url is opened");
driver.manage().window().maximize();
        LoginPage lp = new LoginPage(driver);
        lp.setTxtUserName(username);
        logger.info("username is entered");
        lp.setTxtPassword(password);
        lp.clickSubmit();
        System.out.println(driver.getTitle());

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
        }

        else
        {
            captureScreenshot
                    ("loginTest");

            Assert.assertTrue(false);
        }
        lp.logOut();
    }
}
