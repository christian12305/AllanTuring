/**
 * Leet code problem: 2672. Number of Adjacent Elements With the Same Color
 * @param {number} n
 * @param {number[][]} queries
 * @return {number[]}
 */
var colorTheArray = function(n, queries) {

    //The returning array
    let answer = [];

    //Array which will store the query result
    let nums = [];
    //Fill with 0, length n
    nums.fill(0, n);
    
    //loop through queries,
    //each [index, color]
    for(let i = 0; i < queries.length; i++){

        //query
        let idx = queries[i][0];
        let color = queries[i][1];

        //execute
        nums[idx] = color;

        //Adjacent colors
        let count = 0;
        //count adjacent colors
        for(let j = 0; j < nums.length; j++){
            if(nums[j] && nums[j] === nums[j+1]){
                count++;
            }
        }

        answer.push(count);

    }

    return answer;
};