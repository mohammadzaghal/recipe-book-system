package mainrest;

/**
 * 
 * constructor for the child (vegetable) returns true here. 
 */
public class Bakery extends Ingredient{
    private int restingTime; 
    private int bakingTime; 
    public Bakery(String n, String c,String u, int usageCnt, int restingTime, int bakingTime){
        super(n,c,u,usageCnt);
        category = "Vegetable";
        this.restingTime = restingTime; 
        this.bakingTime = bakingTime;
    }

    @Override
    public Boolean isVege() {
        return true; 
    }
    @Override
    
    public int getPrepTime(){
        return restingTime + bakingTime; 
    }
    
}
