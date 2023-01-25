Feature: To test the forgot password functionality

  Scenario Outline: Send reset password link in mail
    Given browser is launched
    And URL address is entered and checked if the user is on login page
    Then user clicks on the Forgot Password link and check if the user is on forgot password page
    When user fills the <Email>
    And clicks on Reset Password button and message should be displayed to check the mail

    Examples: 
      | Email                 |
      | aneesh@mailinator.com |

  Scenario Outline: To open mailinator in new tab and click on Create New Password button
    Given a new tab is opened and mail URL address is entered
    When user fills <Mail_Email> and clicks on Go button
    
    Examples: 
      | Mail_Email            |
      | aneesh@mailinator.com |
