// Leetcode: 509. Fibonacci Number
class Solution {
    public int fib(int n) {

        //Dynamic Programming approach using memoization
        //bottom up approach

        if(n < 1)
            return 0;

        int a = 0; int b = 1;

        for(int i = 1; i < n; i++){

            //current fib
            int res = a + b;

            //update for next iteration
            a = b;
            b = res;

        }

        return b;
    }

}