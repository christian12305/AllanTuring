// Leetcode: 136. Single Number
/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {

    //so the first thought that I approached was building a
    //frequency map and returning the one with value 1
    //but problem requires constant extra space

    //so the other approach I learned that would be constant space
    //is using bit manipulation
    //So, similar to the steganography project where we use XOR operator
    //to compare the original photo with the one with the hidden message,
    //and obtain the hidden message based on the result of performing xor
    //on every bit.

    //so similarly, here we can use XOR bit manipulation to determine what is the
    //single number.
    //Every pair of numbers will cancel itself out 
    //if we do x ^ x = 0
    //so by canceling every pair, the result of doing the operation on each number
    //will result on the only single number.

    //result of XOR
    //remember if 0 ^ i = i
    let xor = 0;

    //iterate nums
    for(let i = 0; i < nums.length; i++){
        xor ^= nums[i];
    }

    return xor;
    
};