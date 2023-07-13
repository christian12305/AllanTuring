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
// 872. Leaf-Similar Trees
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        //builds the leaf value sequence
        // of each given tree into a string
        dfs(root1, str1);
        dfs(root2, str2);
        
        //return comparison
        return str1.toString().equals(str2.toString());
    }

    public void dfs(TreeNode root, StringBuilder s){

        //base case for dfs (out of bounds)
        if(root == null){
            return;
        }

        //found a leaf, store its value
        if(root.left == null && root.right == null){
            s.append(root.val + "*");
        }

        //having left first to keep the correct order in our string
        //from left to right
        if(root.left != null)
            dfs(root.left, s);
        if(root.right != null)
            dfs(root.right, s);

        //doesnt return anything, it is stored in the stringBuilder
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