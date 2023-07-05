/**
 * Leetcode: 53. Maximum Subarray
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    
        /** EVERY SINGLE SUBARRAY ALGORITHM */
    //maxSum = 0
    //
    //loop i nums
    //  loop j = i nums
    //      sum += nums[j]
    //      maxSum = max(maxSum, sum)
    //      j++
    //  sum -= nums[i]
    //  i++
    //return maxSum


        /** OPTIMIZATION */
    //maxSum = nums[0], sum = 0
    //loop nums
    //  (negative sum, we discard that subarray sum by sum = 0)
    //  if(sum < 0)
    //      sum = 0
    //  sum += nums[i]
    //  maxSum = max(maxSum, sum)
    //return maxSum

    let maxSum = nums[0], sum = 0;

    for(let i = 0; i < nums.length; i++){
        if(sum < 0){
            sum = 0;
        }
        sum += nums[i];

        maxSum = Math.max(maxSum, sum);
    }

    return maxSum;
};