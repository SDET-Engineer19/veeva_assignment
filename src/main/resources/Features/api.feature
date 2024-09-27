Feature: Create New User

  Scenario Outline: Create New User And Validate the Status Code

    Given Create New User
    Then Validate <StatusCode> <Response Time> <Name> <Job>
    Examples:
      | StatusCode | Response Time | Name     | Job |
      | 201        | 1m            | Digvijay | SSE |