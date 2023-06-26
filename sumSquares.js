/**
 * Leetcode: 633. Sum of Square Numbers
 * @param {number} c
 * @return {boolean}
 */
var judgeSquareSum = function(c) {
    /*
    Time limit exceeded for big numbers
    //a * a + b * b = c
    for(let a = 0; a * a <= c; a++){
        for(let b = 0; b * b <= c; b++){
            if(a*a + b*b === c){
                return true;
            }
        }
    }
    return false;
    */

    /* a*a + b*b = c
     * a*a = c - b*b
     * sqrt(a*a) = sqrt(c-b*b)
     * a = sqrt(c-b*b)
     * 
     * if a is an integer, then it means that
     * there are is a perfect square a*a
     */

    for(let b =0; b*b <= c; b++){
        let a = Math.sqrt(c-b*b);
        if(Number.isInteger(a)){
            return true;
        }
    }

    return false;
};