// Leetcode: 1466. Reorder Routes to Make All Paths Lead to the City Zero
import java.util.*;
class Solution {

    //global counter
    int count = 0;

        //global map
    //mapping a node with its neighbors (adjacent)
    // key -> node
    // value -> neighbors of node
    // (a list of pair of indices)
    Map<Integer, List<List<Integer>>> adjacencyMap = new HashMap();

    public int minReorder(int n, int[][] connections) {

        //loop connections and store a bidirectional graph

        //key : a
        //val : lists -> (neighbor, sign)
        
        for(int[] x: connections){

            //constructs (a, List with: (b, 1)) and (b, List with: (a, 0))

            // sign represents if the edges is original (1)
            adjacencyMap.computeIfAbsent(x[0], k ->
                new ArrayList<List<Integer>>()).add(Arrays.asList(x[1], 1));

            // or artificial (0)
            adjacencyMap.computeIfAbsent(x[1], k -> 
                new ArrayList<List<Integer>>()).add(Arrays.asList(x[0], 0));

        }

        //call dfs with parent as -1
        //and node as 0 to traverse to its neighbors
        dfs(-1, 0);

        return count;
    }

    private void dfs(int parent, int node){

        //if the node doesnt exists in the map just return
        if(!adjacencyMap.containsKey(node))
            return;

        //loop the neighbors of each node
        //get its neighbor
        //get the sign
        //
        //making sure that the neighbor is not the parent itself
        //so we dont visit parent again
        //sum sign to count if its an original edge
            
        for(List<Integer> neighbors : adjacencyMap.get(node)){
            int neighbor = neighbors.get(0);
            int sign = neighbors.get(1);

            //
            //we are not supposed to be able to travel from parent to node
            //we are supposed to travel from node to parent. 
            //so if we use the artificial edge to travel from parent to node, 
            //we are adding a 0 (sign), else we add 1 (sign).

            //to not visit twice the parent
            if(parent != neighbor){
                count += sign;
                //enter dfs to the neighbor
                dfs(node, neighbor);
            }

        }
    }
}