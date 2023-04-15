package codenights;

import java.util.*;

public class MaxVowels {

	public static void main(String[] args) {
		String s = "abciiidef";
		int k = 3;
		System.out.println(maxVowels(s,k));
	}
	
	//Sliding Window
    public static int maxVowels(String s, int k) {
    	
    	ArrayList<Character> vowels = new ArrayList<Character>();
    	
    	vowels.add('a');
    	vowels.add('e');
    	vowels.add('i');
    	vowels.add('o');
    	vowels.add('u');
    	
    	int length = s.length();
    	
    	int count = 0;
    	
    	//First window
    	for(int i = 0; i < k; i++) {
    		
    		//Count vowels
    		if(vowels.contains(s.charAt(i)))
    			count++;
    	}
    	
    	int maxCount = count;
    	
    	//Recorre el string, cada caracter
    	for(int i = k; i < length; i++) {
    		
    		//Current char
    		if(vowels.contains(s.charAt(i)))
    			count++;
    		
    		//Left char
    		// if vocal, discount 1
    		if(vowels.contains(s.charAt(i-k)))
    			count--;
    			
    		maxCount = Math.max(maxCount, count);
    		
    	}
    		
    	return maxCount;
        
    }

}
