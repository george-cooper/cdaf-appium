Feature:
  @appium-test
  Scenario Outline: transition status
    Given a user is logged into the ServCo application as user '<username>' on a mobile device or tablet
    And the project '<project>' is selected
    And the ticket '<ticket>' is selected
    When the user transitions its status to '<status>'
    Then the issue with id '<ticket>' has a status of '<status>' when checked through the API
    Examples:
      | username                  | project        | ticket        | status |
      | george.cooper@acutest.com | CDAF Sandbox C | CDAFSBXC-1333 | In Progress   |