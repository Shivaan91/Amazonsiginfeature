Feature: Login into Amazon webpage

Scenario: Login into amazon website with valid credentials
  Given I open the Amazon webpage
  When I click on signin button on web page
  And I enter email into sigin field
  And I click on continue button
  And I enter password into sigin field
  Then I click on signin button