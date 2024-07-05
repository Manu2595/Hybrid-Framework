package com.inetbanking.utilities;

import com.inetbanking.testCases.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

//public class IListeners implements ITestListener
//public class IListeners extends ITest
public class IListeners extends BaseClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // Either u can extend base class or create instance of base class and call screenshot methods
        // This is for failed test cases
        {
            captureScreenshot
                    (result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg");

        }


    }

//    @Override
//    public void onTestSkipped(ITestResult result) {
//
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//
//    }
//
//    @Override
//    public void onTestFailedWithTimeout(ITestResult result) {
//
//    }
//
//    @Override
//    public void onStart(ITestContext context) {
//
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//
//    }
}
