package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageTester {
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
    public WebElement testerHomePageTitle;

    @FindBy(xpath="//button[contains(text(),'Change Status')]")
    public WebElement defectChangeStatusButton;

    public HomePageTester(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
