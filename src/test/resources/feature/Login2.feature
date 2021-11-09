@Sanity
@Login
@TestDropdown_Login2
Feature: Test Login2
  Feature To Test Login
  
  Background:
  Given Launch Application
  
  @TestDropdown_VerifyAllText_Pass
  Scenario: Verify Login2
    Then Verify All Text in Skills dropdown field

  @TestDropdown_VerifyAllText_Fail
  Scenario: Verify Login2
    Then Verify Text in Skills dropdown field
