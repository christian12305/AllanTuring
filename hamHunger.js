/**
 * This program solves leet code problem: Minimum Number of Food Buckets to Feed the Hamsters
 * @param {string} hamsters
 * @return {number}
 */
var minimumBuckets = function(hamsters) {
    let count = 0;
    //Iterate through each character
    for(let i = 0; i < hamsters.length; i++){
        //If hamster (H) check for food posibilities
        if(hamsters[i] === 'H'){

            //Food to the right
            //Extends to after the next posible hamster and validates that one too.
            //This happens because one food can extend to two adjacent hamsters.
            if(i+1 < hamsters.length && hamsters[i+1] === '.'){
                count++;
                i += 2;
            }
            //Food to the left
            else if(i > 0 && hamsters[i-1] === '.'){
                count++;
            //No food
            } else{
                return -1;
            }
        }
    }
    //Total food needed.
    return count;
};