/**
 * Leetcode: 1431. Kids With the Greatest Number of Candies
 * @param {number[]} candies
 * @param {number} extraCandies
 * @return {boolean[]}
 */
var kidsWithCandies = function(candies, extraCandies) {

    //get the max
    //loop
    //if candies[i] + extraCandies >= max
    //result[i] = true
    //else
    //result[i] = false;

    let result = [];
    //...candies spread operator
    let max = Math.max(...candies);

    for(let i = 0; i < candies.length; i++){
        if((candies[i] + extraCandies) >= max){
            result[i] = true;
        }else{
            result[i] = false;
        }
    }

    return result;
};