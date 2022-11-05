package com.revature.runners;

import com.revature.pages.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

@CucumberOptions(features = "classpath:features", glue = "com.revature.stepImplementation")
public class BasicRunner extends AbstractTestNGCucumberTests {

        public static WebDriver driver;
        public static LoginPage loginPage;
        public static HomePageManager homePageManager;
        public static HomePageTester homePageTester;
        public static DefectOverviewManager defectOverviewManager;
        public static MatrixDashboardPageManager matrixDashboardPageManager;
        public static ReportDefectPageManager reportDefectPageManager;
        public static TestCasePageManager testCasePageManager;


        @BeforeMethod
        public void setup() {
            WebDriverManager.chromedriver().setup();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            driver = new ChromeDriver();

            loginPage = new LoginPage(driver);

            homePageManager = new HomePageManager(driver);

            homePageTester = new HomePageTester(driver);

            defectOverviewManager = new DefectOverviewManager(driver);

            matrixDashboardPageManager = new MatrixDashboardPageManager(driver);

            reportDefectPageManager = new ReportDefectPageManager(driver);

            testCasePageManager = new TestCasePageManager(driver);
        }

        @AfterMethod
        public void cleanup() {
            driver.quit();
        }
}
