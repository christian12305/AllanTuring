/**
 * Leetcode: 1493. Longest Subarray of 1's After Deleting One Element
 * @param {number[]} nums
 * @return {number}
 */
var longestSubarray = function(nums) {
    //max = 0
    //left at 0
    //loop nums (this is right)
    //  if nums[right] = 0
    //      k--
    //  if k < 0
    //      adjust left
    //      increment k
    //  max = max between max and right - left - 1
    //return max
    let k = 1;
    let maxCount = left = 0;
    for(let right = 0; right < nums.length; right++){
        if(nums[right] === 0){
            k--;
        }

        if(k < 0){
            if(nums[left] === 0){
                k++;
            }
            left++;
        }

        maxCount = Math.max(maxCount, right - left);
    }

    return maxCount;

};