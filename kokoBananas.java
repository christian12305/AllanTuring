//Leetcode: 875. Koko Eating Bananas
class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        //each pile[i] represents an integer of the amount of bananas at i

        //how many bananas per hour (k) are needed to finish all bananas in (h) hours
        //we want to return the minimum (k)

        //using the max k
        //if we get the max pile[i], we eat that pile in an hour
        //  and since the rest is < max, every pile is consumed in an hour too

        //brute force w binary search
        //
        //we iterate k, 1...max pile[i]
        // using binary search
        //
        //  sumAll(pile[i] / k) = total amnt of hours on pile[i]
        //  
        //  if total hours > h
        //      we must pick a bigger k
        //  else
        //      store in min the k
        //      pick a smaller k

        //least k possible will be 1
        int lo = 1;
        //max k from piles
        int hi = piles[0];
        for(int i : piles)
            hi = Math.max(hi, i);

        //to store result
        int result = hi;

        //Binary Search
        while(lo <= hi){
            //or k
            int mid = lo + (hi - lo)/2;

            //iterating all piles 
            //sum all hours to eat bananas with k banana per hour
            int total = 0;
            for(int i : piles)
                //hours needed for this pile
                total += Math.ceil( (double) i /mid);
            
            //this means that using k bananas per hour,
            //we have exceeded the time limit of h
            //so we look forward to get a bigger k bananas per hour
            //to diminish the total hours
            if(total <= h){
                //store minimum k
                result = Math.min(result, mid);
                //look for smaller k
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }   
        }

        return result;
    }
}