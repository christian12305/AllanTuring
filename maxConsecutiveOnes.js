/**
 * Leetcode: 1004. Max Consecutive Ones III
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var longestOnes = function(nums, k) {
    //loop nums
    //  if nums[right] is 0
    //      decrease k
    //  if k < 0
    //      while first elem of window not 0
    //          shrink window from left
    //      k++
    //      left++
    //  max of max and window size
    //
    //return max
    //
    let maxCount = left = 0;

    //extend window
    for(let right = 0; right < nums.length; right++){
        //zero flip
        if(nums[right] === 0){
            k--;
        }

        //adjust window if no flip available
        if(k < 0){
            //move until the first 0, which is what we want to remove
            while(nums[left] !== 0){
                left++;
            }
            //removes first 0
            left++
            k++
        }

        //tracks the maximum window of 1s
        maxCount = Math.max(maxCount, right - left + 1);

    }

    return maxCount;
};