Feature: Login tests

  Background:
    Given Select URL

  Scenario Outline: validate Text
    When Select add two Courses <User> and <Password>
    Then Validate text <Text>
    Examples:
      | User  | Password | Text    |
      | Admin | admin123 | Time at Work |

  Scenario Outline: Create employees
    When Create employees
    And Se selecciona archivo seleccionarArchivo <seleccionarArchivo>
    And llenar formulario <firstName> y <middleName> y <lastName> y <EmployeeId>
    Then Validate Employeed <Employeed>
    Examples:
      | seleccionarArchivo | firstName | middleName | lastName | EmployeeId | Employeed     |
      | dino.jpg           | Anderson  | tester     | Narajos  | 02020      | Anderson Narajos|
