// Leetcode: 62. Unique Paths
import java.util.Arrays;
class Solution {
    public int uniquePaths(int m, int n) {

        //FOR A BOTTOM UP APPROACH//

        //having all values in first row as 1
        //and all values in the firs col as 1 too
        //we start from (1,1)
        //and sum the path going up, and the path going right to determine (1,1)
        //
        //we will then return the value saved at (m-1, n-1)

        int dp[][] = new int[m][n];

        //fill array with 1
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], 0, n, 1);
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){

                //for the rest calculate using the sum of up and left
                //(BOTTOM UP)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                
            }
        }

        return dp[m-1][n-1];
    }
    // public int uniquePaths(int m, int n) {
                
    //     //we want to enter through the matrix
    //     //starting from top left and go to bottom right
    //     //we want to add the number of paths going to the right
    //     // and also going down
    //     // we want to fill a m x n matrix with the possible paths on each
    //     // position

    //     //MEMO TOP-DOWN APPROACH//

    //     int[][] dp = new int[m][n];
    //     for(int i = 0; i < m; i++){
    //         Arrays.fill(dp[i], 0 , n, -1);
    //     }

    //     return rec(m, n, 0, 0, dp);

    // }

    // public int rec(int ROW, int COL, int i, int j, int[][] dp){

    //     //out of bounds
    //     if(i >= ROW || j >= COL)
    //         return 0;

    //     //bottom right
    //     if(i == ROW-1 && j == COL-1){
    //         return 1;
    //     }

    //     //if already calculated, return calculation
    //     if(dp[i][j] > -1){
    //         return dp[i][j];
    //     }


    //     return dp[i][j] = rec(ROW, COL, i + 1, j, dp) + rec(ROW, COL, i, j + 1, dp);
    // }
}