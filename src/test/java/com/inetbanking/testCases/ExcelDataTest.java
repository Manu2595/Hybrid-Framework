package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtil;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class ExcelDataTest extends BaseClass {


    @Test(dataProvider = "TestDataExcelData")
    public void testLogin(String username, String pwd) throws InterruptedException {
        driver.manage().window().maximize();
        LoginPage lp = new LoginPage(driver);
        lp.setTxtUserName(username);
        lp.setTxtPassword(pwd);
        lp.clickSubmit();
        Thread.sleep(3000);
        if(isAlertPresent()==true){
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.warn("Login failed due to invalid password");
        }
        else
            Assert.assertTrue(true);
        logger.info("Login is passed");
        lp.logOut();
        driver.switchTo().alert().accept(); // close the logout alert
        driver.switchTo().defaultContent();
    }

    public boolean isAlertPresent() { // user defined method to check if alert is present or not
        try {
driver.switchTo().alert();
return true;
        } catch (NoAlertPresentException e) {
            return false;
        }

    }

    @DataProvider(name = "TestDataExcelData")
    public Object[][] excelDataProvider() throws IOException {
        String filePath = "./src/test/java/com/inetbanking/testdata/LoginData.xlsx"; // Update with your actual file path
        XLUtil xlUtil = new XLUtil(filePath);
        String sheetName = "Sheet1"; // Update with your actual sheet name

        int rowCount = xlUtil.getRowCount(sheetName);
        int cellCount = xlUtil.getCellCount(sheetName, 0);

        Object[][] data = new Object[rowCount][cellCount];
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < cellCount; j++) {
                data[i-1][j] = xlUtil.getCellData(sheetName, i, j);
            }
        }

        xlUtil.close();
        return data;
    }


}

