package com.BidQa.test;

import com.BidQa.test.Data.DataGenerator;
import com.BidQa.test.Data.DataProviderClass;
import com.BidQa.test.Pages.BidQaHelper;
import com.BidQa.test.Resources.PageResources;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
    private DataGenerator dataGenerator;
    public String projectTitle  ;


    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.navigate().to("http://test.bidqa.com/");
        driver.manage().window().maximize();

    }
//----------------------------Project Owner Posting and Publishing Project----------------------------------------------

    @Test( priority = 1,enabled = true,dataProviderClass = DataProviderClass.class,dataProvider = "DataCredentials")
    public void ProjectOwnerTest(String username, String pwd) throws InterruptedException {

        pageResources = new PageResources(driver);

        // Click Login link
        pageResources.getHomePage().ClickLoginLink();

        //Login as Project Owner
        BidQaHelper.LoginCred(pageResources,driver,username,pwd);
        //Verifying that logged in as a Project Owner
        java.lang.String welcomeText =  pageResources.getMyAccountPage().GetPresentText();
        try {
            Assert.assertTrue(true, String.valueOf(welcomeText.contains(" Project Owner")));
            System.out.println(welcomeText);
        }
        catch (Exception e)
        {
            Assert.fail("Project Owner is not logged in");
        }

        //Click on post new project link
        pageResources.getMyAccountPage().ClickPostNewProLink();

        //Verifying project information text
        java.lang.String infoText = pageResources.getMyAccountPage().GetProjectText();
        try {
            Assert.assertTrue(true, String.valueOf(infoText.contains("Information")));
            System.out.println(infoText);
        }
        catch (Exception e)
        {
            Assert.fail("No Project Information");
        }


        //Calling PostNewProject from helper class
        BidQaHelper.PostNewProject(pageResources, driver);
       /* projectTitle = dataGenerator.randomTitleChars;
        System.out.println("Project Title="+pageResources.getPostNewProjectPage().EnterProjectTitle(projectTitle));*/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Calling Paypal method from helper calss
        BidQaHelper.PayPal(pageResources, driver);

        //System.out.println("Project name ="+projectTitle);

        //Logout
        //Click on logout link
        //pageResources.getLogoutPage().ClickLogoutLink();

    }

    //----------------------QA Engineers Bidding on the Project--------------------------------------

    @Test( priority = 2,enabled = false,dataProviderClass = DataProviderClass.class,dataProvider = "DataCredentials")
    public void QaEngineerTest(String username,String pwd) throws InterruptedException {

        pageResources = new PageResources(driver);

        // Click Login link
        pageResources.getHomePage().ClickLoginLink();

        //Login as QA Engineer
        BidQaHelper.LoginCred(pageResources, driver, username, pwd);

        //Verifying that logged in as a QA Engineer
        java.lang.String welcomeQAText =  pageResources.getMyAccountPage().GetQaPresentText();
        try {
            Assert.assertTrue(true, String.valueOf(welcomeQAText.contains("QA Engineer")));
            System.out.println(welcomeQAText);
        }
        catch (Exception e)
        {
            Assert.fail("qa Engineer is not logged in");
        }
        //Caliing QaBiddingProject method from helper class
        BidQaHelper.QaBiddingProject(pageResources, driver);

        //Verifying QA Engineer's Bidding Status
        java.lang.String statusText =  pageResources.getQaBiddingProjectPage().GetBidStatus();
        try {
            Assert.assertTrue(true, String.valueOf(statusText.contains(" Your bid")));
            System.out.println(username+":"+statusText);
        }
        catch (Exception e)
        {
            Assert.fail("Project Owner is not logged in");
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //Logout
        //Click on logout link
        pageResources.getLogoutPage().ClickLogoutLink();
    }

    //---------------------Project Owner Select QA Engineers as a Winner----------------------------
    @Test( priority = 3,enabled = false,dataProviderClass = DataProviderClass.class,dataProvider = "DataCredentials")
    public void ProjectOwnerTest1(String username,String pwd) throws InterruptedException {

        pageResources = new PageResources(driver);

        // Click Login link
        pageResources.getHomePage().ClickLoginLink();

        //Login as Project Owner
        BidQaHelper.LoginCred(pageResources, driver, username, pwd);
        //Verifying that logged in as a Project Owner
        java.lang.String welcomeText = pageResources.getMyAccountPage().GetPresentText();
        try {
            Assert.assertTrue(true, String.valueOf(welcomeText.contains(" Project Owner")));
            System.out.println(welcomeText);
        } catch (Exception e) {
            Assert.fail("Project Owner is not logged in");
        }

        //calling SelectWinner method from helper class
        BidQaHelper.SelectWinner(pageResources,driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Click on My Account link
        pageResources.getMyAccountPage().ClickMyAccountLink();

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Calling CreateNewTeam method from helper class
        BidQaHelper.CreateNewTeam(pageResources,driver);

        //calling AddUsersToTeam method from helper class
        BidQaHelper.AddUsersToTeam(pageResources,driver);

        //Logout from the account
        Thread.sleep(3000);
       // pageResources.getLogoutPage().ClickLogoutLink();

    }


    @AfterClass
    public void afterClass() throws InterruptedException {
        //Close the browser
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.close();
        //driver.quit();
    }
}
