# Retail Reward Offers Calculator
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
 
# Features
This application equipped to calculate the reward points and show the results in different combinations as below:
1.	Create a Transaction <b><i>(…/retail/transaction)</i></b>:<br>
It helps to create a transaction and store in the Database.
2.	Return total reward points of all the customers till date <b><i>(…/retail/reward-points)</i></b>:<br>
	It displays the reward points of all the customers since inception.
3.	Return total reward points of a specific user <b><i>(…/retail/reward-points/{phone-number})</i></b>:<br>
	It displays the total reward points of a specific user by inputting the phone number
4.	Return total reward points along with individual month reward points <b><i>(…/retail/reward-points/{phone-number}/{number-of-months})</i></b>:<br>
	It displays the total reward points of a customer along with the month-wise reward points for a given number of months.
5.	Return transactions associated with a customer <b><i>(…/retail/reward-points/transaction/{phone-number})</i></b>:<br>
	It gives a list of all the transactions a customer made

<b>Note:</b> The application enables a feature to add Client specific reward point program. <br>
<i>Example 1: The reward program starts with $50 and above as 1, $100 and above as 2 points and so on.<br>
Example 2: The reward program starts with $20 and above as 1, $50 and above as 2 points and so on.</i><br>
The reward points will be calculated by getting the information from reward_points table.

<b>Note:</b> Swagger is configured with the application (http://localhost:8080/swagger-ui/index.html#)

# Technologies used
•	Spring boot <br>
•	Java 11 <br>
•	H2 database<br>
•	Maven<br>
•	Swagger OpenAPI3<br>
•	SLF4J logging<br>

# Installation
1.	git clone https://github.com/sravanthi24/rewards.git
2.	mvn clean install
3.	mvn spring-boot:run

# Database Connectivity
1.  http://localhost:8080/h2-ui
2.  JDBC URL:jdbc:h2:mem:retailDB
3.  username : sa
4.  password :