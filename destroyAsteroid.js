/**
 * Leetcode: 2126. Destroying Asteroids
 * @param {number} mass
 * @param {number[]} asteroids
 * @return {boolean}
 */
var asteroidsDestroyed = function(mass, asteroids) {
    //sort asteroids ascending
    //loop asteroids
    //  if mass >= asteroids[i]
    //      mass += asteroid[i]
    //  else
    //      return false;
    //return true

    let flag = true;

    asteroids.sort((a,b)=> a - b);

    for(let i = 0; i <asteroids.length; i++){
        if(mass < asteroids[i]){
            flag = false;
            break;
        }

        mass += asteroids[i];
    }

    return flag;
};