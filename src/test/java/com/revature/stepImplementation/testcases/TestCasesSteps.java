package com.revature.stepImplementation.testcases;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

public class TestCasesSteps {

    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() throws InterruptedException {
        String testCaseTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(testCaseTitle, "Test Cases");
        Thread.sleep(1000);
    }
    @When("The tester types {string} into input with")
    public void the_tester_types_into_input_with(String string, String docString) throws InterruptedException {
        BasicRunner.testCasePageManager.testCaseDescriptionInput.sendKeys(string, docString);
        Thread.sleep(1000);
    }
    @When("The tester presses the submit button")
    public void the_tester_presses_the_submit_button() throws InterruptedException {
        WebElement submitButton = BasicRunner.driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitButton.click();
        Thread.sleep(1000);
    }
    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {
        WebElement invalidInputTC = BasicRunner.driver.findElement(By.xpath("//table[1]/tbody/tr)[last()]"));
    }
    @Then("The test case result should say UNEXECUTED")
    public void the_test_case_result_should_say_unexecuted() {
        String invalidInputTC = BasicRunner.driver.findElement(By.xpath("//table[1]/tbody/tr)[last()]/td[3]")).getText();
        Assert.assertEquals(invalidInputTC, "UNEXECUTED");
    }
    @When("The tester presses on details")
    public void the_tester_presses_on_details() throws InterruptedException {
        WebElement detailsButton = BasicRunner.driver.findElement(By.xpath("//tbody/tr[1]/td[4]/button[1]"));
        detailsButton.click();
        Thread.sleep(1000);
    }
    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() {
        String caseModalId = BasicRunner.driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/h3[1]")).getText();
        Assert.assertTrue(caseModalId.contains("Case"));
    }
    @Then("The performed by field should say No One")
    public void the_performed_by_field_should_say_no_one() {
        String performedBy = BasicRunner.driver.findElement(By.xpath("//p[contains(text(),'No One')]")).getText();
        Assert.assertEquals(performedBy, "No One");
    }
    @When("The tester presses the close button")
    public void the_tester_presses_the_close_button() throws InterruptedException {
//    fixed typo buttton
        WebElement closeButton = BasicRunner.driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
        closeButton.click();
        Thread.sleep(1000);
    }
    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() {
        boolean closeButtonDisplayed = BasicRunner.driver.findElement(By.xpath("//button[contains(text(),'Close')]")).isDisplayed();
        Assert.assertFalse(closeButtonDisplayed);
    }
    @When("The tester clicks on details")
    public void the_tester_clicks_on_details() throws InterruptedException {
        BasicRunner.testCasePageManager.testCaseDetailsButton.click();
        Thread.sleep(1000);
    }
    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() throws InterruptedException {
        BasicRunner.testCasePageManager.modalEditButton.click();
        Thread.sleep(1000);
    }
    @Then("The Tester should be on the case editor for that case")
    public void the_tester_should_be_on_the_case_editor_for_that_case() {
        boolean caseEditorFieldset = BasicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]")).isDisplayed();
        Assert.assertTrue(caseEditorFieldset);
    }
    String originalDescription = BasicRunner.testCasePageManager.testCaseDescriptionInput.getText();
    @Then("The fields should be uneditable")
    public void the_fields_should_be_uneditable() {
        boolean uneditableDescription = BasicRunner.testCasePageManager.testCaseDescriptionInput.isEnabled();
        Assert.assertFalse(uneditableDescription);
    }
    @When("The tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button() throws InterruptedException {
        BasicRunner.testCasePageManager.editPageEditButton.click();
        Thread.sleep(1000);
    }
    @Then("The test case fields should be editable")
    public void the_test_case_fields_should_be_editable() throws InterruptedException {
        boolean editableDescription = BasicRunner.testCasePageManager.testCaseDescriptionInput.isEnabled();
        Assert.assertTrue(editableDescription);
        Thread.sleep(1000);
    }
    @When("The tester types in a new description into the description text area")
    public void the_tester_types_in_a_new_description_into_the_description_text_area() throws InterruptedException {
        BasicRunner.testCasePageManager.testCaseDescriptionInput.sendKeys("some new text");
        Thread.sleep(1000);
    }
    @When("The tester types in a new steps into the steps text area")
    public void the_tester_types_in_a_new_steps_into_the_steps_text_area() throws InterruptedException {
        BasicRunner.testCasePageManager.testCaseStepsInput.sendKeys("4. new step");
        Thread.sleep(1000);
    }
    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark() throws InterruptedException {
        BasicRunner.testCasePageManager.automatedCheckBox.click();
        Thread.sleep(1000);
    }
    @When("The tester selects ryeGuy for performed from drop down")
    public void the_tester_selects_rye_guy_for_performed_from_drop_down() throws InterruptedException {
        Select dropDown = new Select(BasicRunner.testCasePageManager.performedByDropDown);
        dropDown.selectByVisibleText("ryeGuy");
        Thread.sleep(1000);
    }
    @When("The tester selects FAIL for test result from drop down")
    public void the_tester_selects_fail_for_test_result_from_drop_down() throws InterruptedException {
        Select testResultDropDown = new Select(BasicRunner.testCasePageManager.testResultDropDown);
        testResultDropDown.selectByVisibleText("FAIL");
        Thread.sleep(1000);
    }
    @When("The tester types in a new summary into the summary text area")
    public void the_tester_types_in_a_new_summary_into_the_summary_text_area() throws InterruptedException {
        BasicRunner.testCasePageManager.summaryInput.sendKeys("a new summary");
        Thread.sleep(1000);
    }
    @When("The tester clicks save on test case page")
    public void the_tester_clicks_save_on_test_case_page() throws InterruptedException {
        BasicRunner.testCasePageManager.saveButton.click();
        Thread.sleep(1000);
    }
    @Then("A confirmation prompt should appear")
    public void a_confirmation_prompt_should_appear() throws InterruptedException {
        String alertBox = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertNotNull(alertBox);
        Thread.sleep(1000);
    }
    @When("The tester clicks on Ok")
    public void the_tester_clicks_on_ok() throws InterruptedException {
        BasicRunner.driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }
    @Then("An alert says the test case has been saved")
    public void an_alert_says_the_test_case_has_been_saved() throws InterruptedException {
        String alertBox2 = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(alertBox2, "Test Case has been Saved");
        Thread.sleep(1000);
    }
    @Given("the tester is on the test case editor for a specific test case")
    public void the_tester_is_on_the_test_case_editor_for_a_specific_test_case() throws InterruptedException {
        boolean caseEditorFieldset = BasicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]")).isDisplayed();
        Assert.assertTrue(caseEditorFieldset);
        Thread.sleep(1000);
    }

    @When("The tester clicks on the reset button")
    public void the_tester_clicks_on_the_reset_button() throws InterruptedException {
        BasicRunner.testCasePageManager.resetButton.click();
        Thread.sleep(1000);
    }
    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() {
        String resetDescription = BasicRunner.testCasePageManager.testCaseDescriptionInput.getText();
        Assert.assertEquals(resetDescription, originalDescription);
    }
}
