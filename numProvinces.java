// Leetcode: 547. Number of Provinces
class Solution {
    public int findCircleNum(int[][] isConnected) {
        //having a boolean list to indicate the visited nodes
        //with length being the amount of nodes in isConnected
        //and having a counter of the numberOfComponents in the province

        //loop through the nodes in isConnected
        //if it hasnt been visited,
        //  visit, increment counter of provinces
        //  enter recursively to the node to visit it
        //      passing the number of the node, the bool list and our matrix

        int length = isConnected.length;

        boolean list[] = new boolean[length];

        int count = 0;

        //loop nodes
        for(int i = 0; i < length; i++){
            if(!list[i]){
                //increment the number of provinces
                count++;
                //start recursion to mark connected nodes in this province
                dfs(i, list, isConnected);
            }
        }

        return count;
    }

    //DFS
        //mark node as visited
        //loop through the values inside the node,
        //  if its a 1, and has not been visited,
        //  enter recursively to visit it

        //so what the dfs is doing is connecting the province
        //and marking it as visited, so it doesnt count as another province
    private void dfs(int node, boolean list[], int isConnected[][]){
        //mark visited
        list[node] = true;

        //length of each of the node's values is the same length as the amount
        // of nodes.
        int length = isConnected.length;

        //loop values
        for(int i = 0; i < length; i++){
            //if its connected but we havent visited,
            // enter to that node recursively to visit it
            if(isConnected[node][i] == 1 && !list[i]){
                dfs(i, list, isConnected);
            }
        }
    }
}