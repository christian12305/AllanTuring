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
// Leetcode: 199. Binary Tree Right Side View
import java.util.*;
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        //BFS
        //storing the whole level, adding right first

        //result list

        //queue to store nodes
        //  store first node (root)

        //loop until there are no remaining elements in the queue
        //  
        //  get the number of elements in the queue
        //  
        //  loop from 0 to # of elements
        //      remove and store current
        //      if we have the first element in the queue
        //          add to result -> only stores right most elements of the tree
        //              since we are adding right first, the first element is the rightmost
        //              element in that level
        //      if current.right != null
        //          add the curr.right to the queue
        //      if current.left != null
        //          add the curr.left to the queue

        List<Integer> resultList = new ArrayList();

        if(root == null)
            return resultList;
        
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            //loop through each element in the queue
            for(int i =0; i < size; i++){

                //remove elem
                TreeNode temp = queue.remove();

                //if temp is the first on this iteration in queue
                //it means its the rightmost element of the level
                if(i == 0 && temp != null){
                    //add the nodes value
                    resultList.add(temp.val);
                }

                //add the right to next level
                if(temp.right != null)
                    queue.add(temp.right);

                //add left to next level
                if(temp.left != null)
                    queue.add(temp.left);

            }
        }

        return resultList;
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