//Leetcode: 933. Number of Recent Calls
import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        //initializing the counter with zero requests
        queue = new LinkedList<Integer>();
    
    }
    
    public int ping(int t) {
        //insert t at last index
        //first value must be >= t-3000
        //t-3000 indicates the first possible value
        //so any value that doesnt comply, must be removed

        queue.offer(t);

        //top of the queue represents the first value
        //so we remove values than are less than the first possible values
        while(queue.peek() < t -3000){
            queue.poll();
        }

        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */