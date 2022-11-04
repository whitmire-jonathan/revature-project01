Feature: Navigation

    Background: Logged in as a Manager
        Given The manager is logged in as a manager 
        Given The manager is on the home page
    
    Scenario: Home Page Links Visible
        Then The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview 

    Scenario: Back Navigation
        When The manager clicks on Matrices
        When The manager clicks the browser back button 
        Then The manager should be on the home page and the title of page is Home 
        When The manager clicks on Test Cases
        When The manager clicks the browser back button 
        Then The manager should be on the home page and the title of page is Home 
    
    Scenario Outline: All Links Viable 
        Then The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview 
        When The manager clicks on <link>
        Then The title of page should be <title>
    
    Examples:
        | link           | title               | 
        | Matrices       | Matrix Overview     |
        | Test Cases     | Test Case Overview  |
        | Report a Defect| Defect Reporter     |
        | Defect Overview| Defect Overview     |
        | Matrices       | Matrix Dashboard    |
        | Test Cases     | Test Cases          |
        | Report a Defect| Case Reporter       |
        | Defect Overview| Case Overview       |

