//Leetcode: 2336. Smallest Number in Infinite Set
import java.util.*;
class SmallestInfiniteSet {
    
    //since we only have positive integers, smallest will be 1
    int smallestIndex;
    //min-heap
    PriorityQueue<Integer> heap;

    public SmallestInfiniteSet() {

        smallestIndex = 1;
        heap = new PriorityQueue<Integer>();

    }
    
    public int popSmallest() {
        //if there are elements in the heap,
        //this means that there are smaller elements
        //than the current index's number
        if(heap.size() > 0){
            return heap.poll();
        }

        //return the current smallest index 
        //and move to the next smallest index
        return smallestIndex++;
    }
    
    public void addBack(int num) {

        //when adding numbers back
        //if number already exists in the set or the added numbers
        //dont add
        //else
        if(num < smallestIndex && !heap.contains(num)){
            //add to a min-heap that can store smallest at top
            heap.add(num);
        }
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */