Feature: Signin functionality

  Scenario: Signin as superadmin
    Given User is in the home page
   When User clicks the link signin
   And Enters 'admin' as username
  And Enters 'admin' as password
  And clicks the signin button
  Then User can see the superadmin homepage
  @Signin
Scenario Outline: User cannot login with invalid id
  Given User is in the home page
  When User clicks the link signin
  And Enters '<username>' as username
  And Enters '<Password>' as password
  And clicks the signin button
  Then User sees the '<Error>' as errormessage
  Examples:
  |username|Password|Error|
  |admin   |admin1  |Invalid Credentials !|
  |admin1  |admin   |Invalid Credentials !|
  |        |        |Invalid Credentials !|

