/**
 * Leetcode: 1318. Minimum Flips to Make a OR b Equal to c
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @return {number}
 */
var minFlips = function(a, b, c) {

    //comparing the rightmost bit of each a and b, making sure its
    //equal to the rightmost bit of c
    //to get righmostbit we use binary and operator with a 1
    //
    //to determine if we have to flip, we check for the rightmost bit of c
    //if its a 0, we have to make sure both a and b rightmost bit are 0
    //if its a 1, we only need one of a or b to be 1
    //
    //we keep rightshifting a and b to iterate through their rightmost bit
    //until its a 0

    //num of flips
    let flipCount = 0;

    while(a > 0 || b > 0 || c > 0){

        let a_bit = a & 1;
        let b_bit = b & 1;
        let c_bit = c & 1;

        //for rightmostbit of c = 0
        if(c_bit == 0){

            //we have to flip the ones to get all zeroes
            //we determine if we have to flip by simply having a 1,
            //if it were a 0 then we are not adding anything
            //do only sum to the accumulator the rightmost bit of a and b
            flipCount += (b_bit + a_bit);


        //for the rightmost bit of c = 1
        }else{
            //we need at least one 1 to accomplish
            //if none we need to flip one
            if(a_bit == 0 && b_bit == 0){
                flipCount += 1;
            }
        }

        //now right shift a, b, and c for 1 place for next iteration
        a >>= 1;
        b >>= 1;
        c >>= 1;



    }

    return flipCount;

};