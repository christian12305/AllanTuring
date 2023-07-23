// Leetcode: 746. Min Cost Climbing Stairs
/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
    //Return the minimum cost to reach the top of the floor.

    //so the subproblem states that we choose either one step further ,
    // or two steps further

    //this is DP problem since there is a recurring subproblem

    //so we enter recursively until we have a base case
    //our base case would be the last i
    // n-1 or n-2
    //  in base case, return the value called
    //
    // so each recursive call we add the current value and the
    //  step with minimum cost between the two


    //RECURSIVE APPROACH//

    // const dp = (n) =>{

    //     //base case
    //     if(n === cost.length-1 || n === cost.length - 2)
    //         return cost[n];

    //     return cost[n] + Math.min(dp(n+1), dp(n+2));

    // }

    // return Math.min(dp(0), dp(1));

    //////TIME LIMIT EXCEEDED////////

    let map = new Map();

    //DP TOP-DOWN APPROACH//

    const topdown = (n) =>{

        //base case
        if(n === cost.length-1 || n === cost.length - 2)
            return cost[n];

        //to obtain an already stored value
        if(map[n] != null)
            return map[n];

        //extra layer to store each of the values
        map[n] = cost[n] + Math.min(topdown(n+1), topdown(n+2));

        return map[n];

    }

    return Math.min(topdown(0), topdown(1));

    //WORKING 63ms//

    //DP BOTTOM-UP APPROACH//

    // let first = cost[0];
    // let second = cost[1];

    // //if no calculation needed
    // if(cost.length < 2)
    //     return Math.min(first, second);


    // //SIMILAR TO FIBONACCI
    // //we need the two numbers before i to compare the minimum cost
    // //either single or double jump

    // //iterate from the third item to the last
    // for(let i = 2; i < cost.length; i++){

    //     //decide if single or double jump
    //     //?
    //     //first -> double jump
    //     //second -> single jump
    //     //?
    //     let temp = cost[i] + Math.min(first, second);

    //     //moving for next iteration comparison
    //     first = second;
    //     //stores the 
    //     second = temp;
    // }

    // return Math.min(first, second);

};