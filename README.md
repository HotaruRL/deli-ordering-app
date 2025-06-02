
<img alt="Project banner" src="https://github.com/HotaruRL/deli-ordering-app/blob/master/img/Capstone%202%20-%20NioBites%20Deli%20Ordering%20App.png"></img>

### NioBites: A Java CLI application for ordering customizable deli sandwiches and sides.

<a target="_blank" href="https://github.com/HotaruRL/deli-ordering-app/commits/master/" style="display: inline-block;"><img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/HotaruRL/deli-ordering-app"></a>
<a target="_blank" href="https://github.com/HotaruRL/deli-ordering-app/issues" style="display: inline-block;"><img alt="GitHub Open Issues" src="https://img.shields.io/github/issues/HotaruRL/deli-ordering-app"></a>
<a target="_blank" href="https://github.com/HotaruRL/deli-ordering-app/pulls" style="display: inline-block;"><img alt="GitHub Pull Requests" src="https://img.shields.io/github/issues-pr/HotaruRL/deli-ordering-app"></a>


NioBites - command-line interface (CLI) application for a custom sandwich shop! This project simulates a point-of-sale system where users can build custom sandwiches, add drinks, and chips to their order, and generate a receipt. It's built entirely in Java and showcases various Object-Oriented Programming (OOP) principles.

# 🌟 Table of Contents
*   [🚀 Core Features](#-core-features)
*   [✨ User-Friendly Features](#-user-friendly-features)
*   [🛣️ Future Enhancements](#%EF%B8%8F-future-enhancements)
*   [🗺️ Diagrams](#%EF%B8%8F-diagrams)
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
- [x] ⌚ **Store Hours & Future Orders**
  - Checking if the store is currently open based on pre-defined hours
  - Allowing users to schedule an order for a future date/time if the store is closed

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

# 🗺️ Diagrams

<html>
<h3>Classes Diagram</h3>
<details>
<summary>Images</summary>
<p><img alt="deliOrderingAppClasses-version0.4" src="https://github.com/HotaruRL/deli-ordering-app/blob/master/img/deliOrderingAppClasses-version0.4.png"></p>
</details>

<h3>Flow Diagram</h3>
<details>
<summary>Images</summary>
<p><img alt="deliOrderingAppFlow-version0.2" src="https://github.com/HotaruRL/deli-ordering-app/blob/master/img/deliOrderingAppFlow-version0.2.png"></p>
</details>
</html>

# 📸 Screenshots

<html>
<h3>Home Screen</h3>
<details>
<summary>Images</summary>
<p><img alt="01.homeScreen" src="https://github.com/HotaruRL/deli-ordering-app/blob/20-clean-up-code/img/01.homeScreen.png"></p>
</details>

<h3>Order Screen</h3>
<details>
<summary>Images</summary>
<p><img alt="02.orderScreen" src="https://github.com/HotaruRL/deli-ordering-app/blob/20-clean-up-code/img/02.orderScreen.png"></p>
</details>

<h3>Sandwich Screen</h3>
<details>
<summary>Images</summary>
<p><img alt="03.sandwichScreen" src="https://github.com/HotaruRL/deli-ordering-app/blob/20-clean-up-code/img/03.sandwichScreen.png"></p>
</details>

<h3>Custom Sandwich Screen - Choose Bread Type</h3>
<details>
<summary>Images</summary>
<p><img alt="04.customSandwichScreen-breadType" src="https://github.com/HotaruRL/deli-ordering-app/blob/20-clean-up-code/img/04.customSandwichScreen-breadType.png"></p>
</details>

<h3>Custom Sandwich Screen - Choose Bread Size</h3>
<details>
<summary>Images</summary>
<p><img alt="05.customSandwichScreen-breadSize" src="https://github.com/HotaruRL/deli-ordering-app/blob/20-clean-up-code/img/05.customSandwichScreen-breadSize.png"></p>
</details>

<h3>Custom Sandwich Screen - Choose Toppings - Meat</h3>
<details>
<summary>Images</summary>
<p><img alt="06.customSandwichScreen-toppings-meat" src="https://github.com/HotaruRL/deli-ordering-app/blob/20-clean-up-code/img/06.customSandwichScreen-toppings-meat.png"></p>
</details>

<h3>Custom Sandwich Screen - Choose Toppings - Add Extra</h3>
<details>
<summary>Images</summary>
<p><img alt="07.customSandwichScreen-toppings-addExtra" src="https://github.com/HotaruRL/deli-ordering-app/blob/20-clean-up-code/img/07.customSandwichScreen-toppings-addExtra.png"></p>
</details>

<h3>Custom Sandwich Screen - Choose Toppings - Done</h3>
<details>
<summary>Images</summary>
<p><img alt="08.customSandwichScreen-done" src="https://github.com/HotaruRL/deli-ordering-app/blob/20-clean-up-code/img/08.customSandwichScreen-done.png"></p>
</details>

<h3>Custom Checkout Screen - Receipt Review</h3>
<details>
<summary>Images</summary>
<p><img alt="09.checkoutScreen-receiptReview" src="https://github.com/HotaruRL/deli-ordering-app/blob/20-clean-up-code/img/09.checkoutScreen-receiptReview.png"></p>
</details>
</html>

# 💡 Interesting Code
### 1.  **Create a dynamic menu from an ArrayList**
<html>
<details>
<summary>Code</summary>

```java
// create a menu with options autopopulated and numbered from an ArrayList (the last item is numbered with [0])
    public void setMenu(String menuName, ArrayList<String> options, String bordersChars, String paddingChars, int paddingLength) {
        int optionNumber = 1;
        StringBuilder output = new StringBuilder();
        String header = textUtils.headerWithPadding(menuName, bordersChars, paddingChars, paddingLength);
        output.append(header).append("\n");
        for (String s : options) {
            if (!s.equals(options.getLast())) {
                output.append(String.format("%-10s[" + BLUE + "%d" + RESET + "] %s", "", optionNumber, s)).append("\n");
                optionNumber++;
            } else {
                output.append(String.format("%-10s[" + BLUE + "%d" + RESET + "] %s", "", 0, s)).append("\n");
            }
        }
        System.out.println(output);
    }
```

</details>
</html>

### 2.  **Convert to a SelectedTopping type:**

<html>
<details>
<summary>Code</summary>

```java

// convert String to SelectedTopping object
public SelectedTopping convertToSelectedTopping(String toppingType, String toppingName) {
Topping toppingObject = null; // create an empty Topping object to modify
// convert empty Topping Object to the appropriate toppingType based on the string name toppingType provided
// add provided toppingName to its name
switch (toppingType) {
case "Meat" -> toppingObject = new Meat(toppingName);
case "Cheese" -> toppingObject = new Cheese(toppingName);
case "Other Toppings" -> toppingObject = new OtherToppings(toppingName);
case "Sauce" -> toppingObject = new Sauce(toppingName);
case "Sides" -> toppingObject = new Sides(toppingName);
}
// convert current topping object into SelectedTopping object (non-extra)
return new SelectedTopping(toppingObject, false);
}
```

</details>
</html>

### 3.  **Reverse Lookup for Topping Type:**

<html>
<details>
<summary>Code</summary>

```java
public SelectedTopping findToppingType(String nameToLookUp, HashMap<String, ArrayList<String>> toppingChart) {
        Topping toppingObject = null;
        if (nameToLookUp == null || toppingChart == null) {
            return null;
        }
        String processedName = nameToLookUp.trim().toLowerCase();

        // go through each entry of toppingChart
        for (Map.Entry<String, ArrayList<String>> entry : toppingChart.entrySet()) {
            // get the current Topping Type
            String toppingType = entry.getKey();
            // list of options of current Topping Type
            ArrayList<String> options = entry.getValue();
            // if options list is not empty
            if (options != null) {
                // compare to each option in that list
                for (String option : options) {
                    if (option.trim().toLowerCase().equals(processedName)) {
                        switch (toppingType) {
                            case "Meat" -> toppingObject = new Meat(option);
                            case "Cheese" -> toppingObject = new Cheese(option);
                            case "Other Toppings" -> toppingObject = new OtherToppings(option);
                            case "Sauce" -> toppingObject = new Sauce(option);
                            case "Sides" -> toppingObject = new Sides(option);
                        }
                        return new SelectedTopping(toppingObject, false);
                    }
                }
            }
        }
        // options list is empty or none match
        return null;
    }
```

</details>
</html>

### 4.  **Parse a CSV file into HashMap of HashMaps (like XLOOKUP in Excel)**

<html>
<details>
<summary>Code</summary>

```java
    // parse csv file with lines of multiple columns each e.g. size|basePrice|meat|extraMeat|cheese|extraCheese
    // delimiter: pipe (|)
    // HashMap 0: each column number is key, name of each column header is value
    // HashMap of n line (header line not included): each column header is a key, each column value is a value
    // HashMap output: each line's value of first column (header line not included) is a key, a hashmap of that line created above is a value
    public HashMap<String, HashMap<String, String>> parseMultipleColumns(String filePath) {
        HashMap<String, String> headerField = new HashMap<>();
        HashMap<Integer, HashMap<String, String>> priceChartMap = new HashMap<>();
        HashMap<String, HashMap<String, String>> output = new HashMap<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            //parse header line
            int currentHeaderPart = 0;
            String partName;
            String partContent;
            String[] headerParts = bufferedReader.readLine().trim().split("\\|");
            for (String s : headerParts){
                partName = "part" + currentHeaderPart;
                partContent = s;
                headerField.put(partName, partContent);
                currentHeaderPart++;
            }
            // parse pricing lines

            int priceChartID = 0;
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] valueParts = input.trim().split("\\|");
                HashMap<String, String> currentPriceChart = new HashMap<>();
                int partNumber = 0;
                for (String s : valueParts) {
                    currentPriceChart.put(headerField.get("part" + partNumber), valueParts[partNumber]);
                    partNumber++;
                }
                priceChartMap.put(priceChartID, currentPriceChart);
                output.put(valueParts[0], priceChartMap.get(priceChartID));
                priceChartID++;
            }
        } catch (Exception e) {
            System.out.println("File cannot be read. Please double check FilePath!\nError: " + e.toString());
        }
        return output;
    }
```

</details>
</html>



