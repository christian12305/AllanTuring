/**
 * Leetcode: 1. Two Sum
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    //nums[i] + x = target
    //x = target - nums[i]
    //find x
    //return i and x.index
    let map1 = new Map();
    for(let i = 0; i < nums.length; i++){
        let x = target - nums[i];

        if(map1.has(x)){
            return [i, map1.get(x)];
        }else{
            map1.set(nums[i], i);
        }
    }

    return [0];
};