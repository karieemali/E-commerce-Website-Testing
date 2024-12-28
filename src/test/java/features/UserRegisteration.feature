Feature: User Registration
  I want to check that the user can register in our e-commerce website

  Scenario Outline: User Registration
    Given The user in the home page
    When I click on register link
    And I entered "<firstname>" , "<lastname>" , "<email>" , "<password>"
    Then The registration page displayed successfully

    Examples:
      | firstname | lastname | email            | password |
      | ahmed     | mohamed  | ahmed@test.com   | 12345678 |
      | karim     | ali      | kareem@gmail.com | 123456   |




