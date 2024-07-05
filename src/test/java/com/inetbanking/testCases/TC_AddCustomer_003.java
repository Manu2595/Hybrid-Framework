package com.inetbanking.testCases;

import com.inetbanking.pageObjects.AddNewCustomer;
import com.inetbanking.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class TC_AddCustomer_003 extends BaseClass {


    @Test
    public void addNewCustomer() throws InterruptedException {

        LoginPage lp = new LoginPage(driver);
        lp.setTxtUserName(username);
        logger.info("User name is provided");
        lp.setTxtPassword(password);
        logger.info("User password is provided");

        lp.clickSubmit();

        Thread.sleep(3000);
        logger.info("Customer details are provided");

        AddNewCustomer addNewCustomer = new AddNewCustomer(driver);
        addNewCustomer.addLinkCustomer();
        addNewCustomer.getTxtCustomerName("vyshnavi");
        addNewCustomer.custGender("female");
        addNewCustomer.cusDob("04","04","1995");
        Thread.sleep(3000);
        addNewCustomer.cusAddress("INDIA");
        addNewCustomer.setCity("HYD");
        addNewCustomer.setState("ANDHRA");
        addNewCustomer.cusPin(500045);
        addNewCustomer.cusMobileNumber("9848022338");
        String email = randomStr() + "@gmail.com";
        addNewCustomer.cusTxtemail(email);
        addNewCustomer.cusTxtpassword("abcde");
        addNewCustomer.cusBtnSubmit();
        Thread.sleep(3000);

//        // Scroll and fill in the remaining fields
//        addNewCustomer.scrollToElementAndSendKeys(addNewCustomer.address, "123 Main St");
//        addNewCustomer.scrollToElementAndSendKeys(addNewCustomer.city, "New York");
//        addNewCustomer.scrollToElementAndSendKeys(addNewCustomer.state, "NY");
//        addNewCustomer.scrollToElementAndSendKeys(addNewCustomer.pin, "123456");
//        addNewCustomer.scrollToElementAndSendKeys(addNewCustomer.mobileNumber, "1234567890");
//        addNewCustomer.scrollToElementAndSendKeys(addNewCustomer.email, "johndoe@example.com");
//        addNewCustomer.scrollToElementAndSendKeys(addNewCustomer.password, "password123");

        boolean responseContains = driver.getPageSource().contains("Customer Registered Successfully!!!");

        if(responseContains==true){
            Assert.assertTrue(true);
            logger.info("Test case is passed");
        }

        else{
            Assert.assertTrue(false);
            logger.info("Test case is failed");
        }


    }





}
