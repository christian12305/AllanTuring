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
// Leetcode: 450. Delete Node in a BST
import java.util.*;
class Solution1 {

    public TreeNode deleteNode(TreeNode root, int val) {
        if(root == null)
            return null;

        return bst(root, val);

    }

    private TreeNode bst(TreeNode root, int val){
        

        //base case
        //found or no tree available left
        if(root == null){
            return root;
        }

        //Find val
        //going right since the current value is smaller than the val
        if(root.val < val){
            root.right = bst(root.right, val);
        //going left since the value we are looking for is smaller
        // than the current value
        }else if(root.val > val){
            root.left = bst(root.left, val);
        }

         //found node
        //delete it
        // and return the root reference
        //Found
        else{

            //no left subtree
            if(root.left == null)
                return root.right;
            //no right subtree
            if(root.right == null)
                return root.left;
            //if both subtree are null, they return null so no need to evaluate for both
            
            //subtree on both sides
            //to keep BST inOrder
            //we must gather the smallest node in the right subtree,
            TreeNode curr = root.right;
            while(curr.left != null)
                curr = curr.left;
            
            // so that we get a base case where the node is a leaf
            //and remove that same value from the right subtree recursively
            root.val = curr.val;
            root.right = bst(root.right, curr.val);

        }

        return root;



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