// Leetcode: 1926. Nearest Exit from Entrance in Maze
import java.util.*;
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        int rows = maze.length, cols = maze[0].length;

        int[][] movements = new int[][]{

            //up    down     right   left
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        
        int y = entrance[0], 
        x = entrance[1];

        // Mark the entrance as visited since its not a exit.
        maze[y][x] = '+';
        
        // use a queue to store all the cells to be visited.
        Queue<int[]> queue = new LinkedList<>();

        //adds first row,col and the step 0
        queue.offer(new int[]{y, x, 0});
        
        //BFS
        //adds to the queue all the nodes in the step (starting at 0 as origin)
        while (!queue.isEmpty()) {

            //process queue
            int[] currState = queue.poll();

            // gets x, y and the step of the top element in the queue
            int currY = currState[0], 
                currX = currState[1], 
                currStep = currState[2];

            // For the current cell, check its four possible movements
            //MOVES TO NEXT LEVEL (each level being an iteration of all possible movements)
            for (int[] dir : movements) {

                //adjust
                int nextRow = currY + dir[0], 
                    nextCol = currX + dir[1];

                    //IF THERE IS A WALL, THE MOVEMENT IS NOT PROCESSED,
                    //ONLY MOVES IF '.'
                // If there exists an unvisited empty neighbor or we reached an exit:
                if (0 <= nextRow && nextRow < rows && 
                    0 <= nextCol && nextCol < cols && 
                    maze[nextRow][nextCol] == '.') {
                    
                    // If this empty cell is an exit, return distance + 1
                    //we determine an exit if we reached a border on the left or up
                    //or a border on the right or down
                    if (nextRow == 0 || 
                        nextCol == 0 || 
                        nextRow == rows - 1 || 
                        nextCol == cols - 1)
            
                        return currStep + 1;
                    
                    // Otherwise,  mark it as visited.
                    //Although, it is not recommended to modify the given matrix.
                    maze[nextRow][nextCol] = '+';

                    //and add this cell to 'queue' with the new step
                    queue.offer(new int[]{nextRow, nextCol, currStep + 1});
                }  
            }
        }

        // If we finish iterating without finding an exit, return -1.
        return -1;
    }
}