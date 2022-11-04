package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasePageManager {
    @FindBy(xpath="//fieldset/textarea[1]")
    public WebElement testCaseDescriptionInput;

    @FindBy(xpath="//fieldset/textarea[2]")
    public WebElement testCaseStepsInput;

    @FindBy(xpath="//button[contains(text(), 'Submit')]")
    public WebElement testCaseSubmitButton;

    @FindBy(xpath="//tbody/tr[1]/td[4]/button[1]")
    public WebElement testCaseDetailsButton;

    @FindBy(xpath="//a[contains(text(),'Edit')]")
    public WebElement modalEditButton;

    @FindBy(xpath="//button[contains(text(),'Edit')]")
    public WebElement editPageEditButton;

    @FindBy(xpath="//body/div[@id='root']/fieldset[1]/input[1]")
    public WebElement automatedCheckBox;

    @FindBy(xpath="//body/div[@id='root']/fieldset[1]/select[1]")
    public WebElement performedByDropDown;

    @FindBy(xpath="//body/div[@id='root']/fieldset[2]/select[1]")
    public WebElement testResultDropDown;

    @FindBy(xpath="//body/div[@id='root']/fieldset[2]/textarea[1]]")
    public WebElement summaryInput;

    @FindBy(xpath="//button[contains(text(),'Save')]")
    public WebElement saveButton;

    @FindBy(xpath="//button[contains(text(),'Reset')]")
    public WebElement resetButton;

    public TestCasePageManager(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
