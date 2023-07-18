// Leetcode: 994. Rotting Oranges
import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        
        //BFS
        //
        //first count the number of fresh oranges and
        //add to the queue the rotten ones
        //
        //
        //having a queue where we store the minute's cells (nodes)
        //add the first node to the queue
        //
        //having a counter at 0
        //while queue is not empty
        //  process cell (node) - poll from queue
        //  if its a 1, change to 2
        //  add all adjacent cells (nodes) to queue
        //  increment level counter

        int ROWS = grid.length;
        int COLS = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        //keep count of the fresh oranges found
        int fresh = 0;

        //add all rotten
        //count fresh
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                //rotten
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                //fresh
                if(grid[i][j] == 1)
                    fresh++;
            }
        }

        //if there are no fresh return 0
        if(fresh == 0)
            return 0;

        //if there is no rotten, means none will get rotten
        //therefore we return -1 cause we ddidnt accomplish the goal
        if(queue.isEmpty())
            return -1;

        int[][] movements = new int[][]{
            //up    down     right   left
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        int minute = -1;

        //starting at the first level of the first rotten orange
        //iterates per level
        while(!queue.isEmpty()){

            //current level size
            int size = queue.size();

            //Traverse all elements at current level
            for(int i = 0; i < size; i++){

                int[] temp = queue.poll();

                int row = temp[0];
                int col = temp[1];

                //add all adjacent oranges if fresh
                for(int[] dir : movements){

                    //adjustment
                    int nextRow = row + dir[0], 
                        nextCol = col + dir[1];

                    // If there exists a fresh neighbor, make it rot
                    if (0 <= nextRow && nextRow < ROWS && 
                        0 <= nextCol && nextCol < COLS && 
                        grid[nextRow][nextCol] == 1) {

                        //rot
                        grid[nextRow][nextCol] = 2;

                        //discount from fresh
                        fresh--;

                        //and add this cell to 'queue' to the new step
                        queue.offer(new int[]{nextRow, nextCol});
                    }

                }

            }

            minute++;
        }

        return fresh == 0 ? minute : -1;
    }
}