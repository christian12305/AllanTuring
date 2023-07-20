// Leetcode: 2462. Total Cost to Hire K Workers
import java.util.PriorityQueue;
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        //return the total cost to hire k workers

        //Having two heaps to store the first {candidates}
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        //and to store the last {candidates}
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        //and having two pointers of costs that keeps track on what to add to our heaps
        int right = costs.length - candidates - 1, left = candidates;
        
        //0 -> canidates-1
        //left
        for(int i = 0; i < candidates; i++)
            leftHeap.add(costs[i]);

        // length-candidates -> length -1
        for (int i = Math.max(candidates, costs.length - candidates); i < costs.length; i++)
            rightHeap.add(costs[i]);
            
        //total
        long total = 0;

        //since we must hire k workers, we iterate k times
        for(int i = 0; i < k; i++){

            //We pick new workers, 
            //having the leftHeap as priority 
            //checks if there are remaining elements in the leftHeap first

            //
            //if its the smallest from leftHeap, or if its equal to the rightHeap smallest
        
            //we are getting the smallest element from leftHeap
            if(rightHeap.isEmpty() || !leftHeap.isEmpty() 
                && leftHeap.peek() <= rightHeap.peek()){

                //pick smallest from left
                //add cost to total
                total += leftHeap.poll();

                //if there are remaining workers
                //add from left to leftHeap
                if(left <= right){
                    leftHeap.add(costs[left]);
                    //increment left pointer
                    left++;
                }

            //we are getting smallest from rightHeap
            }else{

                //pick smallest from right
                //add cost to total
                total += rightHeap.poll();

                //if there are remaining workers
                //add from right to rightHeap
                if(left <= right){
                    rightHeap.add(costs[right]);
                    //decrement right pointer
                    right--;
                }

            }

        }

        return total;


        ///////////////////////////////////////////////////////////////////////
        //  FIRST IDEA, WAS NOT ASSERTED BECAUSE WE ARE ITERATING K TIMES    //
        ///////////////////////////////////////////////////////////////////////
        //
        // //remaining elements to add
        // while(left <= right){

        //     //pick lowest
        //     if(rightHeap.peek() < leftHeap.peek()){
        //         //pick from right
        //         //add cost to total
        //     }else if(rightHeap.peek() >= leftHeap.peek()){
        //         //pick from left
        //         //add cost to total
        //     }

        //     //add more workers
        //     //move pointer from picked side

        // }
    }
}