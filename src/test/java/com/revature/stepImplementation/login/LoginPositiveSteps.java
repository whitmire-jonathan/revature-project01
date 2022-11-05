package com.revature.stepImplementation.login;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPositiveSteps {
    @When("The employee types g8tor into username input")
    public void the_employee_types_g8tor_into_username_input() {
        BasicRunner.loginPage.usernameInput.sendKeys("g8tor");
    }
    @When("The employee types chomp! into password input")
    public void the_employee_types_chomp_into_password_input() {
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
    }
    @Then("the employee should be on the Manager page")
    public void the_employee_should_be_on_the_manager_page() throws InterruptedException {
        Thread.sleep(1000);
        String manPageTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(manPageTitle, "Manager Home");
    }
    @Then("The employee should see their name Patty Pastiche on the home page")
    public void the_employee_should_see_their_name_patty_pastiche_on_the_home_page() {
        String ppName = BasicRunner.driver.findElement(By.xpath("//body/div[@id='root']/nav[1]/p[1]")).getText();
        Assert.assertEquals(ppName, "Welcome Patty Pastiche");
    }
    @When("The employee types ryeGuy into username input")
    public void the_employee_types_rye_guy_into_username_input() {
        BasicRunner.loginPage.usernameInput.sendKeys("ryeGuy");
    }
    @When("The employee types coolbeans into password input")
    public void the_employee_types_coolbeans_into_password_input() {
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
    }
    @Then("the employee should be on the Tester page")
    public void the_employee_should_be_on_the_tester_page() throws InterruptedException {
        Thread.sleep(1000);
        String testerPageTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(testerPageTitle, "Tester Home");
    }
    @Then("The employee should see their name Fakey McFakeFace on the home page")
    public void the_employee_should_see_their_name_fakey_mc_fake_face_on_the_home_page() {
        String fmName = BasicRunner.driver.findElement(By.xpath("//body/div[@id='root']/nav[1]/p[1]")).getText();
        Assert.assertEquals(fmName, "Welcome Fakey McFakeFace");
    }
    @When("The employee types cavalier89 into username input")
    public void the_employee_types_cavalier89_into_username_input() {
        WebElement usernameInput = BasicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[1]"));
        usernameInput.sendKeys("cavalier89");
    }
    @When("The employee types alucard into password input")
    public void the_employee_types_alucard_into_password_input() {
        WebElement passwordInput = BasicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[2]"));
        passwordInput.sendKeys("alucard");
    }
    @Then("The employee should see their name Dracula FangsCheck on the home page")
    public void the_employee_should_see_their_name_dracula_fangs_check_on_the_home_page() throws InterruptedException {
        Thread.sleep(1000);
        String dfName = BasicRunner.driver.findElement(By.xpath("//body/div[@id='root']/nav[1]/p[1]")).getText();
        Assert.assertEquals(dfName, "Welcome Dracula Fangs");

    }
}
