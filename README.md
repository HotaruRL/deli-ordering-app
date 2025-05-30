
<img alt="Project banner" src="https://github.com/HotaruRL/workshop-4-carDealership/blob/master/Workshop%204%20-%20Car%20Dealership.jpg"></img>

### NioBites: A Java CLI application for ordering customizable deli sandwiches and sides.

<a target="_blank" href="https://github.com/HotaruRL/deli-ordering-app/commits/master/" style="display: inline-block;"><img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/HotaruRL/deli-ordering-app"></a>
<a target="_blank" href="https://github.com/HotaruRL/deli-ordering-app/issues" style="display: inline-block;"><img alt="GitHub Open Issues" src="https://img.shields.io/github/issues/HotaruRL/deli-ordering-app"></a>
<a target="_blank" href="https://github.com/HotaruRL/deli-ordering-app/pulls" style="display: inline-block;"><img alt="GitHub Pull Requests" src="https://img.shields.io/github/issues-pr/HotaruRL/deli-ordering-app"></a>


NioBites - command-line interface (CLI) application for a custom sandwich shop! This project simulates a point-of-sale system where users can build custom sandwiches, add drinks, and chips to their order, and generate a receipt. It's built entirely in Java and showcases various Object-Oriented Programming (OOP) principles.

# 🌟 Table of Contents
*   [🚀 Core Features](#-core-features)
*   [✨ User-Friendly Features](#-user-friendly-features)
*   [🛣️ Future Enhancements](#%EF%B8%8F-future-enhancements)
*   [📸 Screenshots](#-screenshots)
*   [💡 Interesting Code Snippets](#-interesting-code)

# 🚀 Core Features
- [x] 📒 **Order Management**
  - Create new orders
  - Add multiple items (sandwiches, drinks, chips) to an order
  - Cancel an in-progress order
- [x] 🥪 **Sandwich Customization**
  - Select sandwich size (4", 8", 12")
  - Choose bread type (White, Wheat, Rye, Wrap)
  - Add a wide variety of toppings, categorized into:
        *   Meats
        *   Cheeses
        *   Other Toppings (veggies, etc.)
        *   Sauces
  - Option to add extra portions of toppings (with associated costs for premium toppings)
  - Option to have the sandwich toasted
- [x] 🥙 **Signature Sandwiches**
  - Select from pre-defined signature sandwiches (e.g., Philly Cheesesteak, BLT)
  - Option to take a signature sandwich as a base and further customize it
- [x] 🧋 **Drinks & Chips**
  - Add various drinks with size options
  - Add different types of chips
- [x] 💵 **Pricing Engine**
  - Dynamic price calculation based on sandwich size, bread, and premium/extra toppings
  - Prices for drinks and chips loaded from external files
- [x] 🧾 **Receipt Generation**
  - Detailed, formatted text receipts generated upon checkout
  - Receipts saved to a `receipts` directory with a timestamped filename (e.g., `yyyyMMdd-HHmmss.txt`)
- [x] 🗃️ **Data Persistence**
  - Sandwich, topping, drink, and chip prices are loaded from `.csv` or `.txt` files (e.g., `sandwichPrice.csv`)
  - Signature sandwich definitions loaded from a file

# ✨ User-Friendly Features
*   **Clear, Interactive Prompts:** Each step of the order process presents clear questions and numbered options.
*   **Color-Coded Output:** Key information, errors, and confirmations are highlighted using ANSI escape codes for better readability in compatible terminals.
    *   Example: Success messages in GREEN, errors in RED, options in BLUE/YELLOW.
*   **"Go Back" Options:** Most menus include an option to go back to the previous step, allowing for corrections.
*   **Input Validation:** Basic checks for user input to guide them towards valid selections.
*   **Confirmation Messages:** Users receive feedback after adding items or making key selections.
*   **Detailed Order Summary:** Before final checkout, a comprehensive summary of the order with all details and total price is displayed.
*   **Descriptive Topping Selection:** The topping selection process is broken down by category (Meats, Cheese, etc.) to avoid overwhelming the user.
*   **Handling "Extra" Toppings:** Clear prompts when a topping is already selected, asking if the user wants to make it "extra" instead of just adding it again.

# 🛣️ Future Enhancements
- [ ] 💵 **Payment System**
  - Processing payments
- [ ] ⌚ **Store Hours & Future Orders**
  - Checking if the store is currently open based on pre-defined hours
  - Allowing users to schedule an order for a future date/time if the store is closed
- [ ] 🖱️ **GUI Implementation**
  - Porting the application to a graphical user interface (e.g., using JavaFX)
- [ ] 🗄️ **More Robust Data Storage**
  - Using databases or more structured file formats for prices and orders
- [ ] 🗃️ **Order History**
  - Allowing users to view past orders
- [ ] 🙋‍♀️ **User Accounts**
  - Basic user authentication
- [ ] 🧑‍💻 **Admin Panel**
  - For managing menu items, prices, and store hours
- [ ] ✅ **Unit Testing**
  - Implementing JUnit tests for better code reliability

# 📸 Screenshots

<html>
<h3>Home Screen</h3>
<details>
<summary>Images</summary>
<p><img alt="01.homeScreen" src="https://github.com/HotaruRL/capstone-1-accounting-ledger/blob/master/img/01.%20main%20menu.png"></p>
</details>

<h3>Order Screen</h3>
<details>
<summary>Images</summary>
<p><img alt="02.orderScreen" src="https://github.com/HotaruRL/capstone-1-accounting-ledger/blob/master/img/01.%20main%20menu.png"></p>
</details>

<h3>Sandwich Screen</h3>
<details>
<summary>Images</summary>
<p><img alt="03.sandwichScreen" src="https://github.com/HotaruRL/capstone-1-accounting-ledger/blob/master/img/01.%20main%20menu.png"></p>
</details>

<h3>Custom Sandwich Screen - Choose Bread Type</h3>
<details>
<summary>Images</summary>
<p><img alt="04.customSandwichScreen-breadType" src="https://github.com/HotaruRL/capstone-1-accounting-ledger/blob/master/img/01.%20main%20menu.png"></p>
</details>

<h3>Custom Sandwich Screen - Choose Bread Size</h3>
<details>
<summary>Images</summary>
<p><img alt="05.customSandwichScreen-breadSize" src="https://github.com/HotaruRL/capstone-1-accounting-ledger/blob/master/img/01.%20main%20menu.png"></p>
</details>

<h3>Custom Sandwich Screen - Choose Toppings - Meat</h3>
<details>
<summary>Images</summary>
<p><img alt="06.customSandwichScreen-toppings-meat" src="https://github.com/HotaruRL/capstone-1-accounting-ledger/blob/master/img/01.%20main%20menu.png"></p>
</details>

<h3>Custom Sandwich Screen - Choose Toppings - Add Extra</h3>
<details>
<summary>Images</summary>
<p><img alt="07.customSandwichScreen-toppings-addExtra" src="https://github.com/HotaruRL/capstone-1-accounting-ledger/blob/master/img/01.%20main%20menu.png"></p>
</details>

<h3>Custom Sandwich Screen - Choose Toppings - Done</h3>
<details>
<summary>Images</summary>
<p><img alt="08.customSandwichScreen-done" src="https://github.com/HotaruRL/capstone-1-accounting-ledger/blob/master/img/01.%20main%20menu.png"></p>
</details>

<h3>Custom Checkout Screen - Receipt Review</h3>
<details>
<summary>Images</summary>
<p><img alt="09.checkoutScreen-receiptReview" src="https://github.com/HotaruRL/capstone-1-accounting-ledger/blob/master/img/01.%20main%20menu.png"></p>
</details>
</html>

# 💡 Interesting Code
1.  **Dynamic Enum Display Names with ANSI Colors:**
2.  **Flexible String to Boolean Conversion for User Input:**
3.  **Reverse Lookup for Topping Type:**


