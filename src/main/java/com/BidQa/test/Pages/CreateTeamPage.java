package com.BidQa.test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.BidQa.test.Pages.BidQaHelper.dataGenerator;
import static java.lang.Thread.*;

/**
 * Created by shail on 5/22/2017.
 */
public class CreateTeamPage {
    WebDriver driver;

    public CreateTeamPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //Define Team Manager link
    @FindBy(how= How.XPATH, using="//a[@href='http://test.bidqa.com/my-account/team-manager/']")
    private WebElement teamManagerLink;

    //Define Team Manager link Method
    public void ClickTeamManagerLink()
    {
        teamManagerLink.click();
    }

    //Define create new team button
    @FindBy(how= How.XPATH, using="//button[@id='create-new-team']")
    private WebElement createNewTeamBtn;

    //Define Team Manager link Method
    public void ClickCreateNewTeamBtn()
    {
        createNewTeamBtn.click();
    }

    //Define Select Project Field
    /*@FindBy(how = How.XPATH, using = "//select[@id='select-project']")
    private WebElement selectProject;*/

  public WebElement selectproject(){
      return driver.findElement(By.id("select-project"));
  }

   /* public String SelectProject(String title) throws InterruptedException {
        Select project = new Select(selectProject);
        project.selectByVisibleText(title);
        System.out.println("Select Project Name ="+title);
        return dataGenerator.randomTitleChars;
    }*/

    //Define team title field
    @FindBy(how= How.XPATH, using="//input[@id='team-title']")
    private WebElement enterTeamTitle;

    //Define team title Method
    public void EnterTeamTitle()
    {
        enterTeamTitle.sendKeys(dataGenerator.teamTitleChars);
    }

    //Define description field
    @FindBy(how= How.XPATH, using="//textarea[@id='team-desc']")
    private WebElement enterTeamDescription;

    //Define description Method
    public void EnterTeamDescription()
    {
        enterTeamDescription.sendKeys(dataGenerator.teamDescriptionChars);
    }

    //Define create button
    @FindBy(how= How.XPATH, using="//input[@id='submit-create-team']")
    private WebElement createBtn;

    //Define create button Method
    public void ClickCreateBtn()
    {
        createBtn.click();
    }

    //Define Add Users  button
    @FindBy(how= How.XPATH, using="//a[@class='show-add-user glyphicon glyphicon-user btn btn-default btn-xs']")
    private WebElement addUsersBtn;

    //Define create button Method
    public void AddUsersBtn()
    {
        addUsersBtn.click();
    }


}
