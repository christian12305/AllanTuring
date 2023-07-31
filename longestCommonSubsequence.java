// Leetcode: 1143. Longest Common Subsequence
import java.util.Arrays;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //first we want to fill the matrix[text1.len + 1][text2.len + 1] with 0s
        //then we want to approach it in a bottom up manner
        //where we start from the bottom right matrix[text1.len][text2.len] 
        //and have two conditions
        //if the character at i and j is the same,
        //we want to sum 1 plus the diagonal of it
        //matrix[i+1][j+1], and store it at matrix[i][j]
        //else if the characters are not the same,
        //we want to find the max between matrix[i-1][j]
        // and matrix[i][j-1] and store in matrix[i][j]
        //this will fill the whole matrix and store our result at the top left
        //so we return top left

        //matrix
        int[][] dp = new int[text1.length() +1][text2.length() +1];

        //fill matrix with 0
        for(int i = 0; i <= text1.length(); i++){
            Arrays.fill(dp[i], 0, text2.length(), 0);
        }

        //iterate matrix from bottom up
        for(int i = text1.length()-1; i >= 0; i--){
            for(int j = text2.length()-1; j >= 0; j--){
                //conditionals
                //found a match
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }


        //return matrix[0][0]
        return dp[0][0];
    }

}