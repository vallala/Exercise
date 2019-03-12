@exercise @smoke
Feature: Exercise

	Background: 
		Given User opens Exercise home page

  @TC-100
  Scenario: Verify the right count of values
  	Then user should see Value 1 to Value 5
  	
  @TC-101
  Scenario: Verify the values on the screen are greater than 0
  	Then user should see all values on the screen are more than 0
  	
  @TC-102
  Scenario: Verify the values are formatted as currencies
  	Then user should see values in curreny format
  	
  @TC-103
  Scenario: Verify the total balance matches the sum of the values
  	Then user should see total balance equals to sum of values on the screen