// Leetcode: 162. Find Peak Element
class Solution {
    public int findPeakElement(int[] nums) {
        
        //similar to Binary Search
        //with lo and hi
        //while lo < hi
        //  mid = low + (high-low)/2
        //  making sure to not go out of bounds
        //  if mid - 1 < mid && mid + 1 < mid
        //      found return mid
        //  if mid-1 > mid 
        //      hi = mid -1
        //  elif mid + 1 > mid
        //      lo = mid +1

        //length 1 case
        if(nums.length <= 1)
            return 0;

        int lo = 0;
        int hi = nums.length-1;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            //checks if peak
            //validating if it goes out of bounds, count as smaller number
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])){
                lo = mid;
                break;
            }
            //goes towards the bigger number
            //making sure is not out of bounds
            else if(mid > 0 && nums[mid-1] > nums[mid])
                hi = mid -1;
            else
                lo = mid+1;
            
                
        }


        return lo;
    }
}