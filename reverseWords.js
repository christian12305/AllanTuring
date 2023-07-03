/**
 * Leetcode: 151. Reverse Words in a String
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    //split string with " "
    //join the array in reverse order

    let arr = s.split(/\s+/);

    let reverseArr = [];

    let count = 0;
    for(let i = arr.length-1; i >= 0; i--){
        reverseArr[count] = arr[i];
        count++;
    }

    return reverseArr.join(" ").trim();

};