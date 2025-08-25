@regression
Feature: User should be able to register on the website

  Background: user directed to signup page and fill data
    Given User is at the signup page
    And User handle the cookies banner
    When User fill the first name "Automation"
    And User fill the last name "Testing"
    And User select the country "eg"
    And User fill the phone field "01222252988"


  Scenario: User should be able to signup with valid data

    And User add an email address "test110@gmail.com"
    And User add a password "123456"
    And User solve the captcha
    Then User click on the signup button
    And User is logged in



  Scenario: User shouldn't be able to signup with invalid email
    And User add an email address "test15.com"
    And User add a password "123456"
    And User solve the captcha
    Then User can't click on the signup button
    And User still in home page

  Scenario: User shouldn't be able to signup if the email is registered before
    And User add an email address "test110@gmail.com"
    And User add a password "123456"
    And User solve the captcha
    Then User click on the signup button
    And User still in home page
