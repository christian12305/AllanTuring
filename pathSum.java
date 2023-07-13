/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// LeetCode: 437. Path Sum III
import java.util.*;
class Solution {
    //global counter
    int count = 0;

    //global map for frequencies of currentSum
    HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    

    public int pathSum(TreeNode root, long targetSum) {

        //added 0 to validate for if the first node is the target
        map.put((long)0, 1);

        dfs(root, 0, targetSum);

        return count;
        
    }

    private void dfs(TreeNode root, long oldSum, long target){

        if(root == null){
            return;
        }

        //calculate the sum up to current node
        long currentSum = oldSum + root.val;

        //x is the value we are looking for, this is because
        //sum(target) = currentSum - x
        //means that there is a node X with value x that we can eliminate from
        //the currentSum, so that the remaining sum is our target value;
        long x = currentSum - target;
        //there is such a value 

        //adds the amount of times x appears in our map
        count += map.getOrDefault(x, 0);
        
        //update our map with current sum of nodes frequency
        map.put(currentSum, map.getOrDefault(currentSum, 0)+1);

        dfs(root.left, currentSum, target);
        dfs(root.right, currentSum, target);

        //since branch is already checked to the left and right,
        //we update the frequency of currentSum
        map.put(currentSum, map.get(currentSum) -1);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}