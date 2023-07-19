/**
 * Leet code problem: 2672. Number of Adjacent Elements With the Same Color
 * @param {number} n
 * @param {number[][]} queries
 * @return {number[]}
 */
var colorTheArray = function(n, queries) {
    //loop queries
    //  check if we are incrementing the count or decrementing
    //  we decrement if before the change, 
    //  if a node to the left or to the right is the same as the current
    //      decrement
    //  do the change
    //  if a node to the left or to the right is the same as the current
    //      increment
    //  store the counter at the resulting array 
    //  at the same index we are currently at
    //return the resulting array

    let res = Array(n+1);

    let count = 0;

    //query count
    let queryCount = 0;
    
    //count arr
    let countArr = [];

    queries.forEach( query =>{

        let idx = query[0];
        let color = query[1];

        //Making sure to not go out of bounds
        let prev = idx>0 ? res[idx-1] : 0;
        let next = idx < n-1 ? res[idx+1] : 0;

        //break adjacents if any before applying query
        //truthy value makes sure to not account for uncolored spaces
        if(res[idx] && prev == res[idx])
            count--;
        
        if(res[idx] && next == res[idx])
            count--;

        //apply query
        res[idx] = color;

        //update with new query
        //sum adjacent count if any
        if(res[idx] && prev == res[idx])
            count++;
        
        if(res[idx] && next == res[idx])
            count++;

        //Store current count
        countArr[queryCount] = count;
        queryCount++;
        
    });

    return countArr;
    

};