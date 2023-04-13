Feature: To test the login functionality

  Scenario Outline: Login with valid credentials
    Given user launches a browser
    And enters the URL address and check if the user is on login page
    When user enters <Email> and <Password>
    And clicks on login button and check <Email> and <Password> entered are valid or not
    Given credentials entered are valid
    Then login success message should be displayed
    And user should be navigated to the dashboard
    
    Examples: 
      | Email                 | Password      |
      | aneesh.vyas@xotiv.com | Password@1981 |

  Scenario Outline: Login with invalid credentials
    Given user launches a browser
    And enters the URL address and check if the user is on login page
    When user enters <Email> and <Password>
    And clicks on login button and check <Email> and <Password> entered are valid or not
    Given credentials entered are invalid
    Then login error message should be displayed    

    Examples: 
      | Email                  | Password      |
      | aneesh.vyas1@xotiv.com | Password_1981 |
