Feature: Login function


  Scenario: The user is on login page
    Given the user "<username>" is on login page
    When user login with credentials username "<username>" and password "<password>"
    Then dashboard of "<username>" is displayed

    Examples:
      | username | password   |  |
      | sai      | sai123     |  |
      | krishna  | krishna123 |  |