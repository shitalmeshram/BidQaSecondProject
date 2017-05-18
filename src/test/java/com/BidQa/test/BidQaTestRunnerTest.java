package com.BidQa.test;

import com.BidQa.test.Data.DataProviderClass;
import com.BidQa.test.Pages.BidQaHelper;
import com.BidQa.test.Resources.PageResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by hishailesh77 on 5/17/2017.
 */
public class BidQaTestRunnerTest {
    private WebDriver driver;
    private PageResources pageResources;


    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.navigate().to("http://test.bidqa.com/");
        driver.manage().window().maximize();

        pageResources = new PageResources(driver);
        // Click Login link
        pageResources.getHomePage().ClickLoginLink();

    }

   /* @Test(priority = 1)
    public void HomePageTest() {
        pageResources = new PageResources(driver);
        // Click Login link
        pageResources.getHomePage().ClickLoginLink();
    }
*/
    @Test( dataProviderClass = DataProviderClass.class,dataProvider = "ProjectOwnerData")
    public  void ProjectOwner(String username,String pwd){
        pageResources = new PageResources(driver);
        pageResources = new PageResources(driver);
        //Enter username
        pageResources.getLoginPage().EnterUserName(username);
        //Enter pwd
        pageResources.getLoginPage().EnterPwd(pwd);
        //Click Sign In button
        pageResources.getLoginPage().ClickSignInBtn();

    }


    @AfterClass
    public void afterClass() throws InterruptedException {
        //Close the browser
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.close();
        //driver.quit();
    }
}
