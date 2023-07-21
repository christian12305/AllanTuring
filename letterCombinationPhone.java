// Leetcode: 17. Letter Combinations of a Phone Number
import java.util.*;
class Solution {

    //first a map with the numbers to characters
    private HashMap<Integer, Character[] > map = new HashMap();

    public List<String> letterCombinations(String digits) {

        //Backtracking
        //using a recursive approach

        //build the map from 2-9
        map.put(0, null);
        map.put(1, null);
        map.put(2, new Character[]{'a', 'b', 'c'});
        map.put(3, new Character[]{'d', 'e', 'f'});
        map.put(4, new Character[]{'g', 'h', 'i'});
        map.put(5, new Character[]{'j', 'k', 'l'});
        map.put(6, new Character[]{'m', 'n', 'o'});
        map.put(7, new Character[]{'p', 'q', 'r', 's'});
        map.put(8, new Character[]{'t', 'u', 'v'});
        map.put(9, new Character[]{'w', 'x', 'y', 'z'});

        //store result
        List<String> result = new ArrayList();

        //if length = 0
        if(digits.length() < 1)
            return result;

        //iterate digits recursively
        backtrack(0, "", result, digits);

        return result;

    }

    private void backtrack(int idx, String curr, List<String> result, String digits){

        int digitsLength = digits.length();

        //if we have a substring completed
        if(curr.length() == digitsLength){
            //add to result
            result.add(curr);
            //goes back for the other characters if available, if none available returns
            //  to the next digit
            return;
        }

        //enter recursively to the digits
        //iterate through the characters in current digit
        //  to add them to our current string
        for(Character c : map.get(digits.charAt(idx) - '0')){
            backtrack(idx+1, curr + c, result, digits);
        }
        

    }


}