package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
    WebDriver localDriver;

  public   AddNewCustomer(WebDriver rdriver) {
      localDriver = rdriver;
      //PageFactory to initialize the WebElements.
      PageFactory.initElements(rdriver, this);
  }

      @FindBy(how = How.XPATH, using = "//a[contains(text(),'New Customer')]" )
      @CacheLookup
      WebElement linkCustomer;

  @FindBy(how = How.NAME,using = "name")
    WebElement txtCustomerName;

  @FindBy(how = How.NAME, using = "rad1")
    WebElement gender;

  @FindBy(how=How.NAME ,using="dob")
    WebElement dob;
    @FindBy(how=How.NAME ,using="addr")
    public WebElement address;

    @FindBy(how=How.NAME ,using="city")
    public WebElement city;

    @FindBy(how=How.NAME ,using="state")
    public WebElement state;

    @FindBy(how=How.NAME ,using="pinno")
    public WebElement pin;

    @FindBy(how=How.NAME ,using="telephoneno")
    public WebElement mobileNumber;

    @FindBy(how=How.NAME ,using="emailid")
    WebElement txtemail;

    @FindBy(how=How.NAME ,using="password")
    WebElement txtpassword;

    @FindBy(how=How.NAME ,using="sub")
    WebElement btnSubmit;


    public void addLinkCustomer() {
       linkCustomer.click();
    }

    public void getTxtCustomerName(String name) {
        txtCustomerName.sendKeys(name);
    }

    public void custGender(String cgen) {
        gender.click();
    }

    public void cusDob(String mm,String dd,String yyyy) {
       dob.sendKeys(mm);
       dob.sendKeys(dd);
       dob.sendKeys(yyyy);
    }

    public void cusAddress(String cadd) {
        address.sendKeys(cadd);
    }

    public void setCity(String cusCity){
        city.sendKeys(cusCity);

    }

    public void cusPin(int cpin) {
        pin.sendKeys(String.valueOf(cpin));
    }

    public void setState(String  cstate) {
        state.sendKeys(cstate);
    }

    public void cusMobileNumber(String  cmobileNumber) {
        mobileNumber.sendKeys(cmobileNumber);
    }

    public void cusTxtemail(String custxtemail) {
      txtemail.sendKeys(custxtemail);
    }

    public void cusTxtpassword(String custxtpassword) {
      txtpassword.sendKeys(custxtpassword);
    }

    public void cusBtnSubmit() {
btnSubmit.click();
    }



    // Method to scroll to an element and send keys
//    public void scrollToElementAndSendKeys(WebElement element, String value) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        element.sendKeys(value);
//    }
}

