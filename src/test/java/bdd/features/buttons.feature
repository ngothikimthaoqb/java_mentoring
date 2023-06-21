Feature: Buttons

  Background:
    Given Open Website https://formy-project.herokuapp.com/

  @SmokeTest
  Scenario: Verify all buttons display
    When User click on button tab in navigation bar
    Then Danger button is displayed
    And Primary button is displayed
    And Success button is displayed
    But Dark button is not displayed