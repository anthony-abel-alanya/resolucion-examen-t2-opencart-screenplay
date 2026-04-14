Feature: User Login
  Scenario: Successful login with valid credentials
    Given the user navigates to the login page
    When the user enters email "202312037@cibertec.pe" and password "Test@12345"
    And clicks on the login button
    Then the user should see the name "Anthony" in the page header

  Scenario: Failed login with wrong password
    Given the user navigates to the login page
    When the user enters email "fakeuser123@mail.com" and password "wrongpass"
    And clicks on the login button
    Then the user should see the login error message "Warning: No match for E-Mail Address and/or Password."