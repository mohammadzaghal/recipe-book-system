package mainrest;
import java.util.ArrayList; 

public class Recipe {
    private String name; 
    private String cuisine; 
    private ArrayList<Ingredient> ingredients;
    private int cookingTime; 

    /**
     * constructor
     * @param name
     * @param cuisine
     * @param ingredients
     * @param cookingTime 
     */
    public Recipe(String name, String cuisine, ArrayList<Ingredient> ingredients, int cookingTime) {
        this.name = name;
        this.cuisine = cuisine;
        this.ingredients = ingredients;
        this.cookingTime = cookingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }
    
    
    /**
     * adds ingredient 
     * @param ingredient 
     */
    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }
    
    /**
     * 
     * @param ingredient
     * @return if ingredient was removed successfully
     */
    public Boolean removeIngredient(Ingredient ingredient){
        return ingredients.remove(ingredient);
    }
    
    /**
     * 
     * @return total cookingTime of a recipe
     */
    public int totalCookingTime() {
        int prepTime = 0;
        for (Ingredient i : ingredients) {
            prepTime += i.getPrepTime();
        }
        return prepTime + cookingTime;
    }

    
    /**
     * 
     * @param recipeName 
     * prints out the details of the recipe given
     */
    public void getDetails(String recipeName){ 
        System.out.println("recipe Name: " + name);
        System.out.println("cuisine: " + cuisine);
        System.out.println("cooking Time: " + cookingTime + " minutes");
        System.out.println("total cooking Time: " + totalCookingTime() + " minutes");

        System.out.println("ingredients:");
        for (Ingredient i : ingredients) {
            System.out.println("- " + i.getName() + " (" + i.getCategory() + ")");
        }
        
    }
    
    /**
     * 
     * @param ingredient
     * @return checks if an ingredient exists in the list of ingredients
     */
    public Boolean hasIngredient(String ingredient){
        
        for(Ingredient i : ingredients){
            if(i.getName().equals(ingredient)){
                return true;
            }
        }
        return false;
    }
}
