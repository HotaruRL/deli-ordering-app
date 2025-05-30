
<img alt="Project banner" src="https://github.com/HotaruRL/workshop-4-carDealership/blob/master/Workshop%204%20-%20Car%20Dealership.jpg">
### NioBites: A Java CLI application for ordering customizable deli sandwiches and sides.

<a target="_blank" href="https://github.com/HotaruRL/deli-ordering-app/commits/master/" style="display: inline-block;"><img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/HotaruRL/deli-ordering-app"></a>
<a target="_blank" href="https://github.com/HotaruRL/deli-ordering-app/issues" style="display: inline-block;"><img alt="GitHub Open Issues" src="https://img.shields.io/github/issues/HotaruRL/deli-ordering-app"></a>
<a target="_blank" href="https://github.com/HotaruRL/deli-ordering-app/pulls" style="display: inline-block;"><img alt="GitHub Pull Requests" src="https://img.shields.io/github/issues-pr/HotaruRL/deli-ordering-app"></a>


Welcome to NioBites, our command-line interface (CLI) application for a custom sandwich shop! This project simulates a point-of-sale system where users can build custom sandwiches, add drinks and chips to their order, and generate a receipt. It's built entirely in Java and showcases various Object-Oriented Programming (OOP) principles.

## 🌟 Table of Contents

*   [Short Description](#short-description)
*   [🚀 Core Features](#core-features)
*   [✨ User-Friendly Features](#user-friendly-features)
*   [📸 Screenshots](#screenshots)
*   [💡 Interesting Code Snippets](#interesting-code-snippets)
*   [🛣️ Future Enhancements](#future-enhancements)


## Short Description
NioBites is a Java-based CLI application designed to manage orders for a sandwich shop. It allows users to fully customize sandwiches, select from pre-defined signature sandwiches, add side items, and complete their order by generating a text-based receipt. The application emphasizes OOP design, file I/O for data persistence (prices, receipts), and a structured, interactive user experience within the console.

## 🚀 Core Features
Our NioBites application incorporates the following core functionalities:

*   **Order Management:**
    *   Create new orders.
    *   Add multiple items (sandwiches, drinks, chips) to an order.
    *   Cancel an in-progress order.
*   **Sandwich Customization:**
    *   Select sandwich size (4", 8", 12").
    *   Choose bread type (White, Wheat, Rye, Wrap).
    *   Add a wide variety of toppings, categorized into:
        *   Meats
        *   Cheeses
        *   Other Toppings (veggies, etc.)
        *   Sauces
    *   Option to add extra portions of toppings (with associated costs for premium toppings).
    *   Option to have the sandwich toasted.
*   **Signature Sandwiches:**
    *   Select from pre-defined signature sandwiches (e.g., Philly Cheesesteak, BLT).
    *   Option to take a signature sandwich as a base and further customize it.
*   **Drinks & Chips:**
    *   Add various drinks with size options.
    *   Add different types of chips.
*   **Pricing Engine:**
    *   Dynamic price calculation based on sandwich size, bread, and premium/extra toppings.
    *   Prices for drinks and chips loaded from external configuration files.
*   **Receipt Generation:**
    *   Detailed, formatted text receipts generated upon checkout.
    *   Receipts saved to a `receipts/` directory with a timestamped filename (e.g., `yyyyMMdd-HHmmss.txt`).
*   **Data Persistence:**
    *   Sandwich, topping, drink, and chip prices are loaded from `.csv` or `.txt` files (e.g., `prices/sandwich_prices.csv`).
    *   Signature sandwich definitions loaded from a file.
*   **Store Hours & Future Orders:**
    *   Checks if the store is currently open based on pre-defined hours.
    *   Allows users to schedule an order for a future date/time if the store is closed.

## ✨ User-Friendly Features
We've focused on making the CLI experience as intuitive as possible:

*   **Clear, Interactive Prompts:** Each step of the order process presents clear questions and numbered options.
*   **Color-Coded Output:** Key information, errors, and confirmations are highlighted using ANSI escape codes for better readability in compatible terminals.
    *   Example: Success messages in GREEN, errors in RED, options in BLUE/YELLOW.
*   **"Go Back" Options:** Most menus include an option to go back to the previous step, allowing for corrections.
*   **Input Validation:** Basic checks for user input to guide them towards valid selections.
*   **Confirmation Messages:** Users receive feedback after adding items or making key selections.
*   **Detailed Order Summary:** Before final checkout, a comprehensive summary of the order with all details and total price is displayed.
*   **Descriptive Topping Selection:** The topping selection process is broken down by category (Meats, Cheese, etc.) to avoid overwhelming the user.
*   **Handling "Extra" Toppings:** Clear prompts when a topping is already selected, asking if the user wants to make it "extra" instead of just adding it again.

## 📸 Screenshots

1.  **Home Screen:**
    `[Image: Home screen showing "New Order" and "Exit" options, perhaps with a NioBites welcome message.]`
    *Caption: The main entry point of our application.*

2.  **Sandwich Customization - Bread & Size Selection:**
    `[Image: CLI showing options for bread type, then sandwich size.]`
    *Caption: Users select bread and size for their custom sandwich.*

3.  **Topping Selection Process:**
    `[Image: CLI showing a topping category (e.g., "Meat Options") with available toppings and an option to mark as extra.]`
    *Caption: Intuitive topping selection with support for extra portions.*

4.  **Order Screen with Items:**
    `[Image: CLI displaying the current order with a few items listed, and options to add more or checkout.]`
    *Caption: Our order screen keeps track of all selected items.*

5.  **Checkout Summary:**
    `[Image: CLI showing the final order summary with itemized prices, subtotal, tax (if any), and total before confirmation.]`
    *Caption: A clear breakdown of the order before payment.*

6.  **Generated Receipt File (Example Content):**
    
    
## 💡 Interesting Code Snippets

Here are a few snippets that highlight some interesting aspects of our project:
1.  **Dynamic Enum Display Names with ANSI Colors:**
2.  **Flexible String to Boolean Conversion for User Input:**
3.  **Reverse Lookup for Topping Type:**

## 🛣️ Future Enhancements

While NioBites is functional, here are some ideas for future improvements:
*   **GUI Implementation:** Porting the application to a graphical user interface (e.g., using JavaFX or Swing).
*   **More Robust Data Storage:** Using databases (e.g., SQLite) or more structured file formats (JSON, XML) for prices and orders.
*   **Order History:** Allowing users to view past orders.
*   **User Accounts:** Basic user authentication.
*   **Admin Panel:** For managing menu items, prices, and store hours.
*   **Unit Testing:** Implementing JUnit tests for better code reliability.

