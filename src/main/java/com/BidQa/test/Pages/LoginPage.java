package com.BidQa.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by hishailesh77 on 5/17/2017.
 */
public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //Define Username
    @FindBy(how= How.XPATH, using="//input[@id='log']")
    private WebElement enterUname;

    //Define Username Method
    public void EnterUserName(String userName)
    {
        enterUname.sendKeys(userName);
    }
    //Define Password
    @FindBy(how= How.XPATH, using="//input[@id='login_password']")
    private WebElement enterPwd;

    //Define Password Method
    public void EnterPwd(String poPwd)
    {
        enterPwd.sendKeys(poPwd);
    }
    //Define Sign In button
    @FindBy(how= How.XPATH, using="//input[@value='Sign in']")
    private WebElement signInBtn;
    //Define SignIn method
    public void ClickSignInBtn(){
        signInBtn.click();
    }
}
