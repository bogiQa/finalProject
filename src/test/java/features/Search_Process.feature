Feature: Insert informations in search field
  As a user I should be able to insert informations about my trip

    Scenario: Making reservations for Kopaonik
      As a user I should be able to make reservation on Booking webcite

      Given I am on the homepage screen
      When I click on search field
      And  enter location "Kopaonik"
      And click on date field
      And select date for Kopaonik
      And click on person field
      And select number of persons to one person
      And click on search button
      Then I should see my search results

  Scenario: Making reservations for Mar del Plata
  As a user I should be able to make reservation on Booking webcite

    Given I am on the homepage screen
    When I click on search field
    And  enter location "Mar del Plata"
    And click on date field
    And select new date
    And click on person field
    And select number of persons to three persons
    And click on search button
    Then I should see my search results

  Scenario: Making reservations for Sidney
  As a user I should be able to make reservation on Booking webcite

    Given I am on the homepage screen
    When I click on search field
    And  enter location "Budapest"
    And click on date field
    And change date
    And click on person field
    And select number of persons to three persons
    And click on search button
    Then I should see my search results

  Scenario: Making reservations for Chicago
  As a user I should be able to make reservation on Booking webcite

    Given I am on the homepage screen
    When I click on search field
    And  enter location "Chicago"
    And click on date field
    And change date for Chicago
    And click on person field
    And select number of persons to three persons
    And click on search button
    Then I should see my search results

  Scenario: Making reservations for New York
  As a user I should be able to make reservation on Booking webcite

    Given I am on the homepage screen
    When I click on search field
    And  enter location "New York"
    And click on date field
    And change date for New York
    And click on person field
    And select number of persons to three persons
    And click on search button
    Then I should see my search results






