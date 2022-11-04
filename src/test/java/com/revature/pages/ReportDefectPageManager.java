package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportDefectPageManager {
    @FindBy(xpath="//button[contains(text(),'Report')]")
    public WebElement reportDefectReportButton;

    @FindBy(xpath="//body/div[@id='root']/form[@id='defectReport']/input[3]")
    public WebElement reportDefectPrioritySlider;

    @FindBy(xpath="//body/div[@id='root']/form[@id='defectReport']/input[2]")
    public WebElement reportDefectSeveritySlider;

    @FindBy(xpath="//body/div[@id='root']/form[@id='defectReport']/textarea[2]")
    public WebElement reportDefectStepInput;

    @FindBy(xpath="//body/div[@id='root']/form[@id='defectReport']/textarea[1]")
    public WebElement reportDefectDescriptionInput;

    @FindBy(xpath="//body/div[@id='root']/form[@id='defectReport']/input[1]")
    public WebElement reportDefectDateInput;

    public ReportDefectPageManager(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
