@tag
Feature: Grocery Crud - Desafio 01
  Add Customer

  @desafio01
  Scenario: Add Customer and validate the success message
    Given I want to access the grocery crud website
    And change the theme to Boostrap V4 Theme
    When I click on Add Customer
    And fill the fields with data
      | Name          | Last Name | Contact First Name   | Phone        |  | Adress Line1          | Adress Line2 | City         | State | PostalCode | Country |  | from Employeer |  | CreditLimit |
      | Teste Sicredi | Teste     | Guilherme Leindecker | 51 9999-9999 |  | Av Assis Brasil, 3970 | Torre D      | Porto Alegre | RS    | 91000-000  | Brasil  |  | Fixter         |  |         200 |
    And click on save button
    And I validate the message "Your data has been successfully stored into the database."
    Then close the web browser

  @desafio02
  Scenario: Add Customer and go back to the list and delete that user created
    Given I want to access the grocery crud website
    And change the theme to Boostrap V4 Theme
    When I click on Add Customer
    And fill the fields with data
      | Name          | Last Name | Contact First Name   | Phone        |  | Adress Line1          | Adress Line2 | City         | State | PostalCode | Country |  | from Employeer |  | CreditLimit |
      | Teste Sicredi | Teste     | Guilherme Leindecker | 51 9999-9999 |  | Av Assis Brasil, 3970 | Torre D      | Porto Alegre | RS    | 91000-000  | Brasil  |  | Fixter         |  |         200 |
    And click on Save and go back list button
    And I validate "Your data has been successfully stored into the database." message on Home Page
    And I search for the name of the customer created
    And I Click on the checkbox below Actions
    And I Click on the delete buton
    And I validate "Are you sure that you want to delete those 2 items?" message
    And I click on the delete button to confirm
    And I validate the message "Your data has been successfully deleted from the database." when the customer has been delete
    Then close the web browser
