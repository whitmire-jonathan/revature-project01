package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefectOverviewManager {
    @FindBy(xpath="//body/div[@id='root']/ul[1]/li[1]/div[1]/span[1]/p[1]")
    public WebElement firstDefect;

    @FindBy(xpath="//body/div[@id='root']/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]")
    public WebElement firstDefectChangeStatusButton;

    @FindBy(xpath="//a[contains(@href,'/managerhome')]")
    public WebElement defectOverviewHomeLink;

    public DefectOverviewManager(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
