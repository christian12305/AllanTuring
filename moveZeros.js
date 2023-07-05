/**
 * Leetcode: 283. Move Zeroes
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    //"snowball"
    //having the amount of zeroes
    //loop
    //if zero
    //  zeroes++
    //else
    //  switch value to i - zeroes
    //  this accumulates all zeroes and moves them at once
    //  by moving the nonzero behind all the zeroes
    let amntZeroes = 0;
    for(let i = 0; i < nums.length; i++){
        if(nums[i] === 0){
            amntZeroes++;
        }else{
            let temp = nums[i];
            //moving zero to front
            nums[i] = 0;
            //place nonzero behind all the zeroes
            nums[i - amntZeroes] = temp;
        }
    }
    
};