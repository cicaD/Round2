#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
@tag
Feature: Search product on Amazon Web site

# parametrised with table

@tag2
Scenario Outline: Search product on E-store (ex. Amazon) web site with parameters
Given User is on E-store "<homePage>"
When User enters "<searchText>"
And User choose item "<itemListNr>" from list of displayed items
Then item with "<itemName>" is dispalyed on web page

Examples:
| homePage   | searchText | itemListNr | itemName|
| http://www.amazon.com | Nikon | 2 | Nikon |
 
 