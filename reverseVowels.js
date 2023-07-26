/**
 * Leetcode: 345. Reverse Vowels of a String
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
    //the objective is to reverse vocals in the string s
    //to reverse them, we got two pointers one at begining 
    //and one at start. when the two pointers are vocals, 
    //switch them in place
    //when the two pointers cross, we return the string

    let arr = s.split("");

    //first we define the vowels
    let vowels = 'aeiouAEIOU';

    let start = 0;
    let end = s.length -1;

    //loop
    while(start < end){

        //if not a vowel, move pointer
        if(!vowels.includes(arr[start])){
            start++;
        }

        if(!vowels.includes(arr[end])){
            end--;
        }

        //swap vowels
        if(vowels.includes(arr[end]) && vowels.includes(arr[start])){
            let temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            //move to next characters
            start++;
            end--;
        }

    }

    return arr.join("");

};