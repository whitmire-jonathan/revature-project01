package com.revature.stepImplementation.login;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginNegativeSteps {
    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=11");
    }

    @When("The employee types in {string} into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input(String username) {
        BasicRunner.loginPage.usernameInput.sendKeys(username);
    }

    @When("The employee types in {string} into the password input")
    public void the_employee_types_in_chomp_into_the_password_input(String password) {
        BasicRunner.loginPage.passwordInput.sendKeys(password);
    }

    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        BasicRunner.loginPage.loginButton.click();
    }

    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() throws InterruptedException {
//        BasicRunner.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        Thread.sleep(1000);
        String alertMessage = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "Wrong password for User");
    }

    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input() {
        BasicRunner.loginPage.usernameInput.sendKeys("sicEmDawgs");
    }

    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input() {
        BasicRunner.loginPage.passwordInput.sendKeys("natchamps");
    }

    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() throws InterruptedException {
//        BasicRunner.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        Thread.sleep(1000);
        String alertMessage = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "Username not found");
    }
}
