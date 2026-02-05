Feature: vegitable buying end to end.

Scenario: To verify end toned to checkout journey.
Given user is on greenkart site.
When  user add items in basket.
And  user do checkout
Then checkout is done and successful message is dispalyed.


