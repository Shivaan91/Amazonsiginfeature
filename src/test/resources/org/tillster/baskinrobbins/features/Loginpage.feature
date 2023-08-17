@Amazon
Feature: Login into Amazon webpage

Scenario: Login into amazon website with valid credentials
  Given user navigates to the Amazon webpage
  When user click on signin button on the web page
  Then user navigates to sigin page
  When user enter valid email into email field
  And user click on continue button
  Then user should navigate to password field
  When user enter valid password into password field
  And user click on signin button
  Then user successfully login into amazon home page 