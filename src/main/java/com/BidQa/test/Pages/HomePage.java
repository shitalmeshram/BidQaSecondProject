package com.BidQa.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by hishailesh77 on 5/17/2017.
 */
public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Define Login Link
    @FindBy(how= How.XPATH, using="//a[@href='http://test.bidqa.com/wp-login.php']")
    private WebElement loginLink;

    //Define Login Link Method
    public void ClickLoginLink()
    {
        loginLink.click();
    }
}
