/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainrest;

/**
 * 
 * constructor for the child (meat) returns true here. 
 */
public class Meat extends Ingredient{
    private int thawingTime; 
    private int cookingTime; 
    public Meat(String n, String c,String u, int usageCnt, int thawingTime, int cookingTime){
        super(n,c,u,usageCnt);
        setCategory("meat");
        this.cookingTime = cookingTime; 
        this.thawingTime = thawingTime;
    }

    @Override
    public Boolean isMeat() {
        return true;
    }
    
    @Override
    public int getPrepTime(){
        return thawingTime + cookingTime;
    }
    
}
