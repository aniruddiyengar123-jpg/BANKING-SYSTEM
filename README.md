# Bank Account CI Project

A standard Java Maven Continuous Integration project demonstrating automated build, unit testing, and GitHub Actions CI pipelines.

## Project Structure

```text
bank-account-ci/
├── .github/
│   └── workflows/
│       └── ci.yml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── devops/
│   │               └── BankAccount.java
│   └── test/
│       └── java/
│           └── com/
│               └── devops/
│                   └── BankAccountTest.java
├── .gitignore
├── pom.xml
└── README.md
```

## Features

- **JDK 17 & JUnit Jupiter 5.10.0**: Built with modern Java compilation and test runners.
- **Domain Logic**:
  - `deposit(double amount)`: Validates positive amounts, increments balance, and returns the updated balance.
  - `withdraw(double amount)`: Validates positive amounts, verifies sufficient balance, debits the account, and returns `true` on success or `false` on insufficient funds.
  - `calculateInterest(double annualRatePercentage)`: Validates non-negative rate percentages and calculates annual interest based on current balance.
- **Unit Testing**:
  - `testDeposit()`: Validates deposit amount and balance updates using `assertEquals`.
  - `testWithdrawSuccess()`: Validates successful withdrawal using `assertTrue` and `assertEquals`.
  - `testWithdrawInsufficientFunds()`: Validates failed withdrawal due to insufficient funds using `assertFalse` and ensures balance remains intact.
  - `testCalculateInterest()`: Validates interest calculation using `assertEquals`.
  - Validation tests ensuring `IllegalArgumentException` is raised on illegal arguments.
- **CI Pipeline**:
  - Automates build and test execution via GitHub Actions on `push` and `pull_request` against `main` or `master`.

## Running Locally

To build and run tests locally with Maven:

```bash
mvn clean test
```

To package the JAR:

```bash
mvn clean package
```
