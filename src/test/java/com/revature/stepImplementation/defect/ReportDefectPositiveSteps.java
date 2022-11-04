package com.revature.stepImplementation.defect;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ReportDefectPositiveSteps {

    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {
        String alertBox = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertNotNull(alertBox);
    }
    @When("The employee clicks Ok")
    public void the_employee_clicks_ok() {
        BasicRunner.driver.switchTo().alert().accept();
    }

//    String defectReporterTitle = BasicRunner.driver.findElement(By.xpath("//h1[contains(text(),'Defect Reporter')]")).getText();

    @Then("A modal should appear with a Defect ID")
    public void a_modal_should_appear_with_a_defect_id() {
        boolean closeButtonDisplayed = BasicRunner.driver.findElement(By.xpath("//button[contains(text(),'Close')]")).isDisplayed();
        Assert.assertTrue(closeButtonDisplayed);
    }
    @When("The employee clicks close")
    public void the_employee_clicks_close() throws InterruptedException {
        WebElement closeButton = BasicRunner.driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
        closeButton.click();
        Thread.sleep(1000);
    }
    @Then("The modal should disappear")
    public void the_modal_should_disappear() {
        boolean closeButtonDisplayed = BasicRunner.driver.findElement(By.xpath("//button[contains(text(),'Close')]")).isDisplayed();
        Assert.assertFalse(closeButtonDisplayed);
    }
}
