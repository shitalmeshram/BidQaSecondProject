package com.BidQa.test.Pages;

import com.BidQa.test.Data.DataProviderClass;
import com.BidQa.test.Resources.PageResources;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by hishailesh77 on 5/17/2017.
 */
public class BidQaHelper {

    @Test(dataProviderClass = DataProviderClass.class,dataProvider = "ProjectOwnerData")
    public static void ProjectOwner(PageResources pageResources, WebDriver driver,String username,String pwd){
        pageResources = new PageResources(driver);
        //Enter username
        pageResources.getLoginPage().EnterUserName(username);
        //Enter pwd
        pageResources.getLoginPage().EnterPwd(pwd);
        //Click Sign In button
        pageResources.getLoginPage().ClickSignInBtn();

    }
}
