//Leetcode: 901. Online Stock Span
import java.util.*;
class StockSpanner {

    //we want to keep a monotonic stack that stores the span
    //of each day's price of the stock

    //the span is defined by the numbeer of days for which
    //the stock's price was less than or equal to the price of that day

    //in the monotonic stack we want to keep the elements that are smaller than
    //the current price, if price is bigger than top, we remove from stack until its not bigger than top
    //store in the removed index the amount of days to find a greater value

    private Stack<int[]> mono;

    public StockSpanner() {
        mono = new Stack<>();
    }
    
    public int next(int price) {

        //every price has a span of at least 1
        int ans = 1;

        //if stack is not empty and the given price is greater than the top of the stack
        //remove element and add to the answer the days needed for the last element at
        // the top to reach a greater number 
        // (because if this number is higher
        // than the last number at the top, then it means that for the current number
        // to find a higher element, it must also go through the days of the element before it to
        // find the larger number)
        //
        while(!mono.isEmpty() && mono.peek()[0] <= price){
            //since we are keeping a monotonic stack,
            //when finding a price greater than the top
            //remove element and add to answer its number of days
            ans += mono.pop()[1];
        }

        //add current [price, the number of days needed] to the stack
        mono.push(new int[]{price, ans});

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */