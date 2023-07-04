/**
 * Leetcode: 238. Product of Array Except Self
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    //find the product of the array without 0s
    //if there is a 0
    //store its index and dont add to product
    //amountOfZero++

    //loop nums
    
    //if amountOfZero == 0 
    //divide product / nums[i]

    //if amountOfZero == 1
    //  result[0index] = product
    //  the rest is 0
    let result = [];

    let zeroIdx = -1;
    let amntZeros = 0;

    let prod = 1;
    for(let i = 0; i < nums.length; i++){
        if(nums[i] === 0){
            zeroIdx = i;
            amntZeros++;
        }else{
            prod *= nums[i];
        }
    }

    if(amntZeros === 0){
        for(let i = 0; i < nums.length; i++){
            result[i] = prod / nums[i];
        }
    }else if(amntZeros > 0){
        for(let i = 0; i < nums.length; i++){
            result[i] = 0;
        }
        if(amntZeros === 1){
            result[zeroIdx] = prod;
        }
    }

    return result;

};