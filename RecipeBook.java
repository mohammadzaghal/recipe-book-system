package mainrest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecipeBook {
    private ArrayList<Recipe> recipes; 
    private HashMap<String, Integer> ingredientUsage;
    private HashMap<String, Ingredient> ingredientObjects;
    private HashMap<String, Integer> categoryUsage;

    /**
     * constructor
     */
    public RecipeBook() {
        recipes = new ArrayList<>();  
        ingredientUsage = new HashMap<>();
        ingredientObjects = new HashMap<>();
        categoryUsage = new HashMap<>();

    }
    /**
     * 
     * @param recipe 
     * adds recipe into the list of recipes
     * each recipe added we get the ingredient names so we can keep track of the 
     * mostUsedIngredient
     * and same for the category... so we can keep track of mostPopularCategory
     */
    
    public void addRecipe(Recipe recipe){   
        recipes.add(recipe);
        for(Ingredient i : recipe.getIngredients()){
            String name = i.getName();
            String category = i.getCategory();

            ingredientUsage.put(name, ingredientUsage.getOrDefault(name, 0) + 1);
            ingredientObjects.putIfAbsent(name, i);
            
            categoryUsage.put(category, categoryUsage.getOrDefault(category, 0) + 1);

        }
    }
    
    /**
     * 
     * @param recipe
     * @return Boolean on where parameter was removed successfully or not
     */
    public Boolean removeRecipe(Recipe recipe){
        return recipes.remove(recipe);
    }
    
    /**
     * 
     * @param name
     * @return list of filtered recipes by name
     * 
     */
    public ArrayList<Recipe> filterByName(String name){
   
        ArrayList<Recipe> filteredNames = new ArrayList<>();

        for(Recipe i : recipes){
            if(name.equals(i.getName())){
                filteredNames.add(i);
            }
        }
        return filteredNames;
        
    }
    
    /**
     * 
     * @param cuisine
     * @return list of filtered recipes depending on the cuisine param
     */
    public ArrayList<Recipe> filterByCuisine(String cuisine){
        
        ArrayList<Recipe> filteredCuisine = new ArrayList<>();

        for(Recipe i : recipes){
            if(cuisine.equals(i.getCuisine())){
                filteredCuisine.add(i);
            }
        }
        return filteredCuisine;
    }
    
    /**
     * 
     * @param ingredient
     * @return list of recipe which is filtered depending on the param
     */
    public ArrayList<Recipe> filterByIngredient(String ingredient){
        
        ArrayList<Recipe> filteredIngreds = new ArrayList<>();

        for(Recipe i : recipes){
            if(i.hasIngredient(ingredient)){
                filteredIngreds.add(i);
            }
        }
        return filteredIngreds;
    }
    
    /**
     * 
     * @return most used ingredients in all recipes 
     */
    public ArrayList<Ingredient> mostUsedIngredients(){   
        ArrayList<Ingredient> result = new ArrayList<>();
        int max = 0; 
        
        for (String name : ingredientUsage.keySet()) {
            int usage = ingredientUsage.get(name);
            if (usage > max) {
                result.clear();
                result.add(ingredientObjects.get(name));
                max = usage;
            } else if (usage == max) {
                result.add(ingredientObjects.get(name));
            }
        }  
        return result;
    }

   /**
    * 
    * @return most popular category from all recipes
    */
    public String mostPopularCategory(){
        String mostPopular = null; 
        int max = 0;
        
        for(Map.Entry<String, Integer> entry : categoryUsage.entrySet()){
            if(entry.getValue() > max){
                mostPopular = entry.getKey();
                max = entry.getValue();
            }
        }
        return mostPopular;
    }
    
    /**
     * prints all recipes
     */
    public void printAllRecipes() {
        for (Recipe recipe : recipes) {
            System.out.println("- " + recipe.getName());
        }
    }
}

