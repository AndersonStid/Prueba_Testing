Feature: Validate create alias

  Scenario: Validate employees
    When Load customer information
      | Authorization | limit | offset | model    | includeEmployees | sortField          | sortOrder |
      | Authorization | 4     | 0      | detailed | onlyCurrent      | employee.firstName | ASC       |
    When Load templates
    And Api response code 200
    Then Validate Json

  Scenario: Validate employee error without limit field
    When Load customer information
      | Authorization | limitd | offset | model    | includeEmployees | sortField          | sortOrder |
      | Authorization | 50     | 0      | detailed | onlyCurrent      | employee.firstName | ASC       |
    When Load templates
    And Api response code 422
    Then Validate Json error limit

  Scenario: Validate employee error without offset field
    When Load customer information
      | Authorization | limit | offsetd | model    | includeEmployees | sortField          | sortOrder |
      | Authorization | 50    | 0       | detailed | onlyCurrent      | employee.firstName | ASC       |
    When Load templates
    And Api response code 422
    Then Validate Json error offset

  Scenario: Validate employee error without model field
    When Load customer information
      | Authorization | limit | offset | models   | includeEmployees | sortField          | sortOrder |
      | Authorization | 50    | 0      | detailed | onlyCurrent      | employee.firstName | ASC       |
    When Load templates
    And Api response code 422
    Then Validate Json error model

  Scenario: Validate employee error without includeEmployees field
    When Load customer information
      | Authorization | limit | offset | model    | includeEmployeesg | sortField          | sortOrder |
      | Authorization | 50    | 0      | detailed | onlyCurrent       | employee.firstName | ASC       |
    When Load templates
    And Api response code 422
    Then Validate Json error includeEmployees

  Scenario: Validate employee error without sortField field
    When Load customer information
      | Authorization | limit | offset | model    | includeEmployees | sortFieldh         | sortOrder |
      | Authorization | 50    | 0      | detailed | onlyCurrent      | employee.firstName | ASC       |
    When Load templates
    And Api response code 422
    Then Validate Json error sortField

  Scenario: Validate employee error without sortOrder field
    When Load customer information
      | Authorization | limit | offset | model    | includeEmployees | sortField          | sortOrderj |
      | Authorization | 50    | 0      | detailed | onlyCurrent      | employee.firstName | ASC        |
    When Load templates
    And Api response code 422
    Then Validate Json error sortOrder


