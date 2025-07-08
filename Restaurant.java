package mainrest;
import java.util.ArrayList; 
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.*;


public class Restaurant {
    private RecipeBook recipeBook;
    private ArrayList<String> shoppingList = new ArrayList<>();
    private HashMap<String, Integer> stock;

    /**
     * constructor
     */
    public Restaurant() {
        recipeBook = new RecipeBook();
        shoppingList = new ArrayList<>();
        stock = new HashMap<String, Integer>();
    }

    public RecipeBook getRecipeBook() {
        return recipeBook;
    }
    /**
     * 
     * file reader and scanner functionalities
     */
    public void read(String ingredientsFile, String recipesFile) {
        try {
            HashMap<String, Ingredient> ingredients = new HashMap<>();
            Scanner scanner = new Scanner(new File(ingredientsFile));

            // Read ingredients
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(" ");
                    String name = parts[0];
                    String category = parts[1];
                    String unit = parts[2];

                    Ingredient ingredient;

                    switch (category.toLowerCase()) {
                        case "meat":
                            int thawingTime = Integer.parseInt(parts[3]);
                            int cookingTime = Integer.parseInt(parts[4]);
                            ingredient = new Meat(name, "meat", unit, 0 , thawingTime , cookingTime);
                            break;
                        case "vegetables":
                            int washingTime = Integer.parseInt(parts[3]);
                            int cuttingTime = Integer.parseInt(parts[4]);
                            ingredient = new Vegetable(name, "Vegetable", unit, 0,washingTime,cuttingTime);
                            break;
                        case "dairy":
                            ingredient = new Dairy(name, "Dairy", unit, 0);
                            break;
                        case "bakery":
                            int restTime = Integer.parseInt(parts[3]);
                            int bakeTime = Integer.parseInt(parts[4]);
                            ingredient = new Bakery(name, "Bakery",unit,0, restTime, bakeTime);
                            break;
                        default:
                            System.out.println("Unknown category: " + category);
                        continue;                    }

                    ingredients.put(name, ingredient);
                }
            }
            scanner.close();

            scanner = new Scanner(new File(recipesFile));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(" ");
                    String recipeName = parts[0];
                    String cuisine = parts[1];
                    String ingredientList = parts[2];
                    int cookingTime = Integer.parseInt(parts[3]);

                    String[] ingredientNames = ingredientList.split("-");
                    ArrayList<Ingredient> recipeIngredients = new ArrayList<>();
                    for (String ingName : ingredientNames) {
                        if (ingredients.containsKey(ingName)) {
                            recipeIngredients.add(ingredients.get(ingName));
                        } else {
                            System.out.println("Missing ingredient in file: " + ingName);
                        }
                    }

                    Recipe recipe = new Recipe(recipeName, cuisine, recipeIngredients, cookingTime);
                    this.recipeBook.addRecipe(recipe);
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
    
    public void setRecipeBook(RecipeBook recipeBook) {
        this.recipeBook = recipeBook;
    }

    public ArrayList<String> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ArrayList<String> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public HashMap<String, Integer> getStock() {
        return stock;
    }

    public void setStock(HashMap<String, Integer> stock) {
        this.stock = stock;
    }
    
    /**
     * 
     * @param recipe
     * @return boolean (if recipe was prepared successfully or not) 
     */
    public boolean prepareRecipe(Recipe recipe) {
        boolean canPrepare = true;

        for (Ingredient ingredient : recipe.getIngredients()) {
            if (!isAvailable(ingredient.getName())) {
                canPrepare = false;
                if (!shoppingList.contains(ingredient.getName())) {
                    shoppingList.add(ingredient.getName()); 
                }
            }
        }

        if (canPrepare) {
            for (Ingredient ingredient : recipe.getIngredients()) {
                reduceStock(ingredient);
            }
            System.out.println("Recipe prepared successfully: " + recipe.getName());
        } else {
            System.out.println("Cannot prepare recipe: " + recipe.getName());
            System.out.println("Missing ingredients were added to the shopping list.");
        }

        return canPrepare;
    }

    /**
     * 
     * @param ingredientName
     * @param quantity 
     * add to stock (which is a hahmap) hence it needs a key and value (ingredientname as key and quantity as value
     */
    public void addStock(String ingredientName, int quantity){
        stock.put(ingredientName, quantity);
        
    }
    
    /**
     * 
     * @param ingredient 
     * removes param from stock
     */
   public void reduceStock(Ingredient ingredient) {
        String name = ingredient.getName();
        if (stock.containsKey(name)) {
            int currentStock = stock.get(name);
            if (currentStock > 1) {
                stock.put(name, currentStock - 1);
            } else {
                stock.remove(name);
            }
        }
    }
   
   /**
    * 
    * @param ingredient
    * @return boolean on whether param is available
    * which is checked by checking the stock
    */
    public Boolean isAvailable(String ingredient){
        
        if(shoppingList.contains(ingredient)){
            return false; 
            
        }
        else if(stock.containsKey(ingredient)){
            return true;
            
        }
        return false;
    }
    
    /**
     * 
     * @param ingredient 
     * adding param(ingredient) to shopping list
     */
    public void addToShoppingList(Ingredient ingredient){
        shoppingList.add(ingredient.getName());
    }
    
    /**
     * 
     * @param ingredientName
     * @param quantity 
     * buying an ingredient and a quantity from it... 
     * removes it from shopping list and adds it to the stock
     */
    public void buyIngredient(String ingredientName, int quantity) {
        if (shoppingList.contains(ingredientName)) {
            addStock(ingredientName, quantity); 
            shoppingList.remove(ingredientName);
        }
        else{
            System.out.println("Couldnt buy ingredient");
        }
}
        public void buyAllIngredients() {
        if (shoppingList.isEmpty()) {
            System.out.println("Shopping list is already empty");
            return;
        }

        for (String ingredientName : shoppingList) {
            addStock(ingredientName, 1);  
            System.out.println("Bought 1 unit of: " + ingredientName);
        }

        shoppingList.clear(); 
        System.out.println("All ingredients bought and shopping list cleared");
    }
        
    /**
     * prints stock 
     */
    public void printStock() {
        System.out.println("Current Stock:   ");
        if (stock.isEmpty()) {
            System.out.println("Stock is empty!");
        } else {
            for (String ingredient : stock.keySet()) {
                System.out.println(ingredient + ": " + stock.get(ingredient));
            }
        }
    }
    /**
     * prints shopping list
     */
    public void printShoppingList() {
        System.out.println("Shopping List: ");
        if (shoppingList.isEmpty()) {
            System.out.println("Shopping list is empty ");
        } else {
            for (String ingredient : shoppingList) {
                System.out.println(" " + ingredient);
            }
        }
    }
}
