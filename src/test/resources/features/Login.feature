@SentMail
Feature: Sent Mail
  As an user of mail service
  I want to sent my mail

  Background:
    Given Scenario is started

  Scenario: User navigates to mail service home page
    Given I am on the "https://mail.ru/"
    Then I should see login form

  Scenario Outline: Successful login
    When I login with "<login>" and "<password>"
    Then I am on the Service page

  Examples:
  | login          | password     |
  | cdptraining    | 1practice1   |

  Scenario: Mail creation
    When I create mail with "fennya@gmail.com" and "cdp practice" and "text for chapter 4"
    And Open drafts tab
    Then Content should be "text for chapter 4" and addressee should be "<Не указано>"

  Scenario: Sent mail
    When I open mail from draft page
    And Push sent mail button
    Then Mail should be absent in draft container

  Scenario: Successful logout
    When I push logout button
    Then I should be logged off
