package com.BidQa.test.Resources;

import com.BidQa.test.Pages.*;
import org.openqa.selenium.WebDriver;

/**
 * Created by hishailesh77 on 5/17/2017.
 */
public class PageResources {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    LogoutPage logoutPage;
    PostNewProjectPage postNewProjectPage;
    MyAccountPage myAccountPage;
    PayPalPage payPalPage;
    QaBiddingProjectPage qaBiddingProjectPage;

    public PageResources(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
        postNewProjectPage = new PostNewProjectPage(driver);
        myAccountPage = new MyAccountPage(driver);
        payPalPage = new PayPalPage(driver);
        qaBiddingProjectPage = new QaBiddingProjectPage(driver);

    }
    public HomePage getHomePage() {
        return homePage;
    }
    public LoginPage getLoginPage() {
        return loginPage;
    }
    public LogoutPage getLogoutPage() {
        return logoutPage;
    }
    public PostNewProjectPage getPostNewProjectPage() {
        return postNewProjectPage;
    }
    public MyAccountPage getMyAccountPage() {
        return myAccountPage;
    }
    public PayPalPage getPayPalPage() {
        return payPalPage;
    }
    public QaBiddingProjectPage getQaBiddingProjectPage() {
        return qaBiddingProjectPage;
    }

}
