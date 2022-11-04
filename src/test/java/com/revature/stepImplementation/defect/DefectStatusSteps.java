package com.revature.stepImplementation.defect;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DefectStatusSteps {
    @Given("The tester is on the Home Page")
    public void the_tester_is_on_the_home_page() throws InterruptedException {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=11");
        BasicRunner.loginPage.usernameInput.sendKeys("cavalier89");
        BasicRunner.loginPage.passwordInput.sendKeys("alucard");
        BasicRunner.loginPage.loginButton.click();
        Thread.sleep(1000);
        String testerHomePageTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(testerHomePageTitle, "Tester Home");
    }
    @Then("The tester can can see only defects assigned to them")
    public void the_tester_can_can_see_only_defects_assigned_to_them() throws InterruptedException {
        WebElement defect = BasicRunner.driver.findElement(By.xpath("//body[1]/div[1]/ul[1]/li[1]/div[1]/span[1]/p[1]"));
        defect.click();
        Thread.sleep(1000);
        String assignedToText = BasicRunner.driver.findElement(By.xpath("//p[text() = 'cavalier89']")).getText();

        Assert.assertEquals(assignedToText, "Assigned To: cavalier89");
        Thread.sleep(1000);
    }
    @When("The tester changes to defect to any status")
    public void the_tester_changes_to_defect_to_any_status() throws InterruptedException {
        BasicRunner.homePageTester.defectChangeStatusButton.click();
        Thread.sleep(1000);
        WebElement clickAcceptedStatus = BasicRunner.driver.findElement(By.xpath("//button[contains(text(),'Accepted')]"));
        clickAcceptedStatus.click();
        Thread.sleep(1000);
    }
    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status() {
        String defectStatus = BasicRunner.driver.findElement(By.xpath("//b[contains(text(),'Accepted')]")).getText();
        Assert.assertEquals(defectStatus, "Accepted");
    }
}
