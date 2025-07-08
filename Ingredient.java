package mainrest;

public abstract class Ingredient {
    protected String name; 
    protected String category;    
    protected String unitOfMeasurement; 
    protected int usageCount; //make fields protected

    /**
     * 
     * @param name
     * @param category
     * @param unitOfMeasurement
     * @param usageCount
     * Constructor For Ingredient.java 
     */
    protected Ingredient(String name, String category, String unitOfMeasurement, int usageCount) {
        this.name = name;
        this.category = category;
        this.unitOfMeasurement = unitOfMeasurement;
        this.usageCount = usageCount;
    }
    
    /**
     * increments the usageCount
     */
    public void incrementUsage(){
        usageCount = usageCount + 1;
    }
    
    public int getUsageCount(){
        return usageCount;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }
    
    /**
     * the children of Ingredient.java (inheritance) all return false here.
     * @return 
     */
    public Boolean isMeat(){
        return false;
    }
    
    public Boolean isDairy(){
        return false;
    }
    
    public Boolean isVege(){
        return false;
    }
    
    public Boolean isBakery(){
        return false; 
    }
    
    public abstract int getPrepTime();
}
