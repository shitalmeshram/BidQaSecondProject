package com.BidQa.test.Pages;

import com.BidQa.test.Data.DataGenerator;
import com.BidQa.test.Data.DataProviderClass;
import com.BidQa.test.Resources.PageResources;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by hishailesh77 on 5/17/2017.
 */
public class BidQaHelper {
    static DataGenerator dataGenerator = new DataGenerator();
    //static String projectTitle = dataGenerator.randomTitleChars;
    public static  String projectTitle;

   // @Test(dataProviderClass = DataProviderClass.class,dataProvider = "ProjectOwnerData")
    public static void LoginCred(PageResources pageResources, WebDriver driver,String username,String pwd){
        pageResources = new PageResources(driver);
        //Enter username
        pageResources.getLoginPage().EnterUserName(username);
        //Enter pwd
        pageResources.getLoginPage().EnterPwd(pwd);
        //Click Sign In button
        pageResources.getLoginPage().ClickSignInBtn();

    }
    public static void PostNewProject(PageResources pageResources, WebDriver driver) throws InterruptedException {
        pageResources = new PageResources(driver);
       // DataGenerator dataGenerator = new DataGenerator();

        //Enter title
        // String projectTitle = dataGenerator.randomTitleChars;

        projectTitle = pageResources.getPostNewProjectPage().EnterProjectTitle();

        System.out.println("Project Title="+projectTitle);
        //Enter description
        pageResources.getPostNewProjectPage().EnterDescription();
        Thread.sleep(5000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //Select category
        pageResources.getPostNewProjectPage().SelectCategory();

        JavascriptExecutor jse1 = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //Enter Tag
        pageResources.getPostNewProjectPage().EnterTag();
        //Select Skills
        pageResources.getPostNewProjectPage().SelectSkills();

        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //Select price budget
        pageResources.getPostNewProjectPage().SelectBudget();

        JavascriptExecutor jse3 = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //Select project ending date
        pageResources.getPostNewProjectPage().EnterEndDate();
        Thread.sleep(3000);
        pageResources.getPostNewProjectPage().SelectDate();

        JavascriptExecutor jse4 = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //Select country
        pageResources.getPostNewProjectPage().SelectCountry();
        Thread.sleep(3000);
        //Select State
        pageResources.getPostNewProjectPage().SelectState();
        //Enter Address
        pageResources.getPostNewProjectPage().EnterAddress();

        JavascriptExecutor jse5 = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //Click next button1
        pageResources.getPostNewProjectPage().ClickNextBtn1();
        Thread.sleep(3000);


        //Click next button1
        pageResources.getPostNewProjectPage().ClickNextBtn2();
        Thread.sleep(3000);
        //Verifying Text
        if(driver.getPageSource().contains("This is how project appears to QA engineer"))
            System.out.println("Text is present in the page");
        else
            System.err.println("Text is not present in the page");
        Thread.sleep(3000);
        //Click next button3
        pageResources.getPostNewProjectPage().ClickNextBtn3();

        Thread.sleep(3000);
        //Accept terms
        pageResources.getPostNewProjectPage().ClickchkBox();
        Thread.sleep(5000);
        pageResources.getPostNewProjectPage().ClickPaypalBtn();

    }
    public static void PayPal(PageResources pageResources,WebDriver driver) throws InterruptedException {
        pageResources = new PageResources(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //out of all frames
        driver.switchTo().defaultContent();
        //switch to frame
        driver.switchTo().frame("injectedUl");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageResources.getPayPalPage().EnterEmail();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageResources.getPayPalPage().EnterPwd();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageResources.getPayPalPage().ClickLogInBtn();
        driver.switchTo().defaultContent();
        // Thread.sleep(5000);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(15000);
        pageResources.getPayPalPage().ClickPayNowBtn();

        JavascriptExecutor jse6 = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(12000);
        pageResources.getPayPalPage().ClickReTomerchant();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("Project name ="+projectTitle);
    }
    public static void QaBiddingProject(PageResources pageResources, WebDriver driver){
        pageResources = new PageResources(driver);


        //Enter project name
       // String projectTitle = dataGenerator.randomTitleChars;
        pageResources.getQaBiddingProjectPage().EnterProjectTitle(projectTitle);
       // pageResources.getQaBiddingProjectPage().EnterProjectTitle();
        System.out.println("Project Title="+projectTitle);
        //Click search button
        pageResources.getQaBiddingProjectPage().ClickSearchBtn();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Click on project name
        pageResources.getQaBiddingProjectPage().ClickProjectName();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click submit proposal btn
        pageResources.getQaBiddingProjectPage().ClickSubmitProposal();
        //Enter bid amount
        pageResources.getQaBiddingProjectPage().EnterBidAmount();
        //Enter days to complete
        pageResources.getQaBiddingProjectPage().EnterDays();
        //Enter Description
        pageResources.getQaBiddingProjectPage().EnterDescription();
        //Click check box
        pageResources.getQaBiddingProjectPage().ClickChkBox();
        //Click place bid button
        pageResources.getQaBiddingProjectPage().ClickPlaceBidBtn();
    }

    public static void SelectWinner(PageResources pageResources, WebDriver driver) throws InterruptedException {
        pageResources = new PageResources(driver);

        //Click project name
        pageResources.getSelectWinnerPage().ClickProjectName();
        System.out.println("Project Title :" + projectTitle);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Select winners under Proposals
        List<WebElement> myList = driver.findElements(By.xpath("//a[contains(@href,'http://test.bidqa.com/?p_action=choose_winner')]"));
        /*int counter = 0;
        for (WebElement myElement : myList) {

            //counter++;

            if(myElement.getText().contains("Select as Winner")){
                System.out.println("************==="+myElement.getText());
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                //clicking on project winner
            pageResources.getSelectWinnerPage().ClickSelectWinner();
           // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            //click on Choose a winner Btn
            pageResources.getSelectWinnerPage().ChooseWinnerBtn();

                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } else {
            System.out.println("Winner not found");

        }
            counter++;
        }*/

        int linkCount = myList.size();
        System.out.println("Link count = " + linkCount);

        for (; linkCount > 0; linkCount--) {
            System.out.println("Inside for loop");

            JavascriptExecutor jse1 = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,400)", "");

            driver.findElements(By.xpath("//a[contains(@href,'http://test.bidqa.com/?p_action=choose_winner')]")).get(linkCount - 1).click();
            Thread.sleep(5000);
            pageResources.getSelectWinnerPage().ChooseWinnerBtn();


            Thread.sleep(9000);
        }

        //verify that Bid Flag is now 'Project Winner'
        //Assert.assertEquals(driver.findElement(By.xpath("//*[@id='my_bids']/div/div[6], "Project Winner"));
        //Assert.assertEquals(pageResources.getPOMyAccount().getBigFlag(), "Project Winner");
        //System.out.println("Successfully selected project winner");
    }

    public static void CreateNewTeam(PageResources pageResources, WebDriver driver) throws InterruptedException {
        pageResources = new PageResources(driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Click on Team Manager link
        pageResources.getCreateTeamPage().ClickTeamManagerLink();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Click on create new team button
        pageResources.getCreateTeamPage().ClickCreateNewTeamBtn();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(5000);
        //Select project
        pageResources.getCreateTeamPage().selectproject().click();
        Select project = new Select(pageResources.getCreateTeamPage().selectproject());
        project.selectByVisibleText(projectTitle);
        System.out.println("Select project Name ="+projectTitle);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Enter team title
        pageResources.getCreateTeamPage().EnterTeamTitle();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Enter team description
        pageResources.getCreateTeamPage().EnterTeamDescription();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Click Create btn
        pageResources.getCreateTeamPage().ClickCreateBtn();

    }

    public static void AddUsersToTeam(PageResources pageResources, WebDriver driver) {
        pageResources = new PageResources(driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Select winners under Proposals
        List<WebElement> myList1 = driver.findElements(By.xpath("//div[@class='col-md-4']//span[@class='team-in-project']"));

        for (WebElement myTeam : myList1) {

            //counter++;

            if (myTeam.getText().contains(projectTitle)) {
                System.out.println("Project Name=" + myTeam.getText());
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

                //Click on Add Users Btn
                pageResources.getCreateTeamPage().AddUsersBtn();
            }
        }


    }

    }
