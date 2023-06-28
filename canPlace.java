/*
 * Leetcode: 605. Can Place Flowers
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        //count = 0
        //iterate through flowerbed
        // look for 0s
        // if there is a 0, validate
        // to validate, (flowerBed(i-1) == 0 && (i-1) < 0 )
        // && (flowerBed(i + 1) == 0 && (i+1) > flowerbed.length()) 
        // if valid, count++

        // if count is <= n return true else return false

        if(flowerbed.length < n || flowerbed.length == 0)
            return false;

        int count = 0;

        for( int i = 0; i < flowerbed.length; i++){

            if(flowerbed[i] == 0){

                //valid

                if((i-1 < 0 || flowerbed[i-1] == 0) && (i+1 > flowerbed.length - 1 || flowerbed[i+1] == 0)){
                    //mark plotted
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }

        System.out.println(count);

        if(n <= count)
            return true;
        else
            return false;
    }
}