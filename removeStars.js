/**
 * Leetcode: 2390. Removing Stars From a String
 * @param {string} s
 * @return {string}
 */
var removeStars = function(s) {
    //loop string
    //  if * pop from stack
    //  else insert to stack
    //convert stack to string
    //return string

    let stk = [];

    for(let i = 0; i < s.length; i++){
        if(s[i] === '*'){
            stk.pop();
        }else{
            stk.push(s[i]);
        }
    }

    return stk.join("");

};