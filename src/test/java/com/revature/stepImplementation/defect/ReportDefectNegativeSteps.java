package com.revature.stepImplementation.defect;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;

public class ReportDefectNegativeSteps {
    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page() throws InterruptedException {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=11");
        BasicRunner.loginPage.usernameInput.sendKeys("ryeguy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        BasicRunner.loginPage.loginButton.click();
        Thread.sleep(1000);
        BasicRunner.homePageTester.reportADefectLink.click();
        Thread.sleep(1000);
        String defectReporterTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(defectReporterTitle, "Case Reporter");
    }
    @When("The employee selects todays date")
    public void the_employee_selects_todays_date() {
        BasicRunner.reportDefectPageManager.reportDefectDateInput.sendKeys("11");
        BasicRunner.reportDefectPageManager.reportDefectDateInput.sendKeys("03");
        BasicRunner.reportDefectPageManager.reportDefectDateInput.sendKeys("2022");
    }
    @When("The employee types in {string} with")
    public void the_employee_types_in_with(String string, String docString) throws InterruptedException {
        Thread.sleep(1000);
        BasicRunner.reportDefectPageManager.reportDefectDescriptionInput.sendKeys("Description", "Users are " +
                "able to create multiple accounts using the same username but with a different password.");
        Thread.sleep(1000);
        BasicRunner.reportDefectPageManager.reportDefectStepInput.sendKeys("Steps", "meh");
        Thread.sleep(1000);
    }
    @When("The employee selects high priority")
    public void the_employee_selects_high_priority() {
    }
    @When("The employee selects low severity")
    public void the_employee_selects_low_severity() {
        WebElement slider = BasicRunner.reportDefectPageManager.reportDefectPrioritySlider;
        Actions action = new Actions(BasicRunner.driver);
//        action.dragAndDropBy(slider, )
    }
    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button() throws InterruptedException {
        BasicRunner.reportDefectPageManager.reportDefectReportButton.click();
        Thread.sleep(1000);
    }
    @Then("No confirmation dialog appears")
    public void no_confirmation_dialog_appears() {
        String alertMessage = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertNull(alertMessage);
    }
}
