/**
 * Leet code challenge: 1358. Number of Substrings Containing All Three Characters
 * @param {string} s
 * @return {number}
 */
var numberOfSubstrings = function(s) {

    //store current a, b, and c count
    let map1 = new Map();

    //count of substrings
    let acc = 0;

    //first window
    //sets the map
    let i = 0;
    while(i < s.length){

        //If char exists in map add 1 to value
        if(map1.get(s[i])){
            map1.set(s[i], map1.get(s[i]) + 1);
        //Otherwise set with value 1
        }else{
            map1.set(s[i], 1);
        }

        //if substring has all 3, accumulate the combinations
        // combinations = s.length - i
        // break to return the index
        if(map1.get('a') && map1.get('b') && map1.get('c')){
            acc += s.length - i;
            break;
        }
        i++;
    }

    //Rest of combinations
    let j =0;
    //Eliminate first window
    map1.set(s[j], map1.get(s[j]) - 1);
    j++;

    while(i < s.length && j < s.length){
        //match
        while(map1.get('a') && map1.get('b') && map1.get('c')){
            acc += s.length - i;
            //Eliminate left pointer
            map1.set(s[j], map1.get(s[j]) - 1);
            j++;
        }
        //right pointer moves since no match
        i++;  
        map1.set(s[i], map1.get(s[i]) +1);
         
    }

    return acc;
};

console.log(numberOfSubstrings('abcabc'));