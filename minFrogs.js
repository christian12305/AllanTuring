/**
 * Leetcode: 1419. Minimum Number of Frogs Croaking
 * @param {string} croakOfFrogs
 * @return {number}
 */
var minNumberOfFrogs = function(croakOfFrogs) {
    //croakOfFrogs is a string

    //croakOfFrogs[i] valid?
    // valid means
    // map.has(croakOfFrogs[i]) and 
    // c.value>r.value r.value>o.value o.value>a.value a.value>k.value
    //means that when iterating, the order is correct with c r o a k

        //to validate all values must be equal at last
        //meaning that croak is completed

    // c -> frogs++
    // k -> frogs--

    // accum = max(accum, frogs)

    let frogs = 0;

    let result = 0;

    //base case
    if(croakOfFrogs.length % 5 !== 0){
        return -1;
    }

    //croak
    let map = new Map();
    map.set('c', 0);
    map.set('r', 0);
    map.set('o', 0);
    map.set('a', 0);
    map.set('k', 0);

    for(let i =0; i < croakOfFrogs.length; i++){

        //a letter is not valid
        if(!map.has(croakOfFrogs[i])){
            return -1;
        }

        //Increment letter count
        map.set(croakOfFrogs[i], map.get(croakOfFrogs[i])+1);

        //Check for correct order
        //if not correct return -1;
        if(map.get('c') < map.get('r') || map.get('r') < map.get('o') || map.get('o') < map.get('a') || map.get('a') < map.get('k')){
            return -1;
        }

        //Start
        if(croakOfFrogs[i] === 'c'){
            frogs++;
        //End
        }else if(croakOfFrogs[i] === 'k'){
            frogs--;
        }

        result = Math.max(result, frogs);

    }

    if(map.get('c') === map.get('r') && map.get('r') === map.get('o') && map.get('o') === map.get('a') && map.get('a') === map.get('k')){
        return result;
    }else{
        return -1;
    }

};