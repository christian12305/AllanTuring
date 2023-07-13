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
// Leetcode: 1448. Count Good Nodes in Binary Tree
import java.lang.Math;
class Solution {

    int count = 0;

    public int goodNodes(TreeNode root) {
        
        //enter recursively DFS
        // keep count of the maximum value, if the current value 
        // is greater than or equal to the max, 
        //  update max and 
        //  increment count of good nodes

        dfs(root, Integer.MIN_VALUE);


        return count;
    }

    private void dfs(TreeNode root, int max){

        //out of bounds
        if(root == null){
            return;
        }

        //counts if it keeps the order where
        //there is no number > x in the path from root to x
        if(root.val >= max){
            //update max
            max = Math.max(max, root.val);
            //increment counter
            //including the root since first max is Integer.MIN_VALUE
            count++;
        }

        //depth
        dfs(root.left, max);
        dfs(root.right, max);

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