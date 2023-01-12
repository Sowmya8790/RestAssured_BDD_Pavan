Feature: To perform the CRUD Operations

  Scenario: To Perform the GET Operation on Employe DB
    Given The base URI is "http://localhost:3000/employees"
    When I perform the Get Operation
    Then Response code should be 200

  Scenario Outline: To perform POST operation on Employee DB
    Given The base URI is for post  "http://localhost:3000/employees"
    When The username "<name>" , salary of employee "<salary>"
    And I perform the Post Operation
    Then Response code is 201

    Examples: 
      | name    | salary | 
      | Sowmya  |  20000 | 
      | Lavanya |  30000 | 
      | kavi    |  40000 |  
      
      
  Scenario: To perform Delete operation on Employee DB
  Given The base URI is for Delete "http://localhost:3000/employees/{{Emp_demo}}"
  When The empid 22 should be delete using delete operation
  Then Response code should be 201.
