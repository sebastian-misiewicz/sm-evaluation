Feature: Testdata

Scenario: Items
	Given Item 'Apple' with price 1.23
	Given Item 'Lemon' with price 5

Scenario: Customers
	Given Customer with the name 'Jan Nowak', e-mail 'test@test.com'
	
Scenario: Shoppint Cart '098f6'
	Given Customer with the email 'test@test.com' opens a shopping cart '098f6'
 	  And Put 'Apple' into the cart '098f6' in quantity 5
 	  And Put 'Lemon' into the cart '098f6' in quantity 11
 	  And Checkout the shopping cart '098f6' with the date '2017-08-27 18:17:00'
 	  
Scenario: Shoppint Cart '4e832'
	Given Customer with the email 'test@test.com' opens a shopping cart '4e832'
 	  And Put 'Apple' into the cart '4e832' in quantity 500
