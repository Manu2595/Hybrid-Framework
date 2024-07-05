package com.inetbanking.pageObjects;

import lombok.extern.java.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver localDriver;
   public LoginPage(WebDriver rdriver){
        localDriver=rdriver;
        //The this keyword represents the current instance of the page object class (e.g., LoginPage). By passing this, you instruct the PageFactory to initialize the elements within this particular instance of the class. This means that all the WebElements annotated with @FindBy, @FindBys, etc.,
        // will be located and assigned to the corresponding fields in this instance.
        PageFactory.initElements(rdriver,this);

    }

    @FindBy(name="uid")
    @CacheLookup
    WebElement txtUserName;

    @FindBy(name="password")
    WebElement txtPassword;

    // Difference between findby and findbys

    //@FindBys({
    //    @FindBy(className = "form"),
    //    @FindBy(name = "btnLogin")
    //})
    //WebElement button;
    @FindBy(name="btnLogin")
    WebElement button;

    @FindBy(xpath = "//a[text()='Log out']")
    WebElement logout;


    public void setTxtUserName(String name) {
        txtUserName.sendKeys(name);
    }

    public void setTxtPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void clickSubmit() {
       button.click();
    }


    public void logOut(){
        JavascriptExecutor js= (JavascriptExecutor) localDriver;
        js.executeScript("arguments[0].scrollIntoView(true)",logout);
        logout.click();


    }
}
