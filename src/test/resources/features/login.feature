Feature: Login feature for demo application
  In order to access secure areas
  As a registered user
  I want to be able to login using valid credentials
  
  Background:
	Given user is on the login page

  Scenario: Successful login with valid credentials
    When user enters username "admin"
    And user enters password "admin123"
    And user clicks login button
    Then user should see the dashboard
