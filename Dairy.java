package mainrest;
/**
 * 
 * constructor for the child (dairy) returns true here. 
 */
public class Dairy extends Ingredient{
    public Dairy(String n, String c,String u, int usageCnt){
        super(n,c,u,usageCnt);
        setCategory("Dairy");
    }

    @Override
    public Boolean isDairy() {
        return true;
    }
    
    @Override
    public int getPrepTime(){
        return 0;
    }
    
}