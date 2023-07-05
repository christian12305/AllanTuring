/**
 * Leetcode: 643. Maximum Average Subarray I
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    //maxAvg = 0
    //if(!nums.length >= k)
    //  return maxAvg;
    //
    //firsst window
    //loop nums
    //  sum up from i to k 
    //maxAvg = sum / k
    //
    //
    //slide window
    //loop nums from k
    //  update window, remove left add right
    //  maxAvg = max(maxAvg, sum/k)
    //  
    //return maxAvg

    let maxAvg = 0;

    //min len
    if(nums.length < k){
        return maxAvg;
    }

    //first window i -> k
    let sum = 0;
    for(let i = 0; i < k; i++){
        sum += nums[i];
    }
    
    maxAvg = sum/k;

    //slide window
    for(let i = k; i < nums.length; i++){
        sum += nums[i] - nums[i-k];
        maxAvg = Math.max(maxAvg, sum/k);
    }

    return maxAvg;

};