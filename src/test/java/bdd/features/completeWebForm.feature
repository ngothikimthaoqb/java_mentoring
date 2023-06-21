Feature: Complete Web Form

  Background:
    Given Open Website https://formy-project.herokuapp.com/

  @RegressionTest
  Scenario Outline: Verify complete web form
    When I click Complete Web Form link
    And I input firstname as <firstname>, lastname as <lastname> and job title as <jobTitle>
    Then Verify all fields firstname as <firstname>, lastname as <lastname> and job title as <jobTitle> are filled

    Examples:
      | firstname | lastname | jobTitle  |
      | Thao      | Ngo      | QA        |
      | Nhi       | Nguyen   | Developer |

  @SmokeTest
  Scenario: Verify complete web form
    When I click Complete Web Form link
    And I input firstname as Thao, lastname as Ngo and job title as QA
    Then Verify all fields firstname as Thao, lastname as Ngo and job title as QA are filled

