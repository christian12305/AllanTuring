/**
 * Leetcode: 1456. Maximum Number of Vowels in a Substring of Given Length
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var maxVowels = function(s, k) {

    //define vowels
    let vowels = 'aeiou'
    
    //we want to approach this using sliding window
    //so for the first window, we count the amount of vowels
    //in substring from 0 to k-1

    //after, we want to move the window on each iteration
    //if left pointer was a vowel, discount from count
    //if new right pointer is a vowel, increment count
    //store the max from all iterations

    //counter
    let count = 0;

    //first window
    for(let i = 0; i < k; i++){
        if(vowels.includes(s[i]))
            count++
    }

    //maximum
    let max = count;

    //increment or decrement
    for(let i = k; i < s.length; i++){

        //check if discount on left side of window
        if(vowels.includes(s[i-k]))
            count--;

        //increment for new window vowel
        if(vowels.includes(s[i]))
            count++;

        max = Math.max(max, count);
    }

    return max;
};