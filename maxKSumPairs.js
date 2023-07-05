/**
 * Leetcode: 1679. Max Number of K-Sum Pairs
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxOperations = function(nums, k) {
    //let result = 0
    //loop
    //store all the nums in a map
    //  if map.has(k - map[i])
    //  remove map[i] and map[x]
    //  increment our result count
    //return result

    let map1 = new Map();
    let resultCount = 0;

    //since we are in order going forward, we are checking once for each of the numbers
    //doing an operation if possible
    //if operation is possible, we simulate adding and instantly removing our current key value (thats why we dont add it)
    //while also storing them if they dont exist
    nums.forEach(key =>{

        let x = k - key;
        if(map1.has(x)){
            resultCount++;

            //Last 1, remove
            if(map1.get(x) === 1){
                map1.delete(x);
            //or remove one from its count
            }else{
                map1.set(x, map1.get(x) - 1);
            }
        }else{
            if(map1.has(key)){
                map1.set(key, map1.get(key) + 1);
            }else{
                map1.set(key, 1);
            }
        }

    });

    return resultCount;

};