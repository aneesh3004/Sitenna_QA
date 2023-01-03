Feature: To test the forgot password functionality

  Scenario Outline: Send reset password link in mail
    Given browser is launched
    And URL address is entered and checked if the user is on login page
    Then user clicks on the Forgot Password link and check if the user is on forgot password page
    When user enters the <Email>
    And clicks on Reset Password button
    Then message should be displayed to check the mail

    Examples: 
      | Email                 |
      | aneesh@mailinator.com |

  Scenario Outline: To open mailinator in new tab and click on Create New Password button
    Given a new tab is opened
    And mail URL address is entered
    When user enters <Mail_Email> and clicks on Go button
    Then mail account of user opens
    Given user fetches and opens the mail with Subject Reset Password
    And clicks on Create New Password button
    Then Create New Password window should open in new tab

    Examples: 
      | Mail_Email            |
      | aneesh@mailinator.com |

  Scenario Outline: To reset password and login with new password
    When user enetrs <CreateNewPassword> and <RepeatNewPassword>
    And clicks on Continue button
    Then error message displayed if both passwords entered are not same
    Then success message displayed if both passwords entered are same
    And user should be on login page
    Then enter the <Email> & <NewPassword>
    And clicks on login button
    Then login succss message should be displayed
    And user should be navigated to the dashboard
    And browser is closed

    Examples: 
      | CreateNewPassword | RepeatNewPassword |
      | Password@1234     | Password@123      |
      | Password@1234     | Password@1234     |

    Examples: 
      | Email                 | NewPassword   |
      | aneesh@mailinator.com | Password@1234 |
