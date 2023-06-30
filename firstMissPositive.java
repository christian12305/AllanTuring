/*
 * 41. First Missing Positive
 */

import java.util.Arrays;

class Solution {
    public int firstMissingPositive(int[] nums) {
        //
        //use the same array nums to identify if a number is missing
        // [0,3,-4,-1] returns 2
        //
        //remove < 0 by replacing with 0
        //
        //identify each number to corresponding index if number = 3, idx = 2
        //it is identified by changing number at idx to < 0
        //if 0 change number at idx to len+1 (outofbounds)
        //
        //to check if integer is missing
        //loop through nums
        //if i > 0 return i


        //Remove negative values
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0)
                nums[i] = 0;
        }

        //Identifying each number
        //indicate in its corresponding idx that it exists by giving a < 0
        for(int i = 0; i< nums.length; i++){
            int idx = Math.abs(nums[i]) -1;

            //Using math.abs to get value without mark
            if(Math.abs(nums[i]) > 0 && Math.abs(nums[i]) <= nums.length){
                if(nums[idx] == 0){
                    nums[idx] = (nums.length + 1) * -1;
                }else if(nums[idx] > 0){
                    nums[idx] = nums[idx] * -1;
                }
            }  
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0)
                return i+1;
        }

        return nums.length+1;
    }
}
