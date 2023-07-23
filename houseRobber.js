// Leetcode: 198. House Robber
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    
    //nums[i] -> money of ith house
    //cannot rob adjacent houses
    //we want to return the most amount of money

    //recursively
    //from the last element
    //we determine if we rob current house
    // subproblem
    //  is the i-1 > i-2?
    //      then not pick current
    //      pick i-1
    //      else pick current and i -2

    // const rec = (i) =>{

    //     if(i < 0)
    //         return 0;

    //     return Math.max( rec(i-1), rec(i-2) + nums[i]);
    // };

    // return rec(nums.length-1);

    //FOR A DP. WE IMPLEMENT MEMOIZATION//

    // let map = new Map();

    // const dp = (i) =>{

    //     if(i<0)
    //         return 0;

    //     if(map.has(i))
    //         return map.get(i);

    //     let result = Math.max(dp(i-1), dp(i-2) + nums[i]);
    //     map.set(i, result)
    //     return result;

    // };

    // return dp(nums.length-1);

    //FOR A DP. IMPLEMENTING BOTTOM UP//
    if(nums.length < 2)
        return nums[0];

    let first = 0;
    let second = 0;

    for(let i = 0; i < nums.length; i++){

        let temp = Math.max(first + nums[i] , second);

        first = second;

        second = temp;

    }

    return second;

};