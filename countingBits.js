// Leetcode: 338. Counting Bits
/**
 * @param {number} n
 * @return {number[]}
 */
var countBits = function(n) {
    
    //so we want to iterate from 1 -> n
    //we iterate
    //  while number > 0
    //      if number is odd, the rightmost digit will be 1
    //      we obtain the rightmost 1 by using modulo
    //      if it were even, it doesnt add a 1
    //      so we accumulate += num % 2 
    //      and we update the number "shifting" it
    //      to shift, we use bit shifting
    //  store the accumulated sum in an array on the ith place

    // let arr = [];

    // for(let i = 0; i < n+1; i++){
    //     //accumulator for number of ones in the ith number
    //     let acc = 0;
    //     //the number itself
    //     let num = i;

    //     //O(logn)
    //     //number of 1 in 0 is 0
    //     while(num != 0){

    //         //rightmost 1 is given if odd
    //         //if even, 0 is added
    //         acc += num % 2;

    //         //shift rightmost bit
    //         num = num>>1;
    //     }

    //     //push the number of ones of ith number to our array
    //     arr.push(acc)
    // }

    // return arr;


    //GREAT SOLUTION O(nlogn)//

    //Now for a better approach we will be storing each of the numbers amount of 1s
    //in an array
    //
    //memoization

    let arr = [];

    //defining 0
    arr[0] = 0;

    for(let i = 1; i < n+1; i++){
        //ith 1s is given by the 1s of the right shifted number
        //plus the current numbers rightmost 1 if odd
        arr[i] = arr[i>>1] + i%2;
    }

    return arr;

    //SOLUTION O(N)//

};