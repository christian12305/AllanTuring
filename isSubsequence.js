/**
 * Leetcode: 392. Is Subsequence
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function(s, t) {
    //j = 0
    //loop t
    //  if(t[i] === s[j]) )
    //      j++
    //if j === s.len
    //  return true
    //return false

    // index for s
    let j = 0;

    for(let i = 0; i< t.length; i++){
        //finding each value of our substring in order
        if(t[i] === s[j]){
            j++;
        }
    }

    //determine if the amount of values found 
    // is the length of substring
    // this means all characters were found

    if(j === s.length){
        return true;
    }

    return false;

};