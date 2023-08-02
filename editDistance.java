//Leetcode: 72. Edit Distance
class Solution1 {
    public int minDistance(String word1, String word2) {
        //we want to enter recursively through the options
        //of each word in word1, based on word2
        //and find the minimum operations needed to convert
        //word1 to word2

        //we want to obtain the minimum cost of moving through every
        //letter in word1, taking in mind the operations

        //since we are doing recursion, most likely we'll need memoization
        //so matrix will be helpful
        int dp[][] = new int[word1.length()+1][word2.length()+1];

        //the extra row and extra column will be storing the minimum amount of operations
        //needed to obtain the other word (eg. word length - current position)
        //so this also attacks the base case where one or the other
        //has an empty string (being the length the minimum operations)

        //fill last col 
        for(int i = 0; i <= word1.length(); i++){
            dp[i][word2.length()] = word1.length()-i;
        }
        //fill last row
        for(int i = 0; i <= word2.length(); i++){
            dp[word1.length()][i] = word2.length()-i;
        }


        //if the letter was equal, we dont have to do nothing, else
        //for each letter there can be 3 operations in total
        //insert
        //remove
        //replace
        
        for(int i =  word1.length()-1; i >= 0; i--){
            for(int j = word2.length()-1; j >= 0; j--){

                //if equal, its a 0 and move diagonally
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    int insert = dp[i][j+1];
                    int delete = dp[i+1][j];
                    int replace = dp[i+1][j+1];
                    //finding the minimum operations recursively
                    //but adding one, indicating an operation being made
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        

        return dp[0][0];
    }
}