# recipe-book-system
A Java-Object Oriented-based system for restaurants to manage recipes, ingredient stock, and shopping lists. It allows chefs to prepare meals based on available ingredients, automatically updates stock, and tracks missing items for restocking.

## Features
- Maintain a list of recipes with details like name, cuisine, ingredients, and cooking time.
- Manage ingredients categorized by type (e.g., dairy, meat, vegetables).
- Track ingredient stock and update it when recipes are prepared.
- Automatically add missing ingredients to a shopping list when trying to prepare a recipe.
- Buy ingredients individually or in bulk from the shopping list, updating stock accordingly.
- Search and filter recipes by name, cuisine, or ingredient.

## Usage
1. Initialize the system by loading recipes and ingredients from input files (`ingredients.txt`, `recipes.txt`).
2. Attempt to prepare recipes; the system checks stock and updates the shopping list as needed.
3. Purchase missing ingredients from the shopping list, either one at a time or all at once.
4. Successfully prepare recipes once all ingredients are in stock.

## Example Output
Loaded Recipes:

Chicken_Alfredo

Tomato_Salad

Pancakes

Trying to prepare 'Chicken_Alfredo'...
Cannot prepare recipe: Chicken_Alfredo
Missing ingredients were added to the shopping list.
Shopping List after preparation attempt:
Shopping List:
Chicken
Onion
Milk
Cheese

Buying one missing ingredient (Onion)...
Current Stock after buying Onion:
Current Stock:
Onion: 1

Buying all remaining missing ingredients...
Bought 1 unit of: Chicken
Bought 1 unit of: Milk
Bought 1 unit of: Cheese
All ingredients bought and shopping list cleared

Current Stock after buying all ingredients:
Current Stock:
Onion: 1
Chicken: 1
Cheese: 1
Milk: 1

Trying to prepare 'Chicken_Alfredo' again...
Recipe prepared successfully: Chicken_Alfredo

Final Stock:
Current Stock:
Stock is empty!


## Input File Formats
- **ingredients.txt**  
  Format: `Name Category Unit_Of_Measurement`  
  Example:
  Spaghetti Pasta Grams
Ground_Beef Meat Kilograms
Tomatoes Vegetables Kilograms


- **recipes.txt**  
Format: `Name Cuisine Ingredients Cooking_Time`  
Ingredients are hyphen-separated.  
Example:

Spaghetti_Bolognese Italian Spaghetti-Ground_Beef-Tomatoes-Garlic-Olive_Oil 30
Chicken_Alfredo Italian Chicken-Alfredo_Sauce-Garlic-Parmesan-Fettuccine 25
Veggie_Burger American Veggie_Patty-Lettuce-Tomato-Onion-Bun 20

## Use-Case diagram: 
![image](https://github.com/user-attachments/assets/d779085e-d9eb-473b-b394-8a499059c553)

## Class diagram:
![image](https://github.com/user-attachments/assets/f3cb5e19-3f52-405e-8467-5c462f76ae0e)


## Made with ❤️ by Mohammad Alzaghal

