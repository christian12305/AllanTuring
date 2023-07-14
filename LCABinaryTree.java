/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Leetcode: 236. Lowest Common Ancestor of a Binary Tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //thinking of one node at a time
        //we want to return the lowest common ancestor 
        // of two nodes p and q.
        //root
        //has left and right

        //base case 
        //if null return null
        if(root == null){
            return null;
        }

        //if the root itself is p or q, return root
        if(root == p || root == q){
            return root;
        }

        //if right or left has found p or q,
        //return right or left
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        //
        //if right has p and left has q, return the root
        if(left != null && right != null)
            return root;

        //if right or left has found p or q,
        //return right or left
        if(left == null){
            return right;
        }else{
            return left;
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}