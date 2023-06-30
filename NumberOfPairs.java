
import java.util.*;

public class NumberOfPairs {

	public static void main(String[] args) {


		int nums[] = {1,3,2,1,3,2,2};
		
		int result[] = numberOfPairs(nums);
		
		System.out.println(Arrays.toString(result));
	}
	
	//
	public static int[] numberOfPairs(int[] nums) {
        
        int count = 0;
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        for(int n : nums) {
        	
        	//First ocurrence
        	if(!list.contains(n))
        		list.add(n);
        	else{
        			//pair
        			count++;
        			list.removeFirstOccurrence(n);
        		
        	}
        }

        int answer[] = {count, list.size()};
        
        return answer;
    }

}
