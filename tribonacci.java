// Leetcode: 1137. N-th Tribonacci Number
class Solution {
    public int tribonacci(int n) {
        //tribonacci
        //t(n) = t(n-1) + t(n-2) + t(n-3)
        //
        //t(0) = 0, t(1) = 1, t(2) = 1, t(3) = t(0) + t(1) + t(2), t(4) = t(1) + t(2) + T(3)
        
        //
        if(n < 1)
            return 0;

        //for a bottom up approach
        int a = 0; int b = 1; int c = 1;

        //start calculating fib from the third value f(3)
        for(int i = 2; i < n; i++){
            int sum = a + b + c;

            a = b;

            b = c;

            c = sum;
        }

        return c;
    }

}