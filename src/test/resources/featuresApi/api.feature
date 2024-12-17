Feature: Test Automation Rest API

  @api
  Scenario: Test get list data normal
    Given prepare url valid for "GET_LIST_USERS"
    And hit API get list data
    Then validation status code is equals 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: Test create new user normal
    Given prepare url valid for "CREATE_NEW_USERS"
    And hit API post create new user
    Then validation status code is equals 201
    Then validation response body post list users
    Then validation response json with JSONSchema "post_create_users_normal.json"
  
  @api
  Scenario: Test delete user normal
    Given prepare url valid for "CREATE_NEW_USERS"
    And hit API post create new user
    Then validation status code is equals 201
    Then validation response body post list users
    And hit API delete user
    Then validation status code is equals 204

  @api
  Scenario: Test update user normal
    Given prepare url valid for "CREATE_NEW_USERS"
    And hit API post create new user
    Then validation status code is equals 201
    Then validation response body post list users
    And hit API update user
    Then validation status code is equals 200
    Then validation response body update users