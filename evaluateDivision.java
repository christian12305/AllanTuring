//Leetcode: 399. Evaluate Division
import java.util.*;
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //having an adjacency map
        //we want to add to each node in the map, its neighbor and
        //the corresponding value.
        //while also storing in the neighbor, the node with the 
        //reciprocal of the corresponding value.

        Map<String, Map<String, Double>> adj = fillAdj(equations, values);

        //now we find our solution for each of the queries
        //having a double[] to store the answers of each query
        double[] result = new double[queries.size()];

        //
        for(int i =0; i < queries.size(); i++){

            //List<String> query : queries

            //a
            String a = queries.get(i).get(0);
            //b
            String b = queries.get(i).get(1);

            //we enter a dfs to find the solution of this and store in corresponding result slot
            //we will be sending a new empty set that indicates the visited nodes
            result[i] = dfs(a,b, adj, new HashSet());

        }


        return result;

    }

    private double dfs(String a, String b, Map<String, Map<String, Double>> adj, Set<String> visited){

        //base cases

        //one of a or b does not exists in the adjacency map
        if(!adj.containsKey(a) || !adj.containsKey(b) )
            return -1;

        //if b is a, we return 1 because we found the value
        //in division a/a is 1
        //therefore return 1
        if(a.equals(b))
            return 1;

        //mark a (current node) as visited
        visited.add(a);

        //visit each of the current node's adjacent nodes
        //if not visited
        //int i =0; i < adj.get(a).size(); i++ 
        for(String neighbor : adj.get(a).keySet()){
            
            //if neighbor hasnt been visited,
            //visit in a dfs manner
            if(!visited.contains(neighbor)){
                //store the result of calling dfs on neighbor with same destination
                double res = dfs(neighbor, b, adj, visited);
                //if there was a value found,
                //calculate its weight with the value returned
                //multiplied by the weight of the neighbor
                if(res != -1){
                    //return the weight of current
                    return res * adj.get(a).get(neighbor);
                }
            }
            
        }

        //if no cases were determined
        return -1;
    }

    private Map<String, Map<String, Double>>  fillAdj(List<List<String>> equations, double[] values){

        Map<String, Map<String, Double>> adj = new HashMap<>();

        //store each equation
        //a->b, value
        //b->a, 1/value
        for(int i = 0; i < equations.size(); i++){
            //a
            String a = equations.get(i).get(0);
            //b
            String b = equations.get(i).get(1);
            //value of a->b
            double val = values[i];

            //a->b = value
            if(adj.containsKey(a)){
                adj.get(a).put(b, val);
            }else{
                Map<String, Double> map = new HashMap<>();
                map.put(b, val);
                adj.put(a, map);
            }

            //b->a = 1/value
            if(adj.containsKey(b)){
                adj.get(b).put(a, 1 / val);
            }else{
                Map<String, Double> map = new HashMap<>();
                map.put(a, 1 / val);
                adj.put(b, map);
            }

        }

        return adj;
    }
}