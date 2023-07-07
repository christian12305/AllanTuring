/**
 * Leetcode: 1207. Unique Number of Occurrences
 * @param {number[]} arr
 * @return {boolean}
 */
var uniqueOccurrences = function(arr) {
    //loop arr
    //  store in map
    //loop
    //  store each value of the keys in a map
    //  if value exists already return false
    //return true

    let map = new Map();
    let auxMap = new Map();
    let flag = true;

    arr.forEach(elem=>{
        map.set(elem, (map.get(elem) ? map.get(elem) + 1 : 1));
    });

    map.forEach((value, _) =>{
        if(auxMap.has(value)){
            console.log(value)
            flag = false;
        }else{
            auxMap.set(value, 1);
        }
    });


    return flag;

    //FOR OPTIMIZATION: USING SET INSTEAD OF MAP
    //SETS ONLY HAVE UNIQUE VALUES,
    //THEREFORE WE ONLY CHECK IF IT EXISTS IN THE SET
    //IF IT DOESNT WE ADD
    //IF IT DOES, RETURN FALSE;
};