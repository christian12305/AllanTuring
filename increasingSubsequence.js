/**
 * Leetcode: 334. Increasing Triplet Subsequence
 * @param {number[]} nums
 * @return {boolean}
 */
var increasingTriplet = function(nums) {
    //loop nums
    //have the first and second number
    //they must be in the order first < second
    //if nums[i] < nums[first] 
    //  nums[first] = nums[i]
    //elif nums[i] < nums[second]
    //  nums[second] = nums[i]
    //
    //and because we already know nums[first] < nums[second]
    //if we find a value greater than the second it complies with
    //  nums[first] < nums[second] < nums[i] 
    //  then return true
    //
    //return false;
    if(nums.length < 3){
        return false;
    }

    let first = Number.MAX_VALUE, second = Number.MAX_VALUE;

    for(let i = 0; i < nums.length; i++){
        if(nums[i] <= first){
            first = nums[i];
        }else if(nums[i] <= second){
            second = nums[i];
        }else{
            return true;
        }
    }

    return false;
};