Feature: Check that primitives work in cucumber expressions

  Scenario: Using numbers
    Given I have 42 cucumbers in my belly
    And I have 42.5 cucumbers in my belly
    When I test expressions
    And I test cucumbers
    Then my test should very surely pass