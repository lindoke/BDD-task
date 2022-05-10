Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure site`s main functions work correctly

 Scenario Outline: Check site main functionality
    Given User opens '<homePage>'page
    And User checks title emptiness
   And User checks header visibility
   And User checks footer visibility
    And User checks notifications button visibility
   And User clicks shop by category button
   And User checks that number of categories equals to '<countOfCategories>'
    And User checks search button visibility
    And User checks search field visibility
    And User types '<text>' in search field
    When User clicks search button
    And User checks all results contains '<text>'

  Examples:
    | homePage             | text    | countOfCategories |
    | https://www.ebay.com | samsung | 9                 |

  Scenario Outline: Check sign in page functionality
    Given User opens '<homePage>'page
    When User clicks sign in link or check for captcha
    Then User checks email field is visible
    And User types wrong '<email>' in email field
    When User clicks continue button
    Then User checks password field is visible or check for captcha
    And User types '<password>' in password field
    When User clicks sign in button or check for the captcha
    Then User checks for error or check for the captcha

    Examples:
      | homePage             | email | password |
      | https://www.ebay.com | 123   | 456      |


  Scenario Outline: Check selling
      Given User opens '<homePage>'page
      And User clicks Sell button
      And User checks URL contains '<sell>'
      And User checks List an item button is visible
      And User clicks List an item button
      And User checks listing field is visible
      And User types '<category>' in listing field
      When User clicks search
      And User checks category popup contains '<category>'
      And User clicks searched category

      Examples:
        | homePage             | category | sell |
        | https://www.ebay.com | book   | sell   |


  Scenario Outline: Check advanced search
    Given User opens '<homePage>'page
    And User click AdvancedSearch button
    And User checks header visibility
    And User checks search field is visible
    And User checks dropdown field with keyoptions is visible
    And User checks excluded words field visibility
    And User types '<text>' in searchfield
    And User types '<excluded>' in excluded words field
    When User clicks dropdown field
    Then User selects Any words any order option
    When User clicks Search button
    Then User checks results does not contain '<excluded>' word

    Examples:
      | homePage | text | excluded |
      |https://www.ebay.com| iphone 13 12| 12 |

    Scenario Outline: Check eBay sites
      Given User opens '<homePage>'page
      And User checks selected country is United States
      And User clicks dropdown with list of countries
      And User clicks country button
      And User checks header visibility
      And User checks URL contains '<countryAbbreviation>' in it
      Examples:
        | homePage | countryAbbreviation |
        | https://www.ebay.com | au |


      Scenario Outline: Check Daily Deals Page
        Given User opens '<homePage>'page
        And User clicks Daily Deals button
        And User checks header visibility
        And User checks URL contains deals
        And User checks search stories field visibility
        Examples:
          | homePage |
         | https://www.ebay.com |

      Scenario Outline: Check search results filter
        Given User opens '<homePage>'page
        And User makes search by '<keyword>'
        And User clicks search button
        And User clicks condition button
        And User selects Used option
        And User checks there is Used filter
        Examples:
          | homePage | keyword |
          | https://www.ebay.com | iphone 13 128gb |

    Scenario Outline: Check popular brand
      Given User opens '<homePage>'page
      And User clicks '<brand>' in popular brands list
      And User checks URL contains brand '<brand>'
      And User checks header contains '<brand>'
      Examples:
        | homePage | brand |
        | https://www.ebay.com |Sony|

      Scenario Outline: Check customer service help
        Given User opens '<homePage>'page
        And User clicks Help button
        And User checks header visibility
        And User search eBay help field visibility
        And User types '<wrongInput>'
        And User checks error message
        Examples:
          | homePage | wrongInput |
          | https://www.ebay.com |  @sbg   |

        Scenario Outline: Check stores
          Given User opens '<homePage>'page
          And User clicks Stores button
          And User clicks Find a store button
          And User checks store search field visibility
          And User checks header is visible;
          Examples:
            | homePage |
            | https://www.ebay.com |














