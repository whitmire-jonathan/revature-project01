package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MatrixDashboardPageManager {
    @FindBy(xpath="//body/div[@id='root']/ul[1]/li[1]/div[1]/span[1]/button[1]")
    public WebElement matrixShowButton;

    @FindBy(xpath="//a[contains(@href,'/managerhome')]")
    public WebElement matrixHomeLink;

    @FindBy(xpath="//body[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/button[1]")
    public WebElement matrixEditButton;

    @FindBy(xpath="//body/div[@id='root']/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[2]/li[1]/button[1]")
    public WebElement matrixDefectIdRemoveButton;

    @FindBy(xpath="//body/div[@id='root']/ul[1]/li[1]/div[1]/div[1]/div[1]/button[1]")
    public WebElement matrixSaveRequirementsButton;

    @FindBy(xpath="//body/div[@id='root']/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]")
    public WebElement matrixTestCaseIdRemoveButton;
    public MatrixDashboardPageManager(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
