# PortfolioProject
This repository contains my portfolio project intended to demonstrate my technical skills and expertise in the web automation. 

The project is based on Java. The following frameworks and libraries are applied:
* Selenide 
* JUnit 5
* Allure 
* REST Assured
* JavaFaker 
* SLF4J

Automated site: https://wolt.com. 
It is a well-known international delivery service 'Wolt', which operates in a number of countries. 'Cypress' country
used for most of the automated tests in this portfolio. 

In terms of the organizational structure, portfolio mostly divided into three parts: 'Tests' package, 
containing automated tests, 'TestsSupport' package, having all code used for running automated tests in the 'Tests'
directory and 'TestBase' package, containing preliminary code needed to launch automated tests. It allows to make code 
clean and easy to read.

'Tests' package contains the following tests:

* AuthorizationPopupCheck - a set of tests, verifying different ways of authorization of the site. **PLease note**: a 
complete test for authorization can't be completed, since there is no option for authorization via login and password.  
Therefore there is no test for completing order and processing payment


* MainPageCheck - a set of tests, checking all major elements of the Wolt Cypress homepage


* DeliveryAddressPageCheck - a set of tests, checking all major elements of the 'Discovery' section. This section 
displays all information based on the entered address ('28 October Avenue 353'). 'Restaurants' and 'Stores' sections are
not automated due to Equivalent Class Partitioning. **PLease note**: some tiles are dynamic/temporary and may be removed
after some period of time 


* RestaurantPageCheck - a set of tests, checking all major elements of the 'The Smuggers' restaurant 


* MakingOrder - containing one test, which simulates the order at the 'Smuggers' restaurant
