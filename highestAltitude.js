/**
 * Leetcode: 1732. Find the Highest Altitude
 * @param {number[]} gain
 * @return {number}
 */
var largestAltitude = function(gain) {
    //max
    //altitude = 0
    //loop gain
    //  max = max(max, altitude + gain[i] )
    //  altitude += gain[i]
    //return max

    let max = altitude = 0;

    for(let i =0; i< gain.length; i++){
        max = Math.max(max, altitude + gain[i]);
        altitude += gain[i];
    }

    return max < 0 ? 0 : max;

};