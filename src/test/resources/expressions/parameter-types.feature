Feature: Check that primitives work in cucumber expressions

  Scenario: Using numbers int, double, float
    Given I have 42 cucumbers in my belly
    And I have 1 cucumber in my stomach
    And I have 42.5 cucumbers in my belly
    When I test expressions
    And I test cucumbers
    Then my test should "very surely pass"

  Scenario: Using bigint, bigdec

  Scenario: Using byte value of -128 and a maximum value of 127 (inclusive)
    Given I have 127 cucumbers in my belly
    And I have -128 cucumbers in my stomach
    When I test expressions
    And I test cucumbers
    Then my test should "very surely pass"

  Scenario: Using short value of -32,768 and a maximum value of 32,767 (inclusive)

  Scenario: Using long

  Scenario: Using double