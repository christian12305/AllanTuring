//Leetcode: 1926. Nearest Exit from Entrance in Maze
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        //having a 2D matrix where (x,y)
        //and having a starting point (a,b)
        //we want to determine the minimum steps to get out
        //get out is defined as outside of bounds

        //the matrix hast values + and .
        //where + is a wall
        //we will return integer_max if there is a wall

        //  we want to recursively enter the maze starting at (a,b)
        //  find and return the minimum between all the possible movements

        int y = entrance[0];
        int x = entrance[1];

        int ROW = maze.length;
        int COL = maze[0].length;

        return dfs(maze, x, y, ROW, COL);
    }

    private int dfs(char[][] maze, int x, int y, int ROW, int COL){

        //base case
        if(y >= ROW || x >= COL ){
            return 0;
        }

        //if there is a wall return the max value so we dont go there
        if(maze[y][x] == '+')
            return Integer.MAX_VALUE;

        //if visited return MAX

        //mark as visited
        //esto se hacia modifying el maze with another value

        //recursive call to all possible movements
        return minPath(
            //up
            dfs(maze, x , y -1, ROW, COL),
            //down
            dfs(maze, x , y +1, ROW, COL),
            //left
            dfs(maze, x -1 , y, ROW, COL),
            //right
            dfs(maze, x +1, y, ROW, COL)
        ) + 1;
    }

    //compares 4 possible movements
    //up,down,left,right
    private int minPath(int a, int b, int c, int d){
        //comparing algorithm
        return 0;
    }
}