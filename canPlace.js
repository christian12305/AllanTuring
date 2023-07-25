/**
 * Leetcode: 605. Can Place Flowers
 * @param {number[]} flowerbed
 * @param {number} n
 * @return {boolean}
 */
var canPlaceFlowers = function(flowerbed, n) {
    
    //iterate flowerbed
    //if there is a 0 at i
    //  check if i - 1 === 0 or out of bounds
    //  and check if i + 1 === 0 or out of bounds
    //  if both conditions are true, add to counter
    //when iteration done, if counter === n, return true

    //stores amnt of possible placements
    let counter = 0;

    for(let i = 0; i < flowerbed.length; i++){
        
        if(flowerbed[i] === 0){

            let cond1 = (i-1 < 0 || flowerbed[i-1] === 0)
            let cond2 = (i+1 >= flowerbed.length || flowerbed[i+1] === 0)

            //possible placement
            if(cond1 && cond2){
                //mark so not problem on next iteration
                flowerbed[i] = 1;
                counter++;
            }

        }
    }

    return (counter >= n);
};