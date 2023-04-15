package codenights;

import java.util.*;

public class DistributeMoney {

	public static void main(String[] args) {

		int amount = distMoney(25,3);
		
		System.out.println(amount);
	}
	
	public static int distMoney(int money, int children) {
		
		//Not possible to distribute
        if(money < children)    
        	return -1;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                
        //Distribute first dollar for each children
        for(int i = 0; i < children; i++)   
        	map.put(i, 1);
        
        money -= children;
        
        //Iterate for each children to distribute the rest
        for(int i = 0; i < children; i++){
        	
        	//Increments the money of the children by 7 if enough money
            if(money >= 7){
            	
                money -= 7;
                
                map.replace(i, map.get(i) + 7);
            
             //If no money remaining
            }else if(money == 0)    
            	break;
            
            else{
            	
                if(money == 3){
                	
                	//Increment the childs money by 2
                	map.replace(i, map.get(i) + 2);
                	
                	//Remaining
                    money = 1;
                }else{
                	
                	//Increment the childs money by 1
                	map.replace(i, map.get(i) + 1);
                	
                	//Update remaining
                    money = 0;
                }
            }
        }
        
        int count = 0;
        
        //Count each children w 8 dollars
        for(int i = 0; i < map.size(); i++) 
        	count += map.get(i) == 8 ? 1 : 0;
        
        //If there is money left, discount a children
        if(money != 0)   
        	count--;
        
        return count;
    }

}
