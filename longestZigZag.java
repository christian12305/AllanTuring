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
// Leetcode: 1372. Longest ZigZag Path in a Binary Tree
import java.lang.Math;
class Solution {

    int longestPath = 0;

    public int longestZigZag(TreeNode root) {

        //Zigzag can start either to the right or the left

        //goLeft helps indicate which direction in the zigzag
        dfs(root, false, 0);

        return longestPath;
    }
    
    private void dfs(TreeNode root, boolean goLeft, int count){

        if(root == null){
            return;
        }

        //update longest path on each zig zag
        //storing at last the longest of all
        longestPath = Math.max(longestPath, count);

        //if goLeft is tru, it means we go left next move
        if(goLeft){
            //next will be right, therefore goLeft is false
            //follows zigzag
            dfs(root.left, false, count +1);
            //cannot be merged on to the path since we are going left
            //therefore it is here where we start a new zigzag
            //
            //resets count to 1 to account for the current node before 
            //making new zigzag.
            dfs(root.right, true, 1);
        }else{
            //else is for going right
            //
            //new zig zag start since it doesnt follow current zigzag
            dfs(root.left, false, 1);
            //follows zigzag
            dfs(root.right, true, count + 1);
        }

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