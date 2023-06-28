/*
 * Leetcode: 605. Can Place Flowers
 * Optimized without a counter.
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        //count = 0
        //iterate through flowerbed
        // look for 0s
        // if there is a 0, validate
        // to validate, (flowerBed(i-1) == 0 && (i-1) < 0 )
        // && (flowerBed(i + 1) == 0 && (i+1) > flowerbed.length()) 
        // if valid, discount placed flower

        // if n == 0 return true else return false

        if(n == 0)
            return true;

        for( int i = 0; i < flowerbed.length; i++){

            if(flowerbed[i] == 0){

                //valid

                if((i-1 < 0 || flowerbed[i-1] == 0) && (i+1 > flowerbed.length - 1 || flowerbed[i+1] == 0)){
                    //mark plotted
                    flowerbed[i] = 1;
                    n--;
                    if(n == 0){
                        return true;
                    }
                }
            }
        }
        return false;

    }
}