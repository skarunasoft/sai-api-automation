Feature: Employee-Creation and Validation Test

  Background: 
    Given the Application base API URL is "http://localhost:3000"

  @smoke @regression
  Scenario: Verify all the employees list
    When I send a GET request to "/employees"
    Then the response status code should be 201
    And the response should contain a list of employees
    And each employee should have the id, first_name and phone
    
    
  @smoke @regression @emp_create
  Scenario Outline: Verify all the employees list
    When I send a POST request to "/employees" with employee payload
    Then the response status code should be 201
    And the response should contain a list of employees
    And each employee should have the id, first_name and phone
  

