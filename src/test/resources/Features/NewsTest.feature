Feature: To Test PCMag portal

  Scenario: Verify user is able to access PCMag Home Page
    Given I have launched browser
    Given I am on PCMag page
    Then I should be able to see PCMag home page

  Scenario: Verify user is able to navigate to a subpage
    When I select "Software & Services" from "Best Products " section
    And I select "Best Antivirus Apps" option
    Then I should be navigated to the "Best Antivirus App"
    Then user closes the browser
