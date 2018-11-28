Feature: QA
  QA web tests for DBDS:
    - login is correct
    - session is maintained


  Scenario Outline: User can create session
    Given user named <name>
    When he creates session
    Then attribute page is loaded

  Examples:
    | name |
    | pavel |
    | jorege |
    | */*/sadasd/*a**/s*d/ad |
    | [0-9].*a+?mama         |
