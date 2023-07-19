// Leetcode: 215. Kth Largest Element in an Array
import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //[3,2,1,5,6,4] k = 2

        //using a min heap (could be max heap also, different implementation)
        //we want to insert each num and when the size of
        //the heap is larger than k, 
        //we must pop to only keep the largest k elements
        //once all numbers are inserted, the number remaining on top will be the kth element
        //resulting in a heap the size of k

        //with max heap
        //we would insert all numbers and pop from the heap k-1 times
        //then the result would be heap.peek()

        //Heap is automatically min heap
        //using collections.reverseOrder we accomplish creating a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        //inserting all elements
        for(int i : nums){
            maxHeap.add(i);
        }

        //pop k-1 items
        for(int i = 0; i < k-1; i++){
            maxHeap.poll();
        }

        //kth item
        return maxHeap.poll();
    }
}