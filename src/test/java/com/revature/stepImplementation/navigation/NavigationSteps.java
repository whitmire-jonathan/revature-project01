package com.revature.stepImplementation.navigation;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NavigationSteps {
    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() throws InterruptedException {

        WebElement matricesLink = BasicRunner.homePageManager.matricesLink;
        Assert.assertTrue(matricesLink.isDisplayed());
        Thread.sleep(1000);
        WebElement testCasesLink = BasicRunner.homePageManager.testCasesLink;
        Assert.assertTrue(testCasesLink.isDisplayed());
        Thread.sleep(1000);
        WebElement defectReportLink = BasicRunner.homePageManager.reportADefectLink;
        Assert.assertTrue(defectReportLink.isDisplayed());
        Thread.sleep(1000);
        WebElement defectOverview = BasicRunner.homePageManager.defectOverviewLink;
        Assert.assertTrue(defectOverview.isDisplayed());
    }
    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices() throws InterruptedException {
        WebElement matricesLink = BasicRunner.homePageManager.matricesLink;
        matricesLink.click();
        Thread.sleep(1000);
    }
    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() throws InterruptedException {
        BasicRunner.driver.navigate().back();
        Thread.sleep(1000);
    }
    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home() throws InterruptedException {
        String managerHomePageTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(managerHomePageTitle, "Home");
        Thread.sleep(1000);
        //bug
    }
    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() throws InterruptedException {
        WebElement testCasesLink = BasicRunner.homePageManager.testCasesLink;
        testCasesLink.click();
        Thread.sleep(1000);
    }
    @Then("The title of page should be Matrix Overview")
    //corrected misspelling of Overivew
    public void the_title_of_page_should_be_matrix_overview() throws InterruptedException {
        String matrixPageTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(matrixPageTitle, "Matrix Overview");
        Thread.sleep(1000);
        //bug
    }
    @Then("The title of page should be Test Case Overview")
    //corrected misspelling of Overivew
    public void the_title_of_page_should_be_test_case_overview() throws InterruptedException {
        String testCaseTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(testCaseTitle, "Test Case Overview");
        Thread.sleep(1000);
        //bug
    }
    @When("The manager clicks on Report a Defect")
    public void the_manager_clicks_on_report_a_defect() throws InterruptedException {
        WebElement reportADefectLink = BasicRunner.homePageManager.reportADefectLink;
        reportADefectLink.click();
        Thread.sleep(1000);
    }
    @Then("The title of page should be Defect Reporter")
    public void the_title_of_page_should_be_defect_reporter() throws InterruptedException {
        String reportADefectTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(reportADefectTitle, "Defect Reporter");
        Thread.sleep(1000);
        //bug
    }
    @When("The manager clicks on Defect Overview")
    public void the_manager_clicks_on_defect_overview() throws InterruptedException {
        WebElement defectOverviewLink = BasicRunner.homePageManager.defectOverviewLink;
        defectOverviewLink.click();
        Thread.sleep(1000);
    }
    @Then("The title of page should be Defect Overview")
    public void the_title_of_page_should_be_defect_overview() throws InterruptedException {
        String defectOverviewTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(defectOverviewTitle, "Defect Overview");
        Thread.sleep(1000);
        //bug
    }
    @Then("The title of page should be Matrix Dashboard")
    public void the_title_of_page_should_be_matrix_dashboard() throws InterruptedException {
        String matrixDashboard = BasicRunner.driver.getTitle();
        Assert.assertEquals(matrixDashboard, "Matrix Dashboard");
        Thread.sleep(1000);
    }
    @Then("The title of page should be Test Cases")
    public void the_title_of_page_should_be_test_cases() throws InterruptedException {
        String testCases = BasicRunner.driver.getTitle();
        Assert.assertEquals(testCases, "Test Cases");
        Thread.sleep(1000);
    }
    @Then("The title of page should be Case Reporter")
    public void the_title_of_page_should_be_case_reporter() throws InterruptedException {
        String caseReporter = BasicRunner.driver.getTitle();
        Assert.assertEquals(caseReporter, "Case Reporter");
        Thread.sleep(1000);
    }
    @Then("The title of page should be Case Overview")
    public void the_title_of_page_should_be_case_overview() throws InterruptedException {
        String caseOverview = BasicRunner.driver.getTitle();
        Assert.assertEquals(caseOverview, "Case Overview");
        Thread.sleep(1000);
    }
}
