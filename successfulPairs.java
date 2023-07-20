// Leetcode: 2300. Successful Pairs of Spells and Potions
import java.util.*;
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        //given two positive integer arrays
        //n = spells.length
        //where a pair is (spells[i], potions[j])
        //and it is considered a success if 
        //  spells[i] * potions[j] >= success
        
        //return an array of length n
        //where each value is the number of potions that are successfull
        //with the ith spell

        //having a new empty array called result

        //loop n
        //  since spells[i] * potions[j] >= success
        //  potions[j] >= success / spells[i]
        //  find position of potions[j] if exists
        //  with that position forward we can say all of those are successfull
        //  so store potions.length - position in the n[i]

        int n = spells.length;

        int[] result = new int[n];

        //O(n log n)
        Arrays.sort(potions);

        //O(n)
        for(int i = 0; i < n; i++){

            long minValid = (long) Math.ceil( 1.0 * success / spells[i]);
                

            //O(log n)
            //find minValid's position
            //binary search
            //to accomplish this, potions must be sorted
            int lo = 0;
            int hi = potions.length;
            while(lo<hi){
                int mid = lo + (hi-lo)/2;
                //found
                if(potions[mid] < minValid){
                    lo = mid + 1;
                }else{
                    hi = mid;
                }
            }

            result[i] = potions.length - lo;


        }


        return result;
    }
}