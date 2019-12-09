Feature: Facebook login

Scenario Outline: Login from landing page
Given User is on "https://www.facebook.com/"
When User login with <username> and <password>
Then Homepage is populated
And Friends are "displayed" or "Not displayed"

Examples:
|username	|password	|
|bhangu007@gmail.com	|secretoflife	|
|abc&yy					|12344			|