package mainrest;

import mainrest.Restaurant;

/**
 * 
 * @author Mohammad Alzaghal
 */

public class MainRest {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        restaurant.read("ingredients.txt", "recipes.txt");


        System.out.println("Loaded Recipes: ");
        restaurant.getRecipeBook().printAllRecipes();

        System.out.println(" Trying to prepare 'Chicken_Alfredo'...");
        Recipe chickenAlfredo = restaurant.getRecipeBook().filterByName("Chicken_Alfredo").isEmpty() 
                                ? null 
                                : restaurant.getRecipeBook().filterByName("Chicken_Alfredo").get(0);

        if (chickenAlfredo != null) {
            restaurant.prepareRecipe(chickenAlfredo);
        } else {
            System.out.println("Recipe not found: Chicken_Alfredo");
        }

        System.out.println("Shopping List after preparation attempt: ");
        restaurant.printShoppingList();

        System.out.println("Buying one missing ingredient (Onion)... ");
        restaurant.buyIngredient("Onion", 1);

        System.out.println("Current Stock after buying Onion: ");
        restaurant.printStock();

        System.out.println("Buying all remaining missing ingredients...");
        restaurant.buyAllIngredients();

        System.out.println("Current Stock after buying all ingredients:");
        restaurant.printStock();

        System.out.println("Trying to prepare 'Chicken_Alfredo' again...");
        if (chickenAlfredo != null) {
            restaurant.prepareRecipe(chickenAlfredo);
        }

        System.out.println("Final Stock:");
        restaurant.printStock();
    }
}
