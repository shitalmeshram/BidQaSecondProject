package com.BidQa.test.Resources;

import com.BidQa.test.Pages.HomePage;
import com.BidQa.test.Pages.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by hishailesh77 on 5/17/2017.
 */
public class PageResources {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    public PageResources(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
    public HomePage getHomePage() {
        return homePage;
    }
    public LoginPage getLoginPage() {
        return loginPage;
    }
}
