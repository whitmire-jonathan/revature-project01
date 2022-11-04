package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath="//body/div[@id='root']/fieldset[1]/input[1]")
    public WebElement usernameInput;

    @FindBy(xpath="//*//body/div[@id='root']/fieldset[1]/input[2]")
    public WebElement passwordInput;

    @FindBy(xpath="//button[contains(text(), 'Login')]")
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
