/**
 * Leetcode: 1657. Determine if Two Strings Are Close
 * @param {string} word1
 * @param {string} word2
 * @return {boolean}
 */
var closeStrings = function(word1, word2) {
    //their lengths must be equal
    //
    //loop to get each characters frequency
    //
    //
    //store their frequencies and sort them in ascending order
    //
    //also store in a set the characters from the first
    //then remove characters from the set using the second word's characters
    //
    //if their sorted frequencies are equal and set is empty
    //return true
    //else false

    if(word1.length !== word2.length){
        return false;
    } 

    let set = new Set();

    let map1 = new Map();
    let map2 = new Map();

    for(let i = 0; i < word1.length; i++){
        map1.has(word1[i]) ? map1.set(word1[i], map1.get(word1[i]) +1) : map1.set(word1[i], 1);
        set.add(word1[i]);
    }

    for(let i = 0; i < word2.length; i++){
        map2.has(word2[i]) ? map2.set(word2[i], map2.get(word2[i]) +1) : map2.set(word2[i], 1);
        set.delete(word2[i]);
    }

    let list1 = [...map1.values()];
    list1.sort((a,b)=> a-b);
    let list2 = [...map2.values()];
    list2.sort((a,b)=> a-b);

    if(list1.toString() === list2.toString() && set.size === 0){
        return true;
    }else{
        return false;
    }

};