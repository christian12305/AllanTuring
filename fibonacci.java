// Leetcode: 509. Fibonacci Number
class Solution {
    public int fib(int n) {
        return fib_rec(0, 1, 0, n);
    }

    private int fib_rec(int first, int second, int f, int n){

        if(f == n)
            return first;

        int sum = first + second;

        return fib_rec(second, sum, f+1, n);
    }
}