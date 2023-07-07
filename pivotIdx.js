/**
 * Leetcode: 724. Find Pivot Index
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function(nums) {
    //loop nums
    //  right
    //  loop nums from i -1 to 0
    //      sum c/u
    //  left
    //  loop nums from i + 1 to nums.length -1
    //      sum c/u
    //  if right === left
    //      return i
    //return -1;
    /** ^ THIS IS WHAT CAME TO MIND O(n^2) ^ */

    /** OPTIMIZATION */
    //sumLeft = 0, sum = 0
    //loop nums
    //  sum all elements
    //loop nums
    //
    //      this gives the sum to the right of the current element
    //  rightSum = sum - sumLeft - nums[i]
    //  if right and left are equal return i
    //  update sumLeft for the next nums[i] by adding current value
    // return -1

    let sumLeft = 0;

    let sum = nums.reduce((accum, num) => {
        return accum + num;
    });

    for(let i = 0; i< nums.length; i++){
        let sumRight = sum - sumLeft - nums[i];
        if(sumLeft === sumRight){
            return i;
        }
        sumLeft += nums[i];
    }

    return -1;

};