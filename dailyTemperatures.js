/**
 * Leetcode: 739. Daily Temperatures
 * @param {number[]} temperatures
 * @return {number[]}
 */
var dailyTemperatures = function(temperatures) {
    //return an array with the number of days you have 
    //to wait to get warmer temperature for each day.

    //first approach would be n^2 by iterating temperatures
    //on each temperature, substracting indexes to get the number of days


    //MONOTONIC DECREASING STACK APPROACH//

    //using a stack we want to add each value that is
    //less than the top of stack, or just add if stack is empty
    //
    //while curr value is greater than the top of the stack, we pop
    //and store in result[idx of popped] = i - idx of popped

    //resulting array
    let result = new Array(temperatures.length).fill(0);

    //stack[i] = [temp, idx]
    let stack = [];

    //iterate temps
    for(let i = 0; i < temperatures.length; i++){

        //this keeps the stack monotonic

        //if current value is greater than the top of the stack
        //means we found an increase in temp
        while(stack.length && stack[stack.length-1][0] < temperatures[i]){
            let temp = stack.pop();

            //this substraction indicates the number of days
            //needed to get a higher temp. (current index - the index of the smaller temp)
            //we store in its corresponding index according to the given temperatures
            result[temp[1]] = i - temp[1];

        }

        //add current temp
        //adds every temp, to keep monotonic stack
        //and comparisons for each temperature
        stack.push([temperatures[i], i]);

    }

    return result;

};