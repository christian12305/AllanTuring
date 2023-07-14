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
//Recursive approach to Leetcode: 199. Binary Tree Right Side View
import java.util.*;
class Solution1 {
    
    List<Integer> resultList = new ArrayList();

    public List<Integer> rightSideView(TreeNode root) {

        //BFS
        if(root == null)
            return resultList;

        bfs(root, 0);

        return resultList;
    }

    private void bfs(TreeNode root, int level){

        //base case
        if(root == null)
            return;

        //to store the right most elements
        //if the size of our resultList is equal to the level where we are at
        //it means that can store the element
        //
        //since we are headed to the right most element first
        //the only node stored is that one,
        //because when evaluating the left, the size of the resultList will be above the level
        if(resultList.size() == level){
            resultList.add(root.val);
        }
            
        //we go right first to store the right side of tree
        bfs(root.right, level + 1);
        bfs(root.left, level + 1);
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