/**
 * Leetcode: 790. Domino and Tromino Tiling
 * @param {number} n
 * @return {number}
 */
var numTilings = function(n) {
    
    let modulo = (10 ** 9) + 7;

    let arr = [];
    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 5;

    //the mathematical relation deduced by the first 3 base cases is
   //arr[i] = 2 * arr[i-1] + arr[i-3]

   for(let i = 4; i <= n; i++){
        arr[i] = (2 * arr[i-1] + arr[i-3]) % modulo;
   }

   return arr[n];

};