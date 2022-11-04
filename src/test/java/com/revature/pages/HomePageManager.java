package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageManager {

    @FindBy(xpath="//a[contains(@href,'/matrices')]")
    public WebElement matricesLink;

    @FindBy(xpath="//a[contains(@href,'/testcases')]")
    public WebElement testCasesLink;

    @FindBy(xpath="//a[contains(@href,'/defectreporter')]")
    public WebElement reportADefectLink;

    @FindBy(xpath="//a[contains(@href,'/defectoverview')]")
    public WebElement defectOverviewLink;

    @FindBy(xpath="//a[contains(@href,'/?dev=11')]")
    public WebElement logOutLink;

    @FindBy(xpath="//title")
    public WebElement managerHomePageTitle;

    @FindBy(xpath="//tr/td/button[1]")
    public WebElement selectFirstDefectButton;

    @FindBy(xpath="//button[contains(text(), 'Create A new Requirements Matrix')]")
    public WebElement createNewMatrixButton;
    @FindBy(xpath="//h2[contains(text(),'New matrix')]")
    public WebElement createMatrixTitle;

    @FindBy(xpath="//body/div[@id='root']/input[1]")
    public WebElement createMatrixTitleInput;

    @FindBy(xpath="//tbody/tr[1]/td[1]/input[1]")
    public WebElement createMatrixUserStory;

    @FindBy(xpath="//tbody/tr[1]/td[3]/input[1]")
    public WebElement createMatrixNote;

    @FindBy(xpath="//button[contains(text(),'Add Requirement')]")
    public WebElement createMatrixAddRequirementButton;

    @FindBy(xpath="//button[contains(text(),'Create Matrix')]")
    public WebElement createMatrixButton;

    public HomePageManager(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}