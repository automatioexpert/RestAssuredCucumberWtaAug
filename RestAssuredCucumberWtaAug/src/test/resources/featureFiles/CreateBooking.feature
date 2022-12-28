Feature: Create a booking

Scenario: Create a booking with valid data
Given user sets the base URL
And user sets base path as "auth"
When user provides below data for creating booking
|username|password|
|admin|password123|
And user hits create auth API
Then user verifies status code as 200