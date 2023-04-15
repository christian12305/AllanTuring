package codenights;

import java.util.*;

public class DissapearedNums {

	public static void main(String[] args) {
		int nums[] = {4,3,2,7,8,2,3,1};
		
		System.out.println(findDisappearedNumbers(nums).toString());
		
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		//Remove duplicates
		for( int n : nums) {
			set.add(n);
		}
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			if(!set.contains(i+1))
				list.add(i+1);
		}
		return list;

	}
}
