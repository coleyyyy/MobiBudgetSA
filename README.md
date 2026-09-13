# MobiBudget SA

## 1. Project Overview

MobiBudget SA is an Android personal budgeting application developed using Kotlin and Android Studio.

The purpose of the application is to help users manage their personal finances by recording income and expenses, viewing transactions, managing budgets and viewing financial reports.

The application was developed as a prototype for the OPSC6312 Open Source Coding module.

---

## 2. Main Features

The MobiBudget SA prototype includes:

- User registration
- Email and password login
- Firebase Authentication
- Dashboard
- Add income and expense transactions
- View transactions
- Edit and delete transaction options
- Budget management interface
- Financial reports
- Settings
- Language selection
- Currency selection
- Notification preference
- Logout
- Local data storage using Room
- Automated testing
- GitHub version control
- GitHub Actions automated build and testing

---

## 3. Technologies Used

### Android

- Android Studio
- Kotlin
- XML layouts
- Android SDK

### Authentication

- Firebase Authentication
- Email and password authentication

### Local Database

- Android Room
- SQLite-based local storage

### Networking

- Retrofit
- Gson converter

### Architecture and Supporting Libraries

- AndroidX
- Lifecycle ViewModel
- Kotlin Coroutines
- KSP

### Version Control and Automation

- Git
- GitHub
- GitHub Actions

---

## 4. Application Structure

The application follows a layered approach.

### Presentation Layer

This layer contains the Android activities and XML layouts used to display the user interface.

Examples include:

- LoginActivity
- RegisterActivity
- DashboardActivity
- AddTransactionActivity
- TransactionsActivity
- BudgetActivity
- ReportsActivity
- SettingsActivity

### Data Layer

The data layer uses Room for local storage.

The main entities include:

- User
- Transaction
- Category
- Budget
- Notification

### Repository Layer

Repositories provide a layer between the user interface/ViewModel and the Room database.

### ViewModel Layer

ViewModels are used to manage application data and perform database operations using Kotlin coroutines.

---

## 5. Authentication

Firebase Authentication is used to manage user accounts.

Users can:

1. Create an account using an email address and password.
2. Log in using their registered email and password.
3. Log out from the application.

Passwords are handled by Firebase Authentication rather than being stored directly inside the application's local database.

---

## 6. Transactions

Users can record financial transactions.

A transaction contains information such as:

- Transaction type
- Amount
- Category
- Date
- Description

The transaction data is stored locally using Room.

Users can view their recorded transactions and access edit and delete options.

---

## 7. Budgets

The application includes a budget management screen where users can enter:

- Budget category
- Budget amount

The interface provides feedback when invalid information is entered.

---

## 8. Reports

The Reports screen calculates financial information from stored transactions.

It displays:

- Total income
- Total expenses
- Current balance
- Number of recorded transactions

The balance is calculated using income minus expenses.

---

## 9. Settings

The Settings screen allows users to select:

- Language
- Currency
- Budget notification preference

Settings are stored using Android SharedPreferences.

The available language options are:

- English
- isiXhosa
- isiZulu

The available currencies include:

- ZAR - South African Rand
- USD - US Dollar
- EUR - Euro

Users can also log out from the Settings screen.

---

## 10. Local Database

Room is used to provide local data persistence.

The database contains entities for:

- Users
- Transactions
- Categories
- Budgets
- Notifications

DAO classes are used to perform database operations such as inserting, updating, deleting and retrieving data.

---

## 11. Input Validation

The application performs validation on user input.

Examples include:

- Empty email fields
- Empty passwords
- Invalid email addresses
- Invalid transaction amounts
- Empty transaction fields
- Invalid budget amounts

The application displays error messages using Toast messages instead of allowing invalid input to cause the application to crash.

---

## 12. Testing

The project includes Android unit testing dependencies.

Tests are executed using Gradle.

The GitHub Actions workflow automatically runs:

```text
./gradlew testDebugUnitTest