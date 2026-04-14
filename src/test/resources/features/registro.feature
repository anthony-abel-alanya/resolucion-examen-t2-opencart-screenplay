Feature: User Registration
Scenario: Successful registration with valid data
    Given the user navigates to the register page
    When the user fills the form with first name "Anthony", last name "Alanya", email "202312037@cibertec.pe", phone "985645656" and password "Test@12345"
         And accepts the privacy policy
         And clicks on continue
    Then the user should see the registration message "Your Account Has Been Created!"