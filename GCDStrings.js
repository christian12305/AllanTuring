/**
 * Leetcode: 1071. Greatest Common Divisor of Strings
 * @param {string} str1
 * @param {string} str2
 * @return {string}
 */
var gcdOfStrings = function(str1, str2) {
    //first we determine if str2 can be a divisible string of str1 
    //for that, concatenation of both must be identical in any order
    //else return false
    if(str1 + str2 !== str2 + str1){
        return "";
    }

    //since there is a divisible string
    //we now need to find the greatest common divisor string
    //it is enough for us to find the greatest common divisor between their lengths
    //to get the length of greatest common divisor string
    let gcdLength = gcd(str1.length, str2.length);

    //Produce the gcd string with given length and return
    return str1.slice(0, gcdLength);
};

let gcd = (A, B) =>{
    if(B === 0){
        return A;
    }
    return gcd(B, A%B);
};