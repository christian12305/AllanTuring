/**
 * Leetcode 217. Contains Duplicate
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    
    let map = new Map();

    let flag = false;

    nums.forEach(elem =>{
        if(map.has(elem)){
            flag = true;
        }else{
            map.set(elem, 1);
        }
    });

    return flag;

};