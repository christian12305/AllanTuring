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
// Leetcode: 700. Search in a Binary Search Tree
import java.util.*;
class Solution {

    public TreeNode searchBST(TreeNode root, int val) {

        //in a BST, from top is x number
        // to the left of x is a smaller value, to the right is a bigger value
        //
        //so if we are looking for val
        //if val < root.val, enter left
        //if val > root.val enter right
        //we must return the tree of val

        //if null, return null

        //if we find the val 
        //return val
        //else
        //enter to left and right node

        //base case
        //found or no tree available left
        if(root == null || root.val == val){
            return root;
        }

        //going right since the current value is smaller than the val
        if(root.val < val){
            return searchBST(root.right, val);
        //going left since the value we are looking for is smaller
        // than the current value
        }else{
            return searchBST(root.left, val);
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