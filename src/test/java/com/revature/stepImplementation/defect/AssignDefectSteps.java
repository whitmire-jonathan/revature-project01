package com.revature.stepImplementation.defect;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;

public class AssignDefectSteps {

    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() throws InterruptedException {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=11");
        BasicRunner.loginPage.usernameInput.sendKeys("g8tor");
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
        BasicRunner.loginPage.loginButton.click();
        Thread.sleep(1000);
        String manPageTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(manPageTitle, "Manager Home");
    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        String manPageTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(manPageTitle, "Manager Home");
    }
    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {
        boolean pendingDefects = BasicRunner.driver.findElement(By.cssSelector("div:nth-child(2) table:nth-child(4) tbody:nth-child(2) tr:nth-child(1) > td:nth-child(1)")).isDisplayed();
        Assert.assertTrue(pendingDefects);
    }
    public String defectDesc;
    public String defectDescId;
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        WebElement defectSelectButton = BasicRunner.driver.findElement(By.xpath("//tbody/tr[1]/td[3]/button[1]"));
        defectSelectButton.click();
    }
    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() throws InterruptedException {
        defectDesc = BasicRunner.driver.findElement(By.xpath("//div[@id='root']/div/h4")).getCssValue("font-weight");
        Assert.assertEquals(defectDesc, "700");
        Thread.sleep(1000);
        defectDescId = BasicRunner.driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
    }
    @When("The manager selects a tester from the drop down")
    public void the_manager_selects_a_tester_from_the_drop_down() {
        WebElement testerSelectInput = BasicRunner.driver.findElement(By.xpath("//body/div[@id='root']/div[1]/input[1]"));
        testerSelectInput.sendKeys("ryeGuy");
    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() throws InterruptedException {
        BasicRunner.homePageManager.assignButton.click();
        Thread.sleep(1000);
    }
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
        String defectMessage = BasicRunner.driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
        Assert.assertNotEquals(defectDesc, defectMessage);
    }
    @Given("The assigned tester is on their home page")
    public void the_assigned_tester_is_on_their_home_page() throws InterruptedException {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=11");
        BasicRunner.loginPage.usernameInput.sendKeys("ryeGuy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        BasicRunner.loginPage.loginButton.click();
        Thread.sleep(1000);
        String manPageTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(manPageTitle, "Tester Home");
    }
    @Then("The tester should see the pending defect")
    public void the_tester_should_see_the_pending_defect() {
        List<WebElement> testerDefectList = BasicRunner.driver.findElements(By.xpath("//ul/li//b"));
        boolean flag = false;
        for (WebElement x : testerDefectList) {
            if (x.getText().contains(defectDescId)){
                flag = true;
            }
        }
        Assert.assertTrue(flag);
    }
}
