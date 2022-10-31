@firstdemo
Feature: Get user

Scenario: Get all users
Given I get all user with "/api"
Then execute API call - "AWS"
And status call is 200 - "AWS"
#Then I should recieve a list of users