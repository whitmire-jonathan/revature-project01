package com.revature.stepImplementation.matrix;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MatrixSteps {
    @Given("A manager is on their home page")
    public void a_manager_is_on_their_home_page() throws InterruptedException {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=11");
        BasicRunner.loginPage.usernameInput.sendKeys("g8tor");
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
        BasicRunner.loginPage.loginButton.click();
        Thread.sleep(1000);
        String manPageTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(manPageTitle, "Manager Home");
    }
    @Then("A manager can pull up a form to make a new matrix")
    public void a_manager_can_pull_up_a_form_to_make_a_new_matrix() throws InterruptedException {
        WebElement matrixButton = BasicRunner.homePageManager.createNewMatrixButton;
        matrixButton.click();
        Thread.sleep(1000);
        String matrixFormHeader = BasicRunner.homePageManager.createMatrixTitle.getText();
        Assert.assertEquals(matrixFormHeader, "New matrix");
    }
    @When("A manager creates a title for a matrix")
    public void a_manager_creates_a_title_for_a_matrix() {
        WebElement matrixTitleCheck = BasicRunner.homePageManager.createMatrixTitleInput;
        matrixTitleCheck.sendKeys("New Matrix Title");
    }
    @When("A manager adds requirements to a matrix")
    public void a_manager_adds_requirements_to_a_matrix() throws InterruptedException {
        WebElement createMatrixUserStory = BasicRunner.homePageManager.createMatrixUserStory;
        createMatrixUserStory.sendKeys("New requirement for matrix");
        Thread.sleep(1000);
        WebElement createMatrixNote = BasicRunner.homePageManager.createMatrixNote;
        createMatrixNote.sendKeys("Here is a note about my new requirement");
        Thread.sleep(1000);
        BasicRunner.homePageManager.createMatrixAddRequirementButton.click();
        Thread.sleep(1000);
    }
    @When("A manager saves a matrix")
    public void a_manager_saves_a_matrix() throws InterruptedException {
        BasicRunner.homePageManager.createMatrixButton.click();
        Thread.sleep(1000);
        BasicRunner.driver.switchTo().alert().accept();
        Thread.sleep(1000);
        BasicRunner.homePageManager.matricesLink.click();
        Thread.sleep(1000);
    }
    @Then("The matrix should be visible for all testers and managers")
    public void the_matrix_should_be_visible_for_all_testers_and_managers() throws InterruptedException {
        boolean newMatrixCreatedManagerPage = BasicRunner.driver.findElement(By.xpath("//li[contains(text(), 'New Matrix Title')]")).isDisplayed();
        Assert.assertTrue(newMatrixCreatedManagerPage);
        Thread.sleep(1000);
        BasicRunner.homePageManager.logOutLink.click();
        Thread.sleep(1000);
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=11");
        Thread.sleep(1000);
        BasicRunner.loginPage.usernameInput.sendKeys("ryeGuy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        Thread.sleep(1000);
        BasicRunner.loginPage.loginButton.click();
        Thread.sleep(1000);
        BasicRunner.homePageTester.matricesLink.click();
        Thread.sleep(1000);
        boolean newMatrixCreatedTesterPage = BasicRunner.driver.findElement(By.xpath("//li[contains(text(), 'New Matrix Title')]")).isDisplayed();
        Assert.assertTrue(newMatrixCreatedTesterPage);
        Thread.sleep(1000);
        BasicRunner.homePageTester.logOutLink.click();
    }
    @Given("A manager or tester has selected a matrix")
    public void a_manager_or_tester_has_selected_a_matrix() throws InterruptedException {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=11");
        BasicRunner.loginPage.usernameInput.sendKeys("g8tor");
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
        Thread.sleep(1000);
        BasicRunner.loginPage.loginButton.click();
        Thread.sleep(1000);
        BasicRunner.homePageManager.matricesLink.click();
        Thread.sleep(1000);
        BasicRunner.matrixDashboardPageManager.matrixShowButton.click();
        Thread.sleep(1000);
    }
    String deletedDefect;
    @When("A manager or tester adds or removes defects")
    public void a_manager_or_tester_adds_or_removes_defects() throws InterruptedException {
        deletedDefect = BasicRunner.driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText();
        BasicRunner.matrixDashboardPageManager.matrixEditButton.click();
        Thread.sleep(1000);
        BasicRunner.matrixDashboardPageManager.matrixDefectIdRemoveButton.click();
        Thread.sleep(1000);
        BasicRunner.matrixDashboardPageManager.matrixSaveRequirementsButton.click();
        Thread.sleep(1000);
        BasicRunner.driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }
    @When("A manager or tester confirms their changes")
    public void a_manager_or_tester_confirms_their_changes() {
        String newDefectList = BasicRunner.driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText();
        Assert.assertNotEquals(newDefectList, deletedDefect);
    }
    @Then("Then the matrix should saved")
    public void then_the_matrix_should_saved() {
    }
    String deletedTestCase;
    @When("A manager or tester adds or removes Test Cases")
    public void a_manager_or_tester_adds_or_removes_test_cases() throws InterruptedException {
        deletedTestCase = BasicRunner.driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText();
        BasicRunner.matrixDashboardPageManager.matrixEditButton.click();
        Thread.sleep(1000);
        BasicRunner.matrixDashboardPageManager.matrixTestCaseIdRemoveButton.click();
        Thread.sleep(1000);
        BasicRunner.matrixDashboardPageManager.matrixSaveRequirementsButton.click();
        Thread.sleep(1000);
        BasicRunner.driver.switchTo().alert().accept();
        Thread.sleep(1000);
        String newTestCaseIdList = BasicRunner.driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText();
        Assert.assertNotEquals(newTestCaseIdList, deletedTestCase);
    }
}
