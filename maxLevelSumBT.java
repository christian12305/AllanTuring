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
// Leetcode: 1161. Maximum Level Sum of a Binary Tree
import java.util.*;
import java.lang.Math;
class Solution1 {
    public int maxLevelSum(TreeNode root) {

        //having a queue 
        //starting with the root at level 1

        //while the queue has someting
        //means we still have levels to check
        //  sum = 0
        //  loop the length of the queue at the current level
        //      remove element from queue
        //      accumulate the sum
        //  update max with sum if sum > max
        //  add the next level
        //  each call represents a new level, therefore we store each levels number

        //store maximum sum
        int max = Integer.MIN_VALUE;

        //stores the max values level
        int resultLevel = 0;

        Queue<TreeNode> queue  = new LinkedList();

        //add root
        queue.add(root);

        //stores each of the levels number
        int levelCount = 0;

        while(!queue.isEmpty()){

            levelCount++;

            int size = queue.size();

            int sum = 0;

            //loop the items of this level
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.remove();
                sum += temp.val;

                if(temp.right != null)
                    queue.add(temp.right);
                if(temp.left != null)
                    queue.add(temp.left);
            }

            if(sum > max){
                max = sum;
                resultLevel = levelCount;
            }

        }

        return resultLevel;
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