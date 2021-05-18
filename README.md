User Stories

US 1:
In order to save money
As a bank client
I want to make a deposit in my account



US 2:
In order to retrieve some or all of my savings
As a bank client
I want to make a withdrawal from my account


US 3:
In order to check my operations
As a bank client
I want to see the history (operation, date, amount, balance) of my operations

Example: `http://localhost:8080/account/history/john`
```json
[ {
"id" : "john",
"date" : "18 mai 2021 à 18:35:53",
"balance" : 150.0,
"amount" : 150.0
}, {
"id" : "john",
"date" : "18 mai 2021 à 18:36:12",
"balance" : 300.0,
"amount" : 150.0
}, {
"id" : "john",
"date" : "18 mai 2021 à 18:37:00",
"balance" : 200.0,
"amount" : 100.0
} ]
```