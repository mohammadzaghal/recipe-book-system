package mainrest;

/**
 * 
 * constructor for the child (vegetable) returns true here. 
 */
public class Vegetable extends Ingredient{
    private int washingTime; 
    private int cuttingTime; 
    public Vegetable(String n, String c,String u, int usageCnt, int washingTime, int cuttingTime){
        super(n,c,u,usageCnt);
        category = "Vegetable";
        this.washingTime = washingTime; 
        this.cuttingTime = cuttingTime;
    }

    @Override
    public Boolean isVege() {
        return true; 
    }
    @Override
    
    public int getPrepTime(){
        return washingTime + cuttingTime; 
    }
    
}
