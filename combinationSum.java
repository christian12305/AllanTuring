// Leetcode: 216. Combination Sum III
import java.util.*;
class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {

        //having a list of numbers from 1-9
        //we want to iterate through the list
        //adding a number each iteration (or recursion)
        //  from nums to the currentList
        //and when currentList length = k
        //  append currentList to resulting list if the sum of its elements is n
        //

        List<List<Integer>> result = new ArrayList();
        
        //the 1 indicates that we are currently at the first number
        backtrack(k, n, new ArrayList(), result, 1);

        return result;
    }

    private void backtrack(int k, int n, List<Integer> curr, List<List<Integer>> result, int num){

        //if length is correct and the elements added up to n
        //add to result and return for the next iteration
        if(curr.size() == k && n == 0){

            result.add(new ArrayList(curr));
            
            return;
        }

        //from 1-9
        for(int j = num; j < 10; j++){
            
            curr.add(j);
            //we give j + 1 to update the number, so that we dont repeat numbers
            //substract j from n to determine how much is left to obtain n
            backtrack(k, n - j, curr, result, j + 1);
            //removes last number to iterate through the rest of number possibilities
            curr.remove(curr.size()-1);
        }

    }

}