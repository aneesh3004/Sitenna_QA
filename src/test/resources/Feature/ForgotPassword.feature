Feature: To test the forgot password functionality

  Scenario Outline: Forgot Password
    Given browser is launched
    And URL address is entered and checked if the user is on login page
    Then user clicks on the Forgot Password link and check if the user is on forgot password page
    When user enters the <Email>
    And clicks on Reset Password button
    Then user clicks on the Create New Password button in email and is on Create New Password window
    When user enetrs <New Password> and <Repeat New Password>
    And clicks on Continue button
    Then error message displayed if both passwords entered are not same
    Then success message displayed if both passwords entered are same
    And user is on login page

    Examples: 
      | Email                 |
      | vyas.aneesh@gmail.com |

    Examples: 
      | Create New Password | Repeat New Password |
      | Password@1981       | Password@198        |
      | Password@1981       | Password@1981       |