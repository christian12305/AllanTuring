/**
 * Leetcode: 1768. Merge Strings Alternately
 * @param {string} word1
 * @param {string} word2
 * @return {string}
 */
var mergeAlternately = function(word1, word2) {
    
    let p1 = 0;
    let p2 = 0;

    //iterate through each character on each 
    //adding alternating characters to the resulting string
    let result = "";

    //if remaining letters
    while(p1 < word1.length || p2 < word2.length){
        //add alternately

        //add from first if remaining
        if(p1 < word1.length){
            result += word1.charAt(p1)
            p1++;
        }

        if(p2 < word2.length){
            result += word2.charAt(p2)
            p2++;
        }
    }

    return result;
};